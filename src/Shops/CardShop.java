package Shops;

import Cards.Card;
import Cards.MonsterCard.Friendly.AtlantianMonsters.*;
import Cards.MonsterCard.Friendly.DragonBreedMonster.*;
import Cards.MonsterCard.Friendly.ElvenMonster.*;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Cards.SpellCards.*;
import Player.Player;
import com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class CardShop extends Shop {
    public static ArrayList<Card> cards = new ArrayList<>();
    public static Map<Card,Integer> stock = new HashMap<>();
    public static Map<Card,Integer> price = new HashMap<>();
    public static CardShop instance = new CardShop();
    private CardShop(){
        super.help = "1.\tBuy \"Card Name\" - #NumberToBuy : To nuy a certain number of a card from shop\n" +
                "2.\tSell \"Card Name\" - #NumberToSell : To sell a certain number of a card from inventory\n" +
                "3.\tInfo \"Card Name\" : To get more information about a card\n" +
                "4.\tEdit Deck : To edit Deck and remove and add cards to it\n" +
                "5.\tExit : To return to shop menu";
        //add Elven monsters
        cards.add(new ElvenRanger());
        cards.add(new ElvenHunter());
        cards.add(new ElvenGuardsman());
        cards.add(new ElvenAssassin());
        cards.add(new ElvenDruid());
        //add DragonBreed monsters
        cards.add(new LesserWhelp());
        cards.add(new Dragonling());
        cards.add(new ArmoredDragon());
        cards.add(new YellowDrake());
        cards.add(new BlueDragon());
        //add Atlantian monsters
        cards.add(new MurlocCrawler());
        cards.add(new MurlocWarrior());
        cards.add(new GiantCrab());
        cards.add(new SharkMan());
        cards.add(new NagaSiren());
        //add spell cards
        cards.add(new ThrowingKnives());
        cards.add(new PoisionousCauldron());
        cards.add(new FirstAidKit());
        cards.add(new LunarBlessing());
        cards.add(new StrategicRetreat());
        cards.add(new WarDrum());
        cards.add(new HealingWard());
        cards.add(new Tsunami());
        cards.add(new TakeAllYouCan());
        cards.add(new ArcaneBolt());
        cards.add(new GreaterPurge());
        cards.add(new MagicSeal());
        for(Card card : cards){
            if(card instanceof Spell){
                Spell spell = (Spell) card;
                if(spell.MPCost < 6)
                    stock.put(card,3);
                else
                    stock.put(card,2);
                price.put(card,700*spell.MPCost);
            }else{
                Monster monster = (Monster) card;
                switch (monster.type) {
                    case Normal:
                        stock.put(card, 4);
                        price.put(card,300*monster.MPCost);
                        break;
                    case SpellCaster:
                        stock.put(card,2);
                        price.put(card,500*monster.MPCost);
                        break;
                    case General:
                        stock.put(card,2);
                        price.put(card,700*monster.MPCost);
                        break;
                    case Hero:
                        stock.put(card, 1);
                        price.put(card,1000*monster.MPCost);
                }

            }
        }
    }

    //todo
    @Override
    public String getPrimaryMessage(Player player){
        String primaryMessage = "Shop List :\n";
        int num = 1;
        for(Card card : cards){
            String cardName = card.name;
            primaryMessage += Integer.toString(num) + ".\t" + cardName + " " + Integer.toString(price.get(card)) + "\n";
            num++;
        }
        primaryMessage += player.inventory.showCards();
        return primaryMessage;
    }
    @Override
    public void buy(Player player,String command){
        String cardName;
        try {
            cardName = command.substring(command.indexOf(" ")+1,command.indexOf("-")-1);
        }catch (Exception e){
            Main.print("Invalid input format!");
            return;
        }
        int numberToBuy;
        Card card = Card.getInstance(cardName);
        if (card==null){
            Main.print("Invalid Card Name!");
            return;
        }
        try{
            numberToBuy = Integer.parseInt(command.substring(command.indexOf("-")+2));
        }catch (NumberFormatException e){
            Main.print("Invalid input!");
            return;
        }
        if(cardName.equals("BloodFeast") || cardName.equals("Reaper'sScythe") || cardName.equals("MeteorShower")) {
            Main.print("This card is  non-tradable!");
            return;
        }
        if(numberToBuy < 1){
            Main.print("Invalid input : #NumberToBuy must be a positive number!");
            return;
        }
        if(stock.get(card) < numberToBuy){
            Shop.print(player,"Not enough card in shop!");
            return;
        }
        if(player.money < numberToBuy*price.get(card)){
            Shop.print(player,"Not enough Gil!");
            return;
        }
        stock.put(card,stock.get(card)-numberToBuy);
        if(stock.get(card)==0)
            cards.remove(card);
        player.inventory.removeOrAddToCards(card,numberToBuy);
        player.money -= numberToBuy*price.get(card);
        Shop.print(player,"Successfully bought " + Integer.toString(numberToBuy) + " of " + card.name + "!");
    }
    @Override
    public void sell(Player player,String command){
        String cardName;
        try {
            cardName = command.substring(command.indexOf(" ")+1,command.indexOf("-")-1);
        }catch (Exception e){
            Main.print("Invalid input format!");
            return;
        }
        int numberToSell;
        Card forSaleCard = Card.getInstance(cardName);
        if (forSaleCard == null){
            Main.print("Invalid Card Name!");
            return;
        }
        try {
            numberToSell = Integer.parseInt(command.substring(command.indexOf("-")+2));
        }catch (NumberFormatException e){
            Main.print("Invalid input!");
            return;
        }
        if(numberToSell < 1){
            Main.print("Invalid input : #NumberToSell must be a positive number!");
            return;
        }
        if(cardName.equals("BloodFeast") || cardName.equals("Reaper'sScythe") || cardName.equals("MeteorShower")) {
            Main.print("This card is  non-tradable!");
            return;
        }
        int numOnInventory = 0;
        for(Card card : player.inventory.cards)
            if(card.equals(forSaleCard))
                numOnInventory++;
        if(numberToSell > numOnInventory){
            Main.print("Not enough cards!");
            return;
        }
        player.inventory.removeOrAddToCards(forSaleCard,-numberToSell);
        if(!stock.containsKey(forSaleCard))
            stock.put(forSaleCard,0);
        stock.put(forSaleCard,stock.get(forSaleCard)+numberToSell);
        player.money += numberToSell * price.get(forSaleCard) / 2;
        Shop.print(player,"Successfully sold " + Integer.toString(numberToSell) + " of " + forSaleCard.name + "!");
    }
    @Override
    public String info(String command){
        Card card =  Card.getInstance(command.substring(command.indexOf(" ")+1));
        if (card == null){
            Main.print("Invalid Card Name!");
            return null;
        }
        String info =card.name + " Info :\n" +
                "Name : " + card.name;
        if(card instanceof Monster) {
            Monster monster = (Monster) card;
            info += "\nHP : " + Integer.toString(monster.defaultHP) +
                    "\nAP : " + Integer.toString(monster.defaultAP) +
                    "\nMP cost : " + Integer.toString(monster.MPCost) +
                    "\nCard Type : " + monster.type.toString() +
                    "\nCard Tribe : " + monster.house.toString() +
                    "\nIs Defensive :" + (monster.specialty == Specialty.Defender ? "True" : "False") +
                    "\nIs Nimble : " + (monster.specialty == Specialty.Nimble ? "True" : "False");
            if (monster.type == Type.SpellCaster || monster.type == Type.Hero) {
                info += "\nSpell details : \n";
                if (monster.auraEffects.size() == 0)
                    info += "No Spell";
                else
                    for (Spell spell : monster.auraEffects) {
                        info += "\n" + spell.name + " : " + spell.description;
                    }
            }
            if(monster.type== Type.General || monster.type == Type.Hero){
                info += "\nBattleCry details : \n";
                if(monster.battleCryDescription==null)
                    info += "No BattleCry";
                else
                    info += monster.battleCryDescription;
                info += "\nWill details : \n";
                if(monster.willDescription==null)
                    info += "No Will";
                else
                    info += monster.willDescription;
            }
            return info;
        }
        Spell spell = (Spell) card;
        info += "\nMP cost : " + Integer.toString(spell.MPCost) +
                "\nCard Type : " + spell.type.toString() +
                "\nSpell details : " + spell.details;
        return info;
    }
}
