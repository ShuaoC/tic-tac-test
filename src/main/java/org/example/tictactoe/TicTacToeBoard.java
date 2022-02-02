package org.example.tictactoe;

import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.GameState;
import org.example.tictactoe.model.TicTacToeCell;

import static org.example.tictactoe.model.TicTacToeCell.*;

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
        if(GameWon()!= null){
            if(GameWon()==X) return GameState.X_WINS;
            else return GameState.O_WINS;
        }
        if(fullBoard() == true){
            return GameState.TIE;
        }

        return GameState.ONGOING;
    }

    public boolean isLegalMove(CellSelection selection) {
        /*
        * TODO - Based on the current state of the board, is the input selection allowed? Note that this method does not
        *  need to check that the row and column are in the right range. The InputParser is already doing that
        * */
        if(checkGameState() != GameState.ONGOING) return false;
        if(this.cells[selection.row()][selection.col()]!=EMPTY) return false;
        return true;
    }

    public boolean fullBoard(){
        for(int i = 0; i < 3; i ++){
            for(int j =0; j < 3; j ++){
                if(this.cells[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    public TicTacToeCell GameWon(){
        for(int i = 0; i < 3; i ++){
            if(this.cells[i][0] == this.cells[i][1] && this.cells[i][1] == this.cells[i][2] && this.cells[i][1] != EMPTY) return this.cells[i][0];
            if(this.cells[0][i] == this.cells[1][i] && this.cells[1][i] == this.cells[2][i] && this.cells[0][i] != EMPTY) return this.cells[0][i];
        }
        if(this.cells[0][0] == this.cells[1][1] && this.cells[1][1] == this.cells[2][2] && this.cells[1][1]!=EMPTY) return this.cells[1][1];
        if(this.cells[0][2] == this.cells[1][1] && this.cells[1][1] == this.cells[2][0] && this.cells[1][1]!=EMPTY) return this.cells[1][1];
        return null;
    }


}
