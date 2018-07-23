package View.scenes.CustomGame;


import ItemsAndAmulets.Item;
import View.scenes.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import static ItemsAndAmulets.Item.createCustomItem;
import static ItemsAndAmulets.Item.items;
import static View.Graphics.goToScene;
import static data.constants.scenes.EditItems.*;

public class EditItems extends Scene {

    private TextField name = null;
    private TextField hpIncrease = null;
    private TextField mpIncrease = null;
    private TextField price = null;
    private Item editingItem = null;

    public EditItems() {
        super();
        setFill(BACKGROUND);
        addTitle(TITLE,TITILE_START_X,TITILE_START_Y,TITLE_FONT);
        addNameTextField();
        addHpIncreaseTextField();
        addMpIncreaseTextField();
        addPriceTextFiled();
        addCreateButton();
        addBackButton();
    }

    private void addPriceTextFiled() {
        Text text = createText(PRICE_TEXT_TEXT, PRICE_TEXT_START_X, PRICE_TEXT_START_Y);
        price = createTextFiled(PRICE_TEXTFIELD_TEXT, PRICE_TEXTFIELD_START_X,
                PRICE_TEXTFIELD_START_Y, PRICE_TEXTFIELD_X,PRICE_TEXTFIELD_Y);
        if(editingItem !=null)
            price.setText(Integer.toString(editingItem.getPrice()));
        add(text);
        add(price);
    }

    public EditItems(String itemName){
        this();
        for(Item item:Item.items)
            if(item.getName().equals(itemName)){
                editingItem = item;
                break;
            }
        if(editingItem == null)
            System.out.println("Error");
    }

    public void addBackButton() {
        ToggleButton button = createButton(BACK_BUTTON_IMAGE,BACK_BUTTON_START_X,BACK_BUTTON_START_Y,BACK_BUTTON_X,BACK_BUTTON_Y);
        button.setOnAction(event -> goToScene(new EditGame()));
        add(button);
    }
    private void addCreateButton() {
        Button button = createButton(CREATE_BUTTON_TEXT,CREATE_BUTTON_START_X,CREATE_BUTTON_START_Y,CREATE_BUTTON_X,CREATE_BUTTON_Y,CREATE_BUTTON_FONT);
        button.setOnAction(event -> {
            if(areInputsValid()){
                if(editingItem != null){
                    editingItem.name = name.getText();
                    editingItem.mpIncrease = Integer.parseInt(mpIncrease.getText());
                    editingItem.hpIncrease = Integer.parseInt(hpIncrease.getText());
                    editingItem.setPrice(Integer.parseInt(price.getText()));
                }else
                    createCustomItem(name.getText(),Integer.parseInt(hpIncrease.getText()),Integer.parseInt(mpIncrease.getText()),Integer.parseInt(price.getText()));
                goToScene(new EditGame());
            }else{
                //todo
            }
        });
        add(button);
    }
    private void addMpIncreaseTextField() {
        Text text = createText(MAX_MP_CHANGE_TEXT_TEXT, MAX_MP_CHANGE_TEXT_START_X, MAX_MP_CHANGE_TEXT_START_Y);
        mpIncrease = createTextFiled(MAX_MP_CHANGE_TEXTFIELD_TEXT, MAX_MP_CHANGE_TEXTFIELD_START_X,
                MAX_MP_CHANGE_TEXTFIELD_START_Y, MAX_MP_CHANGE_TEXTFIELD_X,MAX_MP_CHANGE_TEXTFIELD_Y);
        if(editingItem !=null)
            mpIncrease.setText(Integer.toString(editingItem.mpIncrease));
        add(text);
        add(mpIncrease);
    }
    private void addHpIncreaseTextField() {
        Text text = createText(MAX_HP_CHANGE_TEXT_TEXT, MAX_HP_CHANGE_TEXT_START_X, MAX_HP_CHANGE_TEXT_START_Y);
        hpIncrease = createTextFiled(MAX_HP_CHANGE_TEXTFIELD_TEXT, MAX_HP_CHANGE_TEXTFIELD_START_X,
                MAX_HP_CHANGE_TEXTFIELD_START_Y, MAX_HP_CHANGE_TEXTFIELD_X,MAX_HP_CHANGE_TEXTFIELD_Y);
        if(editingItem !=null)
            hpIncrease.setText(Integer.toString(editingItem.hpIncrease));
        add(text);
        add(hpIncrease);
    }
    private void addNameTextField() {
        Text text = createText(NAME_TEXT_TEXT, NAME_TEXT_START_X, NAME_TEXT_START_Y);
        name = createTextFiled(NAME_TEXTFIELD_TEXT, NAME_TEXTFIELD_START_X, NAME_TEXTFIELD_START_Y, NAME_TEXTFIELD_X, NAME_TEXTFIELD_Y);
        if(editingItem !=null)
            name.setText(editingItem.name);
        add(text);
        add(name);
    }
    private boolean areInputsValid(){
        return isNameValid()&&isNumber(hpIncrease.getText())&&isNumber(mpIncrease.getText())&&isNumber(price.getText());
    }
    private boolean isNameValid(){
        if(editingItem !=null && name.getText().equals(editingItem.name))
            return true;
        for(Item item:items)
            if(item.getName().equals(name.getText()))
                return false;
        return true;
    }
    @Override
    public void refresh(){}//todo
}
