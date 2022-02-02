package org.example.tictactoe;

import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.GameState;
import org.example.tictactoe.model.TicTacToeCell;

import static org.example.tictactoe.model.TicTacToeCell.EMPTY;

public class TicTacToeBoard {

    private final TicTacToeCell[][] cells;

    public TicTacToeBoard() {
        this.cells = new TicTacToeCell[][]{
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
        };
    }

    TicTacToeBoard(TicTacToeCell[][] cells) {
        this.cells = cells;
    }

    public void setCell(CellSelection cell, TicTacToeCell value) {
        this.cells[cell.row()][cell.col()] = value;
    }

    public TicTacToeCell[][] getCells() {
        return this.cells;
    }

    public GameState checkGameState() {
        /*
         * TODO - Based on the current state of the board, is the game still ongoing, has a player won, or is there a tie?
         */
        if(gameEnd()){
            if(whoWon() == 1){
                return GameState.X_WINS;
            }else if(whoWon() == 2){
                return GameState.O_WINS;
            }else{
                return GameState.TIE;
            }
        }

        return GameState.ONGOING;
    }

    public boolean isLegalMove(CellSelection selection) {
        /*
        * TODO - Based on the current state of the board, is the input selection allowed? Note that this method does not
        *  need to check that the row and column are in the right range. The InputParser is already doing that
        * */
        return false;
    }

    public boolean gameEnd(){
        return true;
    }

    public int whoWon(){

        return 1;
    }

}
