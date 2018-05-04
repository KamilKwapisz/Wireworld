package tests;

import UserInterface.Controllers.GameGrid;
import core.*;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class TestWireworldSimulation {

    public static void main(String[] args) {
        Board board = new Board(3,3);

        board.addCell(new Cell(0, 0, 1));
        board.addCell(new Cell(1, 0, 3));
        board.addCell(new Cell(2, 0, 2));

        board.addCell(new Cell(0, 1, 3));
        board.addCell(new Cell(1, 1, 2));
        board.addCell(new Cell(2, 1, 1));

        board.addCell(new Cell(0, 2, 1));
        board.addCell(new Cell(1, 2, 2));
        board.addCell(new Cell(2, 2, 3));
        /*
         *   1   3   2          3   2   1        2   1   3        1   3   2
         *   3   2   1  ----->  2   1   3 -----> 1   1   2 -----> 3   3   1
         *   1   2   3          3   1   2        2   3   1        1   2   3
         */
        board.printBoard();
        GameGrid grid = new GameGrid(9);
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel(); // initializes JavaFX environment
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (Exception e){
            ;
        }
        WireworldSimulation ws = new WireworldSimulation(4, 1.0, grid);
//        ws.runSimulation(board);
//        ws.nextGeneration(board);
    }

}
