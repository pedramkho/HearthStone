package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class YellowDrake extends Monster {

    public YellowDrake() {
        super.haveSpell = false;
        super.name = "Yellow Drake";
        super.defaultHP = 800;
        super.defaultAP = 1000;
        super.house = House.Dragon;
        super.readyToAttack = true;
        super.HP = 800;
        super.AP = 1000;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Nimble;
    }
}