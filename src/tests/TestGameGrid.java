package tests;
import static org.assertj.core.api.Assertions.*;
import UserInterface.Controllers.GameGrid;
import core.CellType;

public class TestGameGrid {

    private static void testGridSize() {
        GameGrid grid = new GameGrid();

        assertThat(grid.getXTiles())
                .as("checking grid width")
                .isEqualTo(64);

        assertThat(grid.getYTiles())
                .as("checking grid height")
                .isEqualTo(30);
    }

    private static void testChangeState() {
        GameGrid grid = new GameGrid();

        for(int i = 0; i < 6; i++){
                grid.changeState(i, i, CellType.CONDUCTOR);
        }

        for(int i = 0; i < 6; i++){
            assertThat(grid.getGridState(i,i)).as("checking tile type").isEqualTo( CellType.CONDUCTOR );
        }

    }

    private static void testClearGrid() {
        GameGrid grid = new GameGrid();
        for(int i = 0; i < 15; i++){
            grid.changeState(i, i, CellType.TAIL);
        }
        grid.clearGrid();
        for(int i = 0; i < 15; i++){
            assertThat(grid.getGridState(i,i)).as("checking clear grid").isEqualTo(CellType.EMPTY);
        }

    }

    public void test(){
        testGridSize();
        testChangeState();
        testClearGrid();
    }

    public static void main(String[] args) {
        TestGameGrid testGrid = new TestGameGrid();
        testGrid.test();
    }

}
