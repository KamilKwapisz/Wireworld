package core;

import UserInterface.Controllers.GameGrid;

import java.util.ArrayList;

public class WireworldSimulation {

    private int n; // number of generations to create
    private double delay;
    private boolean isPaused;
    private GameGrid grid;

    public WireworldSimulation(int gen_number, double delay, GameGrid game){
        this.n = gen_number;
        this.delay = delay;
        this.isPaused = true;
        this.grid = game;
    }

    public int getN() { return n; }

    public void setN(int n) { this.n = n; }

    public double getDelay() { return delay; }

    public void setDelay(double delay) { this.delay = delay; }

    public boolean isPaused() { return isPaused; }

    public void pause() { isPaused = true; }
    public void start() { isPaused = false; }

    public void changeCellType(Cell cell, Board board){
        int neighbours = board.countElectronHeadsNeighbours(cell);
        if( cell.getType() == 1 && (neighbours == 1 || neighbours == 2) ){
            // if cell has 1 or 2 electron's head neighbours it also become electron's head
            cell.changeToHead();
            this.grid.changeState(cell.getX(), cell.getY(), 3);
        } else if( cell.getType() == 3 ) {  // if cell was electron's head it become electron's tail
            cell.changeToTail();
            this.grid.changeState(cell.getX(), cell.getY(), 2);
        } else if( cell.getType() == 2 ) { // if cell was electron's tail it become conductor
            cell.changeToConductor();
            this.grid.changeState(cell.getX(), cell.getY(), 1);
        } else {
            cell.changeToConductor();
            this.grid.changeState(cell.getX(), cell.getY(), 1);
        }

    }

    public void nextGeneration(Board board){
        // method creates one next generation
        ArrayList<Cell> notEmptyCells = board.getNotEmptyCells();
        Board oldBoard = board.copyBoard(); // creating board copy to determine how cells should be changed

        for (Cell cell : notEmptyCells) {
            changeCellType(cell, oldBoard);
        }

        // when we finally determined what will be next cells types we can change all of them
        for (Cell cell : notEmptyCells) {
            cell.changeType();
        }

        System.out.println();
        board.printBoard();
        System.out.println();

    }

    public void runSimulation(Board board){
        this.isPaused = false;
        int currentGenerationNumber = 1;

        while( currentGenerationNumber < this.n ){
            if( !isPaused ) {
                ArrayList<Cell> notEmptyCells = board.getNotEmptyCells();
                // we can work on not empty cells only because empty call will remain empty
                // TODO board copy should be replaced with frontend grid array
                Board oldBoard = board.copyBoard(); // creating board copy to determine how cells should be changed

//                GameGrid copy = getGrid();

                for (Cell cell : notEmptyCells) {
                    changeCellType(cell, oldBoard);
                }

                // when we finally determined what will be next cells types we can change all of them
                for (Cell cell : notEmptyCells) {
                    cell.changeType();
                }

                System.out.println();
                board.printBoard();
                System.out.println();

                currentGenerationNumber++;
                try{
                    Thread.sleep(500);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board(3,3);

        board.addCell(new Cell(0, 0, 3));
        board.addCell(new Cell(1, 0, 1));
        board.addCell(new Cell(2, 0, 3));

        board.addCell(new Cell(0, 1, 3));
        board.addCell(new Cell(1, 1, 3));
        board.addCell(new Cell(2, 1, 1));

        board.addCell(new Cell(0, 2, 3));
        board.addCell(new Cell(1, 2, 1));
        board.addCell(new Cell(2, 2, 3));
        /*
         *  3    1   3
         *  3    3   1
         *  3    1   3
         */
        board.printBoard();

//        WireworldSimulation ws = new WireworldSimulation(4, 1.0);
//        ws.runSimulation(board);


    }


}
