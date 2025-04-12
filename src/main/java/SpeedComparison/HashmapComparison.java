package SpeedComparison;

import CSVUtil.FileWriter;
import GenericHashMap.SimpleHashMap;
import GenericHashMap.SimpleHashTreeMap;
import GenericHashMap.SimpleMap;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class HashmapComparison {
    public static void main(String[] args) throws FileNotFoundException {
        int[] iterations = {100, 1000, 10000, 100000, 1000000};

        StringBuilder output = new StringBuilder();
        //output.append("Iterations, SimpleBalancedTreeMap Time (ms), JavaHashMap Time (ms) \n");
        output.append("Iterations, SimpleHashMap Time (ms), SimpleTreeMap Time (ms) \n");

        for (int iteration : iterations){
            System.out.println("Starting Tests with " + iteration + " iterations.");
            Timer timer = new Timer();
            long hashMapTime = 0;
            long treeMapTime;
            long jMapTime;

            // set both maps to the same capacity as to keep timing fair
            SimpleMap<String, String> hMap = new SimpleHashMap<>(50);
            SimpleMap<String, String> treeMap = new SimpleHashTreeMap<>(50);
            Map<String, String> jMap = new HashMap<>(50);


            RandomStringGenerator rsg = new RandomStringGenerator();
            rsg.setRangeAlphaNumeric();

            String[] keys = new String[iteration];
            String[] shuffledKeys = new String[iteration];
            String[] values = new String[iteration];

            for (int i = 0; i < iteration; i++) {
                keys[i] = rsg.getRandomString(8);
                shuffledKeys[i] = keys[i];
                values[i] = rsg.getRandomString(8);
            }

            // get from keys in random order so runtime is not always O(1)
            shuffle(shuffledKeys);

            // my map
            timer.start();
            for(int i = 0; i < iteration; i++){
                hMap.put(keys[i], values[i]);
            }
            for(int i = 0; i < iteration; i++){
                hMap.get(shuffledKeys[i]);
            }
            timer.stop();
            hashMapTime = timer.getTime();
            timer.reset();

            // treemap
            timer.start();
            for(int i = 0; i < iteration; i++){
                treeMap.put(keys[i], values[i]);
            }
            for(int i = 0; i < iteration; i++){
                treeMap.get(shuffledKeys[i]);
            }
            timer.stop();
            treeMapTime = timer.getTime();
            timer.reset();

            // java map
            timer.start();
            for(int i = 0; i < iteration; i++){
                jMap.put(keys[i], values[i]);
            }
            for(int i = 0; i < iteration; i++){
                jMap.get(shuffledKeys[i]);
            }
            timer.stop();
            jMapTime = timer.getTime();

            output.append(iteration).append(", ").append(hashMapTime).append(", ").append(treeMapTime).append("\n");
        }

        new FileWriter().write("../Exports/HashMapSpeeds.csv", output.toString());
    }

    public static void shuffle(String[] input){
        for (int i = 0; i < input.length; i++){
            int randIndex = (int) (Math.random() * input.length);
            String temp = input[i];
            input[i] = input[randIndex];
            input[randIndex] = temp;
        }
    }
}