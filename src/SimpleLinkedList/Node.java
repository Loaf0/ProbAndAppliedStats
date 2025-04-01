package SimpleLinkedList;

public class Node<E> {

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

    public E getNextData() {
        return nextNode.getData();
    }

    public void setNextData(E newData) {
        nextNode.setData(newData);
    }

    public void setNextNode(Node<E> newNextNode) {
        nextNode.setNode(newNextNode);
    }

    public void setNode(Node<E> newNextNode) {
        nextNode = newNextNode;
    }

    public void setData(E newData) {
        data = newData;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }
}
