package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import telran.util.Map;

import org.junit.jupiter.api.Test;

abstract class MapTest {
    String[] keys = {"lmn", "abc", "ab", "a"};
    Integer[] values = {3, 2, 2, 1};
    protected Map<String, Integer> map;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
    }

    @Test
    void getTest() {
        for (int i = 0; i < keys.length; i++) {
            assertEquals(values[i], map.get(keys[i]));
        }
    }

    @Test
    void getOrDefaultTest() {
        assertEquals(3, map.getOrDefault("lmn", 0));
        assertEquals(0, map.getOrDefault("xyz", 0));
    }

    @Test
    void putTest() {
        map.put("newKey", 10);
        assertEquals(10, map.get("newKey"));

        map.put("abc", 5);
        assertEquals(5, map.get("abc"));
    }

    @Test
    void putIfAbsentTest() {
        assertNull(map.putIfAbsent("newKey", 10));
        assertEquals(10, map.get("newKey"));

        assertEquals(2, map.putIfAbsent("ab", 5));
        assertEquals(2, map.get("ab"));
    }

    @Test
    void containsKeyTest() {
        assertTrue(map.containsKey("abc"));
        assertFalse(map.containsKey("xyz"));
    }

    @Test
    void containsValueTest() {
        assertTrue(map.containsValue(2));
        assertFalse(map.containsValue(0));
    }

    @Test
    @Disabled
    void keySetTest() {
        Set<String> expectedKeys = new HashSet<>(Arrays.asList(keys));
        assertEquals(expectedKeys, map.keySet());
    }

    @Test
    @Disabled
    void valuesTest() {
        Collection<Integer> expectedValues = Arrays.asList(values);
        assertEquals(expectedValues, map.values());
    }

    @Test
    @Disabled
    void entrySetTest() {
        Set<Map.Entry<String, Integer>> expectedEntries = new HashSet<>();
        for (int i = 0; i < keys.length; i++) {
            expectedEntries.add(new Map.Entry<>(keys[i], values[i]));
        }
        assertEquals(expectedEntries, map.entrySet());
    }

    @Test
    void removeTest() {
        assertEquals(2, map.remove("abc"));
        assertNull(map.get("abc"));

        assertNull(map.remove("xyz"));
    }
}
