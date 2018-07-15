package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

import java.io.Serializable;

public class SmallMPPotion extends Item implements Serializable {
    public SmallMPPotion(){
        super.itemCost = 1000;
        super.name = "Small MP Potion";
        super.details = "Increase Player’s MP by 2";

    }
    public void action(Player player){
        if(player.MP + 2 > player.MaxMP){
            player.MP = player.MaxMP;
        }else{
            player.MP += 2;
        }
    }
}
