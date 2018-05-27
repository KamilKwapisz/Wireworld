package LogicGate.Insertion;

import LogicGate.Highlights.HighlightLogicGate;
import UserInterface.Controllers.GameGrid;

import static LogicGate.Insertion.InsertionFlag.*;
import static LogicGate.Insertion.InsertionFlag.NORMAL;
import static LogicGate.Insertion.InsertionFlag.NOT_RIGHT;

public class AllowInsertionController {
    // class for checking if specific logic gate can be placed

    private static int X_TILES;
    private static int Y_TILES;

    public AllowInsertionController(int xTiles, int yTiles){
        X_TILES = xTiles;
        Y_TILES = yTiles;
    }

    /* Highlights tiles when user can insert logicGate. Used in onEntered event */
    public void placeIsAllowed(int x, int y, HighlightLogicGate highlightLogicGate, InsertionFlag insertionFlag) {
        if (insertionFlag == AND_TOP) {
            if (x >= 3 && x <= X_TILES - 6 && y >= 17) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightAnd();
            }
        } else if (insertionFlag == AND_BOT) {
            if (x >= 5 && x <= X_TILES - 4 && y <= Y_TILES - 18) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightAnd();
            }
        } else if (insertionFlag == AND_LEFT) {
            if (x >= 17 && y >= 5 && y <= Y_TILES - 4) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightAnd();
            }
        } else if (insertionFlag == AND_RIGHT) {
            if (x <= X_TILES - 18 && y >= 3 && y <= Y_TILES - 6) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightAnd();
            }
        } else if (insertionFlag == OR_TOP) {
            if (x >= 1 && x <= X_TILES - 4 && y >= 8) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightOr();
            }
        } else if (insertionFlag == OR_BOT) {
            if (x >= 3 && x <= X_TILES - 2 && y <= Y_TILES - 9) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightOr();
            }
        } else if (insertionFlag == OR_LEFT) {
            if (x >= 8 && y >= 3 && y <= Y_TILES - 2) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightOr();
            }
        } else if (insertionFlag == OR_RIGHT) {
            if (x <= X_TILES - 9 && y >= 1 && y <= Y_TILES - 4) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightOr();
            }
        } else if (insertionFlag == XOR_TOP) {
            if (x >= 2 && x <= X_TILES - 5 && y >= 10) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightXor();
            }
        } else if (insertionFlag == XOR_BOT) {
            if (x >= 4 && x <= X_TILES - 3 && y <= Y_TILES - 11) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightXor();
            }
        } else if (insertionFlag == XOR_LEFT) {
            if (x >= 10 && y >= 4 && y <= Y_TILES - 3) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightXor();
            }
        } else if (insertionFlag == XOR_RIGHT) {
            if (x <= X_TILES - 11 && y >= 2 && y <= Y_TILES - 5) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightXor();
            }
        } else if (insertionFlag == NAND_TOP) {
            if (x >= 5 && x <= X_TILES - 8 && y >= 13) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNand();
            }
        } else if (insertionFlag == NAND_BOT) {
            if (x >= 7 && x <= X_TILES - 6 && y <= Y_TILES - 14) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNand();
            }
        } else if (insertionFlag == NAND_LEFT) {
            if (x >= 13 && y >= 7 && y <= Y_TILES - 6) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNand();
            }
        } else if (insertionFlag == NAND_RIGHT) {
            if (x <= X_TILES - 14 && y >= 5 && y <= Y_TILES - 8) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNand();
            }
        } else if (insertionFlag == NOT_TOP) {
            if (x >= 2 && x <= X_TILES - 4 && y >= 11) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNot();
            }
        } else if (insertionFlag == NOT_BOT) {
            if (x >= 3 && x <= X_TILES - 3 && y <= Y_TILES - 12) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNot();
            }
        } else if (insertionFlag == NOT_LEFT) {
            if (x >= 11 && y >= 3 && y <= Y_TILES - 3) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNot();
            }
        } else if (insertionFlag == NOT_RIGHT) {
            if (x <= X_TILES - 12 && y >= 2 && y <= Y_TILES - 4) {
                highlightLogicGate.setProperties(x, y, insertionFlag);
                highlightLogicGate.highlightNot();
            }
        }
    }

    /* recover color when mouse leaves the tile. Works when inserting logicGate in onExit event */
    public void leaveTile(GameGrid.Tile[][] grid, InsertionFlag insertionFlag) {
        /* TEMPORARY */
        if (insertionFlag != NORMAL) {
            for (int x = 0; x < X_TILES; x++) {
                for (int y = 0; y < Y_TILES; y++) {
                    grid[x][y].getTileBorder().setFill(grid[x][y].getColor());
                }
            }
        }
    }

}
