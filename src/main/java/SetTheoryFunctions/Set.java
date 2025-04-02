package SetTheoryFunctions;

/*
 * @description Custom Implementation of Java's Set
 * @author Tyler Snyder
 */

public class Set {

    private int pointer;
    private int size;
    public String[] items;


    public Set(){
        pointer = 0;
        size = 0;
        items = new String[10];
    }

    public Set(String[] arr){
        pointer = 0;
        size = 0;
        items = new String[10];
        addAll(arr);
    }

    public boolean add(String input){
        if (!contains(input)) {
            if(pointer < items.length)
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
        return false;
    }

    public Set union(Set a){
        Set union = new Set();
        union.addAll(items);
        union.addAll(a.getArray());

        return union;
    }

    public Set intersection(Set a){
        Set intersect = new Set();
        for(String item : items)
            if(a.contains(item))
                intersect.add(item);
        return intersect;
    }

    public boolean isSuperSet(Set a){
        return a.isSubSet(new Set(items));
    }

    public boolean isSubSet(Set a){
        for(String item : items)
            if (item != null && !a.contains(item))
                return false;
        return true;
    }

    public void addAll(String[] input){
        for(String value : input)
            if (value != null)
                add(value);
    }

    public void clear(){
        items = new String[10];
        size = 0;
    }

    public boolean contains(String input){
        for (var item : items)
            if(item != null && item.equals(input))
                return true;
        return false;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean remove(String input){
        for (int i = 0; i < items.length; i++){
            if (items[i] != null && items[i].equals(input)){
                for(int j = i; i < items.length - 1; i++){
                    items[i] = items[i+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printSet(){
        System.out.print("[");
        for(int i = 0; i < size-1; i++){
            System.out.print(items[i] + ", ");
        }
        System.out.print(items[size - 1]);
        System.out.print("]\n");
    }

    public String[] getArray(){
        return items;
    }

}
