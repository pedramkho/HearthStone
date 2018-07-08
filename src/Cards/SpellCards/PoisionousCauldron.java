package Cards.SpellCards;

import Cards.MonsterCard.Monster;
import Player.Player;

public class PoisionousCauldron extends Spell {

    public PoisionousCauldron() {
        super.name = "Poisionous Cauldron";
        super.MPCost = 4;
        super.type = cardType.Continuous;
        super.cardTypeInString = "Instant";
        super.details = "Deal 100 damage to all enemy monster cards and enemy player.";
    }

    public void action(Player player, Player enemy, String target) {
        for(Monster monster: enemy.getMonsterField()){
            monster.HP -= 100;
        }
        this.removeSpell(player);
    }

}
