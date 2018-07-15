package View;

import Player.Player;
import World.World;
import com.company.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Graphics extends Application {
    public static int Height = 700;
    public static int Width = 1200;
    public static Pages page = Pages.War;
    Group root = new Group();
    static World world;
    public static void run(World world1){
        world = world1;
        launch();
    }

    public static void updateWorld(){
        world = Main.world;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        MapDrawer.initialize();


        Scene scene = new Scene(root);
        primaryStage.setHeight(Height);
        primaryStage.setWidth(Width);
        primaryStage.setTitle("HearthStone");
        primaryStage.setScene(scene);
        primaryStage.show();


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(page == Pages.Map){
                    if(event.getCode() == KeyCode.D){
                        Hero.moveRight();
                    }
                    if(event.getCode() == KeyCode.A){
                        Hero.moveLeft();
                    }
                    if(event.getCode() == KeyCode.W){
                        Hero.moveUp();
                    }
                    if(event.getCode() == KeyCode.S){
                        Hero.moveDown();
                    }
                }
            }
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(page == Pages.StartMenu){
                    Drawers.drawStartMenu(root);
                }else if(page == Pages.War){
                    Drawers.drawWar(root, Main.world);
                }else if(page == Pages.Deck){

                }else if(page == Pages.Map){
                    MapDrawer.drawMap(root);
                }else if(page == Pages.PauseMenu){

                }else if(page == Pages.Shop){

                }

            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
