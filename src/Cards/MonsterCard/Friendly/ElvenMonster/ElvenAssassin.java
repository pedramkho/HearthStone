package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class ElvenAssassin extends Monster{

    public ElvenAssassin() {
        super.haveSpell = false;
        super.name = "Elven Assassin";
        super.readyToAttack = false;
        super.house = House.Elven;
        super.defaultHP = 800;
        super.defaultAP = 1200;
        super.HP = 800;
        super.AP = 1200;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Nimble;
    }
}
