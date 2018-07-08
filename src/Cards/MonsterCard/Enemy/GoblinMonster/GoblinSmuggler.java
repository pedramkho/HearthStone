package Cards.MonsterCard.Enemy.GoblinMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class GoblinSmuggler extends Monster {

    public GoblinSmuggler() {
        super.haveSpell = false;
        super.name = "Goblin Smuggler";
        super.defaultHP = 600;
        super.defaultAP = 400;
        super.readyToAttack = false;
        super.HP = 600;
        super.AP = 400;
        super.MPCost = 2;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
