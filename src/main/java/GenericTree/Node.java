package GenericTree;

public class Node<E extends Comparable<E>>  {

    private E data;
    private Node<E> leftNode;
    private Node<E> rightNode;

    public Node(E newData){
        data = newData;
    }

    public E getData(){
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<E> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<E> leftNode) {
        this.leftNode = leftNode;
    }
}
