package core;

import UserInterface.Controllers.GameGrid;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
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
    private Label currentGenNumberLabel;

    public WireworldSimulation(int genNumber, double delay, GameGrid game){
        int STACKSIZE = 6;
        setNumberOfIterations(genNumber);
        setDelay(delay);
        this.isPaused = true;
        this.grid = game;
        this.lastGenerations = new SizedStack<ArrayList<Cell>>(STACKSIZE);
        initializeBoardFromGrid();
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
    private void incrementCurrentGenNumber(){this.currentGenerationNumber += 1;}
    private void decrementCurrentGenNumber(){
        if( this.currentGenerationNumber > 1)
            this.currentGenerationNumber -= 1;
    }

    public int getNumberOfIterations() { return numberOfIterations; }

    public void setNumberOfIterations(int n) throws IllegalStateException {
        if( n < 0)
            throw new IllegalStateException("Generation number must not be a negative number.");
        this.numberOfIterations = n;
        setCurrentGenerationNumber(1);
    }
    
    public double getDelay() { return delay; }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public boolean isPaused() { return isPaused; }

    public void pause() { this.isPaused = true; }
    public void unpause() { this.isPaused = false; }

    public void setNewGrid( GameGrid newGrid ){
        this.grid = newGrid;
        initializeBoardFromGrid();
    }

    private void initializeBoardFromGrid(){

        int xTilesNumber = grid.getXTiles();
        int yTilesNumber = grid.getYTiles();

        this.board = new Board(xTilesNumber, yTilesNumber);
        setCurrentGenerationNumber(1);  // resetting gen number counter
    }

    public void getCellsFromGrid(){
        GameGrid.Tile tile;
        GameGrid.Tile [][] tiles = grid.getGrid();
        for(int i = 0; i < grid.getXTiles(); i++){
            for(int j=0; j < grid.getYTiles(); j++){
                tile = tiles[i][j];
                this.board.addCell( new Cell( tile ) );
            }
        }

    }

    private void changeCellType(Cell cell){
        // method changes cell given as a parameter type using wireworld rules
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
        rememberCurrentGeneration();

        getCellsFromGrid(); // get the most recent grid board setup

        ArrayList<Cell> notEmptyCells = this.board.getNotEmptyCells();
        for (Cell cell : notEmptyCells) {
            changeCellType(cell);
        }
        changeCellsColors(notEmptyCells);
        incrementCurrentGenNumber();
    }

    private void simulate(){
        while ((getCurrentGenerationNumber() < numberOfIterations) || numberOfIterations == 0) {
            if (!isPaused) {

                nextGeneration(); // create next generation
                System.out.println(currentGenerationNumber);

                try {
                    sleep((int) (delay * 1000)); //delay value in milliseconds
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ie){}
            }
        }
    }

    public void runSimulation(){
        initializeBoardFromGrid(); // initializing board with size of the GUI grid
        Service<Void> backgroundThread;
        backgroundThread = new Service<Void>(){

            @Override
            protected Task<Void> createTask(){
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            setCurrentGenerationNumber(1);
                            while ((getCurrentGenerationNumber() < numberOfIterations) || numberOfIterations == 0) {
                                if (!isPaused) {
                                    nextGeneration(); // create next generation
                                    System.out.println(currentGenerationNumber);

                                    try {
                                        sleep((int) (delay * 1000)); //delay value in milliseconds

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Thread.sleep(2);
                                }

                                updateMessage("" + currentGenerationNumber); // updating message for current gen number label
                            }
                        }catch (Exception e){}
                        return null;
                    }
                };
            }
        };
        try {
            this.currentGenNumberLabel.textProperty().bind(backgroundThread.messageProperty());  // changing current gen label to message prepared before
            backgroundThread.restart();
        } catch (Exception e){
            // no GUI so we can simulate in other way here
           simulate();
        }
    }

    public GameGrid getGrid() { return grid; }
    public Board getBoard() { return board; }

    public void setCurrentGenNumberLabel(Label currentGenNumberLabel) {
        this.currentGenNumberLabel = currentGenNumberLabel;
    }

    public void clearBoard(){
        for(int i = 0; i < grid.getXTiles(); i++){
            for(int j=0; j < grid.getYTiles(); j++){
                this.board.addCell( new Cell(i, j, 0 ) );
            }
        }

        setCurrentGenerationNumber(1);
    }

}
