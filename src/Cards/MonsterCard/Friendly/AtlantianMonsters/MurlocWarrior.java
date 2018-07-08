package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class MurlocWarrior extends Monster {

    public MurlocWarrior() {
        super.haveSpell = false;
        super.name = "Murloc Warrior";
        super.defaultHP = 600;
        super.defaultAP = 600;
        super.house = House.Atlantian;
        super.readyToAttack = false;
        super.HP = 600;
        super.AP = 600;
        super.MPCost = 2;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
