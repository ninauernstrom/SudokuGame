package com.example.sudokufx.view;


public class Controller {
    private com.example.sudokufx.view.SudokuView view;
    private com.example.sudokufx.view.GridView gridView;

    public Controller(com.example.sudokufx.view.SudokuView view) {
        this.view = view;
    }
    public void startNewGame() {

    }

    public void handleExit() {
        System.exit(0);
    }
}
