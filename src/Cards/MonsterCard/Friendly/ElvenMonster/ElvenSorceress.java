package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class ElvenSorceress extends Monster{

    public ElvenSorceress() {
        super.haveSpell = true;
        super.name = "Elven Sorceress";
        super.readyToAttack = true;
        super.house = House.Elven;
        super.defaultHP = 1000;
        super.defaultAP = 1000;
        super.HP = 1000;
        super.AP = 1000;
        super.MPCost = 7;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.Nimble;
    }

    public void spellEffect(Player player, Player enemy, int target){
        for(Monster monster: enemy.monsterField){
            monster.HP -= 400;
        }
        enemy.choosenSpell = enemy.getSearchedSpell();
        enemy.choosenSpell.removeSpell(enemy);
        enemy.updateLists();
    }

    String spellDetails = "Arcane Explosion: Deal 400 damage to all enemy monster cards and remove" +
                          " a random spell card from enemy field and move it to graveyard.";
}
