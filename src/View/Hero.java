package View;

import com.company.Main;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.Map;

public class Hero {

    static int movementSpeed = 2;


    static int centerX = 10;
    static int centerY = 10;

    static int inViewX = 0;
    static int inViewY = 0;

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

        lastDirection = Direction.Left;

        if(!MapDrawer.IsNotPassAble[(centerX - 1 + MapDrawer.imageRecWidth)% MapDrawer.imageRecWidth][centerY]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && MapDrawer.viewRecHeight / 2 < inViewY) {
                centerX -= movementSpeed;
                inViewX -= movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < ((Graphics.Width - MapDrawer.viewRecWidth) / 2) * ((Graphics.Width - MapDrawer.viewRecWidth) / 2)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < ((Graphics.Height - MapDrawer.viewRecHeight) / 2) * ((Graphics.Height - MapDrawer.viewRecHeight) / 2)) {
                    MapDrawer.imageX += movementSpeed;
                    centerX -= movementSpeed;
                }
            }
        }


    }
    public static void moveRight() {

        lastDirection = Direction.Right;
        if(!MapDrawer.IsNotPassAble[(centerX + 1 + MapDrawer.imageRecWidth)% MapDrawer.imageRecWidth][centerY]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && MapDrawer.viewRecHeight / 2 < inViewY) {
                centerX += movementSpeed;
                inViewX += movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < ((Graphics.Width - MapDrawer.viewRecWidth) / 2) * ((Graphics.Width - MapDrawer.viewRecWidth) / 2)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < ((Graphics.Height - MapDrawer.viewRecHeight) / 2) * ((Graphics.Height - MapDrawer.viewRecHeight) / 2)) {
                    MapDrawer.imageX -= movementSpeed;
                    centerX += movementSpeed;
                }

            }
        }
    }
    public static void moveUp(){
        lastDirection = Direction.Up;
        if(!MapDrawer.IsNotPassAble[centerX][(centerY - 1 + MapDrawer.imageRecHeight)% MapDrawer.imageRecHeight]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && MapDrawer.viewRecHeight / 2 < inViewY) {
                centerY -= movementSpeed;
                inViewY -= movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < ((Graphics.Width - MapDrawer.viewRecWidth) / 2) * ((Graphics.Width - MapDrawer.viewRecWidth) / 2)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < ((Graphics.Height - MapDrawer.viewRecHeight) / 2) * ((Graphics.Height - MapDrawer.viewRecHeight) / 2)) {
                    MapDrawer.imageY += movementSpeed;
                    centerY -= movementSpeed;
                }

            }
        }
    }
    public static void moveDown(){
        lastDirection = Direction.Down;
        if(!MapDrawer.IsNotPassAble[centerX][(centerY + 1 + MapDrawer.imageRecHeight)% MapDrawer.imageRecHeight]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && MapDrawer.viewRecHeight / 2 < inViewY) {
                centerY += movementSpeed;
                inViewY += movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < ((Graphics.Width - MapDrawer.viewRecWidth) / 2) * ((Graphics.Width - MapDrawer.viewRecWidth) / 2)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < ((Graphics.Height - MapDrawer.viewRecHeight) / 2) * ((Graphics.Height - MapDrawer.viewRecHeight) / 2)) {
                    MapDrawer.imageY -= movementSpeed;
                    centerY += movementSpeed;
                }

            }
        }
    }

    public static void drawHero(Group root){
        Rectangle rectangle = new Rectangle(X_Calculator(), Y_Calculator(), rectangleWidth, rectangleHeight);
        root.getChildren().addAll(rectangle);
    }

    public static void checkWar(){
        int[] X = {centerX - rectangleWidth/2, centerX + rectangleWidth/2};
        int[] Y = {centerY - rectangleHeight/2, centerY + rectangleHeight/2};
        if(MapDrawer.War[X[0]][Y[0]] || MapDrawer.War[X[0]][Y[1]]
                || MapDrawer.War[X[1]][Y[0]] || MapDrawer.War[X[1]][Y[1]]){
            Graphics.page = Pages.War;
            if(Main.warNumber > 0){
                //TODO: add command
                Main.sendCommand("");
            }
            MapDrawer.empty("War", 4, centerX, centerY);
            //TODO: add points
            MapDrawer.empty("isNotPassAble", 2, 0, 0);
        }
    }
    public static void checkShop(){

        int[] X = {centerX - rectangleWidth/2, centerX + rectangleWidth/2};
        int[] Y = {centerY - rectangleHeight/2, centerY + rectangleHeight/2};
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
