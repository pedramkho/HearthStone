package Shops;

import ItemsAndAmulets.Item;
import ItemsAndAmulets.Items.*;
import Player.Player;
import com.company.Main;

import java.util.ArrayList;

public class ItemShop extends Shop{
    public static ArrayList<Item> items = new ArrayList<>();

    public static ItemShop instance = new ItemShop();

    private ItemShop(){
        super.help = "1.\tBuy \"Item Name\" - #NumberToBuy : To buy an item from the shop\n" +
                "2.\tSell \"Item Name\" - #NumberToSell : To sell an item from your inventory\n" +
                "3.\tInfo \"Item Name\" : To view the full information of the item\n" +
                "4.\tExit : To exit back to the shop menu";
        items.add(new SmallHPPotion());
        items.add(new MediumHPPotion());
        items.add(new LargeHPPotion());
        items.add(new SmallMPPotion());
        items.add(new MediumMPPotion());
        items.add(new LargeMPPotion());
        items.add(new LesserRestorative());
        items.add(new GreaterRestorative());
    }

    //todo
    @Override
    public String getPrimaryMessage(Player player){
        String primarymessage = "Shop List :\n";
        int num = 1;
        for(Item item : items){
            primarymessage += Integer.toString(num) + ".\t" + item.name + " " + Integer.toString(item.getPrice()) +"\n";
            num++;
        }
        primarymessage += player.inventory.showItems();
        return primarymessage;
    }
    @Override
    public void buy(Player player,String command){
//        String itemName;
//        try {
//            itemName = command.substring(command.indexOf(" ")+1,command.indexOf("-")-1);
//        }catch (Exception e){
//            Main.print("Invalid input format!");
//            return;
//        }
//        int numberToBuy;
//        Item item = Item.getInstance(itemName);
//        if (item == null){
//            Main.print("Invalid Item Name!");
//            return;
//        }
//        try {
//            numberToBuy = Integer.parseInt(command.substring(command.indexOf("-")+2));
//        }catch (NumberFormatException e){
//            Main.print("Invalid input!");
//            return;
//        }
//        if(numberToBuy < 1){
//            Main.print("Invalid input : #NumberToBuy must be a positive number!");
//            return;
//        }
//        if(numberToBuy * item.price > player.money){
//            Main.print("Not enough Gil!");
//            return;
//        }
//        player.inventory.removeOrAddToItems(item,numberToBuy);
//        player.money -= numberToBuy*item.price;
//        Shop.print(player,"Successfully bought " + Integer.toString(numberToBuy) + " of " +item.name + ".");
    }
    @Override
    public void sell(Player player,String command){
//        String itemName;
//        try {
//            itemName = command.substring(command.indexOf(" ")+1,command.indexOf("-")-1);
//        }catch (Exception e){
//            Main.print("Invalid input format!");
//            return;
//        }
//        int numberToSell;
//        Item forSaleItem = Item.getInstance(itemName);
//        if (forSaleItem==null){
//            Main.print("Invalid Item Name!");
//            return;
//        }
//        try {
//            numberToSell = Integer.parseInt(command.substring(command.indexOf("-")+2));
//        } catch (NumberFormatException e){
//            Main.print("Invalid input!");
//            return;
//        }
//        if(numberToSell < 1){
//            Main.print("Invalid input : #NumberToSell must be a positive number!");
//            return;
//        }
//        int numOnInventory = 0;
//        for(Item item : player.inventory.items)
//            if(item.equals(forSaleItem))
//                numOnInventory++;
//        if(numberToSell > numOnInventory){
//            Main.print("Not enough cards!");
//            return;
//        }
//        player.inventory.removeOrAddToItems(forSaleItem,-numberToSell);
//        player.money += numberToSell * forSaleItem.price / 2;
//        Shop.print(player,"Successfully sold " + Integer.toString(numberToSell) + " of " + forSaleItem.name+ "!");
    }
    @Override
    public String info(String command){
        Item item =  Item.getInstance(command.substring(command.indexOf(" ")+1));
        if (item == null){
            Main.print("Invalid Item name!");
            return null;
        }
        return item.name + "  Info :\n" + item.details;
    }
}
