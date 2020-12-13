package edu.ib;

public class Converter {
    public static String getStringCalculateValue(double calculateValue){
        int temp = (int) calculateValue;

        if(calculateValue - temp == 0)
            return String.valueOf(temp);

        return String.valueOf(calculateValue);
    }
}
