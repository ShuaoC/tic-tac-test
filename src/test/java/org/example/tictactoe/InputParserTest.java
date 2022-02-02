package org.example.tictactoe;

import org.example.tictactoe.input.InputMoveException;
import org.example.tictactoe.input.InputParser;
import org.example.tictactoe.model.CellSelection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class InputParserTest {
    /*
    * TODO - Write some tests in this file. You should test the InputParser class. Please test the following behaviors
    *  1. When a user inputs a valid coordinate string (in the form 2,1 where 2 is the row and 1 is the column)
    *     the InputParser returns a CellSelection with what they entered
    *  2. If the user tries to use a coordinate with an out of bounds row or column, the InputParser throws an InputMoveException
    *  3. If the user tries to use a coordinate that has too many components, the InputParser throws an InputMoveException
    *  4. If the user tries to use a coordinate with invalid integer numbers, the InputParser throws an InputMoveException
    *  5. If the user tries to choose a coordinate in a square that is already filled with another value, the InputParser
    *     throws an InputMoveException
    * */


    @Test
    void testParseInput() throws InputMoveException {
        InputParser x = new InputParser();
        var board = new TicTacToeBoard();
        assertEquals(new CellSelection(2, 2), x.parseInput("2,2",board));
    }

    @Test
    void testParseInputOutOfBound() throws InputMoveException {
        InputParser x = new InputParser();
        var board = new TicTacToeBoard();
        try{
            x.parseInput("3,2",board);
        }catch (InputMoveException e){
            assertEquals("One of your selections was out of bounds",e.getMessage());
        }

    }


}