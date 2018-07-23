package Cards.SpellCards;

import Cards.Card;
import Player.Player;

import java.util.ArrayList;

public class Spell extends Card {

    public String cardTypeInString = "";
    public cardType type = cardType.Instant;
    public String details;

    Spell(){
        super.description = "";
    }

    public void action(Player player, Player enemy, int target){}
    public void removeSpell(Player player){
        auraRemove(player);
        player.hand.remove(this);
        player.spellField.remove(this);
        player.graveYard.add(this);
    }
    public void auraRemove(Player player){
        //TODO:======
    }
    public String cardInfo() {
        String ans;
        ans = this.name + " info:" + "\n";
        ans = ans + "Name :" + this.name + "\n";
        ans = ans + "MP cost: " + super.MPCost + "\n";
        ans = ans + "Card Type: " + this.cardTypeInString + "\n";
        //We should add Spell details here
        ans = ans + this.details;
        return ans;
    }
    public static boolean removeSpellCard(String name){
        for(Card card : cards)
            if((card instanceof Spell) && card.getName().equals(name)){
                cards.remove(card);
                return true;
            }
            return false;
    }

    public boolean equals(Spell spell){
        return name.equals(spell.name);
    }
}


