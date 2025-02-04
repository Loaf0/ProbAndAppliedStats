package DealOrNoDealSim;

public class DealOrNoDealSimulator {

    private int iterations;
    private int correctSwaps;
    private int correctNoSwaps;

    public DealOrNoDealSimulator(int newIterations){
        iterations = newIterations;
    }

    public void run(){
        for(int i = 0; i < iterations; i++){
            DealOrNoDeal problem = new DealOrNoDeal();
            problem.generateCorrectDoor();
            if(problem.pickRandomDoor(true)){ //swapping
                correctSwaps += 1;
            }
        }

        for(int i = 0; i < iterations; i++){
            DealOrNoDeal problem = new DealOrNoDeal();
            problem.generateCorrectDoor();
            if(problem.pickRandomDoor(false)){ //swapping
                correctNoSwaps += 1;
            }
        }

        double correctSwapPercent = (double) correctSwaps / iterations;
        double correctNoSwapPercent = (double) correctNoSwaps / iterations;

        System.out.println("Chance when not swapping : " + correctSwapPercent);
        System.out.println("    Chance when swapping : " + correctNoSwapPercent);

    }

}
