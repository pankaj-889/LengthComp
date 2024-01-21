import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class ComparisonTest {

    @Test
    public void testWithEmptyDimension() {
        String expectedValue = "Select correct dimension";
        String userValue = "";
        assertEquals(expectedValue, Comparison.selectDimensions(userValue));
    }

    @Test
    public void testWithNumbericDimension() {
        String expectedValue = "Select correct dimension";
        String userValue = "123";
        assertEquals(expectedValue, Comparison.selectDimensions(userValue));


    }

    @Test
    public void testWithInvalidDimension() {
        String expectedValue = "Select correct dimension";
        String userValue = "L";
        assertEquals(expectedValue, Comparison.selectDimensions(userValue));

    }

    @Test
    public void testUppercaseDimension() {
        String expectedValue = "km";
        String userValue = "KM";
        assertEquals(expectedValue, Comparison.selectDimensions(userValue));

    }

    @Test
    public void testValidDimension() {
        String expectedValue = "mm";
        String userValue = "mm";
        assertEquals(expectedValue, Comparison.selectDimensions(userValue));

    }

    @Test
    public void testWithNegativeLength() {
        Boolean expectedValue = false;
        Pair<Double,String> p1 = new Pair<>(-1.1,"cm");
        Pair<Double,String> p2 = new Pair<>(1.1,"Cm");
        assertEquals(expectedValue, Comparison.comparison(p1,p2));
    }

    @Test
    public void testWithBothValueZero() {
        Boolean expectedValue = true;
        Pair<Double,String> p1 = new Pair<>(0.0,"cm");
        Pair<Double,String> p2 = new Pair<>(0.0,"Cm");
        assertEquals(expectedValue, Comparison.comparison(p1,p2));
    }

    @Test
    public void testWithSingleValueZero() {
        Boolean expectedValue = false;
        Pair<Double,String> p1 = new Pair<>(10.0,"cm");
        Pair<Double,String> p2 = new Pair<>(0.0,"Cm");
        assertEquals(expectedValue, Comparison.comparison(p1,p2));
    }

    @Test
    public void test_When_Length_are_not_equal() {
        Boolean expectedValue = false;
        Pair<Double,String> p1 = new Pair<>(10.0,"km");
        Pair<Double,String> p2 = new Pair<>(20.0,"Cm");
        assertEquals(expectedValue, Comparison.comparison(p1,p2));
    }

    @Test
    public void test_When_Length_are_equal() {
        Boolean expectedValue = true;
        Pair<Double,String> p1 = new Pair<>(12323.0,"cm");
        Pair<Double,String> p2 = new Pair<>(0.12323,"km");
        assertEquals(expectedValue, Comparison.comparison(p1,p2));
    }

    @Test
    public void test_convertLengthToMM() {
        Double expectedValue = 1000000.0;
        assertEquals(expectedValue, Comparison.convertLengthToMM(1.0,"km"));
        assertEquals(expectedValue, Comparison.convertLengthToMM(1000.0,"m"));
        assertEquals(expectedValue, Comparison.convertLengthToMM(100000.0,"cm"));
    }

    @Test
    public void test_convertLengthToCM() {
        Double expectedValue = 100000.0;
        assertEquals(expectedValue, Comparison.convertLengthToCM(1.0,"km"));
        assertEquals(expectedValue, Comparison.convertLengthToCM(1000.0,"m"));
        assertEquals(expectedValue, Comparison.convertLengthToCM(1000000.0,"mm"));
    }

    @Test
    public void test_convertLengthToM() {
        Double expectedValue = 1000.0;
        assertEquals(expectedValue, Comparison.convertLengthToM(1.0,"km"));
        assertEquals(expectedValue, Comparison.convertLengthToM(100000.0,"cm"));
        assertEquals(expectedValue, Comparison.convertLengthToM(1000000.0,"mm"));
    }

    @Test
    public void test_convertLengthToKM() {
        Double expectedValue = 1.0;
        assertEquals(expectedValue, Comparison.convertLengthToKM(1000.0,"m"));
        assertEquals(expectedValue, Comparison.convertLengthToKM(100000.0,"cm"));
        assertEquals(expectedValue, Comparison.convertLengthToKM(1000000.0,"mm"));
    }



}