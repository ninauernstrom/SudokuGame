package com.example.sudokufx.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// NB! To run this code, create a proper JavaFX project
public class MainUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        SudokuView view = new SudokuView(); // creates the controller
        GridView gridView = new GridView();

        MenuBar menubar = view.getMenuBar();

        view.setCenter(gridView);

        // we need a VBox to put the menu bar at the top of the window
        VBox root = new VBox(menubar, view);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);

        primaryStage.setTitle("Sudoku");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}