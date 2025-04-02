package GenericHashMap;

import java.util.LinkedList;

public class SimpleHashMap {
    // convert this to use generics
    private LinkedList<KeyValuePair>[] keys;

    public SimpleHashMap(){
        keys = new LinkedList[50];
    }

    public boolean add(String key, String value){
        keys[simpleHash(key)].add(new KeyValuePair(key, value));
        return true;
    }

    public boolean get(String key){
        return true;
    }

    public int simpleHash(String input){
        // eventually change to MD5 or other hashing
        return input.length() % keys.length - 1; // subtract 1 for 0 indexing
    }

    public boolean contains(){
        // hash find value
        return true;
    }

    public void resize(){
        //newKeys =
    }

}
