package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

public class LesserRestorative extends Item {
    public LesserRestorative(){
        super.itemCost = 2000;
        super.name = "Lesser Restorative";
        super.details = "Increase Player’s HP by 500 and MP by 2.";
    }
    public void action(Player player){
        new SmallHPPotion().action(player);
        new SmallMPPotion().action(player);
    }
}
