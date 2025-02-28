package PAASFunctions;

/*
 *  @description A Collection of statistics functions
 *  @author Tyler Snyder
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StatsLibrary {

    public double[] getMode(double[] input) {
        HashMap<Double, Integer> countMap = new HashMap<>();
        int count = 0;
        double largestValue = 0;
        ArrayList<Double> tiedModes = new ArrayList<>();
        countMap.put(largestValue, count); // make sure there exist a default value in map

        for (double cur : input) {
            count = countMap.containsKey(cur) ? countMap.get(cur) + 1 : 1;
            int highestCount = countMap.get(largestValue);
            if (count > highestCount) {
                largestValue = cur;
                tiedModes = new ArrayList<>();
                tiedModes.add(largestValue);
            }
            countMap.put(cur, count);
            if (count == highestCount) {
                tiedModes.add(cur);
            }
        }

        double[] output = new double[tiedModes.size()];
        for(int i = 0; i < tiedModes.size(); i++){
            output[i] = tiedModes.get(i);
        }

        return output;
    }

    public double getMedian(double[] input) {
        double[] sorted = Arrays.stream(input).sorted().toArray();
        System.out.println(Arrays.toString(sorted));
        double median;
        int middle = (int) Math.floor((double) sorted.length / 2);
        if (sorted.length % 2 == 0)
            median = (sorted[middle] + sorted[middle - 1]) / 2;
        else
            median = sorted[middle];
        return median;
    }

    public double getMean(double[] input) {
        double total = 0;
        for (double i : input)
            total += i;

        return total / input.length;
    }

    public double standardDeviation(double[] input) {
        if (input.length <= 1) // Handle 1 and 0
            return 0;

        double sum = 0;
        for (double value : input) {
            sum += value;
        }

        double mean = sum / input.length;

        double deviation;

        sum = 0;
        for (double v : input) {
            deviation = Math.pow(v - mean, 2);
            sum += deviation;
        }

        double variance = sum / (input.length - 1);

        return Math.sqrt(variance);
    }

    public double factorial(int x){
        double output = x;
        for(int i = x-1; i > 0; i--){
            output *= i;
        }
        return output;
    }

    public BigInteger bigFactorial(int x){
        BigInteger output = BigInteger.valueOf(x);
        for(int i = x-1; i > 0; i--){
            output = output.multiply(BigInteger.valueOf(i));
        }
        return output;
    }

    public BigInteger combination(int n, int r){
        BigInteger num = bigFactorial(n);
        BigInteger den = bigFactorial(r).multiply(bigFactorial(n-r));
        return num.divide(den);
    }

    public BigInteger permutation(int n, int r){
        BigInteger num = bigFactorial(n);
        BigInteger den = bigFactorial(n-r);
        return num.divide(den);
    }

    public double binomialDistribution(int numOfTrials, int desiredAmount, double probOfSuccess){
        return combination(numOfTrials, desiredAmount).intValue() * Math.pow(probOfSuccess, desiredAmount) * Math.pow(1 - probOfSuccess, numOfTrials - desiredAmount);
    }

    public double geometricDistribution(double probOfSuccess, double iterations){
        return Math.pow(probOfSuccess, (iterations - 1)) * (1 - probOfSuccess);
    }

}