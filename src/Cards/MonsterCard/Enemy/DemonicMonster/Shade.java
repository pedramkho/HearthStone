package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class Shade extends Monster {

    public Shade() {
        super.haveSpell = false;
        super.name = "Shade";
        super.defaultHP = 500;
        super.defaultAP = 800;
        super.readyToAttack = false;
        super.HP = 500;
        super.AP = 800;
        super.MPCost = 3;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
