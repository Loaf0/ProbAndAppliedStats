package GenericHashMap;

import GenericLinkedList.LinkedList;

public class SimpleHashMap<X extends Comparable<X>, Y> {

    // convert this to use generics
    private LinkedList<KeyValuePair<X, Y>>[] keys;
    public SimpleHashMap(){
        keys = new LinkedList[50];
    }

    public boolean add(X key, Y value){
        // get the hashed location and add node
        int hashLoc = simpleHash(key.toString());
        if (keys[hashLoc] == null)
            keys[hashLoc] = new LinkedList<>();

        keys[hashLoc].add(new KeyValuePair<X, Y>(key, value));
        return true;
    }

    public Y get(X key){
        LinkedList<KeyValuePair<X, Y>> hashLocation = keys[simpleHash(key.toString())];
        // assign fake target to be able to compare values
        KeyValuePair<X, Y> target = new KeyValuePair<>(key, null);
        return hashLocation.getData(target).getValue();
    }

    public int simpleHash(String input){
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += input.charAt(i);
        }
        return sum % keys.length; // subtract 1 for 0 indexing
    }

    public boolean contains(X key){
        // hash find value
        return get(key) != null;
    }

    public void resize(){
        //newKeys =
    }

}
