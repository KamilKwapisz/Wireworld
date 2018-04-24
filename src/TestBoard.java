import java.util.ArrayList;

public class TestBoard {

    private static void testCountElectronHeadsNeighbours(){
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

    private static void testSetSize(){
        Board board = new Board(20,30);
        System.out.println(board.getWidth() == 20 && board.getHeight() == 30);
        board.setSize(100, 300);
        System.out.println(board.getWidth() == 100 && board.getHeight() == 300);
    }

    private static void testAddCell(){
        Cell cell = new Cell(0,0, 1);
        Cell cell2 = new Cell(1,0, 3);
        Cell cell3 = new Cell(2,2, 2);

        Board board = new Board(3, 3);
        board.addCell(cell);
        board.addCell(cell2);
        board.addCell(cell3);

        System.out.println(board.getCell(0,0).equals(cell));
        System.out.println(board.getCell(1,1).getType() == 0);
        System.out.println(board.getCell(1,0).getType() == 3);

    }

    private static void testGetNotEmptyCells(){
        Cell cell = new Cell(0,0, 1);
        Cell cell2 = new Cell(1,1, 3);
        Cell cell3 = new Cell(2,2, 2);

        Board board = new Board(3, 3);
        board.addCell(cell);
        board.addCell(cell2);
        board.addCell(cell3);
        System.out.println(board.getNotEmptyCells().size() == 3);
        ArrayList<Cell> cells = board.getNotEmptyCells();
        System.out.println(cells.get(0).equals(cell));
        System.out.println(cells.get(1).equals(cell2));
        System.out.println(cells.get(2).equals(cell3));
    }

    public static void main(String[] args) {
        System.out.println("test1");
        testCountElectronHeadsNeighbours();
        System.out.println("\ntest2");
        testSetSize();
        System.out.println("\ntest3");
        testAddCell();
        System.out.println("\ntest4");
        testGetNotEmptyCells();


    }


}
