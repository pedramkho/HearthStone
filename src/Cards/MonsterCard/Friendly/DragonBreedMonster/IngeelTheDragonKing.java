package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class IngeelTheDragonKing extends Monster {

    public IngeelTheDragonKing() {
        super.haveSpell = true;
        super.name = "Ingeel, The Dragon King";
        super.defaultHP = 4000;
        super.defaultAP = 800;
        super.house = House.Dragon;
        super.readyToAttack = false;
        super.HP = 4000;
        super.AP = 800;
        super.MPCost = 10;
        super.type = Type.Hero;
        super.specialty = Specialty.None;
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        for(Monster monster: enemy.monsterField){
            monster.AP -= 400;
        }
        enemy.updateLists();
    }

    public void spellEffect(Player player, Player enemy, int target){
        enemy.Hero.HP -= 600;
        for(Monster monster: enemy.monsterField){
            monster.HP -= 600;
        }
        this.haveSpell = false;
    }

    public void battlecry(Player player, Player enemy, int target){
        for(Monster monster : player.monsterField){
            if(monster.type != Type.Hero){
                monster.Alive = false;
            }
        }
        for(Monster monster : enemy.monsterField){
            if(monster.type != Type.Hero){
                monster.Alive = false;
            }
        }
        player.updateLists();
        enemy.updateLists();
    }

    String battleCryDescription = "King’s Grace: Send all non-Hero monster cards on both sides of field to their graveyards.";
    String willDescription = "King’s Wail: Decrease all enemy monster cards’ AP by 400.";
    String spellDetails = "King’s Wing Slash: Deal 600 damage to all enemy monster cards and player.";
}