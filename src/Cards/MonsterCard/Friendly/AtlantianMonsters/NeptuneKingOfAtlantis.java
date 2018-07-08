package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class NeptuneKingOfAtlantis extends Monster {

    public NeptuneKingOfAtlantis() {
        super.haveSpell = true;
        super.name = "Neptune, King Of Atlantis";
        super.defaultHP = 2200;
        super.defaultAP = 2500;
        super.house = House.Atlantian;
        super.readyToAttack = true;
        super.HP = 2200;
        super.AP = 2500;
        super.MPCost = 100;
        super.type = Type.Hero;
        super.specialty = Specialty.Nimble;
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        enemy.Hero.HP -= 400;
        for(Monster monster : enemy.monsterField){
            monster.HP -= 400;
        }
        for(Monster monster: player.monsterField){
            monster.AP += 500;
        }
        enemy.updateLists();
    }
    public void spellEffect(Player player, Player enemy, int target){
        for(int i = 0; i < enemy.monsterField.size() && i < 3; i++) {
            Monster monster = enemy.monsterField.get(i);
            monster.HP -= 800;
        }
        enemy.updateLists();
        this.haveSpell = false;
    }
    public void battlecry(Player player, Player enemy, int target){
        player.moveCardFromHandToField(target);
    }

    String battleCryDescription = "Call to Arms: Select and move a card from hand to play field.";
    String willDescription = "Ocean’s Cry: Deal 400 damage to all enemy monster cards and player and " +
                                "increase all friendly Atlantian monster cards’ AP by 500.";
    String spellDetails = "Trident Beam: Deal 800 damage to three random enemy monster cards or player.";
}
