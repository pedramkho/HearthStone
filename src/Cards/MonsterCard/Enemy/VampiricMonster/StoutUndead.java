package Cards.MonsterCard.Enemy.VampiricMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class StoutUndead extends Monster {

    public StoutUndead() {
        super.haveSpell = false;
        super.name = "Stout Undead";
        super.defaultHP = 1200;
        super.defaultAP = 600;
        super.readyToAttack = false;
        super.HP = 1200;
        super.AP = 600;
        super.MPCost = 4;
        super.type = Type.Normal;
        super.specialty = Specialty.Defender;
    }
}
