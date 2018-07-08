package Cards.MonsterCard.Enemy.DemonicMonster;

import Cards.Card;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class DarkKnight extends Monster {

    public DarkKnight() {
        super.haveSpell = false;
        super.name = "Dark Knight";
        super.defaultHP = 2500;
        super.defaultAP = 2500;
        super.readyToAttack = false;
        super.HP = 2500;
        super.AP = 2500;
        super.MPCost = 8;
        super.type = Type.General;
        super.specialty = Specialty.None;
        super.battleCryDescription = "Sacrifice: Select and move a card from hand to graveyard.";
        super.willDescription = "Loyalty: Heal your player for 1000 HP.";
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        player.Hero.HP += 1000;
    }

    public void battlecry(Player player, Player enemy, int target){
        Card card = player.getSearchedCardFromGraveyard(target);
        player.graveYard.remove(card);
        if(card instanceof Monster){
            Monster.revive((Monster)card);
        }
        player.hand.add(card);
    }

}
