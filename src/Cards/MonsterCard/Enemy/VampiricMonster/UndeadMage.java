package Cards.MonsterCard.Enemy.VampiricMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class UndeadMage extends Monster {

    public UndeadMage() {
        super.haveSpell = true;
        super.name = "Undead Mage";
        super.defaultHP = 800;
        super.defaultAP = 1000;
        super.readyToAttack = false;
        super.HP = 800;
        super.AP = 1000;
        super.MPCost = 6;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player , Player enemy, int target){
        for(Monster monster : enemy.monsterField){
            monster.AP -= 500;
        }
    }

    String spellDetails = "Curse: Reduce an enemy monster card’s AP by 500.";
}
