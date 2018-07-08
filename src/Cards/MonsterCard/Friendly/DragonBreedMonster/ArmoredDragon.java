package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class ArmoredDragon extends Monster {

    public ArmoredDragon() {
        super.haveSpell = false;
        super.name = "Armored Dragon";
        super.defaultHP = 2000;
        super.defaultAP = 400;
        super.house = House.Dragon;
        super.readyToAttack = false;
        super.HP = 2000;
        super.AP = 400;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Defender;
    }
}
