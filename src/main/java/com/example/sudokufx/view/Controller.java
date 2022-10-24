package com.example.sudokufx.view;


public class Controller {
    private com.example.sudokufx.view.SudokuView view;
    private com.example.sudokufx.view.GridView gridView;

    public Controller(com.example.sudokufx.view.SudokuView view) {
        this.view = view;
    }
    public void startNewGame() {
<<<<<<< Updated upstream

=======
    }

    public void setGuess(int guess){
        sudokuManager.setGuess(guess);
    }

    public void makeGuess(int row, int col){
        sudokuManager.makeGuess(row, col);
        gridView.updateGridView();
>>>>>>> Stashed changes
    }

    public void handleExit() {
        System.exit(0);
    }
}
