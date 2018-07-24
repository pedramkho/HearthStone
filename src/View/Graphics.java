package View;

import World.World;
import com.company.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Graphics extends Application {
    public static int Height = 700;
    public static int Width = 1200;
    public static Pages page = Pages.StartMenu;
    Group root = new Group();
    static World world;

    //
    public static Stage stage = null;
    //

    static TextField txt;
    static MediaPlayer mediaPlayer;

    public static void run(World world1){
        world = world1;
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        MapDrawer.initialize();
        Hero.initialize();

        txt = new TextField();
        txt.setLayoutX((2 * Graphics.Width / 3));
        txt.setLayoutY(5);
        txt.setMaxWidth(Graphics.Width / 3);


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

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MapDrawer.runMediaPlayer();

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
    //
    public static void goToScene(Scene scene){
        stage.setScene(scene);
    }
    public static void goToMainMenu() {
        //bazgasht be halat default faramoosh nashavad
    }//todo
    public static void goToPlayCustomGame(){

    }
}
