//import static org.assertj.core.api.Assertions.*;

public class TestCell {

    public static void main(String[] args) {
        // temporarily, it will be replaced with AssertJ tests
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
        System.out.println(board);

        System.out.println(board.countElectronHeadsNeighbours(new Cell(1, 1, 3))); // middle cell 5
        System.out.println(board.countElectronHeadsNeighbours(new Cell(0, 0, 3))); // left top cell 2
        System.out.println(board.countElectronHeadsNeighbours(new Cell(0, 2, 3))); // left bottom cell 2
        System.out.println(board.countElectronHeadsNeighbours(new Cell(2, 0, 3))); // right top cell 1
        System.out.println(board.countElectronHeadsNeighbours(new Cell(2, 2, 3))); // right bottom cell 1
        System.out.println(board.countElectronHeadsNeighbours(new Cell(1, 2, 3))); // middle bottom 4
    }

}
