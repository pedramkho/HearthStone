package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class ElvenRanger extends Monster{

    public ElvenRanger() {
        super.haveSpell = false;
        super.name = "Elven Ranger";
        super.defaultHP = 300;
        super.defaultAP = 400;
        super.house = House.Elven;
        super.readyToAttack = false;
        super.HP = 300;
        super.AP = 400;
        super.MPCost = 1;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}