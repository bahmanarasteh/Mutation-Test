package cal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorGoodTest {

    private final Calculator calc = new Calculator();

    @Test
    void plusOperator() {
        assertEquals(7.0, calc.cal(3.0, 4.0, '+'), 1e-9);
        assertEquals(-1.5, calc.cal(2.5, 1.0, '+'), 1e-9);
    }

    @Test
    void minusOperator() {
        // IMPORTANT: your implementation is b - a (not a - b)
        assertEquals(1.0, calc.cal(3.0, 4.0, '-'), 1e-9);     // 4 - 3
        assertEquals(-7.0, calc.cal(10.0, 3.0, '-'), 1e-9);   // 3 - 10
    }

    @Test
    void multiplyOperator() {
        assertEquals(12.0, calc.cal(3.0, 4.0, '*'), 1e-9);
        assertEquals(-10.0, calc.cal(-2.0, 5.0, '*'), 1e-9);
        assertEquals(0.0, calc.cal(100.0, 0.0, '*'), 1e-9);
    }

    @Test
    void divideOperator() {
        // Implementation is b / a (not a / b)
        assertEquals(2.0, calc.cal(2.0, 4.0, '/'), 1e-9);     // 4 / 2
        assertEquals(-2.0, calc.cal(2.0, -4.0, '/'), 1e-9);   // -4 / 2
        assertEquals(0.5, calc.cal(4.0, 2.0, '/'), 1e-9);     // 2 / 4
    }

    @Test
    void divideByZeroBehavior() {
        // With doubles, division by zero does NOT throw ArithmeticException.
        // b / 0.0 -> +/- Infinity, and 0.0 / 0.0 -> NaN

        assertTrue(Double.isInfinite(calc.cal(0.0, 5.0, '/')));
        assertEquals(Double.POSITIVE_INFINITY, calc.cal(0.0, 5.0, '/'));

        assertTrue(Double.isInfinite(calc.cal(0.0, -5.0, '/')));
        assertEquals(Double.NEGATIVE_INFINITY, calc.cal(0.0, -5.0, '/'));

        assertTrue(Double.isNaN(calc.cal(0.0, 0.0, '/')));
    }

    @Test
    void defaultOperatorReturnsZero() {
        assertEquals(0.0, calc.cal(3.0, 4.0, '%'), 1e-9);
        assertEquals(0.0, calc.cal(3.0, 4.0, 'x'), 1e-9);
    }
}
