package com.company;

import Player.Player;
import World.World;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SecondServer extends Thread {
    public static final int port = 4444;
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

            Player player = new Player();
            player.initializePlayer();
            player.actorName = "Second Player";

            Main.other = player;
            Main.world.theEnemy = player;

            Main.secondServerLock.release();
            System.out.println("Second server connected");
            Main.OnlineGameStart.acquire();


            Main.onlineWorld = Main.world;
            while(true){


                World secondPlayerWorld = new World();

                secondPlayerWorld.theEnemy = Main.onlineWorld.thePlayer;
                secondPlayerWorld.thePlayer = Main.onlineWorld.theEnemy;
                secondPlayerWorld.command = Main.onlineWorld.command;
                secondPlayerWorld.printCommand = Main.onlineWorld.printCommand;
                secondPlayerWorld.chatString = Main.onlineWorld.chatString;

                os.writeObject(secondPlayerWorld);

                World world = (World)is.readObject();
                if(world.command.contains("otherPlayer")){
                    Main.world.chatString += (world.command.replace("_", "Second Player"));
                    Main.onlineWorld.chatString = Main.world.chatString;
                }else if(world.command.contains("refresh")){
                    Main.onlineWorld = Main.world;
                }else if(player == Main.playerOnTurn){
                    Main.sendCommand(world.command);
                    Main.commandInProgress.acquire();
                }

                synchronized (this){
                    wait(500);
                }
                os.reset();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
