package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class SeaSerpent extends Monster{

    public SeaSerpent() {
        super.haveSpell = true;
        super.name = "Sea Serpent";
        super.defaultHP = 1500;
        super.defaultAP = 1200;
        super.house = House.Atlantian;
        super.readyToAttack = true;
        super.HP = 1500;
        super.AP = 1200;
        super.MPCost = 7;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.Nimble;
    }

    public void spellEffect(Player player, Player enemy, int target){
        if(player.Hero.HP < player.Hero.defaultHP / 2 && enemy.monsterField.size() > 0){
            enemy.monsterField.get(0).HP -= 1000;
        }else{
            enemy.Hero.HP -= 1000;
        }
        enemy.updateLists();
    }

    String spellDetails = "Serpent’s Bite: Deal 1000 damage to an enemy monster card or player.";
}
