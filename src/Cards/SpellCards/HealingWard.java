package Cards.SpellCards;

import Cards.MonsterCard.Monster;
import Player.Player;

public class HealingWard extends Spell {

    public HealingWard() {
        super.targetIsFriendly = false;
        super.name = "Healing Ward";
        super.MPCost = 5;
        super.type = cardType.Continuous;
        super.cardTypeInString = "Continuous";
        super.details = "Increase all friendly monster cards’ HP by 200.";
    }

    public void action(Player player, Player enemy, int target) {
        for(Monster monster: player.monsterField){
            monster.HP += 200;
        }
    }
}

