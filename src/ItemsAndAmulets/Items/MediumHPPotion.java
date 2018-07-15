package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

import java.io.Serializable;

public class MediumHPPotion extends Item implements Serializable {
    public MediumHPPotion(){
        super.itemCost = 2000;
        super.name = "Medium HP Potion";
        super.details = "Increase Player’s HP by 1000.";
    }

    public void action(Player player){
        if(player.Hero.HP + 1000 > player.MaxHP){
            player.Hero.HP = player.MaxHP;
        }else{
            player.Hero.HP += 1000;
        }
    }
}
