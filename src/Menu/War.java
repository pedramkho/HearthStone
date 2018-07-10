/*
package Menu;

import ItemsAndAmulets.Item;
import ItemsAndAmulets.Items.MysticHourglass;
import Player.Player;
import Shops.Shop;
import View.GraphicThread;
import World.World;

import java.util.Random;

import static com.company.Main.*;

public class War extends Thread{
    @Override
    public void run() {
        World world = new World();
        Player starter = new Player();
        Player other = new Player();

        world.thePlayer.initializePlayer();

        for(int warNumber = 0; warNumber < 4; warNumber++) {
            world.thePlayer.preWaInitlize();
            int turn = 1;
            switch (warNumber){
                case 0:
                    world.theEnemy.initializeGoblinChieftain();
                    break;
                case 1:
                    world.thePlayer.money += 10000;
                    world.theEnemy.initializeVampireLord();
                    break;
                case 2:
                    world.thePlayer.money += 10000;
                    world.theEnemy.initializeOrgeWarLord();
                    break;
                case 3:
                    world.thePlayer.money += 10000;
                    world.theEnemy.initializeLucifer();
            }


            if(warNumber > 0){
                while(true){
                    String command = scanner.nextLine();
                    if(command.contains("Shop")){
                        Shop.menu(world.thePlayer);
                    }else if(command.contains("inventory")){
                        world.thePlayer.inventory.inventory();
                    }else if(command.contains("Next")){
                        break;
                    }else{
                        print("invalid input!");
                    }
                }
            }


            //a random starter here
            Random random = new Random();
            if (random.nextInt() % 2 == 0) {
                starter = world.theEnemy;
                other = world.thePlayer;
            }else{
                starter = world.thePlayer;
                other = world.theEnemy;
            }

            Player sideName = starter;

            //--------------------------------------------------------------

            System.out.println("Battle against " + world.theEnemy.actorName
                    + " started!");

            System.out.println(sideName.actorName + " starts the battle.");

            for(int i = 0; i < 5; i++){
                world.theEnemy.moveCardFromDeckToHand();
                world.thePlayer.moveCardFromDeckToHand();
            }
            print("Player drew " + sideName.handToString());

            //--------------------------------------------------------------

            Thread graphicThread = new GraphicThread(world);
            graphicThread.start();
            war(world, starter, other, sideName, turn);


            if(someoneLost){
                if(WarMenu.isGameFinished(world)){
                    Item item = null;
                    if(world.thePlayer.inventory.items.contains(new MysticHourglass())){
                        world.thePlayer.inventory.items.remove(new MysticHourglass());
                        warNumber--;
                        someoneLost = false;
                    }else{
                        System.out.println("You Lost!");
                        return;
                    }
                }
                System.out.println("You won the battle against \"" + world.theEnemy.actorName + "\"!");
                someoneLost = false;
            }

            if(
                    exitToMain){
                return;
            }

        }
        System.out.println("You Won :)");

    }

}

*/
