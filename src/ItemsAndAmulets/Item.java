package ItemsAndAmulets;

import Cards.Component;
import Player.Player;
import customGame.CustomGame;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Item extends Component {
    static public ArrayList<Item> items = new ArrayList<>();
    public int mpIncrease;
    public int hpIncrease;
    public String details;

    public static boolean removeItem(String name) {
        for (Item item : items)
            if (item.getName().equals(name)) {
                items.remove(item);
                return true;
            }
        return false;
    }

    public void action(Player player){}

    public Item(){

    }
    public Item(String name,int mpIncrease,int hpincrease,int price,boolean custon){
        this.name = name;
        this.mpIncrease = mpIncrease;
        this.hpIncrease = hpincrease;
        this.price = price;
        this.custom = custon;
    }
    public static void createCustomItem(String name,int mpIncrease,int hpincrease,int price){
        items.add(new Item(name,mpIncrease,hpincrease,price,true));
    }
    public String getName(){
        return name;
    }

    static public Item getInstance(String itemName){
        String className = itemName.replace(" ","");
        className = className.replace("'","");
        className = className.replace(",","");
        Class itemClass = null;
        try {
            itemClass = Class.forName("ItemsAndAmulets.Item" + className);
        }catch (ClassNotFoundException e){ }
        if(itemClass == null)
            return null;
        try {
            Constructor cardConstructor = itemClass.getConstructor();
            return  (Item) cardConstructor.newInstance();
        }catch (Exception e){}
        return null;
    }

    public boolean equals(Item item){
        return getName().equals(item.getName());
    }

    public Item(String name, int itemCost, int MpIncrease, int HpIncrease){
        this.name = name;
        this.price = itemCost;
        this.mpIncrease = MpIncrease;
        this.hpIncrease = HpIncrease;
    }
    public void makeCustomItem(String name, int itemCost, int MpIncrease,int HpIncrease){
        if(existItem(name)){
            System.out.println("Duplicate name");//todo
            return;
        }
        items.add(new Item(name,itemCost,MpIncrease,HpIncrease));
    }
    public boolean existItem(String itemName){
        if(Item.getInstance(itemName)!=null)
            return true;
        for(Item item : items)
            if(item.name.equals(itemName))
                return true;
        return false;
    }
}