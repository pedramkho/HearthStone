package Cards.SpellCards;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Type;
import Player.Player;

public class TakeAllYouCan extends Spell {

    public TakeAllYouCan() {
        super.name = "Take All You Can";
        super.MPCost = 7;
        super.type = cardType.Aura;
        super.cardTypeInString = "Aura";
        super.details = "Increase all friendly normal monster cards’ HP and AP by 400.";
    }

    public void action(Player player, Player enemy, int target) {
        for(Monster monster : player.monsterField){
            if(monster.type == Type.Normal){
                if(!monster.auraEffects.contains(this)) {
                    monster.HP += 400;
                    monster.AP += 500;
                    monster.auraEffects.add(this);
                }
            }
        }
    }

    public void auraRemove(Player player){
        for(Monster monster: player.monsterField){
            if(monster.auraEffects.contains(this)){
                monster.HP -= 400;
                monster.AP -= 500;
                monster.auraEffects.remove(this);
            }
        }
        player.updateLists();
    }
}

