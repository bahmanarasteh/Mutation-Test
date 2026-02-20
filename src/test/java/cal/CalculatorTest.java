package cal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(7.0, calc.cal(3.0, 4.0, '+'), 1e-9);
    }

    @Test
    void testSubtraction() {
        assertEquals(1.0, calc.cal(3.0, 4.0, '-'), 1e-9); // b-a
    }

    @Test
    void testMultiplication() {
        assertEquals(12.0, calc.cal(3.0, 4.0, '*'), 1e-9);
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calc.cal(2.0, 4.0, '/'), 1e-9); // b/a
    }

    @Test
    void testDefaultOperator() {
        assertEquals(0.0, calc.cal(3.0, 4.0, 'x'), 1e-9);
    }

    @Test
    void testDivisionByZeroBehavior() {
        // This program does not guard division by zero; Java returns Infinity for doubles.
        assertTrue(Double.isInfinite(calc.cal(0.0, 4.0, '/')));
    }
}
