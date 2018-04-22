import java.util.ArrayList;
import java.util.List;

public class Board {

    private int width;
    private int height;
    private ArrayList<ArrayList<Cell>> board; // 2d cells list

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        board = new ArrayList<ArrayList<Cell>>();
        for(int i = 0; i < height; i++)  {
            board.add(new ArrayList<Cell>());
            for(int j = 0; j < width; j++){
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void addCell(Cell cell){
        board.get(cell.getY()).set(cell.getX(), cell);
    }

    private void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    private int getWidth() {
        return this.width;
    }

    private int getHeight() {
        return this.height;
    }

    private int getCellsNumber() {
        return (this.height * this.width);
    }

    @Override
    public String toString(){
        return board.toString();
    }


}
