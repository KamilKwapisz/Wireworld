package tests;
import static org.assertj.core.api.Assertions.*;
import UserInterface.Controllers.GameGrid;
import core.*;


public class TestWireworldSimulation {

    private static void testInitializeBoardFromGrid(){
        GameGrid grid = new GameGrid(20);
        WireworldSimulation simulation = new WireworldSimulation(2, 0.5, grid);
        Board board = simulation.getBoard();

        assertThat(board.getHeight())
                .as("testing board height")
                .isEqualTo(30);

        assertThat(board.getWidth())
                .as("testing board height")
                .isEqualTo(64);
    }

    private static void testSeters(){
        GameGrid grid = new GameGrid(20);
        WireworldSimulation simulation = new WireworldSimulation(2, 0.5, grid);

        assertThatThrownBy(() -> simulation.setNumberOfIterations(-5))
                .as("Checking exception thrown by setting iteration's number to negative value")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Generation number must not be a negative number.");

        simulation.setNumberOfIterations(5);
        assertThat(simulation.getNumberOfIterations())
                .as("checking number of iterations")
                .isEqualTo(5);

        assertThat(simulation.getDelay())
                .as("checking delay")
                .isEqualTo(0.5);
    }

    private static void testGetCellsFromGrid(){
        GameGrid grid = new GameGrid(20);
        grid.fillGrid();
        grid.changeState(0, 0, CellType.CONDUCTOR);
        grid.changeState(1, 1, CellType.HEAD);
        grid.changeState(2, 2, CellType.TAIL);

        WireworldSimulation simulation = new WireworldSimulation(3, 0.5, grid);
        simulation.getCellsFromGrid();
        Board board = simulation.getBoard();

        Cell cell1 = board.getCell(0,0);
        Cell cell2 = board.getCell(1,1);
        Cell cell3 = board.getCell(2,2);

        assertThat(cell1.getType())
                .as("checking cell's from board type")
                .isEqualTo(CellType.CONDUCTOR);
        assertThat(cell2.getType())
                .as("checking cell's from board type")
                .isEqualTo(CellType.HEAD);
        assertThat(cell3.getType())
                .as("checking cell's from board type")
                .isEqualTo(CellType.TAIL);

    }

    private static void testNextGeneration(){
        GameGrid grid = new GameGrid(20);
        grid.fillGrid();
        grid.changeState(0, 0, CellType.CONDUCTOR); grid.changeState(0, 1, CellType.HEAD); grid.changeState(0, 2, CellType.CONDUCTOR);
        grid.changeState(1, 0, CellType.HEAD); grid.changeState(1, 1, CellType.TAIL); grid.changeState(1, 2, CellType.TAIL);
        grid.changeState(2, 0, CellType.TAIL); grid.changeState(2, 1, CellType.CONDUCTOR); grid.changeState(2, 2, CellType.HEAD);
        /* 1 3 2
           3 2 1
           1 2 3
         */
        WireworldSimulation simulation = new WireworldSimulation(3, 0.5, grid);
        simulation.getCellsFromGrid();
        simulation.nextGeneration();
        Board board = simulation.getBoard();

        assertThat(board.getCell(0,0).getType()).isEqualTo(CellType.HEAD);
        assertThat(board.getCell(0,1).getType()).isEqualTo(CellType.TAIL);
        assertThat(board.getCell(0,2).getType()).isEqualTo(CellType.HEAD);

        assertThat(board.getCell(1,0).getType()).isEqualTo(CellType.TAIL);
        assertThat(board.getCell(1,1).getType()).isEqualTo(CellType.CONDUCTOR);
        assertThat(board.getCell(1,2).getType()).isEqualTo(CellType.CONDUCTOR);

        assertThat(board.getCell(2,0).getType()).isEqualTo(CellType.CONDUCTOR);
        assertThat(board.getCell(2,1).getType()).isEqualTo(CellType.HEAD);
        assertThat(board.getCell(2,2).getType()).isEqualTo(CellType.TAIL);

    }

    private static void testRunSimulation(){
        GameGrid grid = new GameGrid(20);
        grid.fillGrid();
        int maxGenNumber = 15;
        WireworldSimulation simulation = new WireworldSimulation(maxGenNumber, 0.08, grid);
        simulation.unpause();
        simulation.runSimulation();

        assertThat(simulation.getCurrentGenerationNumber())
                .as("checking whether simulation creates proper number of generations")
                .isEqualTo(maxGenNumber);

        simulation.setNumberOfIterations(10);
        assertThat(simulation.getCurrentGenerationNumber())
                .as("checking whether simulation resets current generation number after setting different max generation number")
                .isEqualTo(1);

        simulation.runSimulation();
        assertThat(simulation.getCurrentGenerationNumber())
                .as("checking whether simulation creates proper number of generation after setting max number manually")
                .isEqualTo(10);
    }

    public void test(){
        testInitializeBoardFromGrid();
        testSeters();
        testGetCellsFromGrid();
        testNextGeneration();
        testRunSimulation();
    }

    public static void main(String[] args) {
        TestWireworldSimulation testSimulation = new TestWireworldSimulation();
        testSimulation.test();

    }

}
