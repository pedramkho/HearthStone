package View;

import com.company.Main;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class Hero {
    private static int counter = 0;

    static boolean warChanged = true;

    private static int movementSpeed = 1;

    private static int centerX = 1200/4;
    private static int centerY = 700/4 - 100;

    private static int inViewX = centerX + MapDrawer.imageX - 1200*2/4;
    private static int inViewY = centerY + MapDrawer.imageY - 700*2/4;

    static int inRealMapX = 0;
    static int inRealMapY = 0;

    private static void calculateNodes(){
        inViewX = centerX + MapDrawer.imageX - 1200*2/4;
        inViewY = centerY + MapDrawer.imageY - 700*2/4;

        inRealMapX = (centerX * 100) / MapDrawer.imageRecWidth;
        inRealMapY = (centerY * 100) / MapDrawer.imageRecHeight;
    }

    private static int rectangleWidth = 20;
    private static int rectangleHeight = 20;
    private static Direction lastDirection = Direction.Down;

    private static int X_Calculator(){
        return centerX - rectangleWidth/2;
    }

    private static int Y_Calculator(){
        return centerY - rectangleHeight/2;
    }

    private static Image[][] heroImage = new Image[4][3]; //TODO: add images

    static void initialize(){
        heroImage[0][0] = new Image(new File("HeroPics/Hero_Down_0.png").toURI().toString());
        heroImage[0][1] = new Image(new File("HeroPics/Hero_Down_1.png").toURI().toString());
        heroImage[0][2] = new Image(new File("HeroPics/Hero_Down_2.png").toURI().toString());

        heroImage[1][0] = new Image(new File("HeroPics/Hero_Up_0.png").toURI().toString());
        heroImage[1][1] = new Image(new File("HeroPics/Hero_Up_1.png").toURI().toString());
        heroImage[1][2] = new Image(new File("HeroPics/Hero_Up_2.png").toURI().toString());

        heroImage[2][0] = new Image(new File("HeroPics/Hero_Right_0.png").toURI().toString());
        heroImage[2][1] = new Image(new File("HeroPics/Hero_Right_1.png").toURI().toString());
        heroImage[2][2] = new Image(new File("HeroPics/Hero_Right_2.png").toURI().toString());

        heroImage[3][0] = new Image(new File("HeroPics/Hero_Left_0.png").toURI().toString());
        heroImage[3][1] = new Image(new File("HeroPics/Hero_Left_1.png").toURI().toString());
        heroImage[3][2] = new Image(new File("HeroPics/Hero_Left_2.png").toURI().toString());
    }

    public static void moveLeft(){
        calculateNodes();
        counter++;

        lastDirection = Direction.Left;
        if(!MapDrawer.IsNotPassAble[(inRealMapX - 1 + 100)% 100][inRealMapY]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerX -= movementSpeed;
                inViewX -= movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    MapDrawer.imageX += movementSpeed + rectangleHeight / 2;
                }
            }
        }


    }
    public static void moveRight() {
        calculateNodes();
        counter++;

        lastDirection = Direction.Right;
        if(!MapDrawer.IsNotPassAble[(inRealMapX + 1 + 100)% 100][inRealMapY]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerX += movementSpeed;
                inViewX += movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    MapDrawer.imageX -= movementSpeed + rectangleHeight / 2;
                }

            }
        }
    }
    public static void moveUp(){
        calculateNodes();
        counter++;

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
                    MapDrawer.imageY += movementSpeed + rectangleHeight / 2;
                }

            }
        }
    }
    public static void moveDown(){
        calculateNodes();
        counter++;
        lastDirection = Direction.Down;
        if(!MapDrawer.IsNotPassAble[inRealMapX][(inRealMapY + 1 + 100)% 100]) {
            if (inViewX < MapDrawer.viewRecWidth / 2 && -MapDrawer.viewRecWidth / 2 < inViewX
                    && inViewY < MapDrawer.viewRecHeight / 2 && -MapDrawer.viewRecHeight / 2 < inViewY) {
                centerY += movementSpeed;
                inViewY += movementSpeed;
            } else {

                if ((MapDrawer.imageX) * (MapDrawer.imageX) < (1200/4) * (1200/4)
                        && (MapDrawer.imageY) * (MapDrawer.imageY) < (700/4) * (700/4)) {
                    centerY += movementSpeed;
                    inViewY += movementSpeed;

                    MapDrawer.imageY -=  movementSpeed + rectangleHeight / 2;
                }

            }
        }
    }

    private static Image setHeroImage(){
        if(Hero.lastDirection == Direction.Down){
            switch (counter % 3){
                case 0:
                    return heroImage[0][0];
                case 1:
                    return heroImage[0][1];
                case 2:
                    return heroImage[0][2];
            }
        }else if(Hero.lastDirection == Direction.Up){
            switch (counter % 3){
                case 0:
                    return heroImage[1][0];
                case 1:
                    return heroImage[1][1];
                case 2:
                    return heroImage[1][2];
            }
        }else if(Hero.lastDirection == Direction.Right){
            switch (counter % 3){
                case 0:
                    return heroImage[2][0];
                case 1:
                    return heroImage[2][1];
                case 2:
                    return heroImage[2][2];
            }
        }else if(Hero.lastDirection == Direction.Left){
            switch (counter % 3){
                case 0:
                    return heroImage[3][0];
                case 1:
                    return heroImage[3][1];
                case 2:
                    return heroImage[3][2];
            }
        }
        return heroImage[1][2];
    }
    public static void drawHero(Group root){
        Rectangle rectangle = new Rectangle(MapDrawer.imageX + X_Calculator(),MapDrawer.imageY + Y_Calculator(), rectangleWidth, rectangleHeight);
        //TODO: set images
        rectangle.setFill(new ImagePattern( setHeroImage() ));
        //rectangle.setFill(Color.RED);
        root.getChildren().addAll(rectangle);
    }


    private static int[] bridges_X = {26, 44, 57};
    private static int[] bridges_Y = {45, 60, 91};

    public static void checkWar(){
        int[] X = {((centerX - rectangleWidth/2)*100/MapDrawer.imageRecWidth + 100) % 100, ((centerX + rectangleWidth/2)*100/MapDrawer.imageRecWidth + 100) % 100};
        int[] Y = {((centerY - rectangleHeight/2)*100/MapDrawer.imageRecWidth + 100) % 100, ((centerY + rectangleHeight/2)*100/MapDrawer.imageRecWidth + 100) % 100};
        if(MapDrawer.War[X[0]][Y[0]] || MapDrawer.War[X[0]][Y[1]]
                || MapDrawer.War[X[1]][Y[0]] || MapDrawer.War[X[1]][Y[1]]){

            warChanged = true;
            Graphics.page = Pages.War;
            if(Main.warNumber > 0){
                //TODO: add command
                Main.sendCommand("");
            }
            MapDrawer.empty("War", 4, centerX*100/2100, centerY*100/2100);
            //TODO: add points
            MapDrawer.empty("isNotPassAble", 2, bridges_X[Main.warNumber%3], bridges_Y[Main.warNumber%3]);
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
