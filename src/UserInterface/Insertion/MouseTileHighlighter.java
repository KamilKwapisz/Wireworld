package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid;
import static UserInterface.Insertion.InsertionFlag.NORMAL;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MouseTileHighlighter {
    
    private HighlightLogicGate logicGate;
    private InsertionFlag insertionFlag;
    private GameGrid game;

    public MouseTileHighlighter(GameGrid game) {
        this.game = game;
        logicGate = new HighlightLogicGate(game.getGrid());
        insertionFlag = NORMAL;
    }

    public InsertionFlag getInsertionFlag() {
        return insertionFlag;
    }

    public void setInsertionFlag(InsertionFlag insertionFlag) {
        this.insertionFlag = insertionFlag;
    }

    private void highlightAnd(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.highlightAnd();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void highlightOr(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.highlightOr();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void highlightXor(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.highlightXor();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void highlightNand(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.highlightNand();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void highlightNot(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.highlightNot();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void cancelInserting(int x, int y) {
        Rectangle border = game.getRectangle(x, y);
        border.setFill(game.getColor(x, y));
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    public void andMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        
    }

    public void orMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                highlightOr(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            if (x < game.getXTiles() && y < game.getYTiles()) {
                cancelInserting(x, y);
            } else {
                insertionFlag = NORMAL;
                game.setInsertionFlag(NORMAL);
            }
        }
    }

    public void xorMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                highlightXor(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            if (x < game.getXTiles() && y < game.getYTiles()) {
                cancelInserting(x, y);
            } else {
                insertionFlag = NORMAL;
                game.setInsertionFlag(NORMAL);
            }
        }
    }

    public void nandMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                highlightNand(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            if (x < game.getXTiles() && y < game.getYTiles()) {
                cancelInserting(x, y);
            } else {
                insertionFlag = NORMAL;
                game.setInsertionFlag(NORMAL);
            }
        }
    }

    public void notMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                highlightNot(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            if (x < game.getXTiles() && y < game.getYTiles()) {
                cancelInserting(x, y);
            } else {
                insertionFlag = NORMAL;
                game.setInsertionFlag(NORMAL);
            }
        }
    }
}
