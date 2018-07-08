package Cards.MonsterCard.Enemy.GoblinMonster;

import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class GoblinShaman extends Monster {

    public GoblinShaman() {
        super.haveSpell = true;
        super.name = "Goblin Shaman";
        super.defaultHP = 1000;
        super.defaultAP = 7000;
        super.readyToAttack = false;
        super.HP = 1000;
        super.AP = 7000;
        super.MPCost = 4;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.None;
    }

    public void spellEffect(Player player, Player enemy, int target){
        for(Monster monster : player.monsterField){
            monster.HP += 400;
        }
    }

    String spellDetails = "Mend: Increase a friendly monster card or player’s HP by 400.";
}
