package tarefa_4_testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa4.MyMap;

class MyMapTest {

    private MyMap<String, Integer> map;

    private static final String KEY_1 = "key1";
    private static final String KEY_2 = "key2";
    private static final String KEY_NON_EXISTENT = "nonexistentKey";
    
    private static final Integer VALUE_10 = 10;
    private static final Integer VALUE_20 = 20;
    private static final Integer VALUE_30 = 30;

    @BeforeEach
    void setUp() {
        map = new MyMap<>();
    }

    @Test
    void testPutAndGet() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        assertEquals(VALUE_10, map.get(KEY_1));
        assertEquals(VALUE_20, map.get(KEY_2));
        assertNull(map.get(KEY_NON_EXISTENT));
    }

    @Test
    void testPutDuplicateKey() {
        map.put(KEY_1, VALUE_10);
        boolean result = map.put(KEY_1, VALUE_20);

        assertFalse(result);
        assertEquals(VALUE_10, map.get(KEY_1));
    }

    @Test
    void testRemove() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        assertTrue(map.remove(KEY_1));
        assertNull(map.get(KEY_1));

        assertFalse(map.remove(KEY_NON_EXISTENT));
    }

    @Test
    void testContainsKey() {
        map.put(KEY_1, VALUE_10);

        assertTrue(map.containsKey(KEY_1));
        assertFalse(map.containsKey(KEY_NON_EXISTENT));
    }

    @Test
    void testSize() {
        assertEquals(0, map.size());

        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        assertEquals(2, map.size());
    }

    @Test
    void testClear() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        map.clear();

        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(map.isEmpty());

        map.put(KEY_1, VALUE_10);

        assertFalse(map.isEmpty());
    }

    @Test
    void testToArray() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        Object[] array = map.toArray();

        assertEquals(2, array.length);
        assertTrue(containsEntry(array, KEY_1, VALUE_10));
        assertTrue(containsEntry(array, KEY_2, VALUE_20));
    }

    @Test
    void testEquals() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        MyMap<String, Integer> otherMap = new MyMap<>();
        otherMap.put(KEY_1, VALUE_10);
        otherMap.put(KEY_2, VALUE_20);

        assertTrue(map.equals(otherMap));

        otherMap.put("key3", VALUE_30);
        assertFalse(map.equals(otherMap));
    }

    @Test
    void testHashCode() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        MyMap<String, Integer> otherMap = new MyMap<>();
        otherMap.put(KEY_1, VALUE_10);
        otherMap.put(KEY_2, VALUE_20);

        assertEquals(map.hashCode(), otherMap.hashCode());
    }

    @Test
    void testIterator() {
        map.put(KEY_1, VALUE_10);
        map.put(KEY_2, VALUE_20);

        int count = 0;
        boolean key1Found = false;
        boolean key2Found = false;

        for (MyMap.Entry<String, Integer> entry : map) {
            count++;
            if (entry.getKey().equals(KEY_1) && entry.getValue().equals(VALUE_10)) {
                key1Found = true;
            } else if (entry.getKey().equals(KEY_2) && entry.getValue().equals(VALUE_20)) {
                key2Found = true;
            }
        }
        assertEquals(2, count);
        assertTrue(key1Found);
        assertTrue(key2Found);
    }

    private boolean containsEntry(Object[] array, String key, Integer value) {
        boolean found = false;

        if (array != null && key != null && value != null) {
            for (Object obj : array) {
                if (obj instanceof MyMap.Entry<?, ?> entry) {
                    String entryKey = (String) entry.getKey();
                    Integer entryValue = (Integer) entry.getValue();

                    if (entryKey != null && entryValue != null &&
                        entryKey.equals(key) && entryValue.equals(value)) {
                        found = true;
                        break;
                    }
                }
            }
        }

        return found;
    }

}
