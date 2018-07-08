package Cards.MonsterCard.Enemy.OrgeMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class OrgeWarrior extends Monster {

    public OrgeWarrior() {
        super.haveSpell = false;
        super.name = "Orge Warrior";
        super.defaultHP = 800;
        super.defaultAP = 500;
        super.readyToAttack = false;
        super.HP = 800;
        super.AP = 500;
        super.MPCost = 3;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
