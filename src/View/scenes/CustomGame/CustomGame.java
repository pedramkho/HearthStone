package View.scenes.CustomGame;

import View.Graphics;
import View.scenes.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import static View.Graphics.goToMainMenu;
import static View.Graphics.goToPlayCustomGame;
import static View.Graphics.goToScene;
import static customGame.CustomGame.initializeNewCustomGame;
import static customGame.CustomGame.loadData;
import static customGame.CustomGame.removeCustomGame;
import static data.constants.General.CUSTOM_GAME_SAVE_LOCATION;
import static data.constants.scenes.customGame.*;

public class CustomGame extends Scene {
    public Text selectedGame = null;
    public ArrayList<Text> customGames = new ArrayList<>();
    public CustomGame() {
        super();
        setFill(BACKGROUND);
        addPlayButton();
        addEditButton();
        addRemoveButton();
        addNewCustomGameButton();
        addCurrentGames();
        addBackButton();
    }
    public void addBackButton() {
        ToggleButton button = createButton(BACK_BUTTON_IMAGE,BACK_BUTTON_START_X,BACK_BUTTON_START_Y,BACK_BUTTON_X,BACK_BUTTON_Y);
        button.setOnAction(event -> goToMainMenu());
        add(button);
    }
    private void refreshCustomGames(){
        for(Text customGame : customGames)
            remove(customGame);
        customGames.clear();
        addCurrentGames();
    }
    private void addCurrentGames() {
        File customGamesDirectory = new File(CUSTOM_GAME_SAVE_LOCATION);
        File[] customGames = customGamesDirectory.listFiles();
        int customGameNumber = 0;
        if(customGames!=null && customGames.length > 0) {
            for (File file : customGames)
                if (file.getName().endsWith(".ser")) {
                    String name = file.getName();
                    name = name.split("/")[name.split("/").length - 1];
                    name = name.substring(0, name.length() - 4);
                    Text customGame = new Text(GAME_BUTTONS_WIDTH,GAME_BUTTONS_HEIGHT,name);
                    customGame.relocate(GAME_BUTTONS_START_X, FIRST_GAME_BUTTON_START_Y + customGameNumber *
                            (GAME_BUTTONS_HEIGHT + GAME_BUTTONS_Y_DISTANCE));
                    customGame.setFont(new Font(GAME_BUTTONS_FONT_SIZE));
                    customGame.setOnMouseClicked(event -> {
                        if (CustomGame.this.selectedGame == customGame) {
                            CustomGame.this.selectedGame = null;
                            customGame.setFont(GAME_BUTTONS_FONT);
                        } else {
                            if(CustomGame.this.selectedGame!=null)
                                CustomGame.this.selectedGame.setFont(GAME_BUTTONS_FONT);
                            CustomGame.this.selectedGame = customGame;
                            customGame.setFont(GAME_BUTTONS_SELECTED_MODE_FONT);
                        }
                    });
                    add(customGame);
                    CustomGame.this.customGames.add(customGame);
                    customGameNumber++;
                }
        }
    }
    private void addNewCustomGameButton() {
        ToggleButton button = new ToggleButton("", new ImageView(NEW_GAME_BUTTON_IMAGE));
        button.relocate(NEW_GAME_BUTTON_START_X, NEW_GAME_BUTTON_START_Y);
        setButtonSize(button, NEW_GAME_BUTTON_X, NEW_GAME_BUTTON_Y);
        button.setOnAction(event -> {
            TextInputDialog textInputDialog = new TextInputDialog("name");
            textInputDialog.setTitle("Create new custom game");
            textInputDialog.setHeaderText("Enter custom game's name:");
            textInputDialog.setContentText("Name:");
            Optional<String> name = textInputDialog.showAndWait();
            name.ifPresent(name1 -> {
                initializeNewCustomGame(name1);
                goToScene(new EditGame());
            });
        });
        add(button);
    }
    private void addRemoveButton() {
        ToggleButton button = new ToggleButton("", new ImageView(REMOVE_BUTTON_IMAGE));
        button.relocate(REMOVE_BUTTON_START_X, REMOVE_BUTTON_START_Y);
        setButtonSize(button,REMOVE_BUTTON_X,REMOVE_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedGame!=null && !selectedGame.getText().equals("Default")){
                if(removeCustomGame(selectedGame.getText())) {
                    refreshCustomGames();
                    selectedGame = null;
                } else
                    System.out.println("Error while deleting custom game");
            }
        });
        add(button);
    }
    private void addEditButton() {
        ToggleButton button = new ToggleButton("", new ImageView(EDIT_BUTTON_IMAGE));
        button.relocate(EDIT_BUTTON_START_X, EDIT_BUTTON_START_Y);
        setButtonSize(button,EDIT_BUTTON_X,EDIT_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedGame!=null && selectedGame.getText()!="Default") {
                loadData(selectedGame.getText());
                goToScene(new EditGame());
            }
        });
        add(button);
    }
    private void addPlayButton() {
        ToggleButton button = new ToggleButton("", new ImageView(PLAY_BUTTON_IMAGE));
        button.relocate(PLAY_BUTTON_START_X, PLAY_BUTTON_START_Y);
        setButtonSize(button,PLAY_BUTTON_X,PLAY_BUTTON_Y);
        button.setOnAction(event -> {
            goToPlayCustomGame();
        });
        add(button);
    }
    private void addAddCardsButton(){
        Button button = new Button(ADD_CARDS_BUTTON_TEXT);
        button.relocate(ADD_CARDS_BUTTON_START_X, ADD_CARDS_BUTTON_START_Y);
        setButtonSize(button, ADD_CARDS_BUTTON_X, ADD_CARDS_BUTTON_Y);
        button.setOnAction(event -> {
            goToScene(new AddMonsterCard());
        });
        add(button);
    }

//    private void addAddSpellsButton(){
//        Button button = new Button(ADD_SPELLS_BUTTON_TEXT);
//        button.relocate(ADD_SPELLS_BUTTON_START_X, ADD_SPELLS_BUTTON_START_Y);
//        setButtonSize(button, ADD_SPELLS_BUTTON_X, ADD_SPELLS_BUTTON_Y);
//        button.setOnAction(event -> {
//            goToScene(new AddSpellCard());
//        });
//        add(button);
//    }
//    private void addEditItemsButton(){
//        Button button = new Button(EDIT_ITEMS_BUTTON_TEXT);
//        button.relocate(EDIT_ITEMS_BUTTON_START_X, EDIT_ITEMS_BUTTON_START_Y);
//        setButtonSize(button, EDIT_ITEMS_BUTTON_X, EDIT_ITEMS_BUTTON_Y);
//        button.setOnAction(event -> {
//            goToScene(new EditItems());
//        });
//        add(button);
//    }
//    private void addAddAmuletsButton(){
//        Button button = createButton(ADD_AMULETS_BUTTON_TEXT,ADD_AMULETS_BUTTON_START_X,ADD_AMULETS_BUTTON_START_Y,
//                ADD_AMULETS_BUTTON_X,ADD_AMULETS_BUTTON_Y,ADD_AMULETS_BUTTON_FONT);
//        button.setOnAction(event -> {
//            goToScene(new EditAmulets());
//        });
//        add(button);
//    }

    @Override
    public void refresh(){}//todo
}