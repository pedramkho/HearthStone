package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class Imp  extends Monster {

    public Imp() {
        super.haveSpell = false;
        super.name = "Imp";
        super.defaultHP = 300;
        super.defaultAP = 500;
        super.readyToAttack = false;
        super.HP = 300;
        super.AP = 500;
        super.MPCost = 2;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
