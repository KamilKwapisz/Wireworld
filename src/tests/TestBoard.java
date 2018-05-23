package tests;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import core.*;

public class TestBoard {

    private static void testGetCell(){
        Board board = new Board(3,3);
        assertThatThrownBy(() -> board.getCell(-2, -2))
                .as("Checking exception thrown by getting cell with negative coordinates")
                .isInstanceOf(NegativeArraySizeException.class)
                .hasMessage("Cell's coordinates mustn't be negative numbers.");
        assertThatThrownBy(() -> board.getCell(10, 12))
                .as("Checking exception thrown by getting cell with coordinates out of board")
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("Board is smaller than given coordinates.");
    }

    private static void testCountElectronHeadsNeighbours(){
        Board board = new Board(3,3);
        board.addCell(new Cell(0, 0, 3));
        board.addCell(new Cell(1, 0, 1));
        board.addCell(new Cell(2, 0, 3));

        board.addCell(new Cell(0, 1, 3));
        board.addCell(new Cell(1, 1, 3));
        board.addCell(new Cell(2, 1, 1));

        board.addCell(new Cell(0, 2, 3));
        board.addCell(new Cell(1, 2, 1));
        board.addCell(new Cell(2, 2, 3));
        /*
         *  3    1   3
         *  3    3   1
         *  3    1   3
         */

        assertThat( board.countElectronHeadsNeighbours( new Cell(1, 1, 3) ) )
                .as("checking neighbours number: cell in the middle")
                .isEqualTo(5);
        assertThat( board.countElectronHeadsNeighbours( new Cell(0, 0, 3) ) )
                .as("checking neighbours number: left top cell")
                .isEqualTo(2);
        assertThat( board.countElectronHeadsNeighbours( new Cell(0, 2, 3) ) )
                .as("checking neighbours number: left bottom cell")
                .isEqualTo(2);
        assertThat( board.countElectronHeadsNeighbours( new Cell(2, 0, 3) ) )
                .as("checking neighbours number: right top cell")
                .isEqualTo(1);
        assertThat( board.countElectronHeadsNeighbours( new Cell(2, 2, 3) ) )
                .as("checking neighbours number: right bottom cell")
                .isEqualTo(1);
        assertThat( board.countElectronHeadsNeighbours( new Cell(1, 2, 3) ) )
                .as("checking neighbours number: middle bottom cell")
                .isEqualTo(4);
        assertThat( board.countElectronHeadsNeighbours( new Cell(2, 1, 3) ) )
                .as("checking neighbours number: right edge cell")
                .isEqualTo(3);
        assertThat( board.countElectronHeadsNeighbours( new Cell(0, 1, 3) ) )
                .as("checking neighbours number: left edge cell ")
                .isEqualTo(3);
        assertThat( board.countElectronHeadsNeighbours( new Cell(1, 0, 1) ) )
                .as("checking neighbours number: top edge cell ")
                .isEqualTo(4);
    }

    private static void testSetSize(){
        Board board = new Board(20,30);
        assertThat(board.getWidth() ).as("checking width set in constructor").isEqualTo(20);
        assertThat(board.getHeight() ).as("checking height set in constructor").isEqualTo(30);

        board.setSize(100, 300);
        assertThat(board.getWidth() ).as("checking width set in setSize").isEqualTo(100);
        assertThat(board.getHeight() ).as("checking height set in setSize").isEqualTo(300);

        assertThatThrownBy(() -> board.setSize(-100, 0))
                .as("Checking exception thrown by setting board's size with negative values")
                .isInstanceOf(NegativeArraySizeException.class)
                .hasMessage("Board's width and height have to be positive numbers.");

    }

    private static void testAddCell() {
        Board board = new Board(3,3);
        Cell cell = new Cell(0, 0, 1);
        Cell cell2 = new Cell(1, 0, 3);
        Cell cell3 = new Cell(2, 2, 2);

        board.addCell(cell);
        board.addCell(cell2);
        board.addCell(cell3);

        assertThat(board.getCell(0, 0))
                .as("checking if cell objects is equal to added one")
                .isEqualTo(cell);
        assertThat(board.getCell(1, 0))
                .as("checking if cell objects is equal to added one")
                .isEqualTo(cell2);
        assertThat(board.getCell(1, 1).getType())
                .as("checking current type of added cell")
                .isEqualTo(0);
        assertThat(board.getCell(1, 0).getType())
                .as("checking current type of added cell")
                .isEqualTo(3);
        assertThat(board.getCell(1, 2).getType())
                .as("checking current type of added cell")
                .isEqualTo(0);

        Cell cell4 = new Cell(5, 3, 2);

        assertThatThrownBy(() -> board.addCell(cell4))
                .as("Checking exception thrown by adding cell with coordinates higher than board size")
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("Board is too small for this cell.");

    }
    private static void testGetBoard() {
        Board board = new Board(3,3);
        Cell cell = new Cell(0, 0, 1);
        Cell cell2 = new Cell(1, 0, 3);
        Cell cell3 = new Cell(2, 2, 2);

        board.addCell(cell);
        board.addCell(cell2);
        board.addCell(cell3);
        assertThat(board.getBoard().get(0))
                .as("checking if returned board contains all cells added to it in the right row")
                .contains(cell, cell2)
                .doesNotContain(cell3);

        assertThat(board.getBoard().get(2))
                .as("checking if returned board contains all cells added to it in the right row")
                .contains(cell3)
                .doesNotContain(cell, cell2);

        assertThat(board.getBoard().get(0))
                .as("checking whether first row contains only y=0 cells")
                .extracting(Cell::getY)
                .containsOnly(0);

        assertThat(board.getBoard().get(1))
                .as("checking whether third row contains only y=0 cells")
                .extracting(Cell::getY)
                .containsOnly(1);

        assertThat(board.getBoard().get(1))
                .as("checking whether second row contains columns number 0, 1 and 2")
                .extracting(Cell::getX)
                .containsOnly(0, 1, 2);

        assertThat(board.getBoard().get(1))
                .as("checking if all not manually added cells are empty")
                .extracting(Cell::isEmpty)
                .containsOnly(true);

        assertThat(board.getBoard())
                .as("checking returned board size")
                .hasSize(3);

        for(ArrayList<Cell> cellsList : board.getBoard())
            assertThat(cellsList).as("checking each row's of returned board size").hasSize(3);
    }

    private static void testGetNotEmptyCells(){
        Board board = new Board(4,4);
        Cell cell = new Cell(0,0, 1);
        Cell cell2 = new Cell(1,1, 1);
        Cell cell3 = new Cell(2,2, 1);

        board.addCell(cell);
        board.addCell(cell2);
        board.addCell(cell3);

        assertThat(board.getNotEmptyCells()).as("Checking size of not empty cells list").hasSize(3);
        assertThat(board.getNotEmptyCells())
                .as("checking if not empty cells list contains each not empty cell")
                .contains(cell, cell2, cell3);
    }

    public void test(){
        testGetCell();
        testCountElectronHeadsNeighbours();
        testSetSize();
        testAddCell();
        testGetBoard();
        testGetNotEmptyCells();
    }

    public static void main(String[] args) {
        TestBoard testBoard = new TestBoard();
        testBoard.test();
    }


}
