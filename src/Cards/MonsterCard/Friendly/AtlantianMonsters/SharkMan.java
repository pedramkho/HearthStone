package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class SharkMan extends Monster {

    public SharkMan() {
        super.haveSpell = false;
        super.name = "Shark Man";
        super.defaultHP = 900;
        super.defaultAP = 1200;
        super.house = House.Atlantian;
        super.readyToAttack = true;
        super.HP = 900;
        super.AP = 1200;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Nimble;
    }
}
