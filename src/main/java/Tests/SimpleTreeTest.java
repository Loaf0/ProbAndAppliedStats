package Tests;

import GenericTree.SimpleTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTreeTest {
    
    @Test
    public void testAdd() {
        SimpleTree<String> simpleTree = new SimpleTree<>();
        simpleTree.insert("test!");
        assertTrue(simpleTree.contains("test!"));
    }

    @Test
    public void testSize() {
        SimpleTree<String> simpleTree = new SimpleTree<>();
        simpleTree.insert("1");
        simpleTree.insert("2");
        simpleTree.insert("2");
        simpleTree.insert("3");
        assertEquals(3, simpleTree.getSize());
    }

    @Test
    public void testClear() {
        SimpleTree<String> simpleTree = new SimpleTree<>();
        simpleTree.insert("test!");
        simpleTree.clear();
        assertFalse(simpleTree.contains("test!"));
    }

    @Test
    public void testContains() {
        SimpleTree<String> simpleTree = new SimpleTree<>();
        simpleTree.insert("2");
        simpleTree.insert("3");
        simpleTree.insert("4");
        assertTrue(simpleTree.contains("4"));
    }
}
