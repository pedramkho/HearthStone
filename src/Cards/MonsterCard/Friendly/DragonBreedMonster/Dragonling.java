package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class Dragonling extends Monster {

    public Dragonling() {
        super.haveSpell = false;
        super.name = "Dragonling";
        super.defaultHP = 700;
        super.defaultAP = 700;
        super.house = House.Dragon;
        super.readyToAttack = false;
        super.HP = 700;
        super.AP = 700;
        super.MPCost = 3;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
