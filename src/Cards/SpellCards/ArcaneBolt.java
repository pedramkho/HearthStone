package Cards.SpellCards;

import Player.Player;

public class ArcaneBolt extends Spell {

    public ArcaneBolt() {
        super.name = "Arcane Bolt";
        super.MPCost = 5;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.needChoosing = true;
        super.details = "Deal 500 damage to enemy player and select and move an enemy spell card from field to graveyard.";
    }

    public void action(Player player, Player enemy, int target) {
        enemy.Hero.HP -= 500;
        Spell selectedSpell = enemy.getSearchedSpell(target);
        enemy.spellField.remove(selectedSpell);
        enemy.graveYard.add(selectedSpell);
        enemy.updateLists();
        this.removeSpell(player);
    }

}