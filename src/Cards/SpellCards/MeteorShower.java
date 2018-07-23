package Cards.SpellCards;

import Player.Player;

public class MeteorShower extends Spell {

    public MeteorShower() {
        super.name = "Meteor Shower";
        super.MPCost = 8;
        super.type = cardType.Continuous;
        super.cardTypeInString = "Continuous";
        super.details = "Deal 800 damage to a random enemy monster card on field or player.";
        super.isTradable = false;//remember
    }

    public void action(Player player, Player enemy, int target) {
        enemy.choosenMonster = enemy.getSearchedMonster();
        enemy.choosenMonster.HP -= 800;
    }
}
