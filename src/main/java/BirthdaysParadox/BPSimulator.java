package BirthdaysParadox;

/*
 *  @description Monte Carlo Birthday Paradox Calculator
 *  @author Tyler Snyder
 */

import java.util.HashMap;
import java.util.Map;

public class BPSimulator {

    public void run(int people, int iterations){
        int possibleDays = 365;
        int duplicateBirthdays = 0;

        for (int i = 0; i < iterations; i++) {
            if (instance(people, possibleDays))
                duplicateBirthdays++;
        }
        double chance =  (double) duplicateBirthdays / (double) iterations * 100;
        System.out.printf("Probability of %s People Not Having the Same Birthday : %.4f %% \n", people, 100.0 - chance);
        System.out.printf("    Probability of %s People Having the Same Birthday : %.4f %%", people, chance);
    }

    public boolean instance(int people, int days){
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i = 0; i < people; i++){
            int random = (int) (Math.random() * days);
            if (countMap.containsKey(random))
                return true;
            countMap.put(random, 0);
        }
        return false;
    }

}
