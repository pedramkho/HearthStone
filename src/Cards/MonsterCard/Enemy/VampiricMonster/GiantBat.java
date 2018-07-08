package Cards.MonsterCard.Enemy.VampiricMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class GiantBat extends Monster {

    public GiantBat() {
        super.haveSpell = false;
        super.name = "Giant Bat";
        super.defaultHP = 500;
        super.defaultAP = 900;
        super.readyToAttack = true;
        super.HP = 500;
        super.AP = 900;
        super.MPCost = 3;
        super.type = Type.Normal;
        super.specialty = Specialty.Nimble;
    }
}
