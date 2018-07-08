package Cards.MonsterCard.Enemy.VampiricMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class Undead extends Monster {

    public Undead() {
        super.haveSpell = false;
        super.name = "Undead";
        super.defaultHP = 200;
        super.defaultAP = 400;
        super.readyToAttack = false;
        super.HP = 200;
        super.AP = 400;
        super.MPCost = 1;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
