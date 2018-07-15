package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

import java.io.Serializable;

public class GreaterRestorative extends Item implements Serializable {
    public GreaterRestorative(){
        super.itemCost = 4000;
        super.name = "Greater Restorative";
        super.details = "Increase Player’s HP by 1000 and MP by 4.";
    }

    public void action(Player player){
        new MediumHPPotion().action(player);
        new MediumMPPotion().action(player);
    }
}
