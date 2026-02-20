package day;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DOWTest {

    @Test
    void testKnownDate_2000_01_01() {
        // 2000-01-01 was Saturday
        assertEquals("Saturday", DOW.dayofweek("01", "01", "2000"));
        assertEquals("Saturday", DOW.dowUsingSakamotoAlg("01", "01", "2000"));
    }

    @Test
    void testKnownDate_2020_02_29_leapDay() {
        // 2020-02-29 was Saturday
        assertEquals("Saturday", DOW.dayofweek("29", "02", "2020"));
        assertEquals("Saturday", DOW.dowUsingSakamotoAlg("29", "02", "2020"));
    }

    @Test
    void testKnownDate_2021_03_01() {
        // 2021-03-01 was Monday
        assertEquals("Monday", DOW.dayofweek("01", "03", "2021"));
        assertEquals("Monday", DOW.dowUsingSakamotoAlg("01", "03", "2021"));
    }

    @Test
    void algorithmsShouldMatch_onMultipleDates() {
        String[][] dates = {
                {"15", "08", "1947"},
                {"31", "12", "1999"},
                {"01", "01", "2010"},
                {"28", "02", "2019"},
                {"01", "03", "2019"},
                {"28", "02", "2020"},
                {"01", "03", "2020"}
        };

        for (String[] d : dates) {
            String d1 = DOW.dayofweek(d[0], d[1], d[2]);
            String d2 = DOW.dowUsingSakamotoAlg(d[0], d[1], d[2]);
            assertEquals(d2, d1, "Mismatch for date: " + String.join("-", d));
        }
    }

    @Test
    void weekdayMappingCoversAllCases() {
        assertEquals("Sunday", DOW.weekday(0));
        assertEquals("Monday", DOW.weekday(1));
        assertEquals("Tuesday", DOW.weekday(2));
        assertEquals("Wednesday", DOW.weekday(3));
        assertEquals("Thursday", DOW.weekday(4));
        assertEquals("Friday", DOW.weekday(5));
        assertEquals("Saturday", DOW.weekday(6));
    }
}
