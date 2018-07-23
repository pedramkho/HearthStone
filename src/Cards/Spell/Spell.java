package Cards.Spell;

import Cards.Component;

import java.util.ArrayList;

public class Spell extends Component {
    public static ArrayList<Spell> spells ;
    public boolean custom = false;
    public String name ;

    public static boolean removeSpell(String name) {
        for(Spell spell : spells)
            if(spell.getName().equals(name)){
            spells.remove(spell);
            return true;
            }
            return false;
    }

    public String getName(){
        return name;
    }
}
