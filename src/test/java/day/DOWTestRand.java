package day;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekRandomTest {

    private static final Random RND = new Random(42);

    @Test
    void randomDates() {
        for (int i = 0; i < 50; i++) {

            int year = 1900 + RND.nextInt(200);
            int month = 1 + RND.nextInt(12);

            int day = 1 + RND.nextInt(
                    LocalDate.of(year, month, 1).lengthOfMonth()
            );

            int expected = LocalDate.of(year, month, day)
                    .getDayOfWeek()
                    .getValue(); // 1=Monday ... 7=Sunday

            int actual = DayOfWeek.getDayOfWeek(day, month, year);

            assertEquals(expected, actual);
        }
    }
}
