package isvalidate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateValidatorTest {

    @Test
    void invalidWhenYearNonPositive() {
        assertFalse(DateValidator.isValidate(1, 1, 0));
        assertFalse(DateValidator.isValidate(1, 1, -2024));
    }

    @Test
    void invalidWhenMonthOutOfRange() {
        assertFalse(DateValidator.isValidate(1, 0, 2024));
        assertFalse(DateValidator.isValidate(1, 13, 2024));
    }

    @Test
    void invalidWhenDayLessThanOne() {
        assertFalse(DateValidator.isValidate(0, 1, 2024));
        assertFalse(DateValidator.isValidate(-5, 1, 2024));
    }

    @Test
    void validForTypicalDates() {
        assertTrue(DateValidator.isValidate(15, 8, 2024));
        assertTrue(DateValidator.isValidate(31, 1, 2024));
        assertTrue(DateValidator.isValidate(30, 4, 2024));
    }

    @Test
    void invalidWhenDayExceedsMonthMaximum() {
        assertFalse(DateValidator.isValidate(31, 4, 2024)); // April has 30
        assertFalse(DateValidator.isValidate(31, 6, 2024)); // June has 30
        assertFalse(DateValidator.isValidate(32, 1, 2024)); // Jan has 31
    }

    @Test
    void februaryNonLeapYearRules() {
        assertTrue(DateValidator.isValidate(28, 2, 2019));
        assertFalse(DateValidator.isValidate(29, 2, 2019));
    }

    @Test
    void februaryLeapYearRules_divisibleBy4NotBy100() {
        assertTrue(DateValidator.isValidate(29, 2, 2020));
        assertFalse(DateValidator.isValidate(30, 2, 2020));
    }

    @Test
    void februaryCenturyYearNotLeapUnlessDivisibleBy400() {
        assertFalse(DateValidator.isValidate(29, 2, 1900)); // not leap
        assertTrue(DateValidator.isValidate(29, 2, 2000));  // leap
    }

    @Test
    void boundaryDaysPerMonth() {
        // 30-day months
        assertTrue(DateValidator.isValidate(30, 9, 2024));
        assertFalse(DateValidator.isValidate(31, 9, 2024));

        // 31-day months
        assertTrue(DateValidator.isValidate(31, 10, 2024));
        assertFalse(DateValidator.isValidate(32, 10, 2024));
    }
}
