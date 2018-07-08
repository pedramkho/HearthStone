package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

public class GreaterRestorative extends Item {
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
