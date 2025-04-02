package GenericHashMap;

public class KeyValuePair<X extends Comparable<X>, Y> implements Comparable<KeyValuePair<X, Y>> {

    private X key;
    private Y value;

    public KeyValuePair(X key, Y value) {
        this.key = key;
        this.value = value;
    }

    public X getKey() {
        return key;
    }

    public void setKey(X key) {
        this.key = key;
    }

    public Y getValue() {
        return value;
    }

    public void setValue(Y value) {
        this.value = value;
    }

    public String toString(){
        return "Key : " + key.toString() + " Value : " + value.toString();
    }

    /*
     * Method to compare KeyValuePairs
     * @param o The object to be compared to
     * @return the comparison of the key and object
     */
    @Override
    public int compareTo(KeyValuePair<X, Y> o) {
        return key.compareTo(o.getKey());
    }
}
