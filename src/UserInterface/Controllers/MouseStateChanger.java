package UserInterface.Controllers;

import UserInterface.Insertion.InsertionFlag;
import static UserInterface.Insertion.InsertionFlag.NORMAL;
import UserInterface.Insertion.LogicGate;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MouseStateChanger {

    private LogicGate logicGate;
    private InsertionFlag insertionFlag;
    private GameGrid game;

    public MouseStateChanger(GameGrid game) {
        this.game = game;
        logicGate = new LogicGate(game.getGrid());
        insertionFlag = NORMAL;
    }
    
    public InsertionFlag getInsertionFlag(){
        return insertionFlag;
    }
    
    public void setInsertionFlag(InsertionFlag insertionFlag){
        this.insertionFlag = insertionFlag;
    }

    private void insertAnd(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertAnd();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }
    private void insertOr(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertOr();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }
    private void insertXor(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertXor();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }
    private void insertNand(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertNand();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }
    private void insertNot(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertNot();
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
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertAnd(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    public void orMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertOr(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    public void xorMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertXor(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    public void nandMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertNand(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    public void notMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertNot(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }
}
