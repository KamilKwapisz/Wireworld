package tests;
import static org.assertj.core.api.Assertions.*;

import core.*;

public class TestCell {

    private static void testTypeChanging(){
        Cell testcell = new Cell(0,0,CellType.EMPTY);
        assertThat(testcell.getType()).as("check cell type").isEqualTo(CellType.EMPTY);

        testcell.changeToConductor();
        assertThat(testcell.getNextType()).as("check conductor cell type").isEqualTo(CellType.CONDUCTOR);

        testcell.changeToEmpty();
        assertThat(testcell.getNextType()).as("check empty cell type").isEqualTo(CellType.EMPTY);

        testcell.changeToHead();
        assertThat(testcell.getNextType()).as("check head cell type").isEqualTo(CellType.HEAD);
        testcell.changeType();
        assertThat(testcell.isHead()).as("check if cell is head").isEqualTo(CellType.CONDUCTOR);

        testcell.changeToTail();
        assertThat(testcell.getNextType()).as("check tail cell type").isEqualTo(CellType.TAIL);

    }

    private static void testCellCoordinates(){
        Cell testcell = new Cell(1,3,CellType.EMPTY);
        assertThat(testcell.getX()).as("checking cell X coordinate").isEqualTo(1);
        assertThat(testcell.getY()).as("checking cell Y coordinate").isEqualTo(3);

        testcell.setCellCoordinate(3, 10);
        assertThat(testcell.getX()).as("checking cell X coordinate").isEqualTo(3);
        assertThat(testcell.getY()).as("checking cell Y coordinate").isEqualTo(10);

    }

    private static void testIncorrectCells(){
        assertThatThrownBy(() -> new Cell(-2, -3, CellType.HEAD))
                .as("Checking exception thrown by creating cell with coordinates lower than 0")
                .isInstanceOf(NegativeArraySizeException.class)
                .hasMessage("Cell's coordinates mustn't be negative numbers.");

    }

    public void test(){
        testTypeChanging();
        testCellCoordinates();
        testIncorrectCells();
    }

    public static void main(String[] args) {
        TestCell testCell = new TestCell();

        testCell.test();
    }

}
