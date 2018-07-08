package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class BlueDragon extends Monster {

    public BlueDragon() {
        super.haveSpell = true;
        super.name = "Blue Dragon";
        super.defaultHP = 800;
        super.defaultAP = 1000;
        super.house = House.Dragon;
        super.readyToAttack = false;
        super.HP = 800;
        super.AP = 1000;
        super.MPCost = 5;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player, Player enemy, int target){
        if(enemy.monsterField.size() > 0)
            enemy.monsterField.get(0).Alive = false;
        enemy.updateLists();
    }

    String spellDetails = "Magical Fire: Move an enemy monster card from field to graveyard.";
}
