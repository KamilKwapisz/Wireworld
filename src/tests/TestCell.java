package tests;
import static org.assertj.core.api.Assertions.*;

import core.*;
import java.awt.*;

public class TestCell {

    private static void testColor(){
        Cell cell0 = new Cell(0,0, 0);
        Cell cell1 = new Cell(0,0, 1);
        Cell cell2 = new Cell(0,0, 2);
        Cell cell3 = new Cell(0,0, 3);

        assertThat(cell0.getColor()).as("check cell type 0 color").isEqualTo(Color.BLACK);
        assertThat(cell1.getColor()).as("check cell type 1 color").isEqualTo(Color.YELLOW);
        assertThat(cell2.getColor()).as("check cell type 2 color").isEqualTo(Color.RED);
        assertThat(cell3.getColor()).as("check cell type 3 color").isEqualTo(Color.BLUE);

    }

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


    public static void main(String[] args) {
        testColor();
        testTypeChanging();
        testCellCoordinates();
    }

}
