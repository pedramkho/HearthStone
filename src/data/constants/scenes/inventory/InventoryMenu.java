package data.constants.scenes.inventory;

import data.constants.GamePlay;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static data.constants.GamePlay.DEFAULT_FONT;

public class InventoryMenu {
    public static final Color BackGround = null;

    public static final double BUTTONS_WIDTH = 200;
    public static final double BUTTONS_START_X = (GamePlay.WIDTH - BUTTONS_WIDTH) / 2;
    public static final double BUTTONS_HEIGHT = 100;
    public static final double BUTTONS_Y_DISTANCE = 50;

    public static final double CARD_INVENTORY_BUTTON_START_X = BUTTONS_START_X;
    public static final double CARD_INVENTORY_BUTTON_START_Y = GamePlay.HEIGHT / 2 - (3 * BUTTONS_HEIGHT / 2 + BUTTONS_Y_DISTANCE);
    public static final double CARD_INVENTORY_BUTTON_X = BUTTONS_WIDTH;
    public static final double CARD_INVENTORY_BUTTON_Y = BUTTONS_HEIGHT;
    public static final Image CARD_INVENTORY_BUTTON_IMAGE = new Image("data/images/general/new button.png", CARD_INVENTORY_BUTTON_X, CARD_INVENTORY_BUTTON_Y, false, false);
    public static final String CARD_INVENTORY_BUTTON_TEXT = "CARD INVENTORY";
    public static final int CARD_INVENTORY_FONT_SIZE = 10;
    public static final Font CARD_INVENTORY_FONT = DEFAULT_FONT;


    public static final double AMULET_INVENTORY_BUTTON_START_X = BUTTONS_START_X;
    public static final double AMULET_INVENTORY_BUTTON_START_Y = CARD_INVENTORY_BUTTON_START_Y + 2 * (BUTTONS_HEIGHT + BUTTONS_Y_DISTANCE);
    ;
    public static final double AMULET_INVENTORY_BUTTON_X = BUTTONS_WIDTH;
    public static final double AMULET_INVENTORY_BUTTON_Y = BUTTONS_HEIGHT;
    public static final Image AMULET_INVENTORY_BUTTON_IMAGE = new Image("data/images/general/new button.png", AMULET_INVENTORY_BUTTON_X, AMULET_INVENTORY_BUTTON_Y, false, false);
    public static final String AMULET_INVENTORY_BUTTON_TEXT = "AMULET INVENTORY";
    public static final int AMULET_INVENTORY_FONT_SIZE = 10;
    public static final Font AMULET_INVENTORY_FONT = DEFAULT_FONT;


    public static final double ITEM_INVENTORY_BUTTON_START_X = BUTTONS_START_X;
    public static final double ITEM_INVENTORY_BUTTON_START_Y = CARD_INVENTORY_BUTTON_START_Y + (BUTTONS_HEIGHT + BUTTONS_Y_DISTANCE);
    public static final double ITEM_INVENTORY_BUTTON_X = BUTTONS_WIDTH;
    public static final double ITEM_INVENTORY_BUTTON_Y = BUTTONS_HEIGHT;
    public static final Image ITEM_INVENTORY_BUTTON_IMAGE = new Image("data/images/general/new button.png", ITEM_INVENTORY_BUTTON_X, ITEM_INVENTORY_BUTTON_Y, false, false);
    public static final String ITEM_INVENTORY_BUTTON_TEXT = "ITEM INVENTORY";
    public static final int ITEM_INVENTORY_FONT_SIZE = 10;
    public static final Font ITEM_INVENTORY_FONT = DEFAULT_FONT;
}