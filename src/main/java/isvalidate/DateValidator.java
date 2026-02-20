package isvalidate;

public class DateValidator {

    // Checks if (day, month, year) is a valid Gregorian date
    public static boolean isValidate(int day, int month, int year) {

        if (year <= 0) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1) {
            return false;
        }

        int maxDay = daysInMonth(month, year);

        if (day > maxDay) {
            return false;
        }

        return true;
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 1:  return 31;
            case 2:  return isLeapYear(year) ? 29 : 28;
            case 3:  return 31;
            case 4:  return 30;
            case 5:  return 31;
            case 6:  return 30;
            case 7:  return 31;
            case 8:  return 31;
            case 9:  return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return 0; // unreachable due to month check
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}
