package Cards.SpellCards;

import Cards.Card;
import Player.Player;

public class Spell extends Card {
    public String cardTypeInString = "";
    public cardType type = cardType.Instant;
    public String details;

    Spell(){
        super.description = "";
    }


    public boolean targetIsFriendly = false;
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

}


