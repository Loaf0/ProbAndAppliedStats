package Tests;

import GenericTree.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    
    @Test
    public void testAdd() {
        Tree<String> tree = new Tree<>();
        tree.insert("test!");
        assertTrue(tree.contains("test!"));
    }

    @Test
    public void testSize() {
        Tree<String> tree = new Tree<>();
        tree.insert("1");
        tree.insert("2");
        tree.insert("2");
        tree.insert("3");
        assertEquals(3, tree.getSize());
    }

    @Test
    public void testClear() {
        Tree<String> tree = new Tree<>();
        tree.insert("test!");
        tree.clear();
        assertFalse(tree.contains("test!"));
    }

    @Test
    public void testContains() {
        Tree<String> tree = new Tree<>();
        tree.insert("2");
        tree.insert("3");
        tree.insert("4");
        assertTrue(tree.contains("4"));
    }
}
