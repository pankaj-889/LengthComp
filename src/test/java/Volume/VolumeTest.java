package Volume;

import Volume.Volume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VolumeTest {

    @Test
    public void test_when_compare_1l_with_100ml() {
        Volume m1 = new Volume(1.0, VolumeUnit.L);
        Volume m2 = new Volume(100.0, VolumeUnit.ML);
        assertNotEquals(m1,m2);
    }

    @Test
    public void test_when_compare_1l_with_10000ml() {
        Volume m1 = new Volume(1.0, VolumeUnit.L);
        Volume m2 = new Volume(1000.0, VolumeUnit.ML);
        assertEquals(m1,m2);
    }

    @Test
    public void testWithBothVolumeesZero() {

        Volume m1 = new Volume(0.0, VolumeUnit.ML);
        Volume m2 = new Volume(0.0, VolumeUnit.ML);
        assertEquals(m1,m2);
    }
    @Test
    public void test_add_two_Volume() {
        Volume m1 = new Volume(1.0, VolumeUnit.L);
        Volume m2 = new Volume(50.0, VolumeUnit.ML);
        assertEquals(new Volume(1050.0, VolumeUnit.ML), m1.add(m2));
    }

    @Test
    public void test_subtract_1l_from_500ml() {
        Volume m1 = new Volume(1.0, VolumeUnit.ML);
        Volume m2 = new Volume(500.0, VolumeUnit.ML);
        assertNotEquals(new Volume(0.0, VolumeUnit.ML), m1.subtract(m2));
    }

    @Test
    public void test_subtract_500ml_from_1l() {
        Volume m1 = new Volume(1.0, VolumeUnit.L);
        Volume m2 = new Volume(500.0, VolumeUnit.ML);
        assertEquals(new Volume(500.0, VolumeUnit.ML), m1.subtract(m2));
    }
}
