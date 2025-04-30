package GenericTree;

/*
 * @description subclass of node that implements custom height checking to be used in self balancing tree
 * @author Tyler Snyder
 */

public class BalancedNode<E extends Comparable<E>> extends Node<E> {

    private int height;

    public BalancedNode(E newData) {
        super(newData);
        height = 1;
    }

    @Override
    public BalancedNode<E> getLeftNode() {
        return (BalancedNode<E>) super.getLeftNode();
    }

    @Override
    public BalancedNode<E> getRightNode() {
        return (BalancedNode<E>) super.getRightNode();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
