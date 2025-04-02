package GenericLinkedList;

public class LinkedList<E extends Comparable<E>> {

    private Node<E> head;

    public LinkedList() {
        head = new Node<E>(null);
    }

    public void add(E newData) {
        Node<E> newHead = new Node<>(newData);
        newHead.setNext(head);
        head = newHead;
    }

    public void remove(E target) {

    }

    public E getData(E e) {
        Node<E> curr = head;
        while (curr.hasNext()){
            // loop through linked list and compare values to find key pair with the same key
            if (curr.getData().compareTo(e) == 0){
                return curr.getData();
            }
        }
        return null;
    }

    public void printAll() {
        if (head != null) {
            head.print();
        }
    }

    public void clear() {
        head = new Node<E>(null);
    }
}