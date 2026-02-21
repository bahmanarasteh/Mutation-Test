package cal;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRandomTest {

    private static final Random RND = new Random(42);
    private static final char[] OPS = new char[]{'+', '-', '*', '/'};

    @Test
    void randomSmoke() {
        for (int i = 0; i < 50; i++) {
            double a = 1 + RND.nextInt(20);   // keep a != 0 to avoid division-by-zero
            double b = RND.nextInt(50) - 25;
            char op = OPS[RND.nextInt(OPS.length)];

            double expected;
            switch (op) {
                case '+': expected = b + a; break;
                case '-': expected = b - a; break;
                case '*': expected = b * a; break;
                case '/': expected = b / a; break;
                default:  expected = 0;     break;
            }

            double actual = new Calculator().cal(a, b, op);
            assertEquals(expected, actual, 1e-9);
        }
    }
}
