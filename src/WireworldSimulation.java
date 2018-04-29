import java.util.ArrayList;

public class WireworldSimulation {

    private int n; // number of generations to create
    private double delay;
    private boolean isPaused;

    public WireworldSimulation(int gen_number, double delay){
        this.n = gen_number;
        this.delay = delay;
        this.isPaused = true;
    }

    public int getN() { return n; }

    public void setN(int n) { this.n = n; }

    public double getDelay() { return delay; }

    public void setDelay(double delay) { this.delay = delay; }

    public boolean isPaused() { return isPaused; }

    public void pause() { isPaused = true; }
    public void start() { isPaused = false; }

    public static void changeCellType(Cell cell, Board board){
        int neighbours = board.countElectronHeadsNeighbours(cell);
        if( cell.getType() != 3 && (neighbours == 1 || neighbours == 2) ){
            // if cell has 1 or 2 electron's head neighbours it also become electron's head
            cell.changeToHead();
        } else if( cell.getType() == 3 ) {  // if cell was electron's head it become electron's tail
            cell.changeToTail();
        } else if( cell.getType() == 2 ) { // if cell was electron's tail it become conductor
            cell.changeToConductor();
        } else {
            cell.changeToConductor();
        }

    }

    public void runSimulation(Board board){
        this.isPaused = false;
        int currentGenerationNumber = 1;

        while( currentGenerationNumber < this.n ){
            if( !isPaused ) {
                ArrayList<Cell> notEmptyCells = board.getNotEmptyCells();
                // we can work on not empty cells only because empty call will remain empty
                // TODO figure out better way to do this
                Board oldBoard = board.copyBoard(); // creating board copy to determine how cells should be changed

                for (Cell cell : notEmptyCells) {
                    changeCellType(cell, oldBoard);
                }

                // when we finally determined what will be next cells types we can change all of them
                for (Cell cell : notEmptyCells) {
                    cell.changeType();
                }

                System.out.println();
                board.printBoard();
                System.out.println();

                currentGenerationNumber++;
            }
        }
    }

    public static void main(String[] args) {
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
        board.printBoard();

        WireworldSimulation ws = new WireworldSimulation(4, 1.0);
        ws.runSimulation(board);


    }


}
