package core;

import java.util.ArrayList;

public class Board{

    private int width;
    private int height;
    private ArrayList<ArrayList<Cell>> board; // 2d cells list

    public Board(int width, int height){
        setSize(width, height);
        board = new ArrayList<ArrayList<Cell>>();
        for(int i = 0; i < height; i++)  {
            board.add(new ArrayList<Cell>());
            for(int j = 0; j < width; j++){
                board.get(i).add(new Cell(j, i));
            }
        }
    }

    public void setSize(int width, int height) throws NegativeArraySizeException{
        // setting board size
        if(width < 0 || height < 0)
            throw new NegativeArraySizeException("Board's width and height have to be positive numbers.");
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Cell getCell(int x, int y) throws IndexOutOfBoundsException, NegativeArraySizeException {
        // method returns cell located in row x and column y
        try {
            return board.get(y).get(x);
        } catch (IndexOutOfBoundsException e){
            if(x < 0 || y < 0)
                throw new NegativeArraySizeException("Cell's coordinates mustn't be negative numbers.");
            else
                throw new IndexOutOfBoundsException("Board is smaller than given coordinates.");
        }
    }

    public ArrayList<Cell> getNotEmptyCells(){
        // method returns arraylist with not empty cells on the board. We can work only on them because empty cell will remain empty
        ArrayList<Cell> newList = new ArrayList<Cell>();
        Cell tempCell;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                tempCell = board.get(i).get(j);
                if(  tempCell.getType() != CellType.EMPTY)
                    newList.add(tempCell);
            }
        }
        return newList;
    }

    public void updateGeneration(ArrayList<Cell> cells){
        for(Cell cell : cells){
            this.addCell(cell);
        }
    }

    public void addCell(Cell cell) throws IndexOutOfBoundsException{
        // method add Cell given as a parameter to a board.
        // this function get x, y and coordinates directly from cell fields
        try {
            board.get(cell.getY()).set(cell.getX(), cell);
        } catch (IndexOutOfBoundsException ex){
                throw new IndexOutOfBoundsException("Board is too small for this cell.");
        }
    }

    public ArrayList<ArrayList<Cell>> getBoard() { return board; }

    public int countElectronHeadsNeighbours(Cell cell){
        // method returns number of given cell's neighbours which are electron's head

        int x = cell.getX();
        int y = cell.getY();
        int headsNumber = 0;

        if(x < width-1 && x > 0 && y < height-1 && y > 0) {
            // cells in the middle of the board
            headsNumber = this.getCell(x-1, y-1).isHead() + this.getCell(x-1, y).isHead()
                        + this.getCell(x-1, y+1).isHead() + this.getCell(x, y-1).isHead()
                        + this.getCell(x, y+1).isHead() + this.getCell(x+1, y-1).isHead()
                        + this.getCell(x+1, y).isHead() +  this.getCell(x+1, y+1).isHead();
        }

         else if(x == 0 && y == 0 ){
            // cell in the left upper corner
            headsNumber = this.getCell(x, y+1).isHead() + this.getCell(x+1, y).isHead()
                    + this.getCell(x+1, y+1).isHead();
        } else if (x == 0 && y == height - 1){
            // cell in the right upper corner
            headsNumber = this.getCell(x, y-1).isHead() + this.getCell(x+1, y-1).isHead()
                    + this.getCell(x+1, y).isHead();
        } else if (x == width-1 && y == 0) {
            // cell in the left bottom corner
            headsNumber = this.getCell(x-1, y).isHead() + this.getCell(x-1, y+1).isHead()
                    + this.getCell(x, y+1).isHead();
        } else if (x == width - 1 && y == height - 1) {
            // cell in the right bottom corner
            headsNumber = this.getCell(x, y-1).isHead() + this.getCell(x-1, y-1).isHead()
                    + this.getCell(x-1, y).isHead();
        }

        else if (x == 0) {
            // cells next to the left edge
            headsNumber = this.getCell(x, y-1).isHead() + this.getCell(x, y+1).isHead()
                    + this.getCell(x+1, y-1).isHead() + this.getCell(x+1, y).isHead()
                    + this.getCell(x+1, y+1).isHead();
        } else if (y == 0) {
            // cells next to the top edge
            headsNumber = this.getCell(x-1, y).isHead() + this.getCell(x+1, y).isHead()
                    + this.getCell(x-1, y+1).isHead() + this.getCell(x, y+1).isHead()
                    + this.getCell(x+1, y+1).isHead();
        } else if (y == height-1) {
            // cells next to the bottom edge
            headsNumber = this.getCell(x-1, y).isHead() + this.getCell(x-1, y-1).isHead()
                    + this.getCell(x, y-1).isHead() + this.getCell(x+1, y).isHead()
                    + this.getCell(x+1, y-1).isHead();
        } else if (x == width-1) {
            // cells next to the right edge
            headsNumber = this.getCell(x-1, y).isHead() + this.getCell(x-1, y-1).isHead()
                    + this.getCell(x, y-1).isHead() + this.getCell(x-1, y+1).isHead()
                    + this.getCell(x, y+1).isHead();
        }

        return headsNumber;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                sb.append(board.get(i).get(j)).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
