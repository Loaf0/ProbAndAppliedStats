package GenericHashMap;

/*
 * @description Interface to build maps
 * @author Tyler Snyder
 */

public interface SimpleMap<X extends Comparable<X>, Y> {
    void put(X key, Y value);
    Y get(X key);
    Y getOrDefault(X key, Y defaultValue);
    boolean contains(X key);
    boolean remove(X key);
    int simpleHash(X x);
}