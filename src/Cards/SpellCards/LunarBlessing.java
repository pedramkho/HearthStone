package Cards.SpellCards;

import Cards.MonsterCard.Monster;
import Player.Player;

public class LunarBlessing extends Spell {

    public LunarBlessing() {
        super.details = "Increase AP and HP of friendly Elven monster cards by 300.";
        super.cardTypeInString = "Aura";
        super.type = cardType.Aura;
        super.MPCost = 6;
        super.name = "Lunar Blessing";
    }

    public void action(Player player, Player enemy, int  target) {
        for(Monster monster: player.getMonsterField()){
            if(!monster.auraEffects.contains(this)) {
                monster.HP += 300;
                monster.AP += 300;
                monster.auraEffects.add(this);
            }
        }
    }
    public void auraRemove(Player player){
        for(Monster monster : player.monsterField){
            if(monster.auraEffects.contains(this)){
                monster.auraEffects.remove(this);
                monster.HP -= 300;
                monster.AP -= 300;
            }
            player.updateLists();
        }
    }
}
