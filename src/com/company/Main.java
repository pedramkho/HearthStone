package com.company;

import AI.AI;
import Cards.Card;
import ItemsAndAmulets.Item;
import ItemsAndAmulets.Items.MysticHourglass;
import Menu.WarMenu;
import Player.Player;
import Shops.Shop;
import View.GraphicThread;
import World.World;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Main {
    private static final boolean thisIsServer = false;
    private static int port = 4444;



    public static GameMode gameMode = GameMode.SinglePlayer;

    private static boolean exitToMain = false;
    public static boolean someoneLost = false;

    //Commands
    private static String Command = "";

    //Locks:
    public static Semaphore GameModeLock = new Semaphore(0);
    private static Semaphore messageLock = new Semaphore(0);
    public static Semaphore firstServerLock = new Semaphore(0);
    public static Semaphore secondServerLock = new Semaphore(0);
    public static Semaphore OnlineGameStart = new Semaphore(0);
    public static Semaphore commandInProgress = new Semaphore(0);


    public static String readCommand() {

        try {
            messageLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Read Command: " + Command);
        return Command;
    }
    public static void sendCommand(String _command){
        System.out.println("Sent Command: " + _command);
        Main.Command = _command;
        messageLock.release();
    }

    private static void runSinglePlayer(){

        world.thePlayer.initializePlayer();

        for (warNumber = 0; warNumber < 4; warNumber++) {
            world.thePlayer.preWarInitialize();

            int turn = 1;
            switch (warNumber) {
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


            if (warNumber > 0) {
                while (true) {
                    String command = scanner.nextLine();
                    if (command.contains("Shop")) {
                        Shop.menu(world.thePlayer);
                    } else if (command.contains("inventory")) {
                        world.thePlayer.inventory.inventory();
                    } else if (command.contains("Next")) {
                        break;
                    } else {
                        print("invalid input!");
                    }
                }
            }


            //a random starter here
            Random random = new Random();
            if (random.nextInt() % 2 == 0) {
                starter = world.theEnemy;
                other = world.thePlayer;
            } else {
                starter = world.thePlayer;
                other = world.theEnemy;
            }

            Player sideName = starter;

            //--------------------------------------------------------------

            System.out.println("Battle against " + world.theEnemy.actorName
                    + " started!");

            System.out.println(sideName.actorName + " starts the battle.");

            for (int i = 0; i < 5; i++) {
                world.theEnemy.moveCardFromDeckToHand();
                world.thePlayer.moveCardFromDeckToHand();
            }
            print("Player drew " + sideName.handToString());

            //--------------------------------------------------------------


            war(world, world.thePlayer, world.theEnemy, world.thePlayer, turn);


            if (someoneLost) {
                if (WarMenu.isGameFinished(world)) {
                    Item item = null;
                    if (world.thePlayer.inventory.items.contains(new MysticHourglass())) {
                        world.thePlayer.inventory.items.remove(new MysticHourglass());
                        warNumber--;
                        someoneLost = false;
                        print("You used MysticHourglass!");
                    } else {
                        print(world.thePlayer + " Lost!");
                        return;
                    }
                }
                print("You won the battle against \"" + world.theEnemy.actorName + "\"!");
                someoneLost = false;
            }

            if (exitToMain) {
                return;
            }

        }
        print("You Won :)");
    }
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

            playerOnTurn = sideName;

            WarMenu.changeTurn(starter, other, sideName, enemySide);

            WarMenu.preTurn(sideName, enemySide, turn);

            if(sideName == world.theEnemy && !thisIsServer) {
                AI.run(sideName, enemySide);
                continue;
            }


            while(!someoneLost) {


                if(thisIsServer) {
                    Main.onlineWorld = world;
                }
                String command = readCommand();

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
                    Main.onlineWorld = world;
                    commandInProgress.release();
                    break;
                }
                //Exit:
                if (command.contains("Exit")) {
                    print(sideName.actorName + " quit!");
                    someoneLost = true;
                    exitToMain = true;
                    sideName.Hero.HP = 0;
                }

                //info Card:
                if (command.contains("info")) {
                    String[] strings = command.split(" ");
                    Card card = Card.getInstance(strings[strings.length - 1]);
                    print(card.cardInfo());
                }

                Main.commandInProgress.release();
            }

            turn++;
            if (turn % 2 == 0) {
                world.thePlayer.modifyMP();
                world.theEnemy.modifyMP();
            }
        }

    }

    public static int warNumber = 0;
    public static String again;
    public static Scanner scanner = new Scanner(System.in);


    public static World onlineWorld = new World();
    public static World world = new World();
    public static Player starter = new Player();
    public static Player other = new Player();
    public static Player playerOnTurn = new Player();

    public static Player player = new Player();

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        player = world.thePlayer;
        onlineWorld = world;

        if(thisIsServer){
            //This is server

            Thread firstPlayer = new FirstServer();
            Thread secondPlayer = new SecondServer();
            firstPlayer.start();
            secondPlayer.start();

            firstServerLock.acquire();
            secondServerLock.acquire();
            OnlineGameStart.release();
            OnlineGameStart.release();

            for (int i = 0; i < 5; i++) {
                world.theEnemy.moveCardFromDeckToHand();
                world.thePlayer.moveCardFromDeckToHand();
            }

            System.out.println("Game Started");
            war(world, starter, other, other, 1);

        }else {
            Thread graphicThread = new GraphicThread(world);
            graphicThread.start();

            GameModeLock.acquire();
            if(gameMode == GameMode.SinglePlayer) {
                runSinglePlayer();
            }else{
                //this is multiPlayer mode

                Socket socket = new Socket("localhost", port);
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

                while(true){

                    Main.world = (World) is.readObject();

                    //Game commands:
                    Main.world.command = readCommand();
                    print(world.printCommand);

                    //
                    os.writeObject(world);
                    os.flush();

                    os.reset();
                }
            }



        }

    }
    //added
    public static void print(String output){
        Main.again = output;
        world.printCommand = output;
        onlineWorld.printCommand = output;
        System.out.println(output);
    }
    //end
}