package SetTheoryFunctions;

public class SetTester {
    public static void main(String[] args){
        Set a = new Set();
        a.add("a");
        a.add("b");
        a.add("c");
        System.out.println(a.contains("d"));
        a.printSet();
    }
}
