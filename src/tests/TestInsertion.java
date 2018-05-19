package tests;
import UserInterface.Controllers.GameGrid;
import UserInterface.Insertion.LogicGate;

import static UserInterface.Insertion.InsertionFlag.*;
import static org.assertj.core.api.Assertions.*;

public class TestInsertion {

    private static void testAndLogicGateInsertion(){
        GameGrid gameGrid = new GameGrid();
        gameGrid.setInsertionFlag(AND_RIGHT);
        LogicGate gate = new LogicGate(gameGrid.getGrid());
        int x = 30;
        int y = 15 ;
        gate.setProperties(x, y, AND_RIGHT);
        gate.insertAnd();
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        assertThat(grid[x][y].getState()).isEqualTo(1);
        assertThat(grid[x][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+1][y].getState()).isEqualTo(1);
        assertThat(grid[x+1][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+2][y].getState()).isEqualTo(1);
        assertThat(grid[x+2][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+3][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+3][y-2].getState()).isEqualTo(1);
        assertThat(grid[x+3][y+3].getState()).isEqualTo(1);
        assertThat(grid[x+4][y-3].getState()).isEqualTo(1);
        assertThat(grid[x+4][y+4].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-2].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+5][y].getState()).isEqualTo(1);
        assertThat(grid[x+5][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+5][y+5].getState()).isEqualTo(1);
        assertThat(grid[x+6][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+6][y+5].getState()).isEqualTo(1);
        assertThat(grid[x+7][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+7][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+7][y+3].getState()).isEqualTo(1);
        assertThat(grid[x+7][y+5].getState()).isEqualTo(1);
        assertThat(grid[x+8][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+8][y+5].getState()).isEqualTo(1);
        assertThat(grid[x+9][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+9][y+3].getState()).isEqualTo(1);
        assertThat(grid[x+9][y+5].getState()).isEqualTo(1);
        assertThat(grid[x+10][y].getState()).isEqualTo(1);
        assertThat(grid[x+10][y+4].getState()).isEqualTo(1);
        assertThat(grid[x+11][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+11][y].getState()).isEqualTo(1);
        assertThat(grid[x+11][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+11][y+4].getState()).isEqualTo(1);
        assertThat(grid[x+12][y].getState()).isEqualTo(1);
        assertThat(grid[x+12][y+4].getState()).isEqualTo(1);
        assertThat(grid[x+13][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+13][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+13][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+13][y+3].getState()).isEqualTo(1);
        assertThat(grid[x+14][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+15][y].getState()).isEqualTo(1);
        assertThat(grid[x+16][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+17][y+1].getState()).isEqualTo(1);

    }

    private static void testOrLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        gameGrid.setInsertionFlag(OR_BOT);
        LogicGate gate = new LogicGate(gameGrid.getGrid());
        int x = 30;
        int y = 15;
        gate.setProperties(x, y, OR_BOT);
        gate.insertOr();
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        assertThat(grid[x][y].getState()).isEqualTo(1);
        assertThat(grid[x-2][y].getState()).isEqualTo(1);
        assertThat(grid[x][y+1].getState()).isEqualTo(1);
        assertThat(grid[x-2][y+1].getState()).isEqualTo(1);
        assertThat(grid[x][y+2].getState()).isEqualTo(1);
        assertThat(grid[x-2][y+2].getState()).isEqualTo(1);
        assertThat(grid[x-3][y+3].getState()).isEqualTo(1);
        assertThat(grid[x+1][y+3].getState()).isEqualTo(1);
        assertThat(grid[x-3][y+4].getState()).isEqualTo(1);
        assertThat(grid[x-1][y+4].getState()).isEqualTo(1);
        assertThat(grid[x+1][y+4].getState()).isEqualTo(1);
        assertThat(grid[x][y+5].getState()).isEqualTo(1);
        assertThat(grid[x-1][y+5].getState()).isEqualTo(1);
        assertThat(grid[x-2][y+5].getState()).isEqualTo(1);
        assertThat(grid[x-1][y+6].getState()).isEqualTo(1);
        assertThat(grid[x-1][y+7].getState()).isEqualTo(1);
        assertThat(grid[x-1][y+8].getState()).isEqualTo(1);

    }

    private static void testXorLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        gameGrid.setInsertionFlag(XOR_LEFT);
        LogicGate gate = new LogicGate(gameGrid.getGrid());
        int x = 30;
        int y = 15;
        gate.setProperties(x, y, XOR_LEFT);
        gate.insertXor();
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        assertThat(grid[x][y].getState()).isEqualTo(1);
        assertThat(grid[x][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-1][y].getState()).isEqualTo(1);
        assertThat(grid[x-1][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-2][y].getState()).isEqualTo(1);
        assertThat(grid[x-2][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-3][y+1].getState()).isEqualTo(1);
        assertThat(grid[x-3][y-3].getState()).isEqualTo(1);
        assertThat(grid[x-4][y+2].getState()).isEqualTo(1);
        assertThat(grid[x-4][y-4].getState()).isEqualTo(1);
        assertThat(grid[x-5][y+2].getState()).isEqualTo(1);
        assertThat(grid[x-5][y-4].getState()).isEqualTo(1);
        assertThat(grid[x-5][y].getState()).isEqualTo(1);
        assertThat(grid[x-5][y-1].getState()).isEqualTo(1);
        assertThat(grid[x-5][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-6][y+1].getState()).isEqualTo(1);
        assertThat(grid[x-6][y].getState()).isEqualTo(1);
        assertThat(grid[x-6][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-6][y-3].getState()).isEqualTo(1);
        assertThat(grid[x-7][y].getState()).isEqualTo(1);
        assertThat(grid[x-7][y-1].getState()).isEqualTo(1);
        assertThat(grid[x-7][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-8][y].getState()).isEqualTo(1);
        assertThat(grid[x-8][y-1].getState()).isEqualTo(1);
        assertThat(grid[x-8][y-2].getState()).isEqualTo(1);
        assertThat(grid[x-9][y-1].getState()).isEqualTo(1);
        assertThat(grid[x-10][y-1].getState()).isEqualTo(1);
    }

    private static void testNandLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        gameGrid.setInsertionFlag(NAND_TOP);
        LogicGate gate = new LogicGate(gameGrid.getGrid());
        int x = 30;
        int y = 15;
        gate.setProperties(x, y, NAND_TOP);
        gate.insertNand();
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        assertThat(grid[x+1][y-13].getState()).isEqualTo(1);
        assertThat(grid[x+1][y-12].getState()).isEqualTo(1);
        assertThat(grid[x+1][y-11].getState()).isEqualTo(1);
        assertThat(grid[x+1][y-10].getState()).isEqualTo(1);
        assertThat(grid[x-5][y-9].getState()).isEqualTo(1);
        assertThat(grid[x-5][y-8].getState()).isEqualTo(1);
        assertThat(grid[x-5][y-7].getState()).isEqualTo(1);
        assertThat(grid[x-4][y-10].getState()).isEqualTo(1);
        assertThat(grid[x-4][y-6].getState()).isEqualTo(1);
        assertThat(grid[x-3][y-11].getState()).isEqualTo(1);
        assertThat(grid[x-3][y-10].getState()).isEqualTo(1);
        assertThat(grid[x-3][y-9].getState()).isEqualTo(1);
        assertThat(grid[x-3][y-5].getState()).isEqualTo(1);
        assertThat(grid[x-2][y-10].getState()).isEqualTo(1);
        assertThat(grid[x-1][y-9].getState()).isEqualTo(1);
        assertThat(grid[x-1][y-11].getState()).isEqualTo(1);
        assertThat(grid[x][y-11].getState()).isEqualTo(1);
        assertThat(grid[x-2][y-4].getState()).isEqualTo(1);
        assertThat(grid[x][y-2].getState()).isEqualTo(1);
        assertThat(grid[x][y-1].getState()).isEqualTo(1);
        assertThat(grid[x][y].getState()).isEqualTo(1);
        assertThat(grid[x][y-8].getState()).isEqualTo(1);
        assertThat(grid[x-1][y-3].getState()).isEqualTo(1);
        assertThat(grid[x][y-6].getState()).isEqualTo(1);
        assertThat(grid[x][y-5].getState()).isEqualTo(1);
        assertThat(grid[x+2][y-6].getState()).isEqualTo(1);
        assertThat(grid[x+2][y-5].getState()).isEqualTo(3);
        assertThat(grid[x+2][y-2].getState()).isEqualTo(1);
        assertThat(grid[x+2][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+2][y].getState()).isEqualTo(1);
        assertThat(grid[x+1][y-7].getState()).isEqualTo(1);
        assertThat(grid[x+2][y-11].getState()).isEqualTo(1);
        assertThat(grid[x+2][y-8].getState()).isEqualTo(1);
        assertThat(grid[x+1][y-4].getState()).isEqualTo(2);
        assertThat(grid[x+3][y-11].getState()).isEqualTo(1);
        assertThat(grid[x+3][y-3].getState()).isEqualTo(1);
        assertThat(grid[x+3][y-9].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-11].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-10].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-9].getState()).isEqualTo(1);
        assertThat(grid[x+4][y-10].getState()).isEqualTo(1);
        assertThat(grid[x+6][y-10].getState()).isEqualTo(1);
        assertThat(grid[x+7][y-9].getState()).isEqualTo(1);
        assertThat(grid[x+7][y-8].getState()).isEqualTo(1);
        assertThat(grid[x+7][y-7].getState()).isEqualTo(1);
        assertThat(grid[x+4][y-4].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-5].getState()).isEqualTo(1);
        assertThat(grid[x+6][y-6].getState()).isEqualTo(1);

    }


    private static void testNotLogicGateInsertion() {
        GameGrid gameGrid = new GameGrid();
        gameGrid.setInsertionFlag(NOT_RIGHT);
        LogicGate gate = new LogicGate(gameGrid.getGrid());
        int x = 30;
        int y = 15;
        gate.setProperties(x, y, NOT_RIGHT);
        gate.insertNot();
        GameGrid.Tile[][] grid = gameGrid.getGrid();

        assertThat(grid[x][y].getState()).isEqualTo(1);
        assertThat(grid[x+1][y].getState()).isEqualTo(1);
        assertThat(grid[x+5][y].getState()).isEqualTo(1);
        assertThat(grid[x+6][y].getState()).isEqualTo(1);
        assertThat(grid[x+7][y].getState()).isEqualTo(1);
        assertThat(grid[x+10][y].getState()).isEqualTo(1);
        assertThat(grid[x+11][y].getState()).isEqualTo(1);
        assertThat(grid[x+2][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+6][y-1].getState()).isEqualTo(1);
        assertThat(grid[x+3][y-2].getState()).isEqualTo(1);
        assertThat(grid[x+4][y-2].getState()).isEqualTo(1);
        assertThat(grid[x+5][y-2].getState()).isEqualTo(1);
        assertThat(grid[x+3][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+6][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+9][y+1].getState()).isEqualTo(1);
        assertThat(grid[x+2][y+2].getState()).isEqualTo(3);
        assertThat(grid[x+4][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+5][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+7][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+8][y+2].getState()).isEqualTo(1);
        assertThat(grid[x+3][y+3].getState()).isEqualTo(2);

    }

    public static void main(String[] args) {
        testAndLogicGateInsertion();
        testOrLogicGateInsertion();
        testXorLogicGateInsertion();
        testNandLogicGateInsertion();
        testNotLogicGateInsertion();
    }



}
