package GenericHashMap;

import CSVPlotting.Vector;

public class SimpleHashMapTester {

    public static void main(String[] args){

        SimpleHashMap<String, String> shm = new SimpleHashMap<>();
        shm.add("Apple", "Fruit");
        shm.add("Tree", "Plant");

        System.out.println(shm.get("Apple"));


        SimpleHashMap<Vector, String> shmInt = new SimpleHashMap<>();

        Vector p1 = new Vector(1.005, 6.044);
        Vector p2 = new Vector(1.04, 6.64);

        shmInt.add(p1, "A");
        shmInt.add(p2, "B");

        System.out.println(shmInt.get(p1));

    }

}
