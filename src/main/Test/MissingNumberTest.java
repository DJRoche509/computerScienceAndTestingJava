package main.Test;

import main.java.MissingNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MissingNumberTest {
    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingThree = { 1, 2, 4, 5, 6, 7, 8, 9, 10 };
    private MissingNumber mn = new MissingNumber();

    @Test
    public void testMissingNumber_MissingMax() {
        assertEquals(10, mn.missingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing() {
        assertEquals(0, mn.missingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven() {
        assertEquals(3, mn.missingNumber(missingThree, 10));
    }
}
