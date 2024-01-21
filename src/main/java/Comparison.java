import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Comparison {
    static String selectDimensions(String userValue){

        userValue = userValue.toLowerCase();
        MeasurementUnits units = new MeasurementUnits();
        for(String unit : units.units){
            if(unit.equals(userValue))return userValue;
        }
        return "Select correct dimension";
    }

    static Double convertLengthToMM(Double length, String userValue){

        switch(userValue){
            case "cm":
                return length * 10;
            case "m":
                return length * 1000;
            case "km":
                return length * 1000000;
            default:
                return length;
        }

    }
    static Double convertLengthToCM(Double length, String userValue){

        switch(userValue){
            case "mm":
                return length/10;
            case "m":
                return length * 100;
            case "km":
                return length * 100000;
            default:
                return length;
        }

    }
    static Double convertLengthToM(Double length, String userValue){

        switch(userValue){
            case "cm":
                return length/100;
            case "mm":
                return length/1000;
            case "km":
                return length * 1000;
            default:
                return length;
        }

    }
    static Double convertLengthToKM(Double length, String userValue){
        switch(userValue){
            case "cm":
                return length/100000;
            case "mm":
                return length/1000000;
            case "m":
                return length/1000;
            default:
                return length;
        }

    }
    static Boolean comparison(Pair<Double,String> p1,Pair<Double,String> p2){

        System.out.println(p1.getKey() + p1.getValue());
        System.out.println(p2.getKey() + p2.getValue());

        String dimension1 = selectDimensions(p1.getValue());
        String dimension2 = selectDimensions(p2.getValue());

        if(dimension1.equals("Select correct dimension") || dimension2.equals("Select correct dimension")){
            System.out.println("Invalid Dimensions can't compare");
            return false;
        }

        Double convertedLength = 0.0;
        if(p1.getKey() == 0 && p2.getKey() == 0) return true;
        else if(p1.getKey() < 0 || p2.getKey() < 0) return false;
        else{
            if(dimension2.equals("mm")){

                convertedLength = convertLengthToMM(p1.getKey(),dimension1);

            } else if (dimension2.equals("cm")) {

                convertedLength = convertLengthToCM(p1.getKey(),dimension1);

            } else if (dimension2.equals("m")) {

                convertedLength = convertLengthToM(p1.getKey(),dimension1);

            } else if (dimension2.equals("km")) {

                convertedLength = convertLengthToKM(p1.getKey(),dimension1);

            } else {
                return false;
            }
            return Objects.equals(convertedLength, p2.getKey());
        }
    }
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        Scanner y = new Scanner(System.in);

        ArrayList<Pair<Double,String> > list = new ArrayList<Pair<Double,String>>();

        for(int i=1;i<=2;i++){

            System.out.printf("Enter Lenght%d : ",i);
            Double Length = x.nextDouble();

            System.out.print("Enter dimension : ");

            String selectedDimension = y.nextLine();

            list.add(new Pair<Double,String>(Length,selectedDimension));
        }

        System.out.println(comparison(list.get(0),list.get(1)));

    }
}


// user select dimension - as of now 3 test
// enter length check  - null or 0 or -ve , string checks
// comparison lengths -