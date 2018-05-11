package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

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

    public Cell getCell(int x, int y) throws IndexOutOfBoundsException{
        try {
            return board.get(y).get(x);
        } catch (IndexOutOfBoundsException e){
            if(x < 0 || y < 0)
                throw new IndexOutOfBoundsException("Cell's coordinates mustn't be negative numbers.");
            else
                throw new IndexOutOfBoundsException("Board is smaller than given coordinates.");
        }
    }

    public void setSize(int width, int height) throws NegativeArraySizeException{
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

    public void updateGeneration(ArrayList<Cell> cells){
        for(Cell cell : cells){
            this.addCell(new Cell(cell.getX(), cell.getY(), cell.getType()));
        }
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
        System.out.println();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board.get(i).get(j).getType() + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void saveGeneration(int genNumber){
        String fname = "gen" + genNumber + ".txt";
        ArrayList<Cell> cells = getNotEmptyCells();
        try (PrintWriter out = new PrintWriter(fname)) {
            for( Cell cell : cells)
                out.println(cell.toString());
        } catch (Exception e){}

    }

    public Board loadGeneration(int previousGenerationNumber){
        Board newBoard = new Board(this.getWidth(), this.getHeight());
        String filename = "gen" + previousGenerationNumber + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                int x = Character.getNumericValue(line.charAt(1));
                int y = Character.getNumericValue(line.charAt(3));
                int type = Character.getNumericValue(line.charAt(6));
                newBoard.addCell(new Cell(x, y, type));

            }
        } catch (Exception e){}

        return newBoard;
    }


    public static void main(String[] args) {
        Board b = new Board(2, 2);
        b.addCell(new Cell(0, 0,1));
        b.addCell(new Cell(1, 1,2));
        b.saveGeneration(1);
        b.addCell(new Cell(0, 0,0));
        b.addCell(new Cell(1, 1,0));
        b = b.loadGeneration(1);
        b.printBoard();
    }


}
