package Cards.SpellCards;

import Player.Player;

public class FirstAidKit extends Spell {

    public FirstAidKit() {
        super.name = "First Aid Kit";
        super.MPCost = 3;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.needChoosing = true;
        super.details = "Increase HP of a selected friendly monster card or player by 500.";
    }

    public void action(Player player , Player enemy, int target) {
        player.choosenMonster = player.getSearchedMonster(target);
        player.getChoosenMonster().HP += 500;

    }
}
