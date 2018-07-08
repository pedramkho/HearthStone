package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class NagaSiren extends Monster {

    public NagaSiren() {
        super.haveSpell = true;
        super.name = "Naga Siren";
        super.defaultHP = 1200;
        super.defaultAP = 600;
        super.house = House.Atlantian;
        super.readyToAttack = false;
        super.HP = 1200;
        super.AP = 600;
        super.MPCost = 6;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player, Player enemy, int target){
        for(Monster monster: player.monsterField){
            monster.HP += 300;
            monster.AP += 300;
        }
        this.haveSpell = false;
    }

    String spellDetails = "Song of the Siren: Increase HP of all friendly monster cards by 300 and their AP by 200.";
}
