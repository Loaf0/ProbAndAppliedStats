package GenericHashMap;

/*
 * @description Stronger version of my HashMap in attempts to keep up with Javas hashmap computation speeds
 * @author Tyler Snyder
 */

import GenericTree.Node;
import GenericTree.Tree;

import java.util.ArrayList;

public class SimpleHashTreeMap<X extends Comparable<X>, Y> implements SimpleMap<X, Y> {

    private Tree<KeyValuePair<X, Y>>[] keys;
    private final double resizeFactor;

    public SimpleHashTreeMap(){
        keys = new Tree[50];
        resizeFactor = 0.3;
    }

    public SimpleHashTreeMap(int size){
        keys = new Tree[size];
        resizeFactor = 0.3;
    }

    public SimpleHashTreeMap(int size, double resizeFactor){
        keys = new Tree[size];
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
            keys[hashLoc] = new Tree<>();

        KeyValuePair<X, Y> target = new KeyValuePair<>(key, value);
        KeyValuePair<X, Y> existing = keys[hashLoc].get(target);

        // if exists update instead of adding additional nodes to prevent bloat
        if(existing != null)
            existing.setValue(value);
        else
            keys[hashLoc].get(target);

        // auto resize logic
        if(keys[hashLoc].getSize() >= keys.length * resizeFactor){
            // resize logic not implemented yet
            resize(keys.length * 2);
        }
    }

    /*
     * get a value associated with a key
     * @param X the key used to search for its pair
     * @return Y the associated value
     */
    public Y get(X key){
        Tree<KeyValuePair<X, Y>> hashLocation = keys[simpleHash(key)];
        if (hashLocation == null)
            return null;
        // search for target and return it or null
        KeyValuePair<X, Y> target = new KeyValuePair<>(key, null);
        target = hashLocation.get(target);
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
    private int simpleHash(X x){
        // faster hashing by getting memory location of object as int
        return Math.abs(x.hashCode() % keys.length);
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
        //sort and grab median when resizing?
        //resizing must balance the array so they are not added in worst case O(n)
        if(newSize < 0)
            return;

        SimpleHashTreeMap<X, Y> newKeys = new SimpleHashTreeMap<>(newSize);

        for(Tree<KeyValuePair<X, Y>> tree : keys){
            if(tree == null || tree.getHead() == null)
                continue;

            ArrayList<Node<KeyValuePair<X, Y>>> nodes = tree.nodesToArrayList();

            while (!nodes.isEmpty()) {
                // so elements are not added in worst O(n)
                int index = (int) (Math.random() * nodes.size());
                Node<KeyValuePair<X, Y>> node = nodes.get(index);
                nodes.remove(index);
                KeyValuePair<X, Y> k = node.getData();
                newKeys.put(k.getKey(), k.getValue());
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
//        LinkedList<KeyValuePair<X, Y>> hashLocation = keys[simpleHash(key)];
//        KeyValuePair<X, Y> target = new KeyValuePair<>(key, null);
//        return hashLocation.remove(target);
        return false;
    }

    public Tree<KeyValuePair<X, Y>>[] getKeys(){
        return keys;
    }

}
