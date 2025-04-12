package GenericLinkedList;

/*
 * @description Custom Implementation of A tree
 * @author Tyler Snyder
 */

public class LinkedList<E extends Comparable<E>> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /*
     * add a value into the linked list
     * @param E value to be added into the linked list
     */
    public void add(E newData) {
        if (head == null){
            head = new Node<>(newData);
            return;
        }

        Node<E> newHead = new Node<>(newData);
        newHead.setNext(head);
        head = newHead;
        size++;
    }

    /*
     * remove a value from a linked list
     * @param E the target data to be removed
     * @return boolean if the value was removed
     */
    public boolean remove(E target) {
        // check if nodes exist
        if (head == null || head.getData() == null)
            return false;

        // check if head is target
        if (head.getData().compareTo(target) == 0) {
            head = head.getNext();
            size--;
            return true;
        }

        //traverse linked list and remove value
        Node<E> curr = head;
        while (curr.getNext() != null) {
            if (curr.getNext().getData().compareTo(target) == 0) {
                curr.setNext(curr.getNext().getNext());
                size--;
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }


    /*
     * Search linked list for a data
     * @param E data to be found in a node
     * @return E data held in node
     */
    public E getData(E e) {
        Node<E> curr = head;
        while (curr != null){
            // loop through linked list and compare values to find key pair with the same key
            if (curr.getData().compareTo(e) == 0){
                return curr.getData();
            }
            curr = curr.getNext();
        }
        return null;
    }

    /*
     * Print all linked list nodes
     */
    public void printAll() {
        if (head != null) {
            head.print();
        }
    }

    /*
     * clear all values from LinkedList
     */
    public void clear() {
        head = new Node<>(null);
        size = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}