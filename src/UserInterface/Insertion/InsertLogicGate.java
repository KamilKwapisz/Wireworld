package UserInterface.Insertion;
import UserInterface.Controllers.GameGrid.Tile;
import static UserInterface.Insertion.InsertionFlag.*;

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
                andInsertion.insertTop(grid, x, y);
                break;
            case AND_BOT:
                andInsertion.insertBottom(grid, x, y);
                break;
            case AND_LEFT:
                andInsertion.insertLeft(grid, x, y);
                break;
            case AND_RIGHT:
                andInsertion.insertRight(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertNand(){
        switch (insertionFlag) {
            case NAND_TOP:
                nandInsertion.insertTop(grid, x, y);
                break;
            case NAND_BOT:
                nandInsertion.insertBottom(grid, x, y);
                break;
            case NAND_LEFT:
                nandInsertion.insertLeft(grid, x, y);
                break;
            case NAND_RIGHT:
                nandInsertion.insertRight(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertNot(){
        switch (insertionFlag) {
            case NOT_TOP:
                notInsertion.insertTop(grid, x, y);
                break;
            case NOT_BOT:
                notInsertion.insertBottom(grid, x, y);
                break;
            case NOT_LEFT:
                notInsertion.insertLeft(grid, x, y);
                break;
            case NOT_RIGHT:
                notInsertion.insertRight(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertOr(){
        switch (insertionFlag) {
            case OR_TOP:
                orInsertion.insertTop(grid, x, y);
                break;
            case OR_BOT:
                orInsertion.insertBottom(grid, x, y);
                break;
            case OR_LEFT:
                orInsertion.insertLeft(grid, x, y);
                break;
            case OR_RIGHT:
                orInsertion.insertRight(grid, x, y);
                break;
            default:
                break;
        }
    }
    
    public void insertXor(){
        switch (insertionFlag) {
            case XOR_TOP:
                xorInsertion.insertTop(grid, x, y);
                break;
            case XOR_BOT:
                xorInsertion.insertBottom(grid, x, y);
                break;
            case XOR_LEFT:
                xorInsertion.insertLeft(grid, x, y);
                break;
            case XOR_RIGHT:
                xorInsertion.insertRight(grid, x, y);
                break;
            default:
                break;
        }
    }
    
}
