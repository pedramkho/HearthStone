package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class ElvenDruid extends Monster{

    public ElvenDruid() {
        super.haveSpell = true;
        super.name = "Elven Druid";
        super.readyToAttack = false;
        super.house = House.Elven;
        super.defaultHP = 1200;
        super.defaultAP = 600;
        super.HP = 1200;
        super.AP = 600;
        super.MPCost = 5;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player, Player enemy, int target){
        player.choosenMonster = player.getSearchedMonster(target);
        player.choosenMonster.HP += 500;
        player.choosenMonster.AP += 300;
        this.haveSpell = false;
    }
    String spellDetails = "Rejuvenation: Increase a selected friendly monster card’s HP by 500 and AP by 300.";
}
