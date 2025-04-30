package SpeedComparison;

import CSVUtil.FileWriter;

import java.util.HashMap;
import java.util.Map;

public class HashmapMemoryComparison {
    public static void main(String[] args) throws Exception {
        int[] iterations = {100, 1000, 10000, 100000};

        StringBuilder output = new StringBuilder();
        output.append("iteration,memoryUsed\n");

        RandomStringGenerator rsg = new RandomStringGenerator();
        rsg.setRangeAlphaNumeric();

        int max = iterations[iterations.length - 1];
        String[] keys = new String[max], vals = new String[max], shuffled = new String[max];
        for (int i = 0; i < max; i++) {
            keys[i] = rsg.getRandomString(8);
            vals[i] = rsg.getRandomString(8);
            shuffled[i] = keys[i];
        }
        shuffle(shuffled);

        Runtime rt = Runtime.getRuntime();
        for (int n : iterations) {
            // run garbage collector and allow time for it to run
            rt.gc();
            Thread.sleep(50);
            long before = rt.totalMemory() - rt.freeMemory();

            Map<String,String> map = new HashMap<>();
            for (int i = 0; i < n; i++) map.put(keys[i], vals[i]);
            for (int i = 0; i < n; i++) map.get(shuffled[i]);

            long after = rt.totalMemory() - rt.freeMemory();
            output.append(n).append(',').append(after - before).append('\n');
        }

        new FileWriter().write("../Exports/HashMapMemory.csv", output.toString());
    }

    static void shuffle(String[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = (int)(Math.random()*a.length);
            String t=a[i]; a[i]=a[j]; a[j]=t;
        }
    }
}
