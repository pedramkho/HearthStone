package Cards.SpellCards;

import Player.Player;

public class ThrowingKnives extends Spell {

    public ThrowingKnives() {
        super.name = "Throwing Knives";
        super.MPCost = 3;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.needChoosing = true;
        details = "Deal 500 damage to a selected enemy monster card on the field or to enemy player.";
    }

    public void action(Player player, Player enemy, int target) {
        enemy.choosenMonster = enemy.getSearchedMonster(target);
        enemy.getChoosenMonster().HP -= 500;
        enemy.updateLists();
        this.removeSpell(player);
    }
}