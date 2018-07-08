package ItemsAndAmulets;

import Cards.Card;
import Player.Player;

import java.lang.reflect.Constructor;

public class Item {
    public int itemCost = 0;
    public String name = "";
    public void action(Player player){}
    //added
    public String details;

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
    @Override
    public boolean equals(Object object){
        return (this.getClass().getName()==object.getClass().getName());
    }
    @Override
    public int hashCode() {
        return getClass().getName().hashCode();
    }
    //end
}
