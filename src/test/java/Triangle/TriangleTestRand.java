import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleRandomTest {

    private static final Random RND = new Random(42);

    @Test
    void randomTriangles() {

        for (int i = 0; i < 100; i++) {

            int a = RND.nextInt(20) - 5;  // includes negatives
            int b = RND.nextInt(20) - 5;
            int c = RND.nextInt(20) - 5;

            int result = Triangle.classify(a, b, c);

            // Weak checks: only ensure result is in valid range
            assertTrue(result >= 0 && result <= 3);
        }
    }

    @Test
    void oneSimpleCase() {
        assertEquals(1, Triangle.classify(3, 4, 5));
    }
}
