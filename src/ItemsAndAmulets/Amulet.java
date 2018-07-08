package ItemsAndAmulets;

import Player.Player;

import java.lang.reflect.Constructor;

public class Amulet {
    public int amuletCost = 0;
    public String name = "";
    public void action(Player player){}
    public void remove(Player player){}
    public String details;

    static public Amulet getInstance(String amuletName){
        String className = amuletName.replace(" ","");
        className = className.replace("'","");
        className = className.replace(",","");
        Class amuletClass = null;
        try {
            amuletClass = Class.forName("ItemsAndAmulets.Amulet" + className);
        }catch (ClassNotFoundException e){ }
        if(amuletClass == null)
            return null;
        try {
            Constructor cardConstructor = amuletClass.getConstructor();
            return  (Amulet) cardConstructor.newInstance();
        }catch (Exception e){}
        return null;
    }

    public Amulet(){}
    @Override
    public boolean equals(Object object){
        return (this.getClass().getName().equals(object.getClass().getName()));
    }
    @Override
    public int hashCode() {
        return getClass().getName().hashCode();
    }
}

//Farhood added this class