package Mass;

import Length.Length;
import Mass.Mass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MassTest {


    @Test
    public void test_when_compare_1kg_with_1000g() {
        Mass m1 = new Mass(1.0,MassUnit.KG);
        Mass m2 = new Mass(1000.0,MassUnit.G);
        assertEquals(m1,m2);
    }

    @Test
    public void test_when_compare_1g_with_1000mg() {
        Mass m1 = new Mass(1.0,MassUnit.G);
        Mass m2 = new Mass(100.0,MassUnit.MG);
        assertNotEquals(m1,m2);
    }

    @Test
    public void testWithBothMassesZero() {

        Mass m1 = new Mass(0.0,MassUnit.G);
        Mass m2 = new Mass(0.0,MassUnit.MG);
        assertEquals(m1,m2);
    }
    @Test
    public void test_add_two_lengths() {
        Mass m1 = new Mass(100.0,MassUnit.MG);
        Mass m2 = new Mass(0.0001,MassUnit.KG);
        assertEquals(new Mass(0.0002,MassUnit.KG), m1.add(m2));
    }

    @Test
    public void test_subtract_two_lengths() {
        Mass m1 = new Mass(1.2, MassUnit.KG);
        Mass m2 = new Mass(1200000.0, MassUnit.MG);
        assertEquals(new Mass(0.0,MassUnit.MG), m1.subtract(m2));
    }



}