package remainder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemainderTest {

    @Test
    void testPositiveNumbers() {
        assertEquals(1, Remainder.compute(10, 3));
        assertEquals(2, Remainder.compute(14, 4));
        assertEquals(0, Remainder.compute(9, 3));
    }

    @Test
    void testNegativeDividend() {
        assertEquals(-1, Remainder.compute(-10, 3));
        assertEquals(-2, Remainder.compute(-14, 4));
        assertEquals(0, Remainder.compute(-9, 3));
    }

    @Test
    void testNegativeDivisor() {
        assertEquals(1, Remainder.compute(10, -3));
        assertEquals(2, Remainder.compute(14, -4));
    }

    @Test
    void testBothNegative() {
        assertEquals(-1, Remainder.compute(-10, -3));
        assertEquals(-2, Remainder.compute(-14, -4));
    }

    @Test
    void testDividendSmallerThanDivisor() {
        assertEquals(2, Remainder.compute(2, 5));
        assertEquals(-2, Remainder.compute(-2, 5));
    }

    @Test
    void testZeroDividend() {
        assertEquals(0, Remainder.compute(0, 5));
        assertEquals(0, Remainder.compute(0, -5));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> Remainder.compute(10, 0)
        );

        assertEquals("Division by zero", exception.getMessage());
    }
}
