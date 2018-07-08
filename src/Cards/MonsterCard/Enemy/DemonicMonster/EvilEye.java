package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class EvilEye extends Monster {

    public EvilEye() {
        super.haveSpell = true;
        super.name = "EvilEye";
        super.defaultHP = 400;
        super.defaultAP = 400;
        super.readyToAttack = false;
        super.HP = 400;
        super.AP = 400;
        super.MPCost = 6;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player, Player enemy, int target){
        enemy.Hero.HP -= 800;
        for (Monster monster : enemy.monsterField){
            monster.HP -= 800;
        }
        enemy.updateLists();
    }

    String spellDetails = "Evil Gaze: Deal 800 damage to all enemy monster cards and player.";
}
