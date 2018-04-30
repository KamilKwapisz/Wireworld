package core;

import java.awt.Color;
import java.util.ArrayList;

public class Cell {

    private int type; // 0 - empty | 1 - conductor | 2 - electron tail | 3 - electron head
    private int nextType; // type which cell will have after change
    private Color color;
    private Coordinate coordinate;


    public Cell(int x, int y){
        this.type = 0;
        setColor(0,0,0);
        setCellCoordinate(x, y);
    }

    public Cell(int x, int y, int type){
        this.type = type;
        setCellColor(type);
        setCellCoordinate(x, y);
    }

    public void setCellColor(int type){
        if( type == 1)
            setColor(Color.YELLOW);
        else if(type == 2)
            setColor(255,0,0);
        else if(type == 3)
            setColor(0,0,255);
        else
            setColor(0,0,0);
    }


    public int getType() {
        return type;
    }

    public void changeToEmpty(){
        this.nextType = 0;
    }

    public void changeToConductor(){
        this.nextType = 1;
        setColor(Color.YELLOW);
    }

    public void changeToTail(){
        this.nextType = 2;
        setColor(255,0,0);
    }

    public void changeToHead(){
        this.nextType = 3;
        setColor(0,0,255);
    }

    public void changeType(){
        this.type = nextType;
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

    private void setColor(int r, int g, int b) {
        Color c = new Color(r,g,b);
        this.color = c;
    }

    private void setColor(Color color) {
        Color c = color;
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

    public int isHead(){
        // method returns 1 if true and 0 if false
        // it's int method not boolean in order to provide more convenient way of calculating neighbours
        if(type == 3)
            return 1;
        else
            return 0;
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
        Cell c1 = new Cell(2,2,3);
        Cell c2 = new Cell(2, 1);

        System.out.println(c1);
        System.out.println(c2);

        Board board = new Board(3,3);

        board.addCell(c2);
        board.addCell(c1);
        System.out.println(board);


        ArrayList<Cell> l = board.getNotEmptyCells();
        System.out.println(l);

    }
}
