package Tests;

import GenericHashMap.SimpleHashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHashMapTest {
    
    @Test
    public void testAdd() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Apple", "Fruit");

        assertEquals("Fruit", shm.get("Apple"));
    }

    @Test
    public void testGet() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Apple", "Red");
        shm.put("Orange", "Orange");
        shm.put("Banana", "Yellow");

        assertEquals("Red", shm.get("Apple"));
    }

    @Test
    public void testContains() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Apple", "Red");

        assertTrue(shm.contains("Apple"));
        assertFalse(shm.contains("Banana"));
    }

    @Test
    public void testCollisions() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>(1);

        shm.put("Apple", "Red");
        shm.put("elppA", "deR");

        assertEquals("Red", shm.get("Apple"));
        assertEquals("deR", shm.get("elppA"));
    }

    @Test
    public void testRemove() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Apple", "Red");

        shm.remove("Apple");

        assertFalse(shm.contains("Apple"));
    }

    @Test
    public void testGetOrDefault() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Apple", "Red");

        assertEquals("Red", shm.getOrDefault("Apple", "Yellow"));
        assertEquals("Yellow", shm.getOrDefault("Banana", "Yellow"));
    }

    @Test
    public void testResize() {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>();

        shm.put("Apple", "Red");
        shm.put("Orange", "Orange");
        shm.put("Banana", "Yellow");

        shm.resize(100);

        assertEquals("Red", shm.get("Apple"));
        assertEquals("Orange", shm.get("Orange"));
        assertEquals("Yellow", shm.get("Banana"));

        shm.resize(10);

        assertEquals("Red", shm.get("Apple"));
        assertEquals("Orange", shm.get("Orange"));
        assertEquals("Yellow", shm.get("Banana"));
    }

}
