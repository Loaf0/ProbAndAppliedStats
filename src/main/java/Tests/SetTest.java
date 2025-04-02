package Tests;

import SetTheoryFunctions.Set;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {
    
    @Test
    public void testAdd() {
        Set set = new Set();
        
        assertTrue(set.add("A"));
        assertFalse(set.add("A"));  // Adding a duplicate should return false
        assertEquals(1, set.size());
    }

    @Test
    public void testUnion() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});
        
        set.add("A");
        Set resultSet = set.union(anotherSet);

        assertTrue(resultSet.contains("A"));
        assertTrue(resultSet.contains("B"));
        assertTrue(resultSet.contains("C"));
        assertEquals(3, resultSet.size());
    }

    @Test
    public void testIntersection() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        set.add("A");
        set.add("B");
        Set resultSet = set.intersection(anotherSet);

        assertTrue(resultSet.contains("A"));
        assertTrue(resultSet.contains("B"));
        assertFalse(resultSet.contains("C"));
        assertEquals(2, resultSet.size());
    }

    @Test
    public void testIsSubSet() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        assertTrue(set.isSubSet(set));
        assertTrue(set.isSubSet(anotherSet));
        set.add("A");
        set.add("B");
        assertTrue(set.isSubSet(anotherSet));  // Since A and B are in anotherSet
    }

    @Test
    public void testContains() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        assertFalse(set.contains("A"));
        set.add("A");
        assertTrue(set.contains("A"));
    }

    @Test
    public void testIsSuperSet() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        set.addAll(new String[]{"A", "B", "C", "D"});
        assertTrue(set.isSuperSet(anotherSet));  // Set should be a superset of anotherSet
    }

    @Test
    public void testIsEmpty() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        assertTrue(set.isEmpty());
        set.add("A");
        assertFalse(set.isEmpty());
    }

    @Test
    public void testRemove() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        set.add("A");
        assertTrue(set.remove("A"));
        assertFalse(set.remove("B"));  // B is not in the set
        assertTrue(set.isEmpty());
    }

    @Test
    public void testClear() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        set.add("A");
        set.add("B");
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testSize() {
        Set set = new Set();
        Set anotherSet = new Set(new String[]{"A", "B", "C"});

        assertEquals(0, set.size());
        set.add("A");
        assertEquals(1, set.size());
        set.remove("A");
        assertEquals(0, set.size());

    }
}
