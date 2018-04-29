//import static org.assertj.core.api.Assertions.*;

import java.awt.*;

public class TestCell {

    private static void testColor(){
        Cell cell0 = new Cell(0,0, 0);
        Cell cell1 = new Cell(0,0, 1);
        Cell cell2 = new Cell(0,0, 2);
        Cell cell3 = new Cell(0,0, 3);

        System.out.println(cell0.getColor().equals(Color.BLACK));
        System.out.println(cell1.getColor().equals(Color.YELLOW));
        System.out.println(cell2.getColor().equals(Color.RED));
        System.out.println(cell3.getColor().equals(Color.BLUE));

    }

    private static void testTypeChanging(){
        Cell testcell = new Cell(0,0,0);
        testcell.changeToConductor();
        System.out.println(testcell.getType() == 1);
        testcell.changeToEmpty();
        System.out.println(testcell.isEmpty());
        testcell.changeToHead();
        System.out.println(testcell.isHead() == 1);
        testcell.changeToTail();
        System.out.println(testcell.getType() == 2);
    }

    public static void main(String[] args) {
        System.out.println("test1");
        testColor();
        System.out.println("\ntest2");
        testTypeChanging();
    }

}
