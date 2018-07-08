package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class CerberusGatekeeperOfHell extends Monster {

    public CerberusGatekeeperOfHell() {
        super.haveSpell = true;
        super.name = "Cerberus, Gatekeeper Of Hell";
        super.defaultHP = 3000;
        super.defaultAP = 2000;
        super.readyToAttack = false;
        super.HP = 3000;
        super.AP = 2000;
        super.MPCost = 10;
        super.type = Type.Hero;
        super.specialty = Specialty.None;
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        for(int i = 0; i < 2; i++) {
            if (enemy.monsterField.size() > 0) {
                Monster monster = enemy.getChoosenMonster();
                monster.Alive = false;
                enemy.updateLists();
            }
        }
    }

    public void spellEffect(Player player, Player enemy, int target){
        for(Monster monster : enemy.monsterField){
            monster.HP -= 300;
        }
        for(Monster monster : player.monsterField){
            monster.HP += 300;
            monster.AP += 300;
        }
        this.haveSpell = false;
        enemy.updateLists();
    }

    public void battlecry(Player player, Player enemy, int target){
        player.moveCardFromDeckToHand();
        player.moveCardFromDeckToHand();
        player.moveCardFromDeckToHand();
    }
}
