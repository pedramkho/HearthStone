package Cards;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Card implements Serializable {
    //TODO: We should add all cards name
    public int MPCost;
    public String name;
    public boolean needChoosing = false;
    //added
    public String description ;
    //todo
    public String cardInfo(){
        return "";
    }

    static public Card getInstance(String cardName){
        String className = cardName.replace(" ","");
        className = className.replace("'","");
        className = className.replace(",","");
        Class cardClass = null;
        try {
            cardClass = Class.forName("Cards.MonsterCard.Friendly.AtlantianMonsters." + className);
        }catch (ClassNotFoundException e){ }
        try {
            cardClass = Class.forName("Cards.MonsterCard.Friendly.DragonBreedMonster." + className);
        }catch (ClassNotFoundException e){ }
        try {
            cardClass = Class.forName("Cards.MonsterCard.Friendly.ElvenMonster." + className);
        }catch (ClassNotFoundException e){ }
        try {
            cardClass = Class.forName("Cards.SpellCards." + className);
        }catch (ClassNotFoundException e){ }
        if(cardClass == null)
            return null;
        try {
            Constructor cardConstructor = cardClass.getConstructor();
            return  (Card) cardConstructor.newInstance();
        }catch (Exception e){}
        return null;
    }
    @Override
    public boolean equals(Object object){
        return (this.getClass().getName().equals(object.getClass().getName()));
    }
    @Override
    public int hashCode() {
        return getClass().getName().hashCode();
    }
    public String getName(){return null;}
//end

}