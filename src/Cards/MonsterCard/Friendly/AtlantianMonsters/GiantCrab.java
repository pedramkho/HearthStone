package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class GiantCrab extends Monster {
    public GiantCrab() {
        super.haveSpell = false;
        super.name = "Giant Crab";
        super.defaultHP = 1500;
        super.defaultAP = 300;
        super.house = House.Atlantian;
        super.readyToAttack = false;
        super.HP = 1500;
        super.AP = 300;
        super.MPCost = 4;
        super.type = Type.Normal;
        super.specialty = Specialty.Defender;
    }
}