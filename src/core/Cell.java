package core;

import userinterface.controllers.GameGrid;

public class Cell {

    private CellType type;
    private CellType nextType;
    private int x;
    private int y;

    public Cell(int x, int y){
        setType(CellType.EMPTY);
        setCellCoordinate(x, y);
    }

    public Cell(GameGrid.Tile tile){
        setType(tile.getState());
        setCellCoordinate(tile.getX(), tile.getY());
    }

    public Cell(int x, int y, CellType type){
        setType(type);
        setCellCoordinate(x, y);
    }

    private void setType(CellType type) throws IllegalStateException {
        if(type == CellType.EMPTY || type == CellType.CONDUCTOR || type == CellType.HEAD  || type == CellType.TAIL)
            this.type = type;
        else
            throw new IllegalStateException("Incorrect cell type.");
    }

    public int getX(){ return this.x;}
    public int getY(){ return this.y;}

    public CellType getType() {
        return type;
    }
    public CellType getNextType() {
        return nextType;
    }

    public void changeToEmpty(){
        this.nextType = CellType.EMPTY;
    }

    public void changeToConductor(){
        this.nextType = CellType.CONDUCTOR;
    }

    public void changeToTail(){
        this.nextType = CellType.TAIL;
    }

    public void changeToHead(){
        this.nextType = CellType.HEAD;
    }

    public void changeType(){
        this.type = nextType;
    }

    public boolean isEmpty(){
        if( this.type == CellType.EMPTY )
            return true;
        else
            return false;
    }

    public void setCellCoordinate(int x, int y) throws NegativeArraySizeException{
        if( x < 0 || y < 0)
                throw new NegativeArraySizeException("Cell's coordinates mustn't be negative numbers.");
        this.x = x;
        this.y = y;
    }

    public int isHead(){
        // method returns 1 if true and 0 if false
        // it's int method not boolean in order to provide more convenient way of calculating neighbours
        if(type == CellType.HEAD)
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
}
