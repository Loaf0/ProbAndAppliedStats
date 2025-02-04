package SetTheoryFunctions;

import java.util.ArrayList;
import java.util.Arrays;

public class Set {

    private int pointer;
    private int size;
    public String[] items;


    public Set(){
        size = 0;
        items = new String[10];
    }

    public boolean add(String input){
        if (!contains(input)) {
            if(pointer < size)
            {
                items[pointer] = input;
                pointer++;
            }
            else {
                String[] newItems = new String[size * 2];

                for(int i = 0; i < items.length; i++)
                {
                    newItems[i] = items[i];
                }

                newItems[pointer] = input;

                items = newItems;
            }
            size++;
            return true;
        }
        return false; // or false if is already in
    }

    public void addAll(String[] input){
        for(String value : input){
            add(value);
        }
    }

    public void clear(){
        items = new String[10];
        size = 0;
    }

    public boolean contains(String input){
        for (var item : items){
            if (item.equals(input))
                return true;
        }
        return false; // if is in set
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean remove(String input){
        for (int i = 0; i < items.length; i++){
            if (items[i].equals(input)){
                for(int j = i; i < items.length; i++){
                    items[i] = items[i+1];
                }
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

}
