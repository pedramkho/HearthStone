package Cards.SpellCards;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Player.Player;

public class Tsunami extends Spell {

    public Tsunami() {
        super.name = "Tsunami";
        super.MPCost = 6;
        super.type = cardType.Instant;
        super.cardTypeInString = "Instant";
        super.details = "Deal 500 damage to all non-Atlantian monster cards on both sides of field.";
    }

    public void action(Player player, Player enemy, int target) {
        for(Monster monster : player.monsterField){
            if(monster.house != House.Atlantian){
                monster.HP -= 500;
            }
        }
        player.updateLists();
        for(Monster monster : enemy.monsterField){
            if(monster.house != House.Atlantian){
                monster.HP -= 500;
            }
        }
        player.updateLists();
    }
}