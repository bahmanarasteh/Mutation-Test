package remainder;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Weak random test suite.
 * Useful as baseline benchmark with low mutation strength.
 */
class RemainderRandomTest {

    private static final Random RND = new Random(42);

    @Test
    void randomInputs() {
        for (int i = 0; i < 50; i++) {

            int dividend = RND.nextInt(200) - 100;   // -100 to 99
            int divisor;

            // avoid zero divisor
            do {
                divisor = RND.nextInt(50) - 25;      // -25 to 24
            } while (divisor == 0);

            int expected = dividend % divisor;

            assertEquals(expected, Remainder.compute(dividend, divisor));
        }
    }
}
