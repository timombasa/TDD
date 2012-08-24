package test;

import main.Franc;
import org.junit.Test;

import static junit.framework.Assert.*;

public class FrancTest {

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5, "CHF");
        assertEquals(new Franc(10, "CHF"), five.times(2));
        assertEquals(new Franc(15, "CHF"), five.times(3));
    }

        @Test
    public void testEquality() {
        assertTrue(new Franc(5, "CHF").equals(new Franc(5, "CHF")));
        assertFalse(new Franc(5, "CHF").equals(new Franc(6, "CHF")));
    }
}
