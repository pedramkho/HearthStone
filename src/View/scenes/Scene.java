package View.scenes;

import Cards.Card;
import Cards.Component;
import Cards.ComponentType;
import ItemsAndAmulets.Item;
import com.company.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static Cards.Component.getComponent;
import static View.Graphics.goToScene;
import static data.constants.GamePlay.*;

abstract public class Scene extends javafx.scene.Scene {
    public Scene(){
        super(new Group(),WIDTH,HEIGHT);
    }
    public Scene(Object wallPaper){
        this();
        if(wallPaper instanceof Paint)
            setFill((Paint)wallPaper);
        else
            add((Node)wallPaper);
    }
    public void add(Node node){
        ((Group)getRoot()).getChildren().add(node);
    }
    public void addAll(Node... nodes){
        ((Group)getRoot()).getChildren().addAll(nodes);
    }
    public void remove(Node node){ ((Group)getRoot()).getChildren().remove(node);}
    public void addTitle(String text,double startX,double startY,Font font) {
        Text title = new Text(text);
        title.relocate(startX,startY);
        title.setFont(font);
        add(title);
    }
    public void setButtonSize(ButtonBase button, double width, double height){
        button.setMinSize(width,height);
        button.setMaxSize(width,height);
    }
    public Button createButton(String Text,double Start_x,double Start_y,double width,double heigh,Font font){
        Button button = new Button(Text);
        button.relocate(Start_x,Start_y);
        setButtonSize(button,width,heigh);
        if(font!=null)
            button.setFont(font);
        return button;
    }
    public ToggleButton createButton(Image image, double Start_x, double Start_y, double width, double height){
        ToggleButton button = new ToggleButton("",new ImageView(image));
        button.relocate(Start_x,Start_y);
        setButtonSize(button,width,height);
        return button;
    }
    public TextField createTextFiled(String text,double Start_x, double Start_y, double width, double height){
        TextField textField = new TextField();
        if(text!=null)
            textField.setText(text);
        textField.relocate(Start_x,Start_y);
        textField.setPrefSize(width,height);
        return textField;
    }
    public Text createText(String Text,double Start_x, double Start_y){
        Text text = new Text(Start_x,Start_y,Text);
        return text;
    }
    public boolean isNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public ScrollPane showObjects(Component[] components, double startX, double startY, double width, double height,
                                  double textsYDistance, Font defaultModeFont, Font selectedModeFont,
                                  TextContainer selectedText,boolean isInShop,boolean isShopComponentList,boolean isDeck){
        VBox vBox = new VBox(textsYDistance);
        int i = 1;
        for(Component component : components){
            Text text  = new Text(getComponentButtonText(component,isInShop,isShopComponentList,isDeck));
            text.setFont(defaultModeFont);
            text.setOnMouseClicked(event -> changeSelectedText(selectedText,text,defaultModeFont,selectedModeFont));
            if(isDeck){
                text.setText(i+". "+text.getText());
                i++;
            }
            vBox.getChildren().add(text);
        }
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.relocate(startX,startY);
        setSize(scrollPane,width,height);
        add(scrollPane);
        return scrollPane;
    }
    public static String getComponentButtonText(Component component,boolean isInShop,boolean isShopComponentList,boolean isDeck){
        String text = component.getName();
        if(isInShop){
            if(isShopComponentList){
                if(!(component instanceof Item))
                    text += " (" + component.getNumberInShop() + ")";
            }else{
                if(component instanceof Card)
                    text += " (" + Main.player.inventory.numberInInventory(component) +") / " +
                            Main.player.inventory.numberInDeck((Card)component)+ " on Deck";
                else
                    text += " (" + Main.player.inventory.numberInInventory(component) + ")";
            }
        }else if(!isDeck){
            if(component instanceof Card)
                text += " (" + Main.player.inventory.numberInInventory(component) +") / " +
                        Main.player.inventory.numberInDeck((Card)component)+ " on Deck";
            else
                text += " (" + Main.player.inventory.numberInInventory(component) + ")";
            }
        return text;
    }
    public void changeSelectedText(TextContainer selectedText,Text currentlySelected,Font defaultModeFont,Font selectedModeFont){
        if(selectedText.text==currentlySelected){
            selectedText.text = null;
            currentlySelected.setFont(defaultModeFont);
        }else{
            if(selectedText.text!=null)
                selectedText.text.setFont(defaultModeFont);
            currentlySelected.setFont(selectedModeFont);
            selectedText.text = currentlySelected;
        }
    }
    public void setSize(Region region,double width,double height){
        region.setMinSize(width,height);
        region.setMaxSize(width,height);
    }
    protected void addBackButton(Scene scene) {
        ToggleButton button = createButton(DEFAULT_BACK_BUTTON_IMAGE,DEFAULT_BACK_BUTTON_START_X,DEFAULT_BACK_BUTTON_START_Y,
                DEFAULT_BACK_BUTTON_X,DEFAULT_BACK_BUTTON_Y);
        button.setOnAction(new EventHandler<ActionEvent>() {
                               @Override
                               public void handle(ActionEvent event) {
                                   goToScene(scene);
                                   scene.refresh();
                               }
                           }
        );
        add(button);
    }
    public Component[] getPlayerComponents(ComponentType componentType,boolean shop){
        return Main.player.inventory.getPlayerComponents(componentType,shop);
    }
    public void showMessage(String text,ComponentType componentType){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(componentType.toString() + "Information");
        alert.setContentText(text);
        alert.showAndWait();
    }
    public Text showGil() {
        Text gilText = new Text(GIL_TEXT_X, GIL_TEXT_Y, Integer.toString(Main.player.money));
        gilText.setFont(GIL_FONT);
        add(gilText);
        ImageView gil = new ImageView(GIL_IMAGE);
        gil.relocate(GIL_IMAGE_X, GIL_IMAGE_Y);
        add(gil);
        return gilText;
    }
    public void addInfoButton(Image image,double startX,double startY,double width,double height,TextContainer textContainer){
        ToggleButton button = createButton(image,startX,startY,width,height);
        button.setOnAction(event -> {
            if(textContainer.text!=null)
                showMessage(getComponent(textContainer.text.getText()).getInfo(),getComponent(textContainer.text.getText()).getType());
        });
        add(button);
    }
    abstract public void refresh();
}