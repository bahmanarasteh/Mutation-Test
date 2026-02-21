package day;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekGoodTest {

    @Test
    void knownReferenceDates() {
        // 1 Jan 2000 was Saturday (6)
        assertEquals(6, DayOfWeek.getDayOfWeek(1, 1, 2000));

        // 29 Feb 2024 is Thursday (4)
        assertEquals(4, DayOfWeek.getDayOfWeek(29, 2, 2024));

        // 15 Aug 1947 was Friday (5)
        assertEquals(5, DayOfWeek.getDayOfWeek(15, 8, 1947));

        // 1 Jan 1970 was Thursday (4)
        assertEquals(4, DayOfWeek.getDayOfWeek(1, 1, 1970));
    }

    @Test
    void leapYearChecks() {
        // 29 Feb valid in leap year
        assertEquals(3, DayOfWeek.getDayOfWeek(29, 2, 2012)); // Wednesday

        // 28 Feb in non-leap year
        assertEquals(1, DayOfWeek.getDayOfWeek(28, 2, 2022)); // Monday
    }

    @Test
    void monthTransitions() {
        assertEquals(
                DayOfWeek.getDayOfWeek(31, 1, 2023),
                2 // 31 Jan 2023 was Tuesday
        );

        assertEquals(
                DayOfWeek.getDayOfWeek(1, 2, 2023),
                3 // 1 Feb 2023 was Wednesday
        );
    }

    @Test
    void centuryRules() {
        // 1 Jan 1900 was Monday (1)
        assertEquals(1, DayOfWeek.getDayOfWeek(1, 1, 1900));

        // 1 Jan 2000 was Saturday (6)
        assertEquals(6, DayOfWeek.getDayOfWeek(1, 1, 2000));
    }

    @Test
    void boundaryDates() {
        assertEquals(7, DayOfWeek.getDayOfWeek(31, 12, 2023)); // Sunday
        assertEquals(1, DayOfWeek.getDayOfWeek(1, 1, 2024));   // Monday
    }
}
