import java.awt.Color;
import java.util.ArrayList;

public class Cell {

    private int type; // 0 - empty | 1 - conductor | 2 - electron tail | 3 - electron head
    private Color color;
    private Coordinate coordinate;

    public Cell(int type){
        this.type = type;
        changeColor(type);

        setCellCoordinate(0,0); // TODO replacing with method returning first free coordinate
    }

    public Cell(){
        this.type = 0;
        setCellColor(0,0,0);
        setCellCoordinate(0,0);
    }

    public Cell(int x, int y){
        this.type = 0;
        setCellColor(0,0,0);
        setCellCoordinate(x, y);
    }

    public Cell(int x, int y, int type){
        this.type = type;
        changeColor(type);
        setCellCoordinate(x, y);
    }

    public void changeColor(int type){
        if( type == 1)
            setCellColor(173,255,47);
        else if(type == 2)
            setCellColor(255,0,0);
        else if(type == 3)
            setCellColor(0,0,255);
        else
            setCellColor(0,0,0);
    }


    public int getType() {
        return type;
    }

    public void changeToEmpty(){
        this.type = 0;

    }

    public void changeToConductor(){
        this.type = 1;
        setCellColor(173,255,47);
    }

    public void changeToTail(){
        this.type = 2;
        setCellColor(255,0,0);
    }

    public void changeToHead(){
        this.type = 3;
        setCellColor(0,0,255);
    }

    public boolean isEmpty(){
        if( this.type == 0 )
            return true;
        else
            return false;
    }

    public Color getColor() {
        return color;
    }

    private void setCellColor(int r, int g, int b) {
        Color c = new Color(r,g,b);
        this.color = c;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getX(){
        return coordinate.getX();
    }

    public int getY(){
        return coordinate.getY();
    }

    public void setCellCoordinate(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }

    @Override
    public String toString(){
        // (x, y)[type]
        StringBuilder sb = new StringBuilder("");
        sb.append("(").append(coordinate.getX())
                .append(", ")
                .append(coordinate.getY()).append(")[")
                .append(this.type).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Cell c1 = new Cell();
        Cell c2 = new Cell(2,2,3);
        Cell c3 = new Cell(2, 1);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        Board board = new Board(3,3);

        board.addCell(c1);
        board.addCell(c2);
        System.out.println(board);

    }
}
