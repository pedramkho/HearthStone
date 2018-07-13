package Cards.SpellCards;

import Player.Player;

public class BloodFeast extends Spell {

    public BloodFeast() {
        super.targetIsFriendly = false;
        super.type = cardType.Instant;
        super.MPCost = 4;
        super.name = "Blood Feast";
        super.cardTypeInString = "Instant";
        super.details = "Deal 500 damage to enemy player and heal your player for 500 HP.";
    }

    public void action(Player player, Player enemy, int target) {
        if(player.Hero.HP + 500 < player.MaxHP){
            player.Hero.HP += 500;
        }else{
            player.Hero.HP = player.MaxHP;
        }
        enemy.Hero.HP -= 500;
        enemy.updateLists();
        this.removeSpell(player);
    }
}
