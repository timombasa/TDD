package test;

import main.Dollar;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5, "USD");
        assertEquals(new Dollar(10, "USD"), five.times(2));
        assertEquals(new Dollar(15, "USD"), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
        assertFalse(new Dollar(5, "USD").equals(new Dollar(6, "USD")));
    }
}
