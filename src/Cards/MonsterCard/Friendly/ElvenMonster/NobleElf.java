package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

import java.util.ArrayList;

public class NobleElf extends Monster {

    public NobleElf() {
        super.haveSpell = false;
        super.name = "Noble Elf";
        super.readyToAttack = false;
        super.house = House.Elven;
        super.defaultHP = 2000;
        super.defaultAP = 2400;
        super.HP = 2000;
        super.AP = 2400;
        super.MPCost = 9;
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        player.choosenMonster = player.getSearchedMonster();
        player.choosenMonster.HP += 800;
        player.choosenMonster.AP += 600;
    }
    public Type type = Type.General;
    public Specialty specialty = Specialty.None;
    public void battlecry(Player player, Player enemy, int target){
        for(Monster monster: enemy.monsterField){
            enemy.hand.add(monster);
        }
        enemy.monsterField = new ArrayList<Monster>();
    }

    String battleCryDescription = "Purge: Remove all enemy spell cards on the field and move them to hand.";
    String willDescription = "Increase a random friendly Elven monster card on the field’s HP by 800 and AP by 600.";
}
