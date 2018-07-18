package World;

import Cards.Card;
import Cards.MonsterCard.Monster;
import Cards.SpellCards.Spell;
import Cards.SpellCards.cardType;
import Player.Player;

import java.io.Serializable;

public class World implements Serializable{
    public String printCommand = "";
    public String command = "";
    public String chatString = "";

    public Player thePlayer = new Player();
    public Player theEnemy = new Player();

    public World(){
        thePlayer.actorName = "Player";
        thePlayer.post = "Player";
        theEnemy.post = "Enemy";
        theEnemy.enemy = thePlayer;
        thePlayer.enemy = theEnemy;
    }
    public static void spellCasting(Card card, Player player, Player enemy){
        //TODO: this func should cast instant spells and wills
        if(card instanceof Monster){
            if(!((Monster)card).needChoosing)
                ((Monster)card).will(player, enemy, 0);
        }
        if(card instanceof Spell){
            if(!((Spell)card).needChoosing)
                ((Spell)card).action(player, enemy, 0);
        }
    }

}