package Cards.MonsterCard.Enemy.VampiricMonster;

import Cards.Card;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class VampirePrince extends Monster {

    public VampirePrince() {
        super.haveSpell = false;
        super.name = "Vampire Prince";
        super.defaultHP = 2000;
        super.defaultAP = 2200;
        super.readyToAttack = false;
        super.HP = 2000;
        super.AP = 2200;
        super.MPCost = 9;
        super.type = Type.General;
        super.specialty = Specialty.None;
    }

    //Will:
    public void will(Player player, Player enemy,int target){
        for(Monster monster : player.monsterField){
            monster.AP -= 200;
        }
        for(Monster monster : enemy.monsterField){
            monster.AP += 200;
        }
    }

    public void battlecry(Player player, Player enemy, int target){
        for(int i = 0 ; i < 2; i++) {
            if (player.graveYard.size() > 0) {
                Card monster = player.graveYard.get(0);
                player.graveYard.remove(monster);
                if(monster instanceof Monster) {
                    Monster.revive((Monster)monster);
                }
                player.hand.add(monster);
            }
        }
    }

    String battleCryDescription = "Fear: Return two random enemy monster cards from field to hand.";
    String willDescription = "Darkness: Reduce all enemy monster cards’ AP by 200 and increase friendly monster cards’ AP by 200.";
}
