package isvalidate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Stronger test suite:
 * - covers typical valid dates
 * - invalid months/days
 * - month length differences
 * - leap year logic (incl. century rules)
 * - boundary values
 *
 * This should produce a much better mutation score.
 */
class DateValidatorGoodTest {

    @Test
    void validTypicalDates() {
        assertTrue(DateValidator.isValid(15, 1, 2024)); // Jan 15
        assertTrue(DateValidator.isValid(30, 4, 2024)); // Apr 30
        assertTrue(DateValidator.isValid(31, 7, 2024)); // Jul 31
    }

    @Test
    void invalidMonthValues() {
        assertFalse(DateValidator.isValid(1, 0, 2024));
        assertFalse(DateValidator.isValid(1, 13, 2024));
        assertFalse(DateValidator.isValid(1, -1, 2024));
    }

    @Test
    void invalidDayValues() {
        assertFalse(DateValidator.isValid(0, 1, 2024));
        assertFalse(DateValidator.isValid(-5, 1, 2024));
        assertFalse(DateValidator.isValid(32, 1, 2024)); // Jan has max 31
    }

    @Test
    void monthWith30Days() {
        // April, June, September, November have 30 days
        assertTrue(DateValidator.isValid(30, 4, 2024));
        assertFalse(DateValidator.isValid(31, 4, 2024));

        assertTrue(DateValidator.isValid(30, 6, 2024));
        assertFalse(DateValidator.isValid(31, 6, 2024));

        assertTrue(DateValidator.isValid(30, 9, 2024));
        assertFalse(DateValidator.isValid(31, 9, 2024));

        assertTrue(DateValidator.isValid(30, 11, 2024));
        assertFalse(DateValidator.isValid(31, 11, 2024));
    }

    @Test
    void monthWith31Days() {
        // Jan, Mar, May, Jul, Aug, Oct, Dec have 31 days
        assertTrue(DateValidator.isValid(31, 1, 2024));
        assertTrue(DateValidator.isValid(31, 3, 2024));
        assertTrue(DateValidator.isValid(31, 5, 2024));
        assertTrue(DateValidator.isValid(31, 7, 2024));
        assertTrue(DateValidator.isValid(31, 8, 2024));
        assertTrue(DateValidator.isValid(31, 10, 2024));
        assertTrue(DateValidator.isValid(31, 12, 2024));

        // Day 32 should be invalid everywhere
        assertFalse(DateValidator.isValid(32, 12, 2024));
    }

    @Test
    void februaryNonLeapYear() {
        assertTrue(DateValidator.isValid(28, 2, 2023));
        assertFalse(DateValidator.isValid(29, 2, 2023));
        assertFalse(DateValidator.isValid(30, 2, 2023));
    }

    @Test
    void februaryLeapYearTypical() {
        // 2024 is a leap year
        assertTrue(DateValidator.isValid(29, 2, 2024));
        assertFalse(DateValidator.isValid(30, 2, 2024));
    }

    @Test
    void leapYearCenturyRules() {
        // 1900 is NOT a leap year (divisible by 100 but not by 400)
        assertFalse(DateValidator.isValid(29, 2, 1900));
        assertTrue(DateValidator.isValid(28, 2, 1900));

        // 2000 IS a leap year (divisible by 400)
        assertTrue(DateValidator.isValid(29, 2, 2000));
        assertFalse(DateValidator.isValid(30, 2, 2000));
    }

    @Test
    void boundaries() {
        // Common boundaries that often hide off-by-one mutants
        assertTrue(DateValidator.isValid(1, 1, 1970));
        assertTrue(DateValidator.isValid(31, 12, 2024));

        assertFalse(DateValidator.isValid(31, 9, 2024));  // Sep has 30
        assertFalse(DateValidator.isValid(29, 2, 2100));  // 2100 is not leap (century not /400)
    }
}
