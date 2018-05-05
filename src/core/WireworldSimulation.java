package core;

import UserInterface.Controllers.GameGrid;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import java.util.ArrayList;

public class WireworldSimulation extends Thread{

    private int n; // number of generations to create
    private double delay;
    private boolean isPaused;
    private GameGrid grid;
    private Board board;

    public WireworldSimulation(int gen_number, double delay, GameGrid game){
        setN(gen_number);
        setDelay(delay);
        this.isPaused = true;
        this.grid = game;
    }

    public int getN() { return n; }

    public void setN(int n) throws IllegalStateException {
        if( n < 0)
            throw new IllegalStateException("Generation number must not be a negative number.");
        this.n = n;
    }

    public double getDelay() { return delay; }

    public void setDelay(double delay) throws IllegalStateException{
        if(delay <= 2.0 && delay >= 0.5)
            this.delay = delay;
        else
            throw new IllegalStateException("Delay value must be between 0.5s and 2.0s.");
    }

    public boolean isPaused() { return isPaused; }

    public void pause() { isPaused = true; }
    public void unpause() { isPaused = false; }

    private void initializeBoardFromGrid(){
        int x_tiles = grid.getXTiles();
        int y_tiles = grid.getYTiles();

        this.board = new Board(x_tiles, y_tiles);
    }

    private void getCellsFromGrid(){
        GameGrid.Tile [][] tiles = grid.getGrid();
        for(int i = 0; i < grid.getXTiles(); i++){
            for(int j=0; j < grid.getYTiles(); j++){
                GameGrid.Tile tile = tiles[i][j];
                this.board.addCell( new Cell( tile ) );
            }
        }
    }

    private void changeCellType(Cell cell){
        int neighbours = this.board.countElectronHeadsNeighbours(cell);
        if( cell.getType() == 1 && (neighbours == 1 || neighbours == 2) ){
            // if cell has 1 or 2 electron's head neighbours it also become electron's head
            cell.changeToHead();
        } else if( cell.getType() == 3 ) {  // if cell was electron's head it become electron's tail
            cell.changeToTail();
        } else if( cell.getType() == 2 ) { // if cell was electron's tail it become conductor
            cell.changeToConductor();
        } else {
            cell.changeToConductor();
        }
    }

    private void changeCellsColors(ArrayList<Cell> notEmptyList){
        for(Cell cell : notEmptyList){
            grid.changeState(cell.getX(), cell.getY(), cell.getNextType());
        }
    }

    public void nextGeneration(){
        // method creates one next generation
        ArrayList<Cell> notEmptyCells = this.board.getNotEmptyCells();
        for (Cell cell : notEmptyCells) {
            changeCellType(cell);
        }
        changeCellsColors(notEmptyCells);
        // when we finally determined what will be next cells types we can change all of them
        for (Cell cell : notEmptyCells) {
            cell.changeType();
        }
        System.out.println();
        this.board.printBoard();
        System.out.println();
    }


    public void runSimulation(){

        initializeBoardFromGrid(); // initializing board with size of the GUI grid

        this.isPaused = false;
        int genMaxNumber = this.n;
        int DelayValue = (int)(this.delay * 1000); // delay value in milliseconds

        Service<Void> backgroundThread;
        backgroundThread = new Service<Void>(){

            @Override
            protected Task<Void> createTask(){
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        int currentGenerationNumber = 1;
                        while( currentGenerationNumber < genMaxNumber ){
                            getCellsFromGrid(); // get the most recent grid board setup
                            if( !isPaused ) {

                                nextGeneration(); // create next generation
                                currentGenerationNumber++;

                                try{
                                    sleep(DelayValue);
                                } catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        return null;
                    }
                };
            }
        };
        backgroundThread.restart();
    }

    public GameGrid getGrid() { return grid; }
    public Board getBoard() { return board; }

}
