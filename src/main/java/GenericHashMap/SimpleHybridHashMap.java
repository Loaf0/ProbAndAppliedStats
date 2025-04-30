package GenericHashMap;

import GenericLinkedList.LinkedList;
import GenericLinkedList.Node;

public class SimpleHybridHashMap<X extends Comparable<X>, Y> implements SimpleMap<X, Y> {

    private SimpleMap<X, Y> currentMap;
    private final double treeResizeFactor;
    private final double linkedResizeFactor;
    private final int swapToTreeMap;
    private int items;

    public SimpleHybridHashMap() {
        // manual resize from this class
        items = 0;
        treeResizeFactor = 0.5;
        linkedResizeFactor = 0.35;
        this.currentMap = new SimpleHashMap<>(100, linkedResizeFactor);
        this.swapToTreeMap = 8190;
    }

    public SimpleHybridHashMap(int size) {
        items = 0;
        treeResizeFactor = 0.5;
        linkedResizeFactor = 0.35;
        this.currentMap = new SimpleHashMap<>(size, linkedResizeFactor);
        this.swapToTreeMap = 8190;
    }

    public SimpleHybridHashMap(int size, int swapToTreeMap) {
        items = 0;
        treeResizeFactor = 0.5;
        linkedResizeFactor = 0.35;
        this.currentMap = new SimpleHashMap<>(size, linkedResizeFactor);
        this.swapToTreeMap = swapToTreeMap;
    }

    @Override
    public void put(X key, Y value) {
        items++;
        if(items > swapToTreeMap){
            swapToTreeMap();
        }
        currentMap.put(key, value);
    }

    @Override
    public Y get(X key) {
        return currentMap.get(key);
    }

    @Override
    public Y getOrDefault(X key, Y defaultValue) {
        return currentMap.getOrDefault(key, defaultValue);
    }

    @Override
    public boolean contains(X key) {
        return currentMap.contains(key);
    }

    @Override
    public boolean remove(X key) {
        items--;
        return currentMap.remove(key);
    }

    @Override
    public int simpleHash(X x){
        return currentMap.simpleHash(x);
    }

    private void swapToTreeMap(){
        if(currentMap instanceof SimpleHashMap<X,Y>){
            SimpleHashMap<X, Y> oldHashMap = (SimpleHashMap<X, Y>) currentMap;

            SimpleRBHashTreeMap<X, Y> treeMap = new SimpleRBHashTreeMap<>(oldHashMap.getKeys().length * 2, treeResizeFactor);

            LinkedList<KeyValuePair<X, Y>>[] lists = oldHashMap.getKeys();
            for (LinkedList<KeyValuePair<X, Y>> list : lists) {
                if (list != null) {
                    Node<KeyValuePair<X, Y>> currNode = list.getHead();
                    treeMap.put(currNode.getData().getKey(), currNode.getData().getValue());

                    while(currNode.hasNext()){
                        currNode = currNode.getNext();
                        treeMap.put(currNode.getData().getKey(), currNode.getData().getValue());
                    }
                }
            }
            currentMap = treeMap;
        }
    }
}
