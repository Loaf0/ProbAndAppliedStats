package DealOrNoDealSim;

import java.util.Scanner;

public class DealOrNoDealSimulator {

    private int iterations;
    private int correctSwaps;
    private int correctNoSwaps;

    public DealOrNoDealSimulator(int newIterations){
        iterations = newIterations;
    }

    public void run(){
        Scanner input = new Scanner(System.in);
        int options = 0;

        System.out.print("Input Number of Doors : ");

        while(options <= 0){
            options = input.nextInt();
        }

        for(int i = 0; i < iterations; i++){
            DealOrNoDeal problem = new DealOrNoDeal(options);
            problem.generateCorrectDoor();
            if(problem.pickRandomDoor(true)){ //swapping
                correctSwaps += 1;
            }
        }

        for(int i = 0; i < iterations; i++){
            DealOrNoDeal problem = new DealOrNoDeal(options);
            problem.generateCorrectDoor();
            if(problem.pickRandomDoor(false)){ //swapping
                correctNoSwaps += 1;
            }
        }

        double correctSwapPercent = (double) correctSwaps / iterations;
        double correctNoSwapPercent = (double) correctNoSwaps / iterations;

        System.out.println("Chance when not swapping : " + correctNoSwapPercent);
        System.out.println("    Chance when swapping : " + correctSwapPercent);

    }

}
