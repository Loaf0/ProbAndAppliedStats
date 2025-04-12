package GenericTree;

/*
 * @description Custom Implementation of a self-balancing tree built based on https://www.baeldung.com/java-avl-trees
 * @author Tyler Snyder
 */

import java.util.ArrayList;

public class BalancedTree<E extends Comparable<E>> implements Tree<E> {

    private BalancedNode<E> head;
    private int size = 0;

    public BalancedTree(E data){
        head = new BalancedNode<>(data);
    }

    public BalancedTree(){
        head = null;
    }

    public void insert(E data) {
        head = insertNode(head, data);
    }

    public void insertOrUpdate(E data) {
        head = insertOrUpdateNode(head, data);
    }

    public boolean contains(E data) {
        return get(data) != null;
    }

    public E get(E data) {
        BalancedNode<E> current = head;
        while (current != null) {
            int cmp = data.compareTo(current.getData());
            if (cmp == 0) {
                return current.getData();
            } else if (cmp < 0) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
        }
        return null;
    }

    public void clear() {
        head = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<BalancedNode<E>> nodesToArrayList() {
        ArrayList<BalancedNode<E>> nodes = new ArrayList<>(); // Create a dynamic list to hold the nodes
        collectNodes(nodes, head); // Perform in-order traversal and populate the list
        return nodes;
    }

    private void collectNodes(ArrayList<BalancedNode<E>> nodes, BalancedNode<E> node) {
        if (node == null)
            return;
        collectNodes(nodes, node.getLeftNode());
        nodes.add(node);
        collectNodes(nodes, node.getRightNode());
    }

    private void updateHeight(BalancedNode<E> n) {
        n.setHeight(1 + Math.max(height(n.getLeftNode()), height(n.getRightNode())));
    }

    private int height(BalancedNode<E> n){
        if(n == null)
            return -1;
        return n.getHeight();
    }

    private int getBalance(BalancedNode<E> n) {
        if(n == null)
            return 0;
        return height(n.getRightNode()) - height(n.getLeftNode());
    }

    private BalancedNode<E> rotateLeft(BalancedNode<E> y) {
        BalancedNode<E> x = y.getRightNode();
        BalancedNode<E> z = x.getLeftNode();

        x.setLeftNode(y);
        y.setRightNode(z);

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private BalancedNode<E> rotateRight(BalancedNode<E> y) {
        BalancedNode<E> x = y.getLeftNode();
        BalancedNode<E> z = x.getRightNode();

        x.setRightNode(y);
        y.setLeftNode(z);

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private BalancedNode<E> rebalanceTree(BalancedNode<E> z) {
        updateHeight(z);
        int balance = getBalance(z);

        // imbalance towards right side
        if (balance > 1) {
            if (height(z.getRightNode().getLeftNode()) > height(z.getRightNode().getRightNode())) {
                z.setRightNode(rotateRight(z.getRightNode()));
            }
            z = rotateLeft(z);
        }

        // imbalance towards left side
        else if (balance < -1) {
            if (height(z.getLeftNode().getRightNode()) > height(z.getLeftNode().getLeftNode())) {
                z.setLeftNode(rotateLeft(z.getLeftNode()));
            }
            z = rotateRight(z);
        }

        return z;
    }


    private BalancedNode<E> insertNode(BalancedNode<E> root, E data) {
        if (root == null) {
            return new BalancedNode<E>(data);
        } else if (data.compareTo(root.getData()) < 0) {
            root.setLeftNode(insertNode(root.getLeftNode(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRightNode(insertNode(root.getRightNode(), data));
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        size++;
        return rebalanceTree(root);
    }


    private BalancedNode<E> insertOrUpdateNode(BalancedNode<E> root, E data) {
        if (root == null)
            return new BalancedNode<E>(data);

        // compare once to reduce computation time
        int comparison = data.compareTo(root.getData());

        if (comparison < 0) {
            root.setLeftNode(insertOrUpdateNode(root.getLeftNode(), data));
        } else if (comparison > 0) {
            root.setRightNode(insertOrUpdateNode(root.getRightNode(), data));
        } else {
            // set data and don't balance if no new node was added
            root.setData(data);
            return root;
        }
        size++;
        return rebalanceTree(root);
    }

}
