package SetTheoryFunctions;

public class SetTester {
    public static void main(String[] args){
        Set a = new Set();
        a.add("a");
        a.add("b");
        a.add("c");
        Set b = new Set();
        b.add("a");
        b.add("b");
        b.add("d");

        a.printSet();
        b.printSet();
        System.out.println("A is super set of B : " + a.isSuperSet(b));
        System.out.println("A is sub set of B : " + a.isSubSet(b));
        System.out.println("B is super set of A : " + b.isSuperSet(a));
        System.out.println("B is sub set of A : " + b.isSubSet(a));

        System.out.println("\nA intersect B");
        a.intersection(b).printSet();

        System.out.println("\nA Union B");
        a.union(b).printSet();
    }
}
