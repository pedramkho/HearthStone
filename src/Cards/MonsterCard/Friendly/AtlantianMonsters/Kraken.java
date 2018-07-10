package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class Kraken extends Monster {

    public Kraken() {
        super.haveSpell = true;
        super.name = "Kraken";
        super.defaultHP = 1800;
        super.defaultAP = 2200;
        super.house = House.Atlantian;
        super.readyToAttack = false;
        super.HP = 1800;
        super.AP = 2200;
        super.MPCost = 8;
        super.type = Type.General;
        super.specialty = Specialty.None;
        battleCryDescription = "Titan’s Presence: Return one random enemy monster card from field to hand and reduce all enemy monsters’ AP by 200";
        willDescription = "Titan’s Fall: Deal 400 damage to all enemy monster cards and player.";
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        for(Monster monster: enemy.monsterField){
            monster.HP -= 400;
        }
        enemy.updateLists();
        this.haveSpell = false;
    }

    public void battlecry(Player player, Player enemy, int target){
        for(Monster monster : enemy.monsterField){
            monster.AP -= 200;
        }
        enemy.choosenMonster = enemy.getSearchedMonster();
        enemy.monsterField.remove(enemy.choosenMonster);
        enemy.hand.add(enemy.choosenMonster);
    }

    String battleCryDescription;
    String willDescription;
}
