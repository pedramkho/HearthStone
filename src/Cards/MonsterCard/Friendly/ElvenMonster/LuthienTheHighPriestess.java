package Cards.MonsterCard.Friendly.ElvenMonster;

import Cards.Card;
import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;
import Player.Player;

public class LuthienTheHighPriestess extends Monster {

    public LuthienTheHighPriestess() {
        super.haveSpell = true;
        super.name = "Luthien, TheHighPriestess";
        super.readyToAttack = false;
        super.house = House.Elven;
        super.defaultHP = 2500;
        super.defaultAP = 2000;
        super.HP = 2500;
        super.AP = 2000;
        super.MPCost = 9;
    }

    //Will:
    public void will(Player player, Player enemy, int target){
        player.Hero.HP += 500;
        for(Monster monster : player.monsterField){
            monster.HP += 500;
            monster.AP += 200;
        }
    }
    public Type type = Type.Hero;
    public Specialty specialty = Specialty.None;
    public void spellEffect(Player player, Player enemy, int target){
        player.getSearchedMonster().HP += 2500;
    }

    public void battlecry(Player player, Player enemy, int target){
        for(int i = 0; i < 2 ; i++){
            if(player.graveYard.size() >= 1){
                Card card = player.graveYard.get(0);
                if(card instanceof Monster){
                    Monster.revive((Monster)card);
                }
                player.hand.add(card);
                player.graveYard.remove(0);
            }
            if(player.graveYard.size() >= 1){
                player.hand.add(player.graveYard.get(0));
                player.graveYard.remove(0);
            }
        }
    }

    String battleCryDescription = "Revive Allies: move two random cards from your graveyard to hand.";
    String willDescription = "Burst of Light: Increase HP of all friendly monster cards and player by 500 and" +
                             " increase AP of all friendly monster cards by 200";
    String spellDetails = "Divine Blessing: Increase HP of a friendly monster card or player by 2500.";
}
