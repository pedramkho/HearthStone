package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class LesserWhelp extends Monster {

    public LesserWhelp() {
        super.haveSpell = false;
        super.name = "Lesser Whelp";
        super.defaultHP = 500;
        super.defaultAP = 300;
        super.house = House.Dragon;
        super.readyToAttack = false;
        super.HP = 500;
        super.AP = 300;
        super.MPCost = 1;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
