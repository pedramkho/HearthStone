package Cards.SpellCards;

import Player.Player;

import java.util.ArrayList;

public class GreaterPurge extends Spell {

    public GreaterPurge() {
        super.targetIsFriendly = false;
        super.name = "Greater Purge";
        super.MPCost = 7;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.needChoosing = false;
        super.details = "Remove all spell cards on field from both sides and move them to hand.";
    }

    public void action(Player player, Player enemy, int target){
        for(Cards.SpellCards.Spell Spell: player.spellField){
            player.graveYard.add(Spell);
        }
        for(Cards.SpellCards.Spell Spell: enemy.spellField){
            enemy.graveYard.add(Spell);
        }
        player.spellField = new ArrayList<Spell>();
        enemy.spellField = new ArrayList<Spell>();
        this.removeSpell(player);
    }
}
