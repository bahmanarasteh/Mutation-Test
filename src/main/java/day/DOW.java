package day;

public class DOW {

    public static String dayofweek(String dd, String mm, String yyyy) {
        int dow_month[] = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int dow_month_leap[] = {6, 2};
        String C = yyyy.substring(0, 2); // century first 2 digit
        String yy = yyyy.substring(2, 4); // year last 2 digit
        int yy2digit = Integer.valueOf(yy); // year last 2 digit integer
        int month = Integer.valueOf(mm);
        int day = Integer.valueOf(dd);
        int century = Integer.valueOf(C);
        int dow_century = 2 * (3 - (century % 4));
        int dow_year = yy2digit + (yy2digit / 4);
        int sum = 0;

        if ((month == 1 || month == 2) &&
            (Integer.valueOf(yyyy) % 4 == 0 && Integer.valueOf(yyyy) % 100 != 0) ||
            (Integer.valueOf(yyyy) % 400 == 0)) {
            sum = dow_century + dow_year + dow_month_leap[month - 1] + day;
        } else {
            sum = dow_century + dow_year + dow_month[month - 1] + day;
        }

        int DOW = sum % 7;
        return weekday(DOW);
    }

    // Using Sakamoto Algorithm
    public static String dowUsingSakamotoAlg(String dd, String mm, String yyyy) {
        int year = Integer.valueOf(yyyy);
        int month = Integer.valueOf(mm);
        int day = Integer.valueOf(dd);
        int dow_month[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        year = year - (month < 3 ? 1 : 0);
        int dow = (year + year / 4 - year / 100 + year / 400 + dow_month[month - 1] + day) % 7;
        return weekday(dow);
    }

    // Map numeric day of week to name
    public static String weekday(int DOW) {
        String dow = "";
        switch (DOW) {
            case 0: dow = "Sunday"; break;
            case 1: dow = "Monday"; break;
            case 2: dow = "Tuesday"; break;
            case 3: dow = "Wednesday"; break;
            case 4: dow = "Thursday"; break;
            case 5: dow = "Friday"; break;
            case 6: dow = "Saturday"; break;
        }
        return dow;
    }
}
