package tests;
import static org.assertj.core.api.Assertions.*;

import core.*;

public class TestCell {


    private static void testTypeChanging(){
        Cell testcell = new Cell(0,0,0);
        assertThat(testcell.getType()).as("check cell type").isEqualTo(0);

        testcell.changeToConductor();
        assertThat(testcell.getNextType()).as("check conductor cell type").isEqualTo(1);

        testcell.changeToEmpty();
        assertThat(testcell.getNextType()).as("check empty cell type").isEqualTo(0);

        testcell.changeToHead();
        assertThat(testcell.getNextType()).as("check head cell type").isEqualTo(3);
        testcell.changeType();
        assertThat(testcell.isHead()).as("check if cell is head").isEqualTo(1);

        testcell.changeToTail();
        assertThat(testcell.getNextType()).as("check tail cell type").isEqualTo(2);

    }

    private static void testCellCoordinates(){
        Cell testcell = new Cell(1,3,0);
        assertThat(testcell.getX()).as("checking cell X coordinate").isEqualTo(1);
        assertThat(testcell.getY()).as("checking cell Y coordinate").isEqualTo(3);

        testcell.setCellCoordinate(3, 10);
        assertThat(testcell.getX()).as("checking cell X coordinate").isEqualTo(3);
        assertThat(testcell.getY()).as("checking cell Y coordinate").isEqualTo(10);

    }

    private static void testIncorrectCells(){
        assertThatThrownBy(() -> new Cell(-2, -3, 3))
                .as("Checking exception thrown by creating cell with coordinates lower than 0")
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("Cell's coordinates mustn't be negative numbers.");

        assertThatThrownBy(() -> new Cell(1, 2, 13))
                .as("Checking exception thrown by creating cell with incorrect type")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Incorrect cell type.");
    }


    public static void main(String[] args) {
        testTypeChanging();
        testCellCoordinates();
        testIncorrectCells();
    }

}
