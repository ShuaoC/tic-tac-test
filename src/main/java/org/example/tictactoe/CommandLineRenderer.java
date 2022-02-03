package org.example.tictactoe;

import org.example.tictactoe.model.TicTacToeCell;

import java.io.PrintStream;

public class CommandLineRenderer {

    private final PrintStream output;
    static final String BOARD_BORDER = "============";
    public CommandLineRenderer(PrintStream output) {
        this.output = output;
    }

    public void renderBoard(TicTacToeBoard board) {
        /*
        * TODO - This function should use the "output" PrintStream to print a command line representation of the board.
        *        Check out how the BoardRendererTest JUnit test expects it to be rendered. This method should not call
        *        renderMessage or renderError. Just directly print to this.output
        * */
        TicTacToeCell[][] cells = board.getCells();
        String data = CommandLineRenderer.BOARD_BORDER + "\n"
                    + " "+ cells[0][0] +" | " + cells[0][1] + " | "+ cells[0][2] +" " + "\n"
                    + " "+ cells[1][0] +" | " + cells[1][1] + " | "+ cells[1][2] +" " + "\n"
                    + " "+ cells[2][0] +" | " + cells[2][1] + " | "+ cells[2][2] +" " + "\n"
                    + CommandLineRenderer.BOARD_BORDER + "\n";
        data = data.replace("EMPTY"," ");
        try{
            output.print(data);
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    public void renderMessage(String message) {
        this.output.println(message);
    }

    public void renderError(String message) {
        this.output.println(message);
    }

}
