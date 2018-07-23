package Shops;

import Cards.Component;
import ItemsAndAmulets.Item;
import Player.Player;
import com.company.Main;
import exceptions.shopExceptions.*;


abstract public class Shop {
    public String help;
    public static void menu(Player player){
        Shop.print(player,"1 .\tCard Shop\n2 .\tItem Shop\n3 .\tAmulet Shop\n4 .\tExit");
        while (true) {
            String command = Main.scanner.nextLine();
            switch (command) {
                case "Help":
                    Shop.print(player,"1 .\tCard Shop\n2 .\tItem Shop\n3 .\tAmulet Shop\n4 .\tExit");
                    break;
                case "Again":
                    System.out.println(Main.again);
                    break;
                case "Exit":
                    return;
                case "Card Shop":
                    Shop.shop(CardShop.instance,player);
                    break;
                case "Item Shop":
                    Shop.shop(ItemShop.instance,player);
                    break;
                case "Amulet Shop":
                    Shop.shop(AmuletShop.instance,player);
                    break;
                default:
                    Main.print("Invalid command!");
            }
        }
    }
    public  static void shop(Shop shop,Player player){
        print(player,shop.getPrimaryMessage(player));
        while(true) {
            String command = Main.scanner.nextLine();
            switch (command) {
                case "Exit":
                    return;
                case "Again":
                    System.out.println(Main.again);
                    break;
                case "Help":
                    print(player,shop.help);
                    break;
                default:
                    if (command.startsWith("Buy"))
                        shop.buy(player, command);
                    else if (command.startsWith("Sell"))
                        shop.sell(player, command);
                    else if (command.startsWith("Info")) {
                        if (shop.info(command) != null)
                            print(player, shop.info(command));
                    }
                    else if (shop instanceof AmuletShop && command.equals("Edit Amulets")) {
                        String info = "Amulets" + player.inventory.showAmulets().substring(18);
                        if(player.inventory.equippedAmulet!=null)
                            info += "\nPlayer is equipped with " + player.inventory.equippedAmulet.name + " .";
                        if(info.charAt(info.length()-1)=='\n')
                            info = info.substring(0,info.length()-1);
                        Shop.print(player,info);
                        player.inventory.editAmulets();
                    }
                    else if (shop instanceof CardShop && command.equals("Edit Deck")) {
                        Shop.print(player,player.inventory.showDeckAndInventoryCards());
                        player.inventory.editDeck();
                    }
                    else {
                        Main.again = "Invalid command";
                        System.out.println(Main.again);
                    }
            }
        }

    }
    abstract public String getPrimaryMessage(Player player);
    abstract public  void buy(Player player,String command);
    abstract public void sell(Player player,String command);
    abstract public  String info(String command);
    public static void print(Player player,String output){
        Main.print("Remaining Gil : " + player.money + " Gil\n"+output);
    }
    //phase 2,3
    public static void buy(Player player,int numberToBuy,Component component) throws ShopException {
        if(!component.isTradable())
            throw new IsNotTradable(component);
        if(!enoughInStock(component,numberToBuy))
            throw new NotEnoghInStock(component);
        if(player.money < numberToBuy*component.getPrice())
            throw new NotEnoghGilException();
        player.inventory.removeOrAddComponent(component,numberToBuy);
        player.money -= numberToBuy*component.getPrice();
        component.changeNumberInShop(-numberToBuy);
    }
    public static void sell(Player player,int numberToSell,Component component) throws ShopException{
        if(!component.isTradable())
            throw new IsNotTradable(component);
        if(!enoughInInventory(player,component,numberToSell))
            throw new NotEnoughInInventoryException(component);
        player.inventory.removeOrAddComponent(component,-numberToSell);
        player.money += (numberToSell*component.getPrice())/2;
        component.changeNumberInShop(numberToSell);
    }
    private static boolean enoughInStock(Component component,int num){
        return (component instanceof Item) || (component.getNumberInShop() >= num);
    }
    private static boolean enoughInInventory(Player player,Component component,int num){
        return (player.inventory.numberInInventory(component) >= num);
    }

}
