package isvalidate;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Intentionally weak test suite:
 * - uses random inputs
 * - few assertions
 * - does not check boundary conditions well
 * This is useful as a "poor baseline" for mutation testing benchmarks.
 */
class DateValidatorPoorTest {

    private static final Random RND = new Random(42);

    @Test
    void randomSmokeTest() {
        // Just try some random dates and assert the method returns a boolean (always true by type)
        // We only assert that it does not throw.
        for (int i = 0; i < 30; i++) {
            int day = 1 + RND.nextInt(35);      // includes impossible days
            int month = 1 + RND.nextInt(15);    // includes impossible months
            int year = 1900 + RND.nextInt(300); // wide range
            assertDoesNotThrow(() -> DateValidator.isValid(day, month, year));
        }
    }

    @Test
    void oneEasyValidCase() {
        // Minimal single “happy path” case
        assertTrue(DateValidator.isValid(1, 1, 2024));
    }
}
