package GenericHashMap;

/*
 * @description Custom Implementation of Java's HashMap class
 * @author Tyler Snyder
 */

import GenericLinkedList.LinkedList;
import GenericLinkedList.Node;

public class SimpleHashMap<X extends Comparable<X>, Y> implements SimpleMap<X, Y> {

    private LinkedList<KeyValuePair<X, Y>>[] keys;
    private final double resizeFactor;

    public SimpleHashMap(){
        keys = new LinkedList[50];
        resizeFactor = 0.15;
    }

    public SimpleHashMap(int size){
        keys = new LinkedList[size];
        resizeFactor = 0.15;
    }

    public SimpleHashMap(int size, double resizeFactor){
        keys = new LinkedList[size];
        this.resizeFactor = resizeFactor;
    }

    /*
     * put key and value to HashMap
     * @param X the key to be added
     * @param Y the value to be added
     */
    public void put(X key, Y value){
        // get the hashed location and add node
        int hashLoc = simpleHash(key);
        if (keys[hashLoc] == null)
            keys[hashLoc] = new LinkedList<>();

        KeyValuePair<X, Y> target = new KeyValuePair<>(key, value);
        KeyValuePair<X, Y> existing = keys[hashLoc].getData(target);

        // if exists update instead of adding additional nodes to prevent bloat
        if(existing != null)
            existing.setValue(value);
        else
            keys[hashLoc].add(target);

        // auto resize logic
        if(keys[hashLoc].getSize() >= keys.length * resizeFactor){
            resize(keys.length * 2);
        }
    }

    /*
     * get a value associated with a key
     * @param X the key used to search for its pair
     * @return Y the associated value
     */
    public Y get(X key){
        LinkedList<KeyValuePair<X, Y>> hashLocation = keys[simpleHash(key)];
        if (hashLocation == null)
            return null;
        // search for target and return it or null
        KeyValuePair<X, Y> target = new KeyValuePair<>(key, null);
        target = hashLocation.getData(target);
        return target != null ? target.getValue() : null;
    }

    /*
     * get a value associated with a key or a default value
     * @param X the key used to search for its pair
     * @param Y the default value to be used in place of null
     * @return Y the associated value
     */
    public Y getOrDefault(X key, Y defaultValue){
        Y value = get(key);
        return value != null ? value : defaultValue;
    }

    /*
     * private helper function to hash a string into an int
     * @param String value to be hashed
     * @return int hashed value
     */
    public int simpleHash(X x){
        // faster hashing by getting memory location of object as int
        return Math.abs(x.hashCode() % keys.length);
    }

    /*
     * private helper function to hash a string into an int
     * @param String value to be hashed
     * @return int hashed value
     */
    private int simplerHash(String input){
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += input.charAt(i);
        }
        return sum % keys.length;
    }

    /*
     * check if a value is in the HashMap
     * @param X the key used to search for its pair
     * @return boolean weather key exists in map
     */
    public boolean contains(X key){
        return get(key) != null;
    }

    /*
     * resize the array backbone for hashmap to increase speeds at larger data sizes
     * @param int the new size to use
     */
    public void resize(int newSize){
        if(newSize < 0)
            return;

        SimpleHashMap<X, Y> newKeys = new SimpleHashMap<>(newSize);

        for(LinkedList<KeyValuePair<X, Y>> ll : keys){
            if(ll == null || ll.getHead() == null)
                continue;

            Node<KeyValuePair<X, Y>> currNode = ll.getHead();
            newKeys.put(currNode.getData().getKey(), currNode.getData().getValue());

            while(currNode.hasNext()){
                currNode = currNode.getNext();
                newKeys.put(currNode.getData().getKey(), currNode.getData().getValue());
            }
        }
        keys = newKeys.getKeys();
    }

    /*
     * Remove a key value pair from the map
     * @param X the key to bed deleted
     * @return boolean to see key was deleted from map
     */
    public boolean remove(X key){
        LinkedList<KeyValuePair<X, Y>> hashLocation = keys[simpleHash(key)];
        KeyValuePair<X, Y> target = new KeyValuePair<>(key, null);
        return hashLocation.remove(target);
    }

    public LinkedList<KeyValuePair<X, Y>>[] getKeys(){
        return keys;
    }

}
