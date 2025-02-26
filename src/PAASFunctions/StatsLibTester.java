package PAASFunctions;

import java.util.Arrays;

public class StatsLibTester {
    public static void main(String[] args) {

        StatsLibrary functions = new StatsLibrary();

        double[] doubleValues = {.904,.929,.901};

        System.out.println(functions.binomialDistribution(10, 4, .15));
//        System.out.println("Standard Deviation : " + functions.standardDeviation(doubleValues));
//        System.out.println("              Mean : " + functions.getMean(doubleValues));
//        System.out.println("              Mode : " + Arrays.toString(functions.getMode(doubleValues)));
//        System.out.println("            Median : " + functions.getMedian(doubleValues));
//        System.out.println("         Factorial : " + functions.bigFactorial(6));
//        System.out.println("      Permutations : " + functions.permutation(8, 3));
//        System.out.println("      Combinations : " + functions.combination(9, 5));

    }
}
