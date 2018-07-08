package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class ElvenHunter extends Monster{

    public ElvenHunter() {
        super.haveSpell = false;
        super.name = "Elven Hunter";
        super.readyToAttack = false;
        super.house = House.Elven;
        super.defaultHP = 800;
        super.defaultAP = 600;
        super.HP = 800;
        super.AP = 600;
        super.MPCost = 3;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
