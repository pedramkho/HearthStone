package Cards.MonsterCard.Friendly.DragonBreedMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class GreaterDragon extends Monster {
    public boolean haveSpell = true;
    public String name = "Greater Dragon";
    public int defaultHP = 2000;
    public int defaultAP = 1800;
    public House house = House.Dragon;
    public boolean readyToAttack = false;
    public int HP = 2000;
    public int AP = 1800;
    public int MPcost = 8;
    public Specialty specialty = Specialty.Defender;
    public Type type = Type.SpellCaster;

    //Will:
    public void will(Player player, Player enemy, int target){
        player.moveCardFromDeckToHand();
        player.moveCardFromDeckToHand();
    }

    public void battlecry(Player player, Player enemy, int target){
        if(enemy.monsterField.size() > 0){
            enemy.monsterField.get(0).Alive = false;
            enemy.updateLists();
        }
    }

    String willDescription = "Dragon’s Call: draw two cards from initialDeck to hand.";
    String battleCryDescription = "Devour: Send a random enemy monster card from field to graveyard.";
}
