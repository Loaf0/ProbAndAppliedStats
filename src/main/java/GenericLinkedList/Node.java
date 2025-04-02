package GenericLinkedList;

public class Node<E extends Comparable<E>> {

    private E data;
    private Node<E> nextNode;

    public Node(E newData) {
        data = newData;
        nextNode = null;
    }

    public E getData() {
        return data;
    }

    public void print() {
        System.out.println(data.toString());

        if (nextNode != null && nextNode.getData() != null) {
            nextNode.print();
        }
    }

    public void setNext(Node<E> newNextNode) {
        nextNode = newNextNode;
    }

    public void setData(E newData) {
        data = newData;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }
}
