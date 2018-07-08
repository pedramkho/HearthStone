package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class VolcaincDragon extends Monster {

    public VolcaincDragon() {
        super.haveSpell = true;
        super.name = "Volcainc Dragon";
        super.defaultHP = 2500;
        super.defaultAP = 700;
        super.house = House.Dragon;
        super.readyToAttack = false;
        super.HP = 2500;
        super.AP = 700;
        super.MPCost = 8;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.Defender;
    }

    public void spellEffect(Player player, Player enemy, int target){
        if(enemy.monsterField.size() > 0){
            enemy.monsterField.get(0).HP -= 500;
            enemy.monsterField.get(0).AP -= 500;
        }
        enemy.updateLists();
        this.haveSpell = false;
    }

    String spellDetails = "Lava Spit: Deal 500 damage to an enemy monster card and reduce its AP by 500.";
}
