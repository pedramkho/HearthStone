package Cards;

import Cards.MonsterCard.Monster;
import Cards.SpellCards.Spell;
import customGame.CustomGame;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Cards.MonsterCard.Monster.removeMonster;
import static Cards.SpellCards.Spell.removeSpellCard;

public class Card extends Component {
    public boolean targetIsFriendly = false;
    public static ArrayList<Card> cards = new ArrayList<>();
    public static Map<String,Integer> cardsNumberInShop = new HashMap<>();
    public static void computeCardsNumberInShop(){
        for(Card card : CustomGame.data.cards) {
            int numberInShop;
            if (card.custom)
                numberInShop = card.defaultNumberInShop;
            else if (card instanceof Monster)
                switch (((Monster) card).type) {
                    case Normal:
                        numberInShop = 4;
                        break;
                    case Hero:
                        numberInShop = 1;
                        break;
                    default:
                        numberInShop = 2;
                }
            else if (card.MPCost < 6)
                numberInShop = 3;
            else
                numberInShop = 2;
            cardsNumberInShop.put(card.getName(), numberInShop);
        }
    }
    public int MPCost;
    public int price;
    public boolean needChoosing = false;
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
    public String getName(){return name;}
    public static boolean removeCard(String name){
        return removeMonster(name)&&removeSpellCard(name);
    }
    public boolean equals(Card card){
        if(this instanceof Monster)
            return (card instanceof Monster) && ((Monster)this).equals((Monster)card);
        return (card instanceof Spell) && ((Spell)this).equals((Spell)card);
    }
    public static void initializeCardsNumberInShop(){

    }//todo
}