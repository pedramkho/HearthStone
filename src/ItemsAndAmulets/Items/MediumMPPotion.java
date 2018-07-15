package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

import java.io.Serializable;

public class MediumMPPotion extends Item implements Serializable {
    public MediumMPPotion(){
        super.itemCost = 2000;
        super.name = "Medium MP Potion";
        super.details = "Increase Player’s MP by 4.";
    }

    public void action(Player player){
        if(player.MP + 4 > player.MaxMP){
            player.MP = player.MaxMP;
        }else{
            player.MP += 4;
        }
    }
}
