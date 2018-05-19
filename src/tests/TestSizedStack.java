package tests;
import static org.assertj.core.api.Assertions.*;
import utils.SizedStack;

public class TestSizedStack {

    public void test() {

        SizedStack stack = new SizedStack();
        for (int i = 0; i <= 6; i++) {
            stack.push(i);
        }

        assertThat(stack).containsOnly(2, 3, 4, 5, 6)
                .as("checking stack content");

        assertThat(stack).hasSize(5)
                .as("checking stack size");

    }

    public static void main(String[] args) {
        TestSizedStack testStack = new TestSizedStack();
        testStack.test();
    }
}
