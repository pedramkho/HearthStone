package Cards;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Cards.Spell.Spell;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;

import java.io.Serializable;

public class Component implements Serializable {
    public String name= "";
    public boolean custom;
    protected int price;
    public Integer defaultNumberInShop = null;
    protected boolean isTradable = true;

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        if(custom || (this instanceof Item) || (this instanceof Amulet))
            return price;
        if(this instanceof Card)
            if(this instanceof Monster)
                switch (((Monster)this).type){
                    case Normal:
                        return 300*((Monster)this).MPCost;
                    case SpellCaster:
                        return 500*((Monster)this).MPCost;
                    case General:
                        return 700*((Monster)this).MPCost;
                    case Hero:
                        return 1000*((Monster)this).MPCost;
                }
            else
                return 700*((Cards.SpellCards.Spell)this).MPCost;
        System.out.println("Error : spell passed to getPrice method");
        return -1;
    }
    public String getName(){
        return name;
    }
    public Integer getNumberInShop(){
        if(this instanceof Card)
            return Card.cardsNumberInShop.get(getName());
        if(this instanceof Amulet)
            return Amulet.amuletsNumberInShop.get(getName());
        else
            return null;
    }//todo
    public boolean isThereInShop(){
        return isTradable()&&((this instanceof Item) || (getNumberInShop() > 0));
    }
    public boolean isTradable(){
        return isTradable;
    }
    public void changeNumberInShop(int num){
        if(this instanceof Card)
            Card.cardsNumberInShop.put(getName(),Card.cardsNumberInShop.get(getName())+num);
        else if(this instanceof Amulet)
            Amulet.amuletsNumberInShop.put(getName(),Amulet.amuletsNumberInShop.get(getName()) + num);
        else if(!(this instanceof Item))
            System.out.println("Error in change number of component in shop");
    }
    public boolean equals(Component component){
        return ((this instanceof Card)&&(component instanceof Card)&&((Card)this).equals((Card)component)
                ||((this instanceof Item)&&(component instanceof Item) && ((Item)this).equals((Item)component))
                ||((this instanceof Amulet)&&(component instanceof Amulet)&&((Amulet)this).equals((Amulet)component)));
    }
    public static Component getComponent(String name) {
        if(name.contains("("))
            name = name.substring(0,name.indexOf("(")-1);
        if(name.contains("."))
            name = name.substring(name.indexOf(".")+2);
        for (Component component : Card.cards)
            if (component.getName().equals(name))
                return component;
        for (Component component : Item.items)
            if (component.getName().equals(name))
                return component;
        for (Component component : Amulet.amulets)
            if (component.getName().equals(name))
                return component;
        System.out.println("Component not found" +
                "looking name : " + name);
        return null;
    }
    public String getInfo(){
        String info = "";
        switch (getType()){
            case Card:
                info =getName() + " Info :\n" +
                        "Name : " + getName();
                if(this instanceof Monster) {
                    Monster monster = (Monster) this;
                    info += "\nHP : " + Integer.toString(monster.defaultHP) +
                            "\nAP : " + Integer.toString(monster.defaultAP) +
                            "\nMP cost : " + Integer.toString(monster.MPCost) +
                            "\nCard Type : " + monster.type.toString() +
                            "\nCard Tribe : " + monster.house.toString() +
                            "\nIs Defensive :" + (monster.specialty == Specialty.Defender ? "True" : "False") +
                            "\nIs Nimble : " + (monster.specialty == Specialty.Nimble ? "True" : "False");
                    if (monster.type == Type.SpellCaster || monster.type == Type.Hero) {
                        info += "\nSpell details : \n";
                        if (monster.auraEffects.size() == 0)
                            info += "No Spell";
                        else
                            for (Cards.SpellCards.Spell spell : monster.auraEffects) {
                                info += "\n" + spell.name + " : " + spell.description;
                            }
                    }
                    if (monster.type == Type.General || monster.type == Type.Hero) {
                        info += "\nBattleCry details : \n";
                        if (monster.battleCryDescription == null)
                            info += "No BattleCry";
                        else
                            info += monster.battleCryDescription;
                        info += "\nWill details : \n";
                        if (monster.willDescription == null)
                            info += "No Will";
                        else
                            info += monster.willDescription;
                    }
                }else{
                    Cards.SpellCards.Spell spell = (Cards.SpellCards.Spell) this;
                    info += "\nMP cost : " + Integer.toString(spell.MPCost) +
                            "\nCard Type : " + spell.type.toString() +
                            "\nSpell details : " + spell.details;
                }
                break;
            case Amulet:
                Amulet amulet = (Amulet) this;
                info = amulet.name + " Info :\n" + amulet.details;
                break;
            case Item:
                Item item = (Item) this;
                info = item.name + "  Info :\n" + item.details;
        }
        return info;
    }//todo
    public static Component[] getGameComponents(ComponentType componentType){
        switch (componentType){
            case Card:
                return Card.cards.toArray(new Card[Card.cards.size()]);
            case Item:
                return Item.items.toArray(new Item[Item.items.size()]);
            case Amulet:
                return Amulet.amulets.toArray(new Amulet[Amulet.amulets.size()]);
            case Spell:
                return Spell.spells.toArray(new Spell[Spell.spells.size()]);
        }
        return null;
    }
    public static void initilizeComponentsNumberInShop(){
        Card.computeCardsNumberInShop();
        Amulet.computeAmuletsNumberInShop();
    }
    public ComponentType getType(){
        if(this instanceof Card)
            return ComponentType.Card;
        else if(this instanceof Amulet)
            return ComponentType.Amulet;
        else if(this instanceof Item)
            return ComponentType.Item;
        else
            return ComponentType.Spell;
    }

    @Override
    public boolean equals(Object object){
        return (object instanceof Component) && equals((Component)object);
    }
}
