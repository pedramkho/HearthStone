package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

import java.io.Serializable;

public class SmallHPPotion extends Item implements Serializable {
    public SmallHPPotion(){
        super.itemCost = 1000;
        super.name = "Small HP Potion";
        super.details = "Increase Player’s HP by 500";
    }
    public void action(Player player){
        if(player.Hero.HP + 500 > player.MaxHP){
            player.Hero.HP = player.MaxHP;
        }else {
            player.Hero.HP += 500;
        }
    }
}