package Shops;

import Player.Player;
import com.company.Main;

public class ShopMenu {
    public static void shopMenu(Player player){
        while (true) {
            String command = Main.scanner.nextLine();
            switch (command) {
                case "Help":
                    Shop.print(player,"1 .\tCard Shops\n2 .\tItem Shops\n3 .\tAmulet Shops\n4 .\tExit");
                    break;
                case "Again":
                    System.out.println(Main.again);
                    break;
                case "Exit":
                    return;
                case "Card Shops":
                    Shop.shop(CardShop.instance,player);
                    break;
                case "Item Shops":
                    Shop.shop(ItemShop.instance,player);
                    break;
                case "Amulet Shops":
                    Shop.shop(AmuletShop.instance,player);
                    break;
                default:
                    Main.print("Invalid command!");
            }
        }
    }
}
