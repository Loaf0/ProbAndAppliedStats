package GenericTree;

public class BalancedNode<E extends Comparable<E>> {

    private E data;
    private BalancedNode<E> leftNode;
    private BalancedNode<E> rightNode;
    private int height;

    public BalancedNode(E newData) {
        data = newData;
        height = 1;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BalancedNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BalancedNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public BalancedNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BalancedNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
