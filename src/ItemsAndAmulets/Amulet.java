package ItemsAndAmulets;

import Cards.Component;
import Player.Player;
import customGame.CustomGame;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Amulet extends Component {
    static public ArrayList<Amulet> amulets = new ArrayList<>();
    public static Map<String, Integer> amuletsNumberInShop = new HashMap<>();
    public static void computeAmuletsNumberInShop(){
        for(Amulet amulet : CustomGame.data.amulets)
            if(amulet.custom)
                amuletsNumberInShop.put(amulet.getName(),amulet.defaultNumberInShop);
            else
                amuletsNumberInShop.put(amulet.getName(),1);
    }
    public int maxHpChange;
    public int maxMpChange;

    public static boolean removeAmulet(String name) {
        for(Amulet amulet : amulets)
            if(amulet.getName().equals(name)){
            amulets.remove(amulet);
            return true;
            }
            return false;
    }

    public void action(Player player){}
    public void remove(Player player){}
    public String details;

    public String getName() {
        return name;
    }

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
    public Amulet(String name,int maxHpChange,int maxMpChange,int price,boolean custom){
        this.name = name;
        this.maxHpChange = maxHpChange;
        this.maxMpChange = maxMpChange;
        this.price = price;
        this.custom = custom;
    }

    public boolean equals(Amulet amulet) {
        return getName().equals(amulet.getName());
    }
    public static void createNewCustomAmulet(String name, int maxHpChange, int maxMpChange, int price){
        amulets.add(new Amulet(name,maxHpChange,maxMpChange,price,true));
    }
}