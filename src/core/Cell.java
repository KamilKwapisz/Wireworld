package core;

import UserInterface.Controllers.GameGrid;

import java.util.ArrayList;

public class Cell {

    private int type; // 0 - empty | 1 - conductor | 2 - electron tail | 3 - electron head
    private int nextType; // type which cell will have after change
    private int x;
    private int y;

    public Cell(int x, int y){
        setType(0);
        setCellCoordinate(x, y);
    }

    public Cell(GameGrid.Tile tile){
        setType(tile.getState());
        setCellCoordinate(tile.getX(), tile.getY());
    }

    public Cell(int x, int y, int type){
        setType(type);
        setCellCoordinate(x, y);
    }

    private void setType(int type) throws IllegalStateException {
        if(type >= 0 && type <= 3)
            this.type = type;
        else
            throw new IllegalStateException("Incorrect cell type.");
    }

    public int getX(){ return this.x;}
    public int getY(){ return this.y;}

    public int getType() {
        return type;
    }
    public int getNextType() {
        return nextType;
    }

    public void changeToEmpty(){
        this.nextType = 0;
    }

    public void changeToConductor(){
        this.nextType = 1;
    }

    public void changeToTail(){
        this.nextType = 2;
    }

    public void changeToHead(){
        this.nextType = 3;
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

    public void setCellCoordinate(int x, int y) throws IndexOutOfBoundsException{
        if( x < 0 || y < 0)
                throw new IndexOutOfBoundsException("Cell's coordinates mustn't be negative numbers.");
        this.x = x;
        this.y = y;
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
        // (x,y)[type]
        StringBuilder sb = new StringBuilder("");
        sb.append("(").append(getX())
                .append(",")
                .append(getY()).append(")[")
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
