package ge.tbcitacademy.util;

public class NumberExtraction {
    public static double extractValue(String value){
        return Double.parseDouble(value.replaceAll("[^\\d.]+", ""));
    }
}
