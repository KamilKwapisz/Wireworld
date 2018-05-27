package LogicGate.Insertion;

import LogicGate.LogicGate;
import UserInterface.Controllers.GameGrid.Tile;
import static LogicGate.Insertion.InsertionFlag.*;

public class InsertLogicGate {
    
    private final LogicGate andInsertion;
    private final LogicGate nandInsertion;
    private final LogicGate notInsertion;
    private final LogicGate orInsertion;
    private final LogicGate xorInsertion;
    private InsertionFlag insertionFlag;
    private int x,y;
    private final Tile[][] grid;
    
    public InsertLogicGate(Tile[][] grid){
        andInsertion = new AndInsertion();
        nandInsertion = new NandInsertion();
        notInsertion = new NotInsertion();
        orInsertion = new OrInsertion();
        xorInsertion = new XorInsertion();
        this.grid = grid;
        this.insertionFlag = NORMAL;
    }
    
    public void setProperties(int x, int y, InsertionFlag insertionFlag){
        this.x = x;
        this.y = y;
        this.insertionFlag = insertionFlag;
    } 

    public void insertAnd(){
        switch (insertionFlag) {
            case AND_TOP:
                andInsertion.topDirection(grid, x, y);
                break;
            case AND_BOT:
                andInsertion.bottomDirection(grid, x, y);
                break;
            case AND_LEFT:
                andInsertion.leftDirection(grid, x, y);
                break;
            case AND_RIGHT:
                andInsertion.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertNand(){
        switch (insertionFlag) {
            case NAND_TOP:
                nandInsertion.topDirection(grid, x, y);
                break;
            case NAND_BOT:
                nandInsertion.bottomDirection(grid, x, y);
                break;
            case NAND_LEFT:
                nandInsertion.leftDirection(grid, x, y);
                break;
            case NAND_RIGHT:
                nandInsertion.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertNot(){
        switch (insertionFlag) {
            case NOT_TOP:
                notInsertion.topDirection(grid, x, y);
                break;
            case NOT_BOT:
                notInsertion.bottomDirection(grid, x, y);
                break;
            case NOT_LEFT:
                notInsertion.leftDirection(grid, x, y);
                break;
            case NOT_RIGHT:
                notInsertion.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertOr(){
        switch (insertionFlag) {
            case OR_TOP:
                orInsertion.topDirection(grid, x, y);
                break;
            case OR_BOT:
                orInsertion.bottomDirection(grid, x, y);
                break;
            case OR_LEFT:
                orInsertion.leftDirection(grid, x, y);
                break;
            case OR_RIGHT:
                orInsertion.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertXor(){
        switch (insertionFlag) {
            case XOR_TOP:
                xorInsertion.topDirection(grid, x, y);
                break;
            case XOR_BOT:
                xorInsertion.bottomDirection(grid, x, y);
                break;
            case XOR_LEFT:
                xorInsertion.leftDirection(grid, x, y);
                break;
            case XOR_RIGHT:
                xorInsertion.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }
    
}
