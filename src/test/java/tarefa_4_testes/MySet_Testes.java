package tarefa_4_testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tarefa4.MySet;

class MySet_Test {

    private MySet<Integer> set;

    private static final Integer ELEMENT_1 = 10;
    private static final Integer ELEMENT_2 = 20;
    private static final Integer ELEMENT_3 = 30;
    private static final Integer ELEMENT_NON_EXISTENT = 40;

    private static final Collection<Integer> COLLECTION_1 = Arrays.asList(ELEMENT_2, ELEMENT_3);

    @BeforeEach
    void setUp() {
        set = new MySet<>();
    }

    @Test
    void testAdd() {
        assertTrue(set.add(ELEMENT_1));
        assertEquals(1, set.size());
        assertFalse(set.add(ELEMENT_1)); 
        assertEquals(1, set.size());
    }

    @Test
    void testRemove() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        assertTrue(set.remove(ELEMENT_1));
        assertEquals(1, set.size());
        assertFalse(set.remove(ELEMENT_NON_EXISTENT)); 
    }

    @Test
    void testContains() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        assertTrue(set.contains(ELEMENT_1));
        assertFalse(set.contains(ELEMENT_NON_EXISTENT));
    }

    @Test
    void testSize() {
        assertEquals(0, set.size());
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        assertEquals(2, set.size());
        set.remove(ELEMENT_1);
        assertEquals(1, set.size());
    }

    @Test
    void testClear() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(set.isEmpty());
        set.add(ELEMENT_1);
        assertFalse(set.isEmpty());
    }

    @Test
    void testToArray() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        Object[] array = set.toArray();
        assertEquals(2, array.length);
        assertTrue(Arrays.asList(array).contains(ELEMENT_1));
        assertTrue(Arrays.asList(array).contains(ELEMENT_2));
    }

    @Test
    void testHashCode() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);

        MySet<Integer> otherSet = new MySet<>();
        otherSet.add(ELEMENT_1);
        otherSet.add(ELEMENT_2);
        assertEquals(set.hashCode(), otherSet.hashCode());
    }

    @Test
    void testAddAll() {
        assertTrue(set.addAll(COLLECTION_1));
        assertEquals(2, set.size());
        assertTrue(set.contains(ELEMENT_2));
        assertTrue(set.contains(ELEMENT_3));
    }

    @Test
    void testRemoveAll() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        assertTrue(set.removeAll(COLLECTION_1));
        assertEquals(1, set.size());
        assertFalse(set.contains(ELEMENT_2));
    }

    @Test
    void testRetainAll() {
        MySet<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Collection<Integer> collection = Arrays.asList(2, 3);

        assertTrue(set.retainAll(collection));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertFalse(set.contains(1));
    }

    @Test
    void testNextThrowsException() {
        MySet<Integer> set = new MySet<>();
        set.add(1);

        Iterator<Integer> iterator = set.iterator();
        iterator.next(); 

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testEquals() {
        MySet<Integer> set1 = new MySet<>();
        set1.add(1);
        set1.add(2);

        MySet<Integer> set2 = new MySet<>();
        set2.add(1);
        set2.add(2);

        MySet<Integer> set3 = new MySet<>();
        set3.add(3);

        assertTrue(set1.equals(set2)); 
        assertFalse(set1.equals(set3)); 
        assertFalse(set1.equals(null)); 
        assertFalse(set1.equals("String")); 
    }

    @Test
    void testEqualsSame() {
        MySet<Integer> set1 = new MySet<>();
        MySet<Integer> set2 = new MySet<>();
        set1.add(1);
        set2.add(1);

        assertTrue(set1.equals(set2)); 
    }

    @Test
    void testEqualsDifferentSize() {
        MySet<Integer> set1 = new MySet<>();
        MySet<Integer> set2 = new MySet<>();
        set1.add(1);
        set1.add(2);
        set2.add(1);

        assertFalse(set1.equals(set2)); 
    }

    @Test
    void testHashCodeDifferent() {
        MySet<Integer> set1 = new MySet<>();
        MySet<Integer> set2 = new MySet<>();
        set1.add(1);
        set2.add(2);

        assertNotEquals(set1.hashCode(), set2.hashCode());
    }

    @Test
    void testHashCodeNull() {
        MySet<Integer> set = new MySet<>();
        set.add(null);

        assertNotNull(set.hashCode()); 
    }

    @Test
    void testRetainAllRemovesHead() {
        MySet<Integer> set = new MySet<>();
        set.add(1); 
        set.add(2);
        set.add(3);

        Collection<Integer> collection = Arrays.asList(2, 3);
        boolean changed = set.retainAll(collection);
        assertTrue(changed);
        assertFalse(set.contains(1)); 
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertEquals(2, set.size());
    }
}
