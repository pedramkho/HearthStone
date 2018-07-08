package Cards.SpellCards;

import Cards.MonsterCard.Monster;
import Player.Player;

public class WarDrum extends Spell {

    public WarDrum() {
        super.name = "War Drum";
        super.MPCost = 6;
        super.type = cardType.Aura;
        super.cardTypeInString = "Aura";
        super.details = "Increase all friendly monster cards’ AP by 300.";
    }

    public void action(Player player, Player enemy, int target) {
        for (Monster monster: player.monsterField) {
            if(!monster.auraEffects.contains(this)) {
                monster.AP += 300;
                monster.auraEffects.add(this);
            }
        }
    }

    public void auraRemove(Player player){
        for(Monster monster: player.monsterField){
            if(monster.auraEffects.contains(this)){
                monster.auraEffects.remove(this);
                monster.HP -= 300;
            }
        }
        player.updateLists();
    }
}

