package GenericTree;

/*
 * @description Custom Implementation of a self-balancing tree built based on https://www.geeksforgeeks.org/insertion-in-red-black-tree/
 * @author Tyler Snyder
 */

import java.util.ArrayList;

public class RBTree<E extends Comparable<E>> implements Tree<E> {

    private RBNode<E> head;

    public RBTree(E data){
        head = new RBNode<>(data);
    }

    public RBTree(){
        head = null;
    }


    public void insert(E data) {
        RBNode<E> newNode = new RBNode<>(data);
        newNode.setBlack(false); // nodes start as red

        head = bstInsert(head, newNode);
        fixInsert(newNode);
    }

    private RBNode<E> bstInsert(RBNode<E> root, RBNode<E> node) {
        if (root == null)
            return node;

        if (node.getData().compareTo(root.getData()) < 0) {
            root.setLeftNode(bstInsert(root.getLeftNode(), node));
            if (root.getLeftNode() != null)
                root.getLeftNode().setParentNode(root);
        } else {
            root.setRightNode(bstInsert(root.getRightNode(), node));
            if (root.getRightNode() != null)
                root.getRightNode().setParentNode(root);
        }
        return root;
    }

    @Override
    public boolean contains(E data) {
        return get(data) != null;
    }

    @Override
    public E get(E data) {
        RBNode<E> current = head;

        while (current != null) {
            int comparison = data.compareTo(current.getData());

            //the node is found
            if (comparison == 0)
                return current.getData();
            // check right path
            else if (comparison < 0)
                current = current.getLeftNode();
            // check right path
            else
                current = current.getRightNode();
        }

        return null;
    }

    @Override
    public void clear() {

    }

    private void fixInsert(RBNode<E> node) {
        while (node != head && node.getParentNode() != null && !node.getParentNode().isBlack()) {
            RBNode<E> parent = node.getParentNode();
            RBNode<E> grandparent = parent.getParentNode();

            if(grandparent == null)
                break;

            if (parent == grandparent.getLeftNode()) {
                // the child of parents parent
                RBNode<E> uncle = grandparent.getRightNode();


                if (uncle != null && !uncle.isBlack()) {
                    parent.setBlack(true);
                    uncle.setBlack(true);
                    grandparent.setBlack(false);
                    node = grandparent;
                } else {
                    if (node == parent.getRightNode()) {
                        node = parent;
                        rotateLeft(node);
                    }
                    parent.setBlack(true);
                    grandparent.setBlack(false);
                    rotateRight(grandparent);
                }
            } else {
                // the child of parents parent
                RBNode<E> uncle = grandparent.getLeftNode();

                if (uncle != null && !uncle.isBlack()) {
                    parent.setBlack(true);
                    uncle.setBlack(true);
                    grandparent.setBlack(false);
                    node = grandparent;
                } else {
                    if (node == parent.getLeftNode()) {
                        node = parent;
                        rotateRight(node);
                    }
                    parent.setBlack(true);
                    grandparent.setBlack(false);
                    rotateLeft(grandparent);
                }
            }
        }
        head.setBlack(true);
    }

    private void rotateLeft(RBNode<E> node) {
        RBNode<E> rightChild = node.getRightNode();
        node.setRightNode(rightChild.getLeftNode());
        if (rightChild.getLeftNode() != null)
            rightChild.getLeftNode().setParentNode(node);

        rightChild.setParentNode(node.getParentNode());

        if (node.getParentNode() == null)
            head = rightChild;
        else if (node == node.getParentNode().getLeftNode())
            node.getParentNode().setLeftNode(rightChild);
        else
            node.getParentNode().setRightNode(rightChild);

        rightChild.setLeftNode(node);

        node.setParentNode(rightChild);
    }

    private void rotateRight(RBNode<E> node) {
        RBNode<E> leftChild = node.getLeftNode();
        node.setLeftNode(leftChild.getRightNode());

        if (leftChild.getRightNode() != null)
            leftChild.getRightNode().setParentNode(node);

        leftChild.setParentNode(node.getParentNode());

        if (node.getParentNode() == null)
            head = leftChild;
        else if (node == node.getParentNode().getLeftNode())
            node.getParentNode().setLeftNode(leftChild);
        else
            node.getParentNode().setRightNode(leftChild);

        leftChild.setRightNode(node);

        node.setParentNode(leftChild);
    }

    public ArrayList<RBNode<E>> nodesToArrayList() {
        ArrayList<RBNode<E>> nodes = new ArrayList<>(); // Create a dynamic list to hold the nodes
        collectNodes(nodes, head); // Perform in-order traversal and populate the list
        return nodes;
    }

    private void collectNodes(ArrayList<RBNode<E>> nodes, RBNode<E> node) {
        if (node == null)
            return;
        collectNodes(nodes, node.getLeftNode());
        nodes.add(node);
        collectNodes(nodes, node.getRightNode());
    }

    public void insertOrUpdate(E data) {
        RBNode<E> newNode = new RBNode<>(data);
        newNode.setBlack(false); // New nodes are red initially

        head = bstInsertOrUpdate(head, newNode);
        fixInsert(newNode);
    }

    private RBNode<E> bstInsertOrUpdate(RBNode<E> root, RBNode<E> node) {
        if (root == null) {
            return node;
        }

        int cmp = node.getData().compareTo(root.getData());

        if (cmp < 0) {
            root.setLeftNode(bstInsertOrUpdate(root.getLeftNode(), node));
            root.getLeftNode().setParentNode(root);
        } else if (cmp > 0) {
            root.setRightNode(bstInsertOrUpdate(root.getRightNode(), node));
            root.getRightNode().setParentNode(root);
        } else {
            root.setData(node.getData());
        }

        return root;
    }
}
