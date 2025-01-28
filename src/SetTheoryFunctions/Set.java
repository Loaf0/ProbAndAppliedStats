package SetTheoryFunctions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Set {

    private int size;
    public ArrayList<Object> items;

    public Set(){
        size = 0;
        items = new ArrayList<>();
    }

    public boolean add(Object obj){
        if (!items.contains(obj)) {
            size++; // if added
            items.add(obj);
            return true;
        }
        return false; // or false if is already in
    }

    public void addAll(Object[] objects){
        items.addAll(Arrays.asList(objects));
    }

    public void clear(){
        items = new ArrayList<>();
        size = 0;
    }

    public boolean contains(Object obj){
        return items.contains(obj); // if is in set
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean remove(Object obj){
        return items.remove(obj); // if removed
    }

    public int size(){
        return size;
    }

}
