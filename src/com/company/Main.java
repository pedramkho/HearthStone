package com.company;

import AI.AI;
import Cards.Card;
import Cards.MonsterCard.Friendly.ElvenMonster.ElvenGuardsman;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Type;
import Inventory.Inventory;
import ItemsAndAmulets.Item;
import ItemsAndAmulets.Items.MysticHourglass;
import Menu.WarMenu;
import Player.Player;
import Shops.Shop;
import View.GraphicThread;
import View.Graphics;
import World.World;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static boolean exitToMain = false;
    public static boolean someoneLost = false;
    static InputStream inputStream = new ByteArrayInputStream("".getBytes());

    public static String readCommand() {
        while(!commandSent){}
        commandSent = false;
        inputStream = new ByteArrayInputStream(command.getBytes());
        Scanner tScanner = new Scanner(inputStream);
        return tScanner.next();
    }

    public static boolean commandSent = false;
    public static void sendCommand(String command){
        Main.command = command;
        commandSent = true;
    }

    public static String command = new String();
    public static void war(World world, Player starter, Player other, Player sideName, int turn){
        Player enemySide = new Player();

        while (!someoneLost) {
            //this change turn
            if (sideName == starter) {
                sideName = other;
            } else {
                sideName = starter;
            }

            if (sideName == starter) {
                enemySide = other;
            } else {
                enemySide = starter;
            }

            WarMenu.changeTurn(starter, other, sideName, enemySide);

            WarMenu.preTurn(sideName, enemySide, turn);

            if(sideName == world.theEnemy) {
                AI.run(sideName, enemySide);
                continue;
            }


            while(!someoneLost) {
                String command = scanner.nextLine();

                //Show Player
                if(command.contains("Show")){
                    print(sideName.actorName + " :"
                            + "\nHP: " + sideName.Hero.HP + " AP: " + sideName.MP +
                            "\n\n" + enemySide.actorName + " :"
                            + "\nHP: " + enemySide.Hero.HP + " AP: " + enemySide.MP);
                }

                //use items:
                if (command.contains("use item")){
                    WarMenu.useItem(command, sideName);
                    continue;
                }

                //Again:
                if(command.contains("Again")){
                    System.out.println(Main.again);
                }

                //Use card mode:
                if (command.contains("use")) {
                    //use card menu:
                    WarMenu.useCard(command, sideName, enemySide);
                }

                //use a card in hand:
                if (command.contains("set")) {
                    WarMenu.setCard(command, sideName, enemySide);
                }


                //View Commands:
                if (command.contains("View")) {
                    if(command.contains("hand")){
                        WarMenu.viewHand(sideName);
                    }
                    if(command.contains("graveyard")){
                        WarMenu.viewGraveyard(sideName, enemySide);
                    }
                    if(command.contains("monsterfield")){
                        WarMenu.viewMonsterField(sideName, enemySide);
                    }
                    if(command.contains("item")){
                        WarMenu.viewItems(sideName);
                    }
                }


                //Help:
                if(command.contains("Help:")){
                    print("1. Use #SlotNum: To use a specific card which is on the Monster Field " +
                            "\n2. Set HandIndex to #SlotNum: To set a card which is on the hand, in the field " +
                            "\n3. View Hand: To view the cards in your hand " +
                            "\n4. View Graveyard: To view the cards in your graveyard " +
                            "\n5. View SpellField: To view the cards in both ’players spell fields " +
                            "\n6. View MonsterField: To view the cards in both ’players monster fields " +
                            "\n7. Info \"Card Name\": To view full information about a card 8. Done: To end your turn ");
                }


                //Done:
                if (command.contains("Done")) {
                    break;
                }
                //Exit:
                if (command.contains("Exit")) {
                    print(sideName.actorName + " quit!");
                    exitToMain = true;
                    return;
                }

                //info Card:
                if (command.contains("info")) {
                    String[] strings = command.split(" ");
                    Card card = Card.getInstance(strings[strings.length - 1]);
                    print(card.cardInfo());
                }

            }

            turn++;
            if (turn % 2 == 0) {
                world.thePlayer.modifyMP();
                world.theEnemy.modifyMP();
            }
        }

    }

    public static String again;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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

            if(exitToMain){
                return;
            }

        }
        System.out.println("You Won :)");

}

    //added
    public static void print(String output){
        Main.again = output;
        System.out.println(output);
    }
    //end
}

