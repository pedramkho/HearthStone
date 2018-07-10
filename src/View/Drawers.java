package View;


import Cards.Card;
import Cards.MonsterCard.Monster;
import Player.Player;
import World.World;
import com.company.Main;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Drawers {
    public static void drawStartMenu(Group root){
        root.getChildren().clear();
        Button singlePlayer = new Button("Single Player");
        singlePlayer.setScaleX(1);
        singlePlayer.setScaleY(1);
        singlePlayer.setLayoutX(Graphics.Height / 2 + 30);
        singlePlayer.setLayoutY(Graphics.Width / 2 - 250);
        singlePlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO:Change it to MAP
                Graphics.page = Pages.War;
            }
        });

        Button settings = new Button("Settings");
        settings.setScaleX(1);
        settings.setScaleY(1);
        settings.setLayoutX(Graphics.Height / 2 + 43);
        settings.setLayoutY(Graphics.Width / 2 - 170);
        settings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Settings
            }
        });

        Button exit = new Button("Exit");
        exit.setScaleX(1);
        exit.setScaleY(1);
        exit.setLayoutX(Graphics.Height / 2 + 60);
        exit.setLayoutY(Graphics.Width / 2 - 70);
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO:Exit
            }
        });

        root.getChildren().addAll(singlePlayer, settings, exit);
    }



    static WarMenuModes warMenuMode = WarMenuModes.ShowHand;
    static Card selectedCard = null;
    static Card targetCard = null;
    static void drawCardMode(Group root, World world){
        //TODO: We should enter use card mode here
        int X = 2 * Graphics.Width / 3;
        Text text = new Text(X, 10, "Choose Target");
        root.getChildren().addAll(text);

        if (targetCard != null){
            Button attack  = new Button("Attack");
            attack.setLayoutX(X + 50);
            attack.setScaleY(20);
            attack.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    targetCard = null;
                    //TODO: add Attack command here
                }
            });
            root.getChildren().add(attack);
        }

        if(((Monster)selectedCard).haveSpell){
            if(((Monster)selectedCard).needChoosing){
                if(targetCard != null){
                    Button spell = new Button("Spell");
                    spell.setLayoutX(X + 50);
                    spell.setLayoutY(60);
                    spell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            //TODO: this should cast The spell with target
                        }
                    });
                    root.getChildren().add(spell);
                }
            }else {
                Button spell = new Button("Spell");
                spell.setLayoutX(X + 50);
                spell.setLayoutY(60);
                spell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        //TODO: this should just cast The spell
                    }
                });
                root.getChildren().add(spell);
            }
        }
    }
    static void drawItem(Group root, World world){}
    static void drawHand(Group root, World world){
        int X = 2 * Graphics.Width / 3;
        int Y = 5;

        for(int i = 0; i < world.thePlayer.hand.size(); i++){
            Text text = new Text(world.thePlayer.hand.get(i).name);
            text.setX(X);
            text.setY(Y + 15);
            Rectangle rectangle = new Rectangle(X, Y, Graphics.Width/3,25);

            if(world.thePlayer.hand.get(i) == selectedCard) {
                rectangle.setFill(Color.DARKRED);
            }else{
                rectangle.setFill(Color.PALEVIOLETRED);
            }
            Y += 28;
            int finalI = i;
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    rectangle.setFill(Color.INDIANRED);
                    selectedCard = world.thePlayer.hand.get(finalI);
                }
            });
            root.getChildren().addAll(rectangle, text);
            if(selectedCard != null){
                Button playCard = new Button("Play Card");
                playCard.setLayoutX(Graphics.Width - 120);
                playCard.setLayoutY(Graphics.Height - 170);
                playCard.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Main.sendCommand("set " + world.thePlayer.hand.indexOf(selectedCard));
                        selectedCard = null;
                    }
                });
                root.getChildren().addAll(playCard);
            }
        }
    }
    static void drawMyField(Group root, World world){
        int X = Graphics.Width / 3;

        double monsterCardLenght = Graphics.Width / 3.0 / 6;

        //add monsterField
        int[] monsterFieldIndex = new int[]{X + 15, (int) (X + monsterCardLenght + 15)
                , (int) (X + 2*monsterCardLenght + 15), (int) (X + 3 * monsterCardLenght + 15)
                , (int) (X + 4 * monsterCardLenght + 15)};
        Player player = world.thePlayer;
        for(int i = 0; i < player.monsterField.size(); i++){
            Text text = new Text(monsterFieldIndex[i], Graphics.Height/2 + 50
                    , player.monsterField.get(i).name + "\nHP: " + player.monsterField.get(i).HP
                    + "\nAP: " + player.monsterField.get(i).AP);
            Rectangle rectangle = new Rectangle(monsterFieldIndex[i], Graphics.Height/2 + 30, monsterCardLenght - 5, 50);
            rectangle.setFill(Color.GREENYELLOW);
            int finalI = i;
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCard = player.monsterField.get(finalI);
                    warMenuMode = WarMenuModes.CardMode;
                }
            });
            root.getChildren().addAll(rectangle, text);
        }
        for(int i = player.monsterField.size(); i < 5; i++){
            Rectangle rectangle = new Rectangle(monsterFieldIndex[i], Graphics.Height/2 + 30, monsterCardLenght - 5, 50);
            rectangle.setFill(Color.DARKGREEN);
            root.getChildren().addAll(rectangle);
        }


        //Add spellField
        int[] spellFieldIndex = new int[]{ (int) (X + monsterCardLenght + 15), (int) (X + 2*monsterCardLenght + 15), (int) (X + 3 * monsterCardLenght + 15)};
        for(int i = 0; i < player.spellField.size(); i++){
            Text text = new Text(spellFieldIndex[i], Graphics.Height - 100, player.spellField.get(i).name);
            Rectangle rectangle = new Rectangle(spellFieldIndex[i],  Graphics.Height / 2 + 88, monsterCardLenght - 5, 50);
            rectangle.setFill(Color.GREEN);
            int finalI = i;
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectedCard = player.spellField.get(finalI);
                    warMenuMode = WarMenuModes.ShowHand;
                }
            });
            root.getChildren().addAll(rectangle, text);
        }
        for(int i = player.spellField.size(); i < 3; i++){
            Rectangle rectangle = new Rectangle(spellFieldIndex[i],  Graphics.Height / 2 + 88, monsterCardLenght - 5, 50);
            rectangle.setFill(Color.DARKRED);
            root.getChildren().addAll(rectangle);
        }

        //Add Hero
        Circle circle = new Circle((int) (X + 2.5*monsterCardLenght + 15), Graphics.Height - 150, 30, Color.ORANGE);
        Text text = new Text((int) (X + 2.5*monsterCardLenght + 15) + 30, Graphics.Height - 150
                , "HP: " + player.Hero.HP + "/10000" + "\nMP: " + player.MP + "/" + player.MaxMP);
        root.getChildren().addAll(circle, text);

        //Add Deck and GraveYard
        Rectangle deck = new Rectangle(X + Graphics.Width/3 - 50, Graphics.Height - 150, 45, 55);
        Text deckText = new Text(X + Graphics.Width/3 - 50 + monsterCardLenght / 2 - 10, Graphics.Height - 120, "" + player.deck.size());
        deck.setFill(Color.BISQUE);
        root.getChildren().addAll(deck, deckText);

        Rectangle graveYard = new Rectangle(X + 5, Graphics.Height - 150, 45, 55);
        graveYard.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO: need to do something
            }
        });
        graveYard.setFill(Color.BISQUE);
        Text graveYardText = new Text(X + 5, Graphics.Height - 120, "GraveYard");
        root.getChildren().addAll(graveYard, graveYardText);

    }
    static void drawEnemyField(Group root, World world){}

    static void drawRightSideMenuInWar(Group root, World world){

        int X = 2*Graphics.Width/3;

        //add showHand and showItem buttons
        Button showHand = new Button("Show Hand");
        showHand.setLayoutX(X + 10);
        showHand.setLayoutY(Graphics.Height - 120);
        showHand.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Clicked");
                warMenuMode = WarMenuModes.ShowHand;
            }
        });

        Button showItem = new Button("Show Item");
        showItem.setLayoutX(Graphics.Width - 120);
        showItem.setLayoutY(Graphics.Height - 120);
        showItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                warMenuMode = WarMenuModes.ShowItems;
            }
        });

        root.getChildren().addAll(showHand, showItem);


        //Add each mode options
        if(warMenuMode == WarMenuModes.ShowHand){
            drawHand(root, world);
        }else if(warMenuMode == WarMenuModes.ShowItems){
            drawItem(root, world);
        }else if(warMenuMode == WarMenuModes.CardMode){
            drawCardMode(root, world);
        }

    }
    static void drawPlayFieldInWar(Group root, World world){
        drawMyField(root, world);
        drawEnemyField(root, world);
    }
    static void drawTextFieldInWar(Group root, World world){
        if(selectedCard != null){
            Text info = new Text(10, 15, ((Monster)selectedCard).description);
            root.getChildren().addAll(info);
        }

        Text event = new Text(10, Graphics.Height/2 + 100, Main.again);
        root.getChildren().addAll(event);

    }

    public static void drawWar(Group root, World world){
        root.getChildren().clear();

        drawRightSideMenuInWar(root, world);
        drawPlayFieldInWar(root, world);
        drawTextFieldInWar(root, world);
    }

    enum WarMenuModes{
        CardMode,
        ShowHand,
        ShowItems
    }

}