package GenericLinkedList;

import GenericHashMap.KeyValuePair;

public class LinkedListTester {
    public static void main(String[] args){
        LinkedList<String> sll = new LinkedList<>();

        sll.add("String A");
        sll.add("String B");
        sll.printAll();

        LinkedList<KeyValuePair<String, String>> keyValueLL = new LinkedList<>();

        keyValueLL.add(new KeyValuePair<>("String A", "A"));
        keyValueLL.add(new KeyValuePair<>("String B", "B"));
        keyValueLL.printAll();
    }
}
