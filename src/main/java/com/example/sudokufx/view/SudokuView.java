package com.example.sudokufx.view;

import com.example.sudokufx.model.SudokuManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SudokuView extends BorderPane {

    private VBox root;
    private Button checkButton;
    private Button hintButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button cButton;
    private MenuBar menuBar;

    private SudokuManager sudokuManager;

    private GridView gridView;

    SudokuView(SudokuManager sudokuManager) {
        super();
        //createUiComponents();
        this.sudokuManager = sudokuManager;
        Controller controller = new Controller(this, sudokuManager);
        createMenuBar(controller);
        createUiComponents();
        addEventHandlers(controller);

    }

    public void addGrid() {
    }

    private void createUiComponents() {
        checkButton = new Button("Check");
        hintButton = new Button("Hint");
        VBox vboxLeft = new VBox(checkButton, hintButton);
        vboxLeft.setAlignment(Pos.CENTER);
        this.setLeft(vboxLeft);
        oneButton = new Button("1");
        twoButton = new Button("2");
        threeButton = new Button("3");
        fourButton = new Button("4");
        fiveButton = new Button("5");
        sixButton = new Button("6");
        sevenButton = new Button("7");
        eightButton = new Button("8");
        nineButton = new Button("9");
        cButton = new Button("C");
        VBox vboxRight = new VBox(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, cButton);
        vboxRight.setAlignment(Pos.CENTER);
        this.setRight(vboxRight);

    }

    private void createMenuBar(Controller controller) {
        Menu fileMenu = new Menu("File");
        MenuItem loadItem = new MenuItem("Load game");
        MenuItem saveItem = new MenuItem("Save game");
        MenuItem exitItem = new MenuItem("Exit");
        EventHandler<ActionEvent> exitHandler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.handleExit(); // save data and exit
            }
        };
        exitItem.addEventHandler(ActionEvent.ACTION, exitHandler);
        fileMenu.getItems().add(loadItem);
        fileMenu.getItems().add(saveItem);
        fileMenu.getItems().add(exitItem);

        Menu gameMenu = new Menu("Game");
        MenuItem difficultyItem = new MenuItem("Set difficulty");
        EventHandler<ActionEvent> difficultyHandler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //controller.setDifficulty();
            }
        };
        difficultyItem.addEventHandler(ActionEvent.ACTION, difficultyHandler);

        MenuItem startItem = new MenuItem("Start new game");
        EventHandler<ActionEvent> startHandler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.startNewGame();
            }
        };
        startItem.addEventHandler(ActionEvent.ACTION, startHandler);

        gameMenu.getItems().add(startItem);
        gameMenu.getItems().add(difficultyItem);

        Menu helpMenu = new Menu("Help");
        MenuItem clearItem = new MenuItem("Clear");
        MenuItem checkIfCorrectItem = new MenuItem("Check if correct");
        MenuItem rulesItem = new MenuItem("Rules");

        helpMenu.getItems().add(clearItem);
        helpMenu.getItems().add(checkIfCorrectItem);
        helpMenu.getItems().add(rulesItem);


        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, gameMenu, helpMenu);
    }

    private void addEventHandlers(Controller controller){
        EventHandler<ActionEvent> numberButtonHandler = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                int number = Integer.parseInt(((Button)actionEvent.getSource()).getText());
                controller.setGuess(number);
            }
        };
        oneButton.addEventHandler(ActionEvent.ACTION, numberButtonHandler);
    }

    // Main.start needs a reference to the menu bar
    public MenuBar getMenuBar() {
        return this.menuBar;
    }


}
