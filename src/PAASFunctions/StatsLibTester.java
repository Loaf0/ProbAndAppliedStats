package PAASFunctions;

import java.util.Arrays;

public class StatsLibTester {
    public static void main(String[] args) {

        StatsLibrary functions = new StatsLibrary();

        double[] doubleValues = {46, 69, 32, 60, 52, 41, 70, 52};
        //double[] doubleValues = {68,80,72,78,84,82,82,63,80,80,68,66,68,64,78,80,80,75,80,52};
        //double[] doubleValues = {80,80,80,80,85,80,75,80,86,84,85,88,80,68,72,64,91,96,98,92,86};

        System.out.println("Standard Deviation : " + functions.standardDeviation(doubleValues));
//        System.out.println("              Mean : " + functions.getMean(doubleValues));
//        System.out.println("              Mode : " + Arrays.toString(functions.getMode(doubleValues)));
//        System.out.println("            Median : " + functions.getMedian(doubleValues));
//        System.out.println("         Factorial : " + functions.bigFactorial(6));
//        System.out.println("      Permutations : " + functions.permutation(8, 3));
//        System.out.println("      Combinations : " + functions.combination(9, 5));

    }
}
