package SimpleLinkedList;

public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = new Node<E>(null);
    }

    public void remove(E target) {

    }

    public E getData(int index) {

        return null;
    }

    public void remove(int index) {

    }

    public void add(E newData) {
        Node<E> newHead = new Node<>(newData);
        newHead.setNextNode(head);
        head = newHead;
    }

    public int getSize() {
        return size;
    }

    public void printAll() {
        if (head.getData() != null) {
            head.print();
        }
    }

    public void clear() {
        head = new Node<E>(null);
    }
}