package Cards.MonsterCard.Enemy.OrgeMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class OrgeMagi extends Monster {

    public OrgeMagi() {
        super.haveSpell = true;
        super.name = "Orge Magi";
        super.defaultHP = 1500;
        super.defaultAP = 800;
        super.readyToAttack = false;
        super.HP = 1500;
        super.AP = 800;
        super.MPCost = 5;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player, Player enemy, int target){
        for(Monster monster : player.monsterField){
            monster.HP += 400;
        }
        this.haveSpell = false;
    }

    String spellDetails = "Enrage: Increase a friendly monster card’s AP by 400.";
}
