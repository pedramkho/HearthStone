package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class LivingArmor extends Monster {

    public LivingArmor() {
        super.haveSpell = false;
        super.name = "Living Armor";
        super.defaultHP = 1500;
        super.defaultAP = 400;
        super.readyToAttack = false;
        super.HP = 1500;
        super.AP = 400;
        super.MPCost = 5;
        super.type = Type.Normal;
        super.specialty = Specialty.Defender;
    }
}
