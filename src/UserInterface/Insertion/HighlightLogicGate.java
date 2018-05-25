package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid.Tile;
import static UserInterface.Insertion.InsertionFlag.*;

public class HighlightLogicGate {

    private final LogicGate andHighlight;
    private final LogicGate nandHighlight;
    private final LogicGate notHighlight;
    private final LogicGate orHighlight;
    private final LogicGate xorHighlight;
    private InsertionFlag insertionFlag;
    private int x,y;
    private final Tile[][] grid;
    
    public HighlightLogicGate(Tile[][] grid) {
        andHighlight = new AndHighlight();
        nandHighlight = new NandHighlight();
        notHighlight = new NotHighlight();
        orHighlight = new OrHighlight();
        xorHighlight = new XorHighlight();
        this.grid = grid;
        this.insertionFlag = NORMAL;
    }

    public void setProperties(int x, int y, InsertionFlag insertionFlag) {
        this.x = x;
        this.y = y;
        this.insertionFlag = insertionFlag;
    }

    public void highlightAnd() {
        switch (insertionFlag) {
            case AND_TOP:
                andHighlight.topDirection(grid, x, y);
                break;
            case AND_BOT:
                andHighlight.bottomDirection(grid, x, y);
                break;
            case AND_LEFT:
                andHighlight.leftDirection(grid, x, y);
                break;
            case AND_RIGHT:
                andHighlight.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }

    public void highlightNand() {
        switch (insertionFlag) {
            case NAND_TOP:
                nandHighlight.topDirection(grid, x, y);
                break;
            case NAND_BOT:
                nandHighlight.bottomDirection(grid, x, y);
                break;
            case NAND_LEFT:
                nandHighlight.leftDirection(grid, x, y);
                break;
            case NAND_RIGHT:
                nandHighlight.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }

    public void highlightNot() {
        switch (insertionFlag) {
            case NOT_TOP:
                notHighlight.topDirection(grid, x, y);
                break;
            case NOT_BOT:
                notHighlight.bottomDirection(grid, x, y);
                break;
            case NOT_LEFT:
                notHighlight.leftDirection(grid, x, y);
                break;
            case NOT_RIGHT:
                notHighlight.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }

    public void highlightOr() {
        switch (insertionFlag) {
            case OR_TOP:
                orHighlight.topDirection(grid, x, y);
                break;
            case OR_BOT:
                orHighlight.bottomDirection(grid, x, y);
                break;
            case OR_LEFT:
                orHighlight.leftDirection(grid, x, y);
                break;
            case OR_RIGHT:
                orHighlight.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }

    public void highlightXor() {
        switch (insertionFlag) {
            case XOR_TOP:
                xorHighlight.topDirection(grid, x, y);
                break;
            case XOR_BOT:
                xorHighlight.bottomDirection(grid, x, y);
                break;
            case XOR_LEFT:
                xorHighlight.leftDirection(grid, x, y);
                break;
            case XOR_RIGHT:
                xorHighlight.rightDirection(grid, x, y);
                break;
            default:
                break;
        }
    }

}