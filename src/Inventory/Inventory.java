package Inventory;

import Cards.Card;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import Shops.AmuletShop;
import Shops.CardShop;
import Shops.ItemShop;
import com.company.Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
    public ArrayList<Card> deck = new ArrayList<>();
    public ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Amulet> amulets = new ArrayList<>();
    public Amulet equippedAmulet = null;

    public Inventory(ArrayList<Card> deck){
        this.deck = deck;
    }

    public void inventory(){
        printHelp();
        while(true){
            String command = Main.scanner.nextLine();
            switch (command) {
                case "Again":
                    System.out.println(Main.again);
                    break;
                case "Help":
                    printHelp();
                    break;
                case "Card Inventory":
                    Main.print(showCards());
                    while (true) {
                        command = Main.scanner.nextLine();
                        if (command.equals("Exit"))
                            break;
                        else if (command.startsWith("Info"))
                            Main.print(CardShop.instance.info(command));
                        else
                            Main.print("Invalid command!");
                    }
                    break;
                case "Item Inventory":
                    Main.print(showItems());
                    while(true){
                        command = Main.scanner.nextLine();
                        if(command.equals("Exit"))
                            break;
                        else if(command.startsWith("Info"))
                            ItemShop.instance.info(command);
                        else
                            Main.print("Invalid command!");
                    }
                    break;
                case "AmuletInventory":
                    Main.print(showAmulets());
                    while (true){
                        command = Main.scanner.nextLine();
                        if(command.equals("Exit"))
                            break;
                        else if(command.startsWith("Info"))
                            AmuletShop.instance.info(command);
                        else
                            Main.print("Invalid command!");
                    }
                    break;
                case "Edit Deck":
                    editDeck();
                    break;
                case "editAmulets":
                    editAmulets();
                    break;
                case "Exit":
                    return;
                default:
                    Main.print("Invalid command!");

            }
        }
    }

    public void printHelp(){
        String help = "1.\tCard Inventory : To view your cards" +
                "\n2.\tItem Inventory : To view your items" +
                "\n3.\tAmulet Inventory : To view your amulets" +
                "\n4.\tEdit Deck : To edit your deck" +
                "\nEdit Amulets : To equip or remove your amulets" +
                "6.\tExit : to exit to previous menu";
        Main.print(help);
    }

    public String showCards(){
        String cardInventory = "Card Inventory :";
        Boolean[] counted = new Boolean[cards.size()];
        for(int i = 0 ; i<cards.size();i++)
            counted[i] = false;
        int num =1;
        for(int i = 0;i < cards.size();i++){
            if(!counted[i]){
                int numOnInventory=0,numOnDeck=0;
                for(int j = i;j<cards.size();j++)
                    if(cards.get(i).equals(cards.get(j))) {
                        numOnInventory++;
                        counted[j] = true;
                    }
                for(int j = 0;j<deck.size();j++)
                    if(cards.get(i).equals(deck.get(j)))
                        numOnDeck++;
                cardInventory += "\n" +  Integer.toString(num) + ".\t" + Integer.toString(numOnInventory) + " " + cards.get(i).name
                        + " / " + Integer.toString(numOnDeck) + " on deck";
                num++;
            }
        }
        return cardInventory;
    }
    public String showItems(){
        String itemInventory = "Item Inventory :";
        Boolean[] counted = new Boolean[items.size()];
        for (int i = 0;i<items.size();i++)
            counted[i]=false;
        int num = 1;
        for(int i = 0;i<items.size();i++){
            int numOnInnventory = 0;
            if(!counted[i]){
                for(int j = i;j<items.size();j++){
                    if(items.get(i).equals(items.get(j))){
                        numOnInnventory++;
                        counted[j] = true;
                    }
                }
                itemInventory += "\n" + Integer.toString(num) + ".\t" + Integer.toString(numOnInnventory) + " " + items.get(i).name;
                num++;
            }
        }
        return itemInventory;
    }
    public String showAmulets(){
        String amuletInventory = "Amulet Inventory :";
        int num = 1;
        Boolean[] counted = new Boolean[amulets.size()];
        for (int i = 0;i<amulets.size();i++)
            counted[i]=false;
        for(int i = 0;i<amulets.size();i++){
            if(!counted[i]){
                int numOnInventory = 0;
                for(int j = i;j<amulets.size();j++)
                    if(amulets.get(i).equals(amulets.get(j))) {
                        numOnInventory++;
                        counted[j] = true;
                    }
                amuletInventory += "\n" + Integer.toString(num) + ".\t" + Integer.toString(numOnInventory) +" "+ amulets.get(i).name;
                num++;
            }
        }
        return amuletInventory;
    }
    public String showDeckAndInventoryCards(){
        String info = "Deck\n";
        for(int i = 0;i<deck.size();i++) {
            info += "Slot " + Integer.toString(i + 1) + " :\t";
            if (deck.get(i) != null)
                info += deck.get(i).name;
            else
                info += "Empty";
            info += "\n";
        }
        info += "Other Cards :" + showCards().substring(16);
        return info;
    }
    public void editDeck(){
        while(true){
            String command = Main.scanner.nextLine();
            switch (command) {
                case "Help":
                    String help = "1.\tAdd \"Card Name\" #CardSlotNum : To add cards to your deck\n" +
                            "2.\tRemove \"Card Name\" #CardSlotNum : To remove cards from your deck\n" +
                            "3.\tInfo \"Card Name\" : To get more information about a specific card\n" +
                            "4.\tExit: To return to the previous section";
                    Main.print(help);
                    break;
                case "Again":
                    Main.print(showDeckAndInventoryCards());
                    break;
                case "Exit":
                    return;
                case "Next":
                    return;
                default:
                    if(command.startsWith("Add"))
                        addToDeck(command);
                    else if(command.startsWith("Remove"))
                        removeFromDeck(command);
                    else if(command.startsWith("Info"))
                        Main.print(CardShop.instance.info(command));
                    else
                        Main.print("Invalid input!");
            }
        }
    }
    public void editAmulets(){
        while (true){
            String command = Main.scanner.nextLine();
            switch (command) {
                case "Help":
                    String help = "1.\tEquip \"Amulet Name\" : To equip the player with an amulet\n" +
                            "2.\tRemove Amulet : To remove the Amulet equipped with the player (if the player is  equipped with one)\n" +
                            "3.\tInfo \"Amulet Name\" : To get more information about a specific amulet\n" +
                            "4.\tExit : To return to the previos section";
                    Main.print(help);
                    break;
                case "Again":
                    String info = "Amulets" + showAmulets().substring(18);
                    if(equippedAmulet!=null)
                        info += "\nPlayer is equipped with " + equippedAmulet.name + " .";
                    if(info.charAt(info.length()-1)=='\n')
                        info = info.substring(0,info.length()-1);
                    Main.print(info);
                    break;
                case "Remove Amulet":
                    removeAmulet();
                    break;
                default:
                    if (command.startsWith("Info"))
                        Main.print(AmuletShop.instance.info(command));
                    else if(command.startsWith("Equip"))
                        equipAmulet(command);
                    else
                        Main.print("Invalid command!");
            }
        }
    }
    public void addToDeck(String command) {
        command = command.substring(command.indexOf(" ")+1);
        String cardName = "";
        for(int i = 0;i<command.split(" ").length-1;i++)
            cardName += command.split(" ")[i] + " ";
        cardName = cardName.substring(0,cardName.length()-1);
        int cardSlotNum = Integer.parseInt(command.split(" ")[command.split(" ").length-1]) - 1;
        Card card = Card.getInstance(cardName);
        if (!cards.contains(card)) {
            Main.print("there isn't " + command.split(" ")[1] + " in your inventory!");
            return;
        }
        if(deck.get(cardSlotNum)!=null)
            cards.add(deck.get(cardSlotNum));
        deck.set(cardSlotNum, card);
        cards.remove(card);
        Main.print(cardName + " was added to slot " + Integer.toString(cardSlotNum+1) + ".");
    }
    public void removeFromDeck(String command){
        command = command.substring(command.indexOf(" ")+1);
        String cardName = "";
        for(int i = 0;i<command.split(" ").length-1;i++)
            cardName += command.split(" ")[i] + " ";
        cardName = cardName.substring(0,cardName.length()-1);
        int cardSlotNum;
        try {
            cardSlotNum = Integer.parseInt(command.split(" ")[command.split(" ").length-1]) - 1;
        }catch (NumberFormatException e){
            Main.print("Invalid input!");
            return;
        }
        if(cardSlotNum > deck.size()) {
            Main.print("Invalid CardSlotNum!");
            return;
        }
        if(deck.get(cardSlotNum)==null) {
            Main.print("Slot is empty!");
            return;
        }
        String slotNumCardName = deck.get(cardSlotNum).name;
        if(!slotNumCardName.equals(cardName)){
            Main.print("Wrong CardName!");
            return;
        }
        cards.add(deck.get(cardSlotNum));
        deck.set(cardSlotNum,null);
        Main.print(cardName + " was removed from slot " + Integer.toString(cardSlotNum+1) + ".");
    }
    public void removeAmulet(){
        if(equippedAmulet!=null) {
            String equippedAmuletName = equippedAmulet.name;
            amulets.add(equippedAmulet);
            equippedAmulet = null;
            Main.print(equippedAmuletName + " was removed!");
        }
        Main.print("There is no equipped amulet!");
    }
    public void equipAmulet(String command) {
        if(equippedAmulet!=null) {
            amulets.add(equippedAmulet);
            equippedAmulet = null;
        }
        String amuletName = command.substring(command.indexOf(" ")+1);
        Amulet amulet = Amulet.getInstance(amuletName);
        amulets.remove(amulet);
        equippedAmulet = amulet;
        Main.print(amuletName + " was equipped on the player.");
    }
    public void removeOrAddToItems(Item item, int num){
        if(num>0)
            for(int i = 0;i<num;i++)
                items.add(item);
        else
            for(int i = 0;i<-num;i++)
                items.remove(item);
    }
    public void removeOrAddToAmulets(Amulet amulet, int num){
        if(num > 0)
            for(int i = 0;i < num ;i++)
                amulets.add(amulet);
        else
            for(int i = 0;i<-num;i++)
                amulets.remove(amulet);
    }
    public void removeOrAddToDeck(Card card , int num) {
        if (num > 0)
            for (int i = 0; i < num; i++)
                deck.add(card);
        else
            for (int i = 0; i < -num; i++)
                deck.remove(card);
    }
    public void removeOrAddToCards(Card card , int num){
        if(num>0)
            for(int i = 0;i<num;i++)
                cards.add(card);
        else
            for(int i = 0; i < -num;i++)
                cards.remove(card);
    }
}