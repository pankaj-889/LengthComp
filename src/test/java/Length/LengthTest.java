package Length;

import Length.Length;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LengthTest {


    @Test
    public void testWhenCompare100cm_With_1m() {
        Length p1 = new Length(1.0,LengthUnit.M);
        Length p2 = new Length(1.0,LengthUnit.M);
        assertEquals(p1,p2);
    }

    @Test
    public void testWhenLength_are_not_equal() {

        Length p1 = new Length(1.0,LengthUnit.MM);
        Length p2 = new Length(10.0,LengthUnit.M);
        assertNotEquals(p1,p2);
    }

    @Test
    public void test_When_Length_are_equal() {

        Length p1 = new Length(10.0,LengthUnit.CM);
        Length p2 = new Length(10.0,LengthUnit.CM);
        assertEquals(p1,p2);
    }

    @Test
    public void testWithBothLengthsZero() {

        Length p1 = new Length(0.0,LengthUnit.CM);
        Length p2 = new Length(0.0,LengthUnit.MM);
        assertEquals(p1,p2);
    }

    @Test
    public void testWithSingleLengthZero() {

        Length p1 = new Length(1.0,LengthUnit.KM);
        Length p2 = new Length(0.0,LengthUnit.M);
        assertNotEquals(p1,p2);
    }

    @Test
    public void test_add_two_lengths() {
        Length p1 = new Length(1.0,LengthUnit.KM);
        Length p2 = new Length(100000.0,LengthUnit.CM);
        assertEquals(new Length(200000.0,LengthUnit.CM), p1.add(p2));
    }

    @Test
    public void test_subtract_two_lengths() {
        Length p1 = new Length(1.2,LengthUnit.KM);
        Length p2 = new Length(120000.0,LengthUnit.CM);
        assertEquals(new Length(0.0,LengthUnit.CM), p1.subtract(p2));
    }





}