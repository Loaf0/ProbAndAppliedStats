package SpeedComparison;

import GenericHashMap.SimpleHashMap;

import java.util.HashMap;
import java.util.Map;

public class HashmapComparison {
    public static void main(String[] args){
        int testIterations = 100000;

        Timer timer = new Timer();
        Map<String, String> jMap = new HashMap<>();
        SimpleHashMap<String, String> tMap = new SimpleHashMap<>();

        RandomStringGenerator rsg = new RandomStringGenerator();
        rsg.setRangeAlphaNumeric();

        String[] keys = new String[testIterations];
        String[] values = new String[testIterations];

        for (int i = 0; i < testIterations; i++) {
            keys[i] = rsg.getRandomString(8);
            values[i] = rsg.getRandomString(8);
        }

        timer.start();
        for(int i = 0; i < testIterations; i++){
            tMap.put(keys[i], values[i]);
            tMap.get(keys[i]);
        }
        timer.stop();
        System.out.println("Tyler's map took " + timer.getTime() + "ms!");

        timer.reset();
        timer.start();
        for(int i = 0; i < testIterations; i++){
            tMap.put(keys[i], values[i]);
            tMap.get(keys[i]);
        }
        timer.stop();
        System.out.println("Java's map took " + timer.getTime() + "ms!");
    }
}
