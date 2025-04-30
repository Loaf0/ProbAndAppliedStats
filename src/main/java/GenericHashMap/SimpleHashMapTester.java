package GenericHashMap;

import CSVPlotting.Vector;

public class SimpleHashMapTester {

    public static void main(String[] args){
        SimpleHybridHashMap<String, String> shm = new SimpleHybridHashMap<>();

        shm.put("deer", "Animal");
        shm.put("reed", "Plant");

        System.out.println(shm.get("reed"));

        //shm.resize();

        System.out.println(shm.get("deer"));
        System.out.println(shm.get("reed"));

        SimpleHybridHashMap<Vector, String> shmInt = new SimpleHybridHashMap<>();

        Vector p1 = new Vector(1.005, 6.044);
        Vector p2 = new Vector(1.04, 6.64);

        shmInt.put(p1, "A");
        shmInt.put(p2, "B");

        System.out.println(shmInt.contains(p1));

        System.out.println("Value removed? " + shmInt.remove(p1));

        System.out.println(shmInt.contains(p1));
    }

}
