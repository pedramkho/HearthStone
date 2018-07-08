package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class ElvenGuardsman extends Monster{

    public ElvenGuardsman() {
        super.haveSpell = false;
        super.name = "Elven Guardsman";
        super.name = "Elven Gaurdsman";
        super.readyToAttack = false;
        super.house = House.Elven;
        super.defaultHP = 1500;
        super.defaultAP = 500;
        super.HP = 1500;
        super.AP = 500;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Defender;
    }
}
