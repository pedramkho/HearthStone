package Cards.MonsterCard.Enemy.VampiricMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class VampireAcolyte extends Monster {

    public VampireAcolyte() {
        super.haveSpell = true;
        super.name = "Vampire Acolyte";
        super.defaultHP = 1500;
        super.defaultAP = 1500;
        super.readyToAttack = true;
        super.HP = 1500;
        super.AP = 1500;
        super.MPCost = 7;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.Nimble;
    }

    public void spellEffect(Player player, Player enemy, int target){
        for(Monster monster : enemy.monsterField){
            monster.HP -= 300;
        }
        for(Monster monster : player.monsterField){
            monster.HP += 300;
        }
        player.updateLists();
        enemy.updateLists();
    }

    String spellDetails = "Black Wave: Deal 300 damage to all enemy monster cards and heal all friendly monster cards for 300 HP.";
}
