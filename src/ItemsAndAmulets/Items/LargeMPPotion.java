package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

import java.io.Serializable;

public class LargeMPPotion extends Item implements Serializable {
    public LargeMPPotion(){
        super.itemCost = 4000;
        super.name = "Large MP Potion";
        super.details = "Increase Player’s MP by 8.";
    }

    public void action(Player player){
        if(player.MP + 8 > player.MaxMP){
            player.MP = player.MaxMP;
        }else{
            player.MP += 8;
        }
    }
}
