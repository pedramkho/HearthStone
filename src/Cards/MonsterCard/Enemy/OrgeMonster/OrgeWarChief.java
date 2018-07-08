package Cards.MonsterCard.Enemy.OrgeMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class OrgeWarChief extends Monster {

    public OrgeWarChief() {
        super.haveSpell = false;
        super.name = "Orge WarChief";
        super.defaultHP = 2500;
        super.defaultAP = 1500;
        super.readyToAttack = false;
        super.HP = 2500;
        super.AP = 1500;
        super.MPCost = 7;
        super.type = Type.General;
        super.specialty = Specialty.None;
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        for(Monster monster : player.monsterField){
            monster.AP += 300;
        }
    }

    public void battlecry(Player player , Player enemy, int target){
        enemy.Hero.HP -= 400;
        for(Monster monster : enemy.monsterField){
            monster.HP -= 400;
        }
        enemy.updateLists();
    }
    String willDescription = "Last Order: Increase all friendly monster cards’ AP by 300.";
    String battleCryDescription = "War Stomp: Deal 400 damage to all enemy monster cards and player.";
}
