package GenericTree;

/*
 * @description subclass of node that implements coloring and parent referencing to be used in a red black tree
 * @author Tyler Snyder
 */

public class RBNode<E extends Comparable<E>> extends Node<E> {

    private RBNode<E> parentNode;
    private boolean black;

    public RBNode(E newData) {
        super(newData);
        black = true;
    }

    @Override
    public RBNode<E> getLeftNode() {
        return (RBNode<E>) super.getLeftNode();
    }

    @Override
    public RBNode<E> getRightNode() {
        return (RBNode<E>) super.getLeftNode();
    }

    public RBNode<E> getParentNode() {
        return parentNode;
    }

    public void setParentNode(RBNode<E> parentNode) {
        this.parentNode = parentNode;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }
}
