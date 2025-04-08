package GenericHashMap;

import CSVPlotting.Vector;

public class SimpleHashMapTester {

    public static void main(String[] args){
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Tree", "Fruit");
        shm.put("Tree", "Plant");
        shm.put("Teer", "PlantTeer");

        System.out.println(shm.get("Teer"));

        shm.resize(70);

        System.out.println(shm.get("Apple"));
        System.out.println(shm.get("Tree"));


        SimpleHashMap<Vector, String> shmInt = new SimpleHashMap<>();

        Vector p1 = new Vector(1.005, 6.044);
        Vector p2 = new Vector(1.04, 6.64);

        shmInt.put(p1, "A");
        shmInt.put(p2, "B");

        System.out.println(shmInt.contains(p1));

        System.out.println("Value removed? " + shmInt.remove(p1));

        System.out.println(shmInt.contains(p1));
    }

}
