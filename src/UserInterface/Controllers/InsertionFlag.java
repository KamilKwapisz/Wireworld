package UserInterface.Controllers;

public enum InsertionFlag {
    NORMAL(0),
    AND_TOP(1), AND_BOT(2), AND_LEFT(3), AND_RIGHT(4),
    OR_TOP(5), OR_BOT(6), OR_LEFT(7), OR_RIGHT(8),
    XOR_TOP(9), XOR_BOT(10), XOR_LEFT(11), XOR_RIGHT(12),
    NAND_TOP(13), NAND_BOT(14), NAND_LEFT(15), NAND_RIGHT(16);

    private final int value;
    private InsertionFlag(int flag){
        this.value = flag;
    }
}
