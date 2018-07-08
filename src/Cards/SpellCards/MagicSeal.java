package Cards.SpellCards;

import Player.Player;

import java.util.ArrayList;

public class MagicSeal extends Spell {

    public MagicSeal() {
        super.name = "Magic Seal";
        super.MPCost = 9;
        super.type = cardType.Continuous;
        super.cardTypeInString = "Continuous";
        super.details = "Remove all enemy spell cards from field and move them to graveyard.";
    }

    public void action(Player player, Player enemy, int target) {
        for(Cards.SpellCards.Spell Spell: enemy.spellField){
            enemy.graveYard.add(Spell);
        }
        enemy.spellField = new ArrayList<Spell>();
    }
}