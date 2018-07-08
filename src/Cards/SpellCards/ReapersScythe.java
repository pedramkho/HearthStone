package Cards.SpellCards;

import Player.Player;

public class ReapersScythe extends Spell {

    public ReapersScythe() {
        super.name = "Reaper's Scythe";
        super.MPCost = 4;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.needChoosing = true;
        super.details = "Send an enemy monster or spell card from field to graveyard.";
    }

    public void action(Player player, Player enemy, int target) {
        enemy.choosenMonster = enemy.getSearchedMonster(target);
        enemy.getChoosenMonster().Alive = false;
        enemy.updateLists();
        this.removeSpell(player);
    }
}

