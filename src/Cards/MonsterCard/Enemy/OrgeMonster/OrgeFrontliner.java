package Cards.MonsterCard.Enemy.OrgeMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class OrgeFrontliner extends Monster {

    public OrgeFrontliner() {
        super.haveSpell = false;
        super.name = "Orge Frontliner";
        super.defaultHP = 1800;
        super.defaultAP = 600;
        super.readyToAttack = false;
        super.HP = 1800;
        super.AP = 600;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Defender;
    }
}
