package BirthdaysParadox;

/*
 *  @description Birthday Paradox Calculator
 *  @author Tyler Snyder
 */

public class BPCalculator {

    public double calculateProbability(int p){
        int possibleDays = 365;
        return factorial(possibleDays) / factorial(possibleDays - p);
    }

    public double factorial(int x){
        double output = x;
        for(int i = x-1; i > 0; i--){
            output = output * i;
        }
        return output;
    }

}
