package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.Card;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class Necromancer extends Monster {

    public Necromancer() {
        super.haveSpell = true;
        super.name = "Necromancer";
        super.defaultHP = 1200;
        super.readyToAttack = true;
        super.HP = 1200;
        super.AP = 1500;
        super.MPCost = 7;
        super.type = Type.SpellCaster;
        super.specialty = Specialty.Nimble;
    }

    public void spellEffect(Player player, Player enemy, int target){
        if(player.graveYard.size() > 0) {
            Card card = player.graveYard.get(0);
            if(card instanceof Monster){
                Monster.revive((Monster)card);
            }
            player.hand.add(card);
            this.haveSpell = false;
        }
    }

    String spellDetails = "Raise Dead: Move a random card from your graveyard to hand.";
}