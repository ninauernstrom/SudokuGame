package com.example.sudokufx.view;


import com.example.sudokufx.model.SudokuManager;

public class Controller {
    private com.example.sudokufx.view.SudokuView view;
    private SudokuManager sudokuManager;
    private com.example.sudokufx.view.GridView gridView;

    public Controller(com.example.sudokufx.view.SudokuView view, SudokuManager sudokuManager) {
        this.view = view;
        this.sudokuManager = sudokuManager;
    }

    public Controller(com.example.sudokufx.view.GridView gridView, SudokuManager sudokuManager){
        this.gridView = gridView;
        this.sudokuManager = sudokuManager;
    }
    public void startNewGame() {
    }

    public void setGuess(int guess){
        sudokuManager.setGuess(guess);
        System.out.println("value when setting guess: " + sudokuManager.getGuess());
    }

    public void makeGuess(int row, int col){
        sudokuManager.makeGuess(row, col);
        gridView.updateGridView();
        System.out.println("value when making guess: " + sudokuManager.getGuess());
    }

    public void handleExit() {
        System.exit(0);
    }
}
