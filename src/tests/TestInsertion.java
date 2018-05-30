package tests;
import userinterface.controllers.GameGrid;
import logicgate.insertion.InsertLogicGate;
import core.CellType;

import static logicgate.insertion.InsertionFlag.*;
import static org.assertj.core.api.Assertions.*;

public class TestInsertion {

    private final int x = 30;
    private final int y = 15 ;

    private void testAndLogicGateInsertion(){
        GameGrid gameGrid = new GameGrid();
        InsertLogicGate gate = new InsertLogicGate(gameGrid.getGrid());
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        gate.setProperties(x, y, AND_RIGHT);
        gate.insertAnd();

        assertThat(grid[x][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y+3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+4][y-3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+4][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y+3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+8][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+8][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+9][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+9][y+3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+9][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+10][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+10][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+11][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+11][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+11][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+11][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+12][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+12][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+13][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+13][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+13][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+13][y+3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+14][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+15][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+16][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+17][y+1].getState()).isEqualTo(CellType.CONDUCTOR);

    }

    private void testOrLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        InsertLogicGate gate = new InsertLogicGate(gameGrid.getGrid());
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        gate.setProperties(x, y, OR_BOT);
        gate.insertOr();

        assertThat(grid[x][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y+3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y+3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y+4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y+5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y+6].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y+7].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y+8].getState()).isEqualTo(CellType.CONDUCTOR);

    }

    private void testXorLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        InsertLogicGate gate = new InsertLogicGate(gameGrid.getGrid());
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        gate.setProperties(x, y, XOR_LEFT);
        gate.insertXor();

        assertThat(grid[x][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y-3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-4][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-4][y-4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y-4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-6][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-6][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-6][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-6][y-3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-7][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-7][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-7][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-8][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-8][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-8][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-9][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-10][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
    }

    private void testNandLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        InsertLogicGate gate = new InsertLogicGate(gameGrid.getGrid());
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        gate.setProperties(x, y, NAND_TOP);
        gate.insertNand();

        assertThat(grid[x+1][y-13].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y-12].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y-9].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y-8].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-5][y-7].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-4][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-4][y-6].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y-9].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-3][y-5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y-9].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-2][y-4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-8].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x-1][y-3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-6].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x][y-5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y-6].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y-5].getState()).isEqualTo(CellType.HEAD);
        assertThat(grid[x+2][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y-7].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y-8].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y-4].getState()).isEqualTo(CellType.TAIL);
        assertThat(grid[x+3][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y-3].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y-9].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-11].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-9].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+4][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y-10].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y-9].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y-8].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y-7].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+4][y-4].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-5].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y-6].getState()).isEqualTo(CellType.CONDUCTOR);

    }


    private void testNotLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        InsertLogicGate gate = new InsertLogicGate(gameGrid.getGrid());
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        gate.setProperties(x, y, NOT_RIGHT);
        gate.insertNot();

        assertThat(grid[x][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+1][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+10][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+11][y].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y-1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+4][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y-2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+6][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+9][y+1].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+2][y+2].getState()).isEqualTo(CellType.HEAD);
        assertThat(grid[x+4][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+5][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+7][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+8][y+2].getState()).isEqualTo(CellType.CONDUCTOR);
        assertThat(grid[x+3][y+3].getState()).isEqualTo(CellType.TAIL);

    }

    public void test(){
        TestInsertion tests = new TestInsertion();

        tests.testAndLogicGateInsertion();
        tests.testOrLogicGateInsertion();
        tests.testXorLogicGateInsertion();
        tests.testNandLogicGateInsertion();
        tests.testNotLogicGateInsertion();
    }

    public static void main(String[] args) {
        TestInsertion tests = new TestInsertion();

        tests.test();
    }



}
