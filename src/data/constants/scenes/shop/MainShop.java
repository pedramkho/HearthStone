package data.constants.scenes.shop;

import data.constants.GamePlay;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static data.constants.GamePlay.DEFAULT_FONT;

public class MainShop {
    public static final Color BackGround = null;

    public static final double BUTTONS_WIDTH = 200;
    public static final double BUTTONS_START_X = (GamePlay.WIDTH-BUTTONS_WIDTH)/2;
    public static final double BUTTONS_HEIGHT = 100;
    public static final double BUTTONS_Y_DISTANCE = 50;

    public static final double CARD_SHOP_BUTTON_START_X = BUTTONS_START_X;
    public static final double CARD_SHOP_BUTTON_START_Y = GamePlay.HEIGHT/2-(3*BUTTONS_HEIGHT/2+BUTTONS_Y_DISTANCE);
    public static final double CARD_SHOP_BUTTON_X = BUTTONS_WIDTH;
    public static final double CARD_SHOP_BUTTON_Y = BUTTONS_HEIGHT;
    public static final Image CARD_SHOP_BUTTON_IMAGE = new Image("data/images/general/new button.png",CARD_SHOP_BUTTON_X,CARD_SHOP_BUTTON_Y,false,false);
    public static final String CARD_SHOP_BUTTON_TEXT = "CARD SHOP";
    public static final int CARD_SHOP_FONT_SIZE = 10;
    public static final Font CARD_SHOP_FONT = DEFAULT_FONT;


    public static final double AMULET_SHOP_BUTTON_START_X = BUTTONS_START_X;
    public static final double AMULET_SHOP_BUTTON_START_Y = CARD_SHOP_BUTTON_START_Y + 2*(BUTTONS_HEIGHT+BUTTONS_Y_DISTANCE);;
    public static final double AMULET_SHOP_BUTTON_X = BUTTONS_WIDTH;
    public static final double AMULET_SHOP_BUTTON_Y = BUTTONS_HEIGHT;
    public static final Image AMULET_SHOP_BUTTON_IMAGE = new Image("data/images/general/new button.png",AMULET_SHOP_BUTTON_X,AMULET_SHOP_BUTTON_Y,false,false);
    public static final String AMULET_SHOP_BUTTON_TEXT = "AMULET SHOP";
    public static final int AMULET_SHOP_FONT_SIZE = 10;
    public static final Font AMULET_SHOP_FONT = DEFAULT_FONT;


    public static final double ITEM_SHOP_BUTTON_START_X = BUTTONS_START_X;
    public static final double ITEM_SHOP_BUTTON_START_Y = CARD_SHOP_BUTTON_START_Y + (BUTTONS_HEIGHT+BUTTONS_Y_DISTANCE);
    public static final double ITEM_SHOP_BUTTON_X = BUTTONS_WIDTH;
    public static final double ITEM_SHOP_BUTTON_Y = BUTTONS_HEIGHT;
    public static final Image ITEM_SHOP_BUTTON_IMAGE = new Image("data/images/general/new button.png",ITEM_SHOP_BUTTON_X,ITEM_SHOP_BUTTON_Y,false,false);
    public static final String ITEM_SHOP_BUTTON_TEXT = "ITEM SHOP";
    public static final int ITEM_SHOP_FONT_SIZE = 10;
    public static final Font ITEM_SHOP_FONT = DEFAULT_FONT;
}
