package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class Hellhound extends Monster {

    public Hellhound() {
        super.haveSpell = false;
        super.name = "Hellhound";
        super.defaultHP = 800;
        super.defaultAP = 1000;
        super.readyToAttack = true;
        super.HP = 800;
        super.AP = 1000;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Nimble;
    }
}
