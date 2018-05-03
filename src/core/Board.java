package core;

import java.util.ArrayList;

public class Board {

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

    public Cell getCell(int x, int y) throws IndexOutOfBoundsException{
        try {
            return board.get(y).get(x);
        } catch (IndexOutOfBoundsException e){
            if(x < 0 || y < 0)
                throw new IndexOutOfBoundsException("Cell's coordinates mustn't be negative.");
            else
                throw new IndexOutOfBoundsException("Board is smaller than given coordinates.");
        }
    }

    public void setSize(int width, int height) throws IndexOutOfBoundsException{
        if(width < 0 || height < 0)
            throw new IndexOutOfBoundsException("Board's width and height have to be positive numbers.");
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<Cell> getNotEmptyCells(){
        // method returns arraylist with not empty cells on the board. We can work only on them because empty cell will remain empty
        ArrayList<Cell> newList = new ArrayList<Cell>();
        Cell tempCell;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                tempCell = board.get(i).get(j);
                if(  tempCell.getType() != 0)
                    newList.add(tempCell);
            }
        }
        return newList;
    }

    public void addCell(Cell cell) throws IndexOutOfBoundsException{
        // Function add Cell given as a parameter to a board.
        // this function get x, y and coordinates directly from cell fields
        try {
            board.get(cell.getY()).set(cell.getX(), cell);
        } catch (IndexOutOfBoundsException ex){
                throw new IndexOutOfBoundsException("Board is too small for this cell.");
        }
    }



    public ArrayList<ArrayList<Cell>> getBoard() { return board; }

    private int getCellsNumber() {
        return (this.height * this.width);
    }

    public int countElectronHeadsNeighbours(Cell cell){

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


    public Board copyBoard(){
        Board newBoard = new Board(this.width, this.height);
        for(ArrayList<Cell> array : this.board){
            for(Cell cell : array){
                newBoard.addCell(cell);
            }
        }
        return newBoard;
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

    public void printBoard(){
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board.get(i).get(j).getType() + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board b = new Board(2, 2);
        b.addCell(new Cell(3, 3,1));
    }


}
