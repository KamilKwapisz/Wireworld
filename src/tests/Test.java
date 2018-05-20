package tests;

public class Test {

    public static void main(String[] args) {
        TestBoard testBoard = new TestBoard();
        TestCell testCell = new TestCell();
        TestGameGrid testGameGrid = new TestGameGrid();
        TestInsertion testInsertion = new TestInsertion();
        TestSizedStack testSizedStack = new TestSizedStack();
        TestWireworldSimulation testWireworldSimulation = new TestWireworldSimulation();

        testBoard.test();
        testCell.test();
        testGameGrid.test();
        testInsertion.test();
        testSizedStack.test();
        testWireworldSimulation.test();
    }
}
