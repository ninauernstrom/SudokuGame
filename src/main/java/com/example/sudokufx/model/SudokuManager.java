package com.example.sudokufx.model;


import static com.example.sudokufx.model.SudokuUtilities.SudokuLevel.*;
import static com.example.sudokufx.model.SudokuUtilities.generateSudokuMatrix;

public class SudokuManager {

    private BoxData[][] boardArray;
    private SudokuUtilities.SudokuLevel difficulty;


    public SudokuManager() {
        boardArray = new BoxData[9][9];
        difficulty = SudokuUtilities.SudokuLevel.EASY;
    }

    public BoxData[][] reset(){
        boardArray = new BoxData[9][9];
        return createBoard();
    }

    public BoxData[][] setDifficulty(SudokuUtilities.SudokuLevel difficulty){
        this.difficulty = difficulty;
        return reset();
    }

    public boolean makeGuess(int guess, int row, int column){
        if(!gameIsOver()){
            boardArray[row][column].setUserInputValue(guess);
            return true;
        } else {
            return false;
        }
    }

    public boolean gameIsOver(){
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(boardArray[i][j].getValueToShow() == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public BoxData[][] createBoard() {
        int[][][] fullBoard  = SudokuUtilities.generateSudokuMatrix(difficulty);
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int show = 0; // represents if correct value should be shown at start
                if(fullBoard[i][j][0] != 0) show = 1;
                boardArray[i][j] = new BoxData(fullBoard[i][j][1], show); //[row][col][0] represents the initial values, zero representing an empty cell.
            }
        }
        return boardArray;
    }

    public BoxData[][] getBoardArray(){
        BoxData[][] copy = new BoxData[9][9];
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = new BoxData(boardArray[i][j].getCorrectValue(),
                        boardArray[i][j].getShowAtStart(),
                        boardArray[i][j].getUserInputValue());
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        String info = "initial board: " + "\n";
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                info += boardArray[i][j].getStartValue();
            }
            info += "\n";
        }
        info += "solution board: " + "\n";
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                info += boardArray[i][j].getCorrectValue();  // [row][col][0] represents the initial values, zero representing an empty cell.
                // [row][col][1] represents the solution.
            }
            info += "\n";
        }
        return info;
    }
}
