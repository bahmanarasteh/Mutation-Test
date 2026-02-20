package remainder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RemainderTest {

    @Test
    void throwsException_whenDivisorIsZero() {
        assertThrows(ArithmeticException.class, () -> Remainder.compute(10, 0));
    }

    @Test
    void remainder_basicPositiveNumbers() {
        assertEquals(1, Remainder.compute(10, 3));
        assertEquals(0, Remainder.compute(10, 5));
        assertEquals(2, Remainder.compute(8, 3));
    }

    @Test
    void remainder_whenDividendIsZero() {
        assertEquals(0, Remainder.compute(0, 7));
    }

    @Test
    void remainder_withNegativeDividend() {
        assertEquals(-1, Remainder.compute(-10, 3));
        assertEquals(-2, Remainder.compute(-8, 3));
    }

    @Test
    void remainder_withNegativeDivisor() {
        // divisor sign should not affect remainder magnitude in this implementation
        assertEquals(1, Remainder.compute(10, -3));
        assertEquals(-1, Remainder.compute(-10, -3));
    }

    @Test
    void remainder_edgeCases() {
        assertEquals(0, Remainder.compute(Integer.MIN_VALUE, 1));
        assertEquals(0, Remainder.compute(Integer.MIN_VALUE, -1));
        assertEquals(0, Remainder.compute(1, Integer.MAX_VALUE));
    }
}
