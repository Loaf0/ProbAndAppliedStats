package GenericTree;

/*
 * @description Custom Implementation of Java's Tree
 * @author Tyler Snyder
 */

import java.util.ArrayList;

public class SimpleTree<E extends Comparable<E>> implements Tree<E> {

    private Node<E> head;
    private int size;

    public SimpleTree(E data){
        head = new Node<>(data);
        size = 1;
    }

    public SimpleTree(){
        head = null;
        size = 0;
    }

    /*
     * Insert into the tree
     * @param data The information added into the tree
     */
    public void insert(E data){
        if(head == null){
            head = new Node<>(data);
            size++;
            return;
        }

        Node<E> currentNode = head;

        // ignore duplicates
        while(data.compareTo(currentNode.getData()) != 0){
            if(data.compareTo(currentNode.getData()) < 0){
                if(currentNode.getLeftNode() == null){
                    currentNode.setLeftNode(new Node<>(data));
                    size++;
                    return;
                }
                else
                    currentNode = currentNode.getLeftNode();
            }
            else{
                if(currentNode.getRightNode() == null){
                    currentNode.setRightNode(new Node<>(data));
                    size++;
                    return;
                }
                else
                    currentNode = currentNode.getRightNode();
            }
        }
    }

    /*
     * Insert into the tree
     * @param data The information to be found in the tree
     * @returns boolean if the data is found in the tree
     */
    public boolean contains(E data){
        return get(data) != null;
    }

    /*
     * Insert into the tree
     * @param data The information to be found in the tree
     * @returns E the object that contains the data
     */
    public E get(E data) {
        if (head == null) {
            return null;
        }

        Node<E> currentNode = head;

        while (currentNode != null) {
            if (data.compareTo(currentNode.getData()) < 0) {
                currentNode = currentNode.getLeftNode();
            } else if (data.compareTo(currentNode.getData()) > 0) {
                currentNode = currentNode.getRightNode();
            } else { // if node data equals search data
                return currentNode.getData();
            }
        }
        return null;
    }

    /*
     * Insert into the tree or update data if it is in the tree
     * @param data The information to be found in the tree
     */
    public void insertOrUpdate(E data) {
        if (head == null) {
            head = new Node<>(data);
            size++;
            return;
        }

        Node<E> currentNode = head;

        // loop through the tree and either add or update a value
        while (true) {
            if (data.compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(new Node<>(data));
                    size++;
                    return;
                } else {
                    currentNode = currentNode.getLeftNode();
                }
            } else if (data.compareTo(currentNode.getData()) > 0) {
                if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(new Node<>(data));
                    size++;
                    return;
                } else {
                    currentNode = currentNode.getRightNode();
                }
            } else {
                currentNode.setData(data);
                return;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    /*
     * turn the tree into a list of nodes
     */
    public ArrayList<Node<E>> nodesToArrayList() {
        ArrayList<Node<E>> nodes = new ArrayList<>(); // Create a dynamic list to hold the nodes
        collectNodes(nodes, head); // Perform in-order traversal and populate the list
        return nodes;
    }

    /*
     * recursive function that collects all nodes in a tree
     * @param nodes the current array list of nodes
     * @param node the current node
     */
    private void collectNodes(ArrayList<Node<E>> nodes, Node<E> node) {
        if (node == null)
            return;
        collectNodes(nodes, node.getLeftNode());
        nodes.add(node);
        collectNodes(nodes, node.getRightNode());
    }

    /*
     * empty all nodes in the tree
     */
    public void clear(){
        head = null;
        size = 0;
    }
}
