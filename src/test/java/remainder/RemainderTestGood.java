package remainder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Strong systematic test suite.
 * Designed to achieve high mutation coverage.
 */
class RemainderGoodTest {

    @Test
    void positiveCases() {
        assertEquals(1, Remainder.compute(10, 3));
        assertEquals(2, Remainder.compute(14, 4));
        assertEquals(0, Remainder.compute(9, 3));
    }

    @Test
    void negativeDividend() {
        assertEquals(-1, Remainder.compute(-10, 3));
        assertEquals(-2, Remainder.compute(-14, 4));
        assertEquals(0, Remainder.compute(-9, 3));
    }

    @Test
    void negativeDivisor() {
        assertEquals(1, Remainder.compute(10, -3));
        assertEquals(2, Remainder.compute(14, -4));
    }

    @Test
    void bothNegative() {
        assertEquals(-1, Remainder.compute(-10, -3));
        assertEquals(-2, Remainder.compute(-14, -4));
    }

    @Test
    void zeroDividend() {
        assertEquals(0, Remainder.compute(0, 5));
        assertEquals(0, Remainder.compute(0, -5));
    }

    @Test
    void dividendLessThanDivisor() {
        assertEquals(2, Remainder.compute(2, 5));
        assertEquals(-2, Remainder.compute(-2, 5));
    }

    @Test
    void divisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> Remainder.compute(10, 0));
    }

    @Test
    void boundaryValues() {
        assertEquals(Integer.MAX_VALUE % 3,
                Remainder.compute(Integer.MAX_VALUE, 3));

        assertEquals(Integer.MIN_VALUE % 7,
                Remainder.compute(Integer.MIN_VALUE, 7));
    }
}
