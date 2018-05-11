package core;

import UserInterface.Controllers.GameGrid;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import utils.SizedStack;

import java.util.ArrayList;

public class WireworldSimulation extends Thread{

    private int numberOfIterations; // number of generations to create
    private double delay;
    private boolean isPaused;
    private int currentGenerationNumber; // number of currently processed generation
    private GameGrid grid;
    private Board board = null;
    private SizedStack<ArrayList<Cell>> lastGenerations; // stack containing 5 recently created generations
    private final int STACKSIZE = 5;

    public WireworldSimulation(int gen_number, double delay, GameGrid game){
        setNumberOfIterations(gen_number);
        setDelay(delay);
        this.isPaused = true;
        this.grid = game;
        this.lastGenerations = new SizedStack<ArrayList<Cell>>(this.STACKSIZE + 1);
    }

    private void rememberCurrentGeneration(){
        ArrayList<Cell> cells = board.getNotEmptyCells();
        lastGenerations.push( cells );
    }

    public void loadLastGeneration(){
        Board board = this.board;
        GameGrid grid = this.grid;

        Service<Void> backgroundThread;
        backgroundThread = new Service<Void>(){

            @Override
            protected Task<Void> createTask(){
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        if( lastGenerations.size() > 0) {
                            ArrayList<Cell> cells = lastGenerations.pop();
                            board.updateGeneration(cells);
                            grid.updateGeneration(cells);
                            decrementCurrentGenNumber();
                        }
                        return null;
                    }
                };
            }
        };
        backgroundThread.restart();


    }


    public int getCurrentGenerationNumber(){ return currentGenerationNumber; }
    public void setCurrentGenerationNumber(int number){ this.currentGenerationNumber = number; }
    public void incrementCurrentGenNumber(){this.currentGenerationNumber += 1;}
    public void decrementCurrentGenNumber(){
        if( this.currentGenerationNumber > 1)
            this.currentGenerationNumber -= 1;
    }

    public int getNumberOfIterations() { return numberOfIterations; }

    public void setNumberOfIterations(int n) throws IllegalStateException {
        if( numberOfIterations < 0)
            throw new IllegalStateException("Generation number must not be a negative number.");
        this.numberOfIterations = n;
    }
    
    public double getDelay() { return delay; }

    public void setDelay(double delay) throws IllegalStateException{
        this.delay = delay;
    }

    public boolean isPaused() { return isPaused; }

    public void pause() { isPaused = true; }
    public void unpause() { isPaused = false; }

    public void setNewGrid( GameGrid newGrid ){ this.grid = newGrid; }

    public void initializeBoardFromGrid(){
        int x_tiles = grid.getXTiles();
        int y_tiles = grid.getYTiles();

        this.board = new Board(x_tiles, y_tiles);
    }

    public void getCellsFromGrid(){
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
            // for each not empty cell change cell's color and type in both grid and board
            grid.changeState(cell.getX(), cell.getY(), cell.getNextType());
            cell.changeType();
        }
    }

    public void nextGeneration(){
        // method creates one next generation

        getCellsFromGrid(); // get the most recent grid board setup

        ArrayList<Cell> notEmptyCells = this.board.getNotEmptyCells();
        for (Cell cell : notEmptyCells) {
            changeCellType(cell);
        }
        changeCellsColors(notEmptyCells);
        rememberCurrentGeneration();

        // for debug purpose only
//        this.board.printBoard();
    }


    public void runSimulation(){
        System.out.println("TEST");

        initializeBoardFromGrid(); // initializing board with size of the GUI grid

//        this.isPaused = true;
        int genMaxNumber = this.numberOfIterations;
        int DelayValue = (int)(this.delay * 1000); // delay value in milliseconds

        Service<Void> backgroundThread;
        backgroundThread = new Service<Void>(){

            @Override
            protected Task<Void> createTask(){
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        setCurrentGenerationNumber(1);
                        int a = 0;
                        while( ( getCurrentGenerationNumber() < genMaxNumber ) || genMaxNumber == 0){
//                            System.out.println(getCurrentGenerationNumber());

                            if( !isPaused ) {
                                nextGeneration(); // create next generation
                                incrementCurrentGenNumber();
                                System.out.println(currentGenerationNumber);

                                try{
                                    //sleep(DelayValue);
                                    sleep((int)(delay * 1000)); //delay value in milliseconds
                                } catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                            else{
                                Thread.sleep(2);
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
