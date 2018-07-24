package Player;

import Cards.Card;
import Cards.MonsterCard.Enemy.DemonicMonster.*;
import Cards.MonsterCard.Enemy.GoblinMonster.GoblinShaman;
import Cards.MonsterCard.Enemy.GoblinMonster.GoblinSmuggler;
import Cards.MonsterCard.Enemy.OrgeMonster.OrgeFrontliner;
import Cards.MonsterCard.Enemy.OrgeMonster.OrgeMagi;
import Cards.MonsterCard.Enemy.OrgeMonster.OrgeWarChief;
import Cards.MonsterCard.Enemy.OrgeMonster.OrgeWarrior;
import Cards.MonsterCard.Enemy.VampiricMonster.*;
import Cards.MonsterCard.Friendly.AtlantianMonsters.*;
import Cards.MonsterCard.Friendly.DragonBreedMonster.*;
import Cards.MonsterCard.Friendly.ElvenMonster.*;
import Cards.MonsterCard.Monster;
import Cards.SpellCards.*;
import Inventory.Inventory;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Items.MysticHourglass;
import ItemsAndAmulets.Items.SmallHPPotion;
import ItemsAndAmulets.Items.SmallMPPotion;
import Menu.WarMenu;
import World.World;
import com.company.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;import ItemsAndAmulets.Item;	import customGame.CustomGame;import customGame.CustomGame;

public class Player implements Serializable{
    public double demonKingsCrownEffect = 1;
    public int currentMaxMP = 1;
    public Player(){
        this.Hero.HP = 10000;
    }
    public Amulet equippedAmulet = null;
    public Monster Hero = new Monster();
    public String actorName = "";
    public String post = "";

    public Player enemy;
    public int MaxHP = 10000;

    public int MP = 1;
    public int MaxMP = 10;

    public int money = 0;
    public Monster choosenMonster = null;
    public Spell choosenSpell = null;
    public Card choosenCard = null;

    public ArrayList<Monster> monsterField = new ArrayList<>();
    public ArrayList<Spell> spellField = new ArrayList<>();

    public ArrayList<Card> hand = new ArrayList<>();
    public ArrayList<Card> deck = new ArrayList<>();
    public ArrayList<Card> graveYard = new ArrayList<>();

    //added
    public Inventory inventory = new Inventory(deck);
    //end
    public void preWarInitialize(){
        this.Hero.HP = this.MaxHP;
        this.MP = 1;
        this.currentMaxMP = 1;
    }

    public void initializePlayer_formerMethod() {
        Main.again = ("Please enter your name : ");
        System.out.print(Main.again);
        String name = Main.scanner.nextLine();
        actorName = name;
        //add items to inventory
        inventory.removeOrAddToItems(new MysticHourglass(),3);
        inventory.removeOrAddToItems(new SmallHPPotion(),2);
        inventory.removeOrAddToItems(new SmallMPPotion(),2);
        //add Elven monsters to deck
        inventory.removeOrAddToDeck(new ElvenRanger(),2);
        inventory.removeOrAddToDeck(new ElvenHunter(),2);
        inventory.removeOrAddToDeck(new ElvenGuardsman(),1);
        inventory.removeOrAddToDeck(new ElvenAssassin(),1);
        inventory.removeOrAddToDeck(new ElvenDruid(),1);
        //add DragonBreed monsters to deck
        inventory.removeOrAddToDeck(new LesserWhelp(),2);
        inventory.removeOrAddToDeck(new Dragonling(),2);
        inventory.removeOrAddToDeck(new ArmoredDragon(),1);
        inventory.removeOrAddToDeck(new YellowDrake(),1);
        inventory.removeOrAddToDeck(new BlueDragon(),1);
        //add Atlantian monsters to deck
        inventory.removeOrAddToDeck(new MurlocCrawler(),2);
        inventory.removeOrAddToDeck(new MurlocWarrior(),2);
        inventory.removeOrAddToDeck(new GiantCrab(),1);
        inventory.removeOrAddToDeck(new SharkMan(),1);
        inventory.removeOrAddToDeck(new NagaSiren(),1);
        //add spell cards to deck
        inventory.removeOrAddToDeck(new FirstAidKit(),3);
        inventory.removeOrAddToDeck(new ThrowingKnives(),3);
        inventory.removeOrAddToDeck(new PoisionousCauldron(),1);
        inventory.removeOrAddToDeck(new HealingWard(),1);
        inventory.removeOrAddToDeck(new WarDrum(),1);
        this.shuffleDeckCards();
    }
    public void initializePlayer() {
        inventory.cards = new ArrayList<>(CustomGame.data.initialInventoryCards);
        inventory.items = new ArrayList<>(CustomGame.data.initialInventoryItems);
        inventory.amulets = new ArrayList<>(CustomGame.data.initialInventoryAmulets);
        inventory.deck = new ArrayList<>(CustomGame.data.initialDeck);
        this.shuffleDeckCards();
    }
    public void initializeGoblinChieftain(){
        deck.clear();
        inventory.removeOrAddToDeck(new GoblinSmuggler(),10);
        inventory.removeOrAddToDeck(new GoblinShaman(),5);
        inventory.removeOrAddToDeck(new ThrowingKnives(),5);
        this.shuffleDeckCards();
        this.actorName = "Goblin Chieftain";
    }
    public void initializeOrgeWarLord(){
        deck.clear();
        inventory.removeOrAddToDeck(new OrgeWarrior(),6);
        inventory.removeOrAddToDeck(new OrgeFrontliner(),4);
        inventory.removeOrAddToDeck(new OrgeMagi(),2);
        inventory.removeOrAddToDeck(new OrgeWarChief(),1);
        inventory.removeOrAddToDeck(new ThrowingKnives(),3);
        inventory.removeOrAddToDeck(new FirstAidKit(),3);
        inventory.removeOrAddToDeck(new PoisionousCauldron(),1);
        this.shuffleDeckCards();
        this.actorName = "Orge War Lord";
    }
    public void initializeVampireLord(){
        deck.clear();
        inventory.removeOrAddToDeck(new Undead(),4);
        inventory.removeOrAddToDeck(new GiantBat(),3);
        inventory.removeOrAddToDeck(new StoutUndead(),3);
        inventory.removeOrAddToDeck(new UndeadMage(),2);
        inventory.removeOrAddToDeck(new VampireAcolyte(),1);
        inventory.removeOrAddToDeck(new VampirePrince(),1);
        inventory.removeOrAddToDeck(new BloodFeast(),3);
        inventory.removeOrAddToDeck(new FirstAidKit(),2);
        inventory.removeOrAddToDeck(new WarDrum(),1);
        inventory.removeOrAddToDeck(new PoisionousCauldron(),1);
        inventory.removeOrAddToDeck(new HealingWard(),1);
        inventory.removeOrAddToDeck(new GreaterPurge(),1);
        this.shuffleDeckCards();
        this.actorName = "Vampire Lord";
    }
    public void initializeLucifer(){
        deck.clear();
        inventory.removeOrAddToDeck(new Imp(),4);
        inventory.removeOrAddToDeck(new Shade(),3);
        inventory.removeOrAddToDeck(new LivingArmor(),3);
        inventory.removeOrAddToDeck(new Hellhound(),2);
        inventory.removeOrAddToDeck(new EvilEye(),2);
        inventory.removeOrAddToDeck(new Necromancer(),2);
        inventory.removeOrAddToDeck(new DarkKnight(),1);
        inventory.removeOrAddToDeck(new CerberusGatekeeperOfHell(),1);
        inventory.removeOrAddToDeck(new ReapersScythe(),3);
        inventory.removeOrAddToDeck(new FirstAidKit(),3);
        inventory.removeOrAddToDeck(new StrategicRetreat(),1);
        inventory.removeOrAddToDeck(new HealingWard(),2);
        inventory.removeOrAddToDeck(new WarDrum(),1);
        inventory.removeOrAddToDeck(new MeteorShower(),1);
        inventory.removeOrAddToDeck(new MagicSeal(),1);
        this.shuffleDeckCards();
        this.actorName = "Lucifer";
    }

    public void modifyMP(){
        if(this.currentMaxMP <= this.MaxHP){
            this.currentMaxMP++;
        }
        if(this.MP + 1 <= this.currentMaxMP){
            this.MP++;
        }
    }

    //TODO: This function should be checked every turn even after every action
    public void updateLists(){
        ArrayList<Monster> toRemove = new ArrayList<>();
        for(Iterator<Monster> itr = this.monsterField.iterator(); itr.hasNext(); ){
            Monster monster = itr.next();
            if(!monster.Alive || monster.deathCheck()){
                toRemove.add(monster);
                this.graveYard.add(monster);
            }
        }
        this.monsterField.removeAll(toRemove);

        if (this.Hero.deathCheck()){
            Main.someoneLost = true;
        }
    }

    //Search functions:
    //TODO: We should add a way to find choosen monster in world
    public Monster getSearchedMonster(int index){
        if(index == -1){
            return this.Hero;
        }
        return this.monsterField.get(index);
    }
    public Card getSearchedCard(int index){
        return this.hand.get(index);
    }
    public Spell getSearchedSpell(int index){
        try{
            return this.spellField.get(index);
        }catch (Exception e){
            System.out.println("No such spell!");
            return null;
        }
    }
    public Spell getSearchedSpell(){
        //This should return a random Spell
        return this.getSearchedSpell(0);
    }
    public Monster getSearchedMonster(){
        //This should be a random search among monsters
        return new Monster();
    }
    public Card randomRevive(){
        //This function revive random cards from graveyard
        return new Card();
    }
    public Card getSearchedCardFromGraveyard(int index){
        return this.graveYard.get(0);
    }

    //Getters:
    public Monster getChoosenMonster(){
        return this.choosenMonster;
    }
    public ArrayList<Monster> getMonsterField() {
        return monsterField;
    }

    //Adders:
    public void moveCardFromHandToField(int index){
        Card card = this.hand.get(index);
        if(this.MP >= card.MPCost){
            if(card instanceof Monster &&
                    this.monsterField.size() < 5) {

                this.MP -= card.MPCost;
                this.hand.remove(card);
                this.monsterField.add((Monster)card);
                World.spellCasting(card, this, this.enemy);

            }else if(card instanceof Spell && this.spellField.size() < 3){

                this.MP -= card.MPCost;
                this.hand.remove(card);
                if(((Spell)card).type != cardType.Instant)
                    this.spellField.add((Spell)card);
                World.spellCasting(card, this, this.enemy);

            }else{
                Main.print("not enough room for card");
            }
        }else{
            Main.print("not enough MP");
        }
    }
    public Card moveCardFromDeckToHand(){
        //this is a random action
        if(this.deck.size() > 0){
            Card card = deck.get(0);
            deck.remove(0);
            hand.add(card);
            return card;
        }
        return null;
    }
    public void shuffleDeckCards(){
        Collections.shuffle(this.deck);
    }

    //toString:
    public String handToString(){
        if(this.hand.size() > 0){
            String string = this.hand.get(0).name + " ";
            for(int i = 1; i < this.hand.size(); i++){
                string += ", " + this.hand.get(i).name;
            }
            return string;
        }else{
            return "";
        }
    }

}
