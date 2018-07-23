package Cards.SpellCards;

import Cards.MonsterCard.Monster;
import Player.Player;

public class StrategicRetreat extends Spell {

    public StrategicRetreat() {
        super.name = "Strategic Retreat";
        super.MPCost = 6;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.needChoosing = true;
        super.details = "Select and move a monster card from field to hand and draw one card from initialDeck.";
    }

    public void action(Player player, Player enemy, int target) {
        //TODO: need to get checked in initialDeck
        player.moveCardFromDeckToHand();
        player.choosenCard = player.getSearchedCard(target);
        player.hand.remove(player.choosenCard);
        if(player.choosenCard instanceof Monster){
            player.monsterField.add((Monster)player.choosenCard);
        }else if(player.choosenCard instanceof Spell){
            player.spellField.add((Spell)player.choosenCard);
        }
        this.removeSpell(player);
    }

}