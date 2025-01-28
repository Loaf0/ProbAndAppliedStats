package PAASFunctions;

import java.util.Arrays;

public class StatsLibTester {
    public static void main(String[] args) {

        StatsLibrary functions = new StatsLibrary();

        double[] doubleValues = {46, 69, 32, 60, 52, 41, 46};

        System.out.println("Standard Deviation : " + functions.standardDeviation(doubleValues));
        System.out.println("              Mean : " + functions.getMean(doubleValues));
        System.out.println("              Mode : " + Arrays.toString(functions.getMode(doubleValues)));
        System.out.println("            Median : " + functions.getMedian(doubleValues));

    }
}
