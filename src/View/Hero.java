package View;

import com.company.Main;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hero {

    static int movementSpeed = 1;


    static int centerX = 1200/4;
    static int centerY = 700/4 - 100;

    static int inViewX = centerX + MapDrawer.imageX - 1200*2/4;
    static int inViewY = centerY + MapDrawer.imageY - 700*2/4;

    static int inRealMapX = 0;
    static int inRealMapY = 0;

    static void calculateNodes(){
        inViewX = centerX + MapDrawer.imageX - 1200*2/4;
        inViewY = centerY + MapDrawer.imageY - 700*2/4;

        inRealMapX = (centerX * 100) / MapDrawer.imageRecWidth;
        inRealMapY = (centerY * 100) / MapDrawer.imageRecHeight;
    }

    static int rectangleWidth = 10;
    static int rectangleHeight = 10;
    static Direction lastDirection = Direction.Down;

    public static int X_Calculator(){
        return centerX - rectangleWidth/2;
    }

    public static int Y_Calculator(){
        return centerY - rectangleHeight/2;
    }

    Image[][] heroImage = new Image[4][3]; //TODO: add images


    public static void moveLeft(){
        calculateNodes();

        lastDirection = Direction.Left;
        if(!MapDrawer.IsNotPassAble[(inRealMapX - 1 + 100)% 100][inRealMapY]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerX -= movementSpeed;
                inViewX -= movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    MapDrawer.imageX += movementSpeed;
                }
            }
        }


    }
    public static void moveRight() {
        calculateNodes();

        lastDirection = Direction.Right;
        if(!MapDrawer.IsNotPassAble[(inRealMapX + 1 + 100)% 100][inRealMapY]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerX += movementSpeed;
                inViewX += movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    MapDrawer.imageX -= movementSpeed;
                }

            }
        }
    }
    public static void moveUp(){
        calculateNodes();
        //centerY -= movementSpeed;
        lastDirection = Direction.Up;
        if(!MapDrawer.IsNotPassAble[inRealMapX][(inRealMapY - 1 + 100)% 100]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerY -= movementSpeed;
                inViewY -= movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    MapDrawer.imageY += movementSpeed;
                }

            }
        }
    }
    public static void moveDown(){
        calculateNodes();

        lastDirection = Direction.Down;
        if(!MapDrawer.IsNotPassAble[inRealMapX][(inRealMapY + 1 + 100)% 100]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerY += movementSpeed;
                inViewY += movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    MapDrawer.imageY -= movementSpeed;
                }

            }
        }
    }

    public static void drawHero(Group root){
        Rectangle rectangle = new Rectangle(MapDrawer.imageX + X_Calculator(),MapDrawer.imageY + Y_Calculator(), rectangleWidth, rectangleHeight);
        rectangle.setFill(Color.RED);
        root.getChildren().addAll(rectangle);
    }

    public static void checkWar(){
        int[] X = {((centerX - rectangleWidth/2)*100/MapDrawer.imageRecWidth + 100) % 100, ((centerX + rectangleWidth/2)*100/MapDrawer.imageRecWidth + 100) % 100};
        int[] Y = {((centerY - rectangleHeight/2)*100/MapDrawer.imageRecWidth + 100) % 100, ((centerY + rectangleHeight/2)*100/MapDrawer.imageRecWidth + 100) % 100};
        if(MapDrawer.War[X[0]][Y[0]] || MapDrawer.War[X[0]][Y[1]]
                || MapDrawer.War[X[1]][Y[0]] || MapDrawer.War[X[1]][Y[1]]){
            Graphics.page = Pages.War;
            if(Main.warNumber > 0){
                //TODO: add command
                Main.sendCommand("");
            }
            MapDrawer.empty("War", 4, centerX*100/2100, centerY*100/2100);
            //TODO: add points
            MapDrawer.empty("isNotPassAble", 2, 0, 0);
        }
    }
    public static void checkShop(){

        int[] X = {((centerX - rectangleWidth/2)*100/MapDrawer.imageRecWidth + 100) % 100, ((centerX + rectangleWidth/2)*1000/MapDrawer.imageRecWidth + 100) % 100};
        int[] Y = {((centerY - rectangleHeight/2)*100/MapDrawer.imageRecWidth + 100) % 100, ((centerY + rectangleHeight/2)*1000/MapDrawer.imageRecWidth + 100) % 100};
        if(MapDrawer.Shop[X[0]][Y[0]] || MapDrawer.Shop[X[0]][Y[1]]
                || MapDrawer.Shop[X[1]][Y[0]] || MapDrawer.Shop[X[1]][Y[1]]){
            Graphics.page = Pages.Shop;
            if(Main.warNumber > 0){
                //TODO: add command
                Main.sendCommand("");
            }
            MapDrawer.empty("Shop", 2, centerX, centerY);
        }


    }

    enum Direction{
        Up,
        Right,
        Left,
        Down
    }
}
