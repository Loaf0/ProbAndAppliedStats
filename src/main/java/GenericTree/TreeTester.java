package GenericTree;

public class TreeTester {
    public static void main(String[] args){
        Tree<String> tree = new Tree<>();

        tree.insert("hello!");
        tree.insert("test!");
        tree.insert("goodbye!");

        System.out.println(tree.get("hello!"));
        System.out.println(tree.contains("test!"));
        System.out.println(tree.contains("hello!"));
        System.out.println(tree.contains("goodbye!"));

        for(Node<String> node : tree.nodesToArrayList()){
            System.out.println(node.getData());
        }
    }
}
