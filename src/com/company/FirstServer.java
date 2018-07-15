package com.company;

import Player.Player;
import World.World;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FirstServer extends Thread {
    public static final int port = 8888;
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();

            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

            Player player = new Player();
            player.initializePlayer();

            Main.starter = player;
            Main.world.thePlayer = player;

            Main.firstServerLock.release();
            System.out.println("First server connected");
            Main.OnlineGameStart.acquire();

            while(true){
                os.writeObject(Main.world);
                World world = (World)is.readObject();
                if(world.command.contains("otherPlayer")){
                    Main.print(world.command);
                }else if(player == Main.playerOnTurn){
                    Main.sendCommand(world.command);
                    Main.commandInProgress.acquire();
                }

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