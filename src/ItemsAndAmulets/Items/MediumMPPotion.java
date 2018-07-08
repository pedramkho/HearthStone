package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

public class MediumMPPotion extends Item {
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
