package tests;
import static UserInterface.Insertion.InsertionFlag.NAND_TOP;
import static org.assertj.core.api.Assertions.*;
import UserInterface.Controllers.GameGrid;

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
//        grid.fillGrid();

        for(int i = 0; i < 6; i++){
                grid.changeState(i, i, (i % 3) + 1);
        }

        for(int i = 0; i < 6; i++){
            assertThat(grid.getGridState(i,i)).as("checking tile type").isEqualTo( (i % 3) + 1);
        }

    }

    private static void testClearGrid() {
        GameGrid grid = new GameGrid();
//        grid.fillGrid();
        for(int i = 0; i < 15; i++){
            grid.changeState(i, i, (i % 3) + 1);
        }
        grid.clearGrid();
        for(int i = 0; i < 15; i++){
            assertThat(grid.getGridState(i,i)).as("checking clear grid").isEqualTo(0);
        }

    }

    public static void main(String[] args) {
        testGridSize();
        testChangeState();
        testClearGrid();
    }

}
