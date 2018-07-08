package ItemsAndAmulets.Items;

import ItemsAndAmulets.Item;
import Player.Player;

public class LargeHPPotion extends Item {
    public LargeHPPotion(){
        super.itemCost = 4000;
        super.name = "Large HP Potion";
        super.details = "Increase Player’s HP by 2000.";
    }
    public void action(Player player){
        if(player.Hero.HP + 2000 > player.MaxHP){
            player.Hero.HP = player.MaxHP;
        }else {
            player.Hero.HP += 2000;
        }
    }
}
