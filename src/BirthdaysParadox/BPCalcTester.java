package BirthdaysParadox;

public class BPCalcTester {

    public static void main(String[] args){
        BPCalculator bpc = new BPCalculator();
        System.out.println("Probability : " + bpc.calculateProbability(23));
        System.out.println("  Factorial : " + bpc.factorial(3));
    }

}
