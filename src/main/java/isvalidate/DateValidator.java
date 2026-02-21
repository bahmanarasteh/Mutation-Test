package isvalidate;

/**
 * Simple Date Validator for mutation testing benchmarks.
 * Validates dates in Gregorian calendar.
 */
public class DateValidator {

    /**
     * Validates a date.
     *
     * @param day   day of month
     * @param month month (1-12)
     * @param year  year (>= 1)
     * @return true if valid date, false otherwise
     */
    public static boolean isValid(int day, int month, int year) {

        // Basic year validation
        if (year < 1) {
            return false;
        }

        // Month must be between 1 and 12
        if (month < 1 || month > 12) {
            return false;
        }

        // Day must be positive
        if (day < 1) {
            return false;
        }

        int maxDays;

        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                maxDays = 31;
                break;

            case 4: case 6: case 9: case 11:
                maxDays = 30;
                break;

            case 2:
                if (isLeapYear(year)) {
                    maxDays = 29;
                } else {
                    maxDays = 28;
                }
                break;

            default:
                return false; // defensive (should never reach)
        }

        return day <= maxDays;
    }

    /**
     * Determines whether a year is a leap year.
     *
     * Leap year rule:
     * - divisible by 4
     * - but not divisible by 100
     * - unless divisible by 400
     */
    private static boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        }

        if (year % 100 == 0) {
            return false;
        }

        return year % 4 == 0;
    }
}
