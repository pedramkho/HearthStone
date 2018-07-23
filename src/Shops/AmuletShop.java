package Shops;

import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Amulets.*;
import Player.Player;
import com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AmuletShop extends Shop{
    public static ArrayList<Amulet> amulets = new ArrayList<>();
    public static Map<Amulet,Integer> stock = new HashMap<>();
    public static AmuletShop instance = new AmuletShop();

    private AmuletShop(){
        super.help = "1.\tBuy \"Amulet Name\" - #NumberToBuy : To buy a number of an amulet from the shop\n" +
                "2.\tSell \"Amulet Name\" - #NumberToSell : To sell a number of an amulet from amulet inventory\n" +
                "3.\tInfo \"Amulet Name\" : To get full info on an amulet\n" +
                "4.\tEdit Amulets : To equip or remove your hero's amulet\n" +
                "5.\tExit : To exit back to the shop menu";
        amulets.add(new IronPendant());
        amulets.add(new GoldPendant());
        amulets.add(new DiamondPendant());
        amulets.add(new IronRing());
        amulets.add(new GoldRing());
        amulets.add(new DimondRing());
        for(Amulet amulet : amulets)
            stock.put(amulet,1);
    }

    //todo
    @Override
    public String getPrimaryMessage(Player player){
        String primaryMessage = "Shop List :\n";
        int num = 1;
        for(Amulet amulet:amulets){
            primaryMessage += Integer.toString(num) + ".\t" + amulet.name + " " + Integer.toString(amulet.getPrice()) + "\n";
            num++;
        }
        primaryMessage += "Equipped Amulet : ";
        if(player.inventory.equippedAmulet==null)
            primaryMessage += "no amulet is equipped!\n\n";
        else
            primaryMessage += player.inventory.equippedAmulet.name + "\n\n";
        primaryMessage += player.inventory.showAmulets();
        return primaryMessage;
    }
    @Override
    public void buy(Player player,String command){
        String amuletName;
        try {
            amuletName = command.substring(command.indexOf(" ") + 1, command.indexOf("-") - 1);
        }catch (Exception e){
            Main.print("Invalid input format!");
            return;
        }
        int numberToBuy;
        Amulet amulet;
        amulet = Amulet.getInstance(amuletName);
        if(amulet == null) {
            Main.print("Invalid Card Name!");
            return;
        }
        try{
            numberToBuy = Integer.parseInt(command.substring(command.indexOf("-")+2));
        } catch (NumberFormatException e){
            Main.print("Invalid input!");
            return;
        }
        if(amuletName.equals("Demon King's Crown")) {
            Main.print("This amulet is non-tradable!");
            return;
        }
        if(numberToBuy < 1){
            Main.print("Invalid input : #NumberToBuy must be a positive number!");
            return;
        }
        if(numberToBuy > stock.get(amulet)){
            Main.print("Not enough amulets in shop!");
            return;
        }
        if(numberToBuy * amulet.getPrice() > player.money){
            Main.print("Not enough Gil!");
            return;
        }
        stock.put(amulet,stock.get(amulet)-numberToBuy);
        if(stock.get(amulet)==0)
            amulets.remove(amulet);
        player.inventory.removeOrAddToAmulets(amulet,numberToBuy);
        player.money -= numberToBuy * amulet.getPrice();
        Shop.print(player,"Successfully bought " + Integer.toString(numberToBuy) + " of " + amulet.name + "!");
    }
    @Override
    public void sell(Player player,String command){
        String amuletName;
        try {
            amuletName = command.substring(command.indexOf(" ")+1,command.indexOf("-")-1);
        }catch (Exception e){
            Main.print("Invalid input format!");
            return;
        }
        int numberToSell;
        Amulet forSaleAmulet;
        forSaleAmulet = Amulet.getInstance(amuletName);
        if(forSaleAmulet == null){
            Main.print("Invalid Card Name!");
            return;
        }
        try{
            numberToSell = Integer.parseInt(command.substring(command.indexOf("-")+2));
        }catch (NumberFormatException e){
            Main.print("Invalid input!");
            return;
        }
        if(numberToSell < 1){
            Main.print("Invalid input : #NumberToSell must be a positive number!");
            return;
        }
        if(amuletName.equals("Demon King's Crown")) {
            Main.print("This amulet is non-tradable!");
            return;
        }
        int numOnInventory = 0;
        for(Amulet amulet : player.inventory.amulets)
            if(amulet.equals(forSaleAmulet))
                numOnInventory++;
        if(numOnInventory < numberToSell){
            Main.print("Not enough cards!");
            return;
        }
        player.inventory.removeOrAddToAmulets(forSaleAmulet,-numberToSell);
        if(!amulets.contains(forSaleAmulet)) {
            amulets.add(forSaleAmulet);
            stock.put(forSaleAmulet,0);
        }
        stock.put(forSaleAmulet,stock.get(forSaleAmulet) + numberToSell);
        player.money += numberToSell * forSaleAmulet.getPrice() /2;
        Shop.print(player,"Successfully sold "+Integer.toString(numberToSell) + " of " + forSaleAmulet.name + "!");
    }
    @Override
    public String info(String command){
        Amulet amulet =  Amulet.getInstance(command.substring(command.indexOf(" ")+1));
        if (amulet==null){
            Main.print("Invalid Amulet name!");
            return null;
        }
        return amulet.name + " Info :\n" + amulet.details;
    }
}