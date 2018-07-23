package data.constants.scenes;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import static data.constants.GamePlay.*;

public class customGame {
    //todo
    public static final Paint BACKGROUND = Color.rgb(255,255,255);

    public static final double NEW_GAME_BUTTON_START_Y = 130;
    public static final double NEW_GAME_BUTTON_START_X = 500;
    public static final double NEW_GAME_BUTTON_X = 20;
    public static final double NEW_GAME_BUTTON_Y = 20;
    public static final Image NEW_GAME_BUTTON_IMAGE = new Image("data/images/general/new button.png",NEW_GAME_BUTTON_X,NEW_GAME_BUTTON_Y,false,false);

    public static final double EDIT_BUTTON_START_Y = 160;
    public static final double EDIT_BUTTON_START_X = 500;
    public static final double EDIT_BUTTON_X = 20;
    public static final double EDIT_BUTTON_Y = 20;
    public static final Image EDIT_BUTTON_IMAGE = new Image("data/images/general/edit button.png",EDIT_BUTTON_X,EDIT_BUTTON_Y,false,false);

    public static final double REMOVE_BUTTON_START_Y = 190;
    public static final double REMOVE_BUTTON_START_X = 500;
    public static final double REMOVE_BUTTON_X = 20;
    public static final double REMOVE_BUTTON_Y = 20;
    public static final Image REMOVE_BUTTON_IMAGE = new Image("data/images/general/remove button.png",REMOVE_BUTTON_X,REMOVE_BUTTON_Y,false,false);

    public static final double PLAY_BUTTON_START_Y = 100;
    public static final double PLAY_BUTTON_START_X = 500;
    public static final double PLAY_BUTTON_X = 20;
    public static final double PLAY_BUTTON_Y = 20;
    public static final Image PLAY_BUTTON_IMAGE = new Image("data/images/custom game/play button.png",PLAY_BUTTON_X,PLAY_BUTTON_Y,false,false);

    public static final double ADD_CARDS_BUTTON_START_X = 40;
    public static final double ADD_CARDS_BUTTON_START_Y = 500;
    public static final double ADD_CARDS_BUTTON_X = 175;
    public static final double ADD_CARDS_BUTTON_Y = 50;
    public static final String ADD_CARDS_BUTTON_TEXT = "New Card";

    public static final double ADD_SPELLS_BUTTON_START_X = 255;
    public static final double ADD_SPELLS_BUTTON_START_Y = 500;
    public static final double ADD_SPELLS_BUTTON_X = 170;
    public static final double ADD_SPELLS_BUTTON_Y = 50;
    public static final String ADD_SPELLS_BUTTON_TEXT = "New spell";

    public static final double EDIT_ITEMS_BUTTON_START_X = 470;
    public static final double EDIT_ITEMS_BUTTON_START_Y = 500;
    public static final double EDIT_ITEMS_BUTTON_X = 170;
    public static final double EDIT_ITEMS_BUTTON_Y = 50;
    public static final String EDIT_ITEMS_BUTTON_TEXT = "Edit items";

    public static final double ADD_AMULETS_BUTTON_START_X = 685;
    public static final double ADD_AMULETS_BUTTON_START_Y = 500;
    public static final double ADD_AMULETS_BUTTON_X = 170;
    public static final double ADD_AMULETS_BUTTON_Y = 50;
    public static final String ADD_AMULETS_BUTTON_TEXT = "New Amulet";
    public static final int ADD_AMULETS_BUTTON_FONT_SIZE = 10;
    public static final Font ADD_AMULETS_BUTTON_FONT = new Font(ADD_AMULETS_BUTTON_FONT_SIZE);

    public static final double BACK_BUTTON_START_X = DEFAULT_BACK_BUTTON_START_X;
    public static final double BACK_BUTTON_START_Y = DEFAULT_BACK_BUTTON_START_Y;
    public static final double BACK_BUTTON_X = DEFAULT_BACK_BUTTON_X;
    public static final double BACK_BUTTON_Y = DEFAULT_BACK_BUTTON_Y;
    public static final Image BACK_BUTTON_IMAGE = DEFAULT_BACK_BUTTON_IMAGE;

    public static final double GAME_BUTTONS_WIDTH = 100;
    public static final double GAME_BUTTONS_HEIGHT = 10;
    public static final double GAME_BUTTONS_START_X = 150;
    public static final double GAME_BUTTONS_Y_DISTANCE = 10;
    public static final double FIRST_GAME_BUTTON_START_Y = 200;
    public static final int GAME_BUTTONS_FONT_SIZE = 10;
    public static final Font GAME_BUTTONS_FONT = new Font(GAME_BUTTONS_FONT_SIZE);
    public static final int GAME_BUTTONS_SELECTED_MODE_FONT_SIZE = 15;
    public static final Font GAME_BUTTONS_SELECTED_MODE_FONT = new Font(GAME_BUTTONS_SELECTED_MODE_FONT_SIZE);
}
