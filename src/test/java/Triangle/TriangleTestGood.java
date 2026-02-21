import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleGoodTest {

    @Test
    void invalid_when_any_side_non_positive() {
        assertEquals(0, Triangle.classify(0, 2, 3));
        assertEquals(0, Triangle.classify(1, 0, 3));
        assertEquals(0, Triangle.classify(1, 2, 0));
        assertEquals(0, Triangle.classify(-1, 2, 3));
    }

    @Test
    void invalid_when_triangle_inequality_violated() {
        assertEquals(0, Triangle.classify(1, 2, 10));
        assertEquals(0, Triangle.classify(1, 10, 2));
        assertEquals(0, Triangle.classify(10, 1, 2));

        // Boundary violation
        assertEquals(0, Triangle.classify(1, 1, 2));
        assertEquals(0, Triangle.classify(2, 1, 1));
        assertEquals(0, Triangle.classify(1, 2, 1));
    }

    @Test
    void scalene_triangle() {
        assertEquals(1, Triangle.classify(4, 5, 6));
        assertEquals(1, Triangle.classify(3, 4, 5));
        assertEquals(1, Triangle.classify(7, 8, 9));
    }

    @Test
    void isosceles_triangle() {
        assertEquals(2, Triangle.classify(5, 5, 6));
        assertEquals(2, Triangle.classify(5, 6, 5));
        assertEquals(2, Triangle.classify(6, 5, 5));
    }

    @Test
    void equilateral_triangle() {
        assertEquals(3, Triangle.classify(5, 5, 5));
        assertEquals(3, Triangle.classify(10, 10, 10));
    }

    @Test
    void boundary_values() {
        assertEquals(1, Triangle.classify(2, 3, 4));
        assertEquals(2, Triangle.classify(2, 2, 3));
        assertEquals(0, Triangle.classify(Integer.MAX_VALUE, 1, 1));
    }
}
