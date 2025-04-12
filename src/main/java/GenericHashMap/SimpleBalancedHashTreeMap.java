package GenericHashMap;

/*
 * @description Stronger version of my HashTreeMap in attempts to keep up with Javas hashmap computation speeds
 * @author Tyler Snyder
 */

import GenericTree.BalancedNode;
import GenericTree.BalancedTree;

import java.util.Arrays;

public class SimpleBalancedHashTreeMap<X extends Comparable<X>, Y> implements SimpleMap<X, Y> {

    private BalancedTree<KeyValuePair<X, Y>>[] keys;
    private long items;
    private final double resizeFactor;

    public SimpleBalancedHashTreeMap(){
        keys = new BalancedTree[50];
        resizeFactor = 0.5;
    }

    public SimpleBalancedHashTreeMap(int size){
        keys = new BalancedTree[size];
        resizeFactor = 0.5;
    }

    public SimpleBalancedHashTreeMap(int size, double resizeFactor){
        keys = new BalancedTree[size];
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
            keys[hashLoc] = new BalancedTree<>();

        KeyValuePair<X, Y> target = new KeyValuePair<>(key, value);
        KeyValuePair<X, Y> existing = keys[hashLoc].get(target);

        // if exists update instead of adding additional nodes to prevent bloat
        if(existing != null)
            existing.setValue(value);
        else{
            keys[hashLoc].insert(target);
            items++;
        }

        if(resizeFactor < (double) items / keys.length){
            resize(keys.length * 2);
        }
    }

    /*
     * get a value associated with a key
     * @param X the key used to search for its pair
     * @return Y the associated value
     */
    public Y get(X key){
        BalancedTree<KeyValuePair<X, Y>> hashLocation = keys[simpleHash(key)];
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
    public void resize(int newSize) {
        BalancedTree<KeyValuePair<X, Y>>[] oldKeys = keys;

        keys = new BalancedTree[newSize];

        Arrays.stream(oldKeys).parallel().filter(tree -> tree != null).forEach(tree -> {
            for (BalancedNode<KeyValuePair<X, Y>> kv : tree.nodesToArrayList()) {
                int newHash = Math.abs(kv.getData().getKey().hashCode() % newSize);

                synchronized (keys) {
                    if (keys[newHash] == null) {
                        keys[newHash] = new BalancedTree<>();
                    }
                    keys[newHash].insertOrUpdate(kv.getData());
                }
            }
        });
    }

    /*
     * Remove a key value pair from the map
     * @param X the key to bed deleted
     * @return boolean to see key was deleted from map
     */
    public boolean remove(X key){
        return false;
    }

    public BalancedTree<KeyValuePair<X, Y>>[] getKeys(){
        return keys;
    }

}
