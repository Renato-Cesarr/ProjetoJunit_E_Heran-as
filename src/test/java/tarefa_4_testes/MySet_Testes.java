package tarefa_4_testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tarefa4.MySet;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MySet_Test {

    private MySet<Integer> set;

    private static final Integer ELEMENT_1 = 10;
    private static final Integer ELEMENT_2 = 20;
    private static final Integer ELEMENT_3 = 30;
    private static final Integer ELEMENT_NON_EXISTENT = 40;

    private static final Collection<Integer> COLLECTION_1 = Arrays.asList(ELEMENT_2, ELEMENT_3);
    private static final Collection<Integer> COLLECTION_NON_EXISTENT = Arrays.asList(ELEMENT_NON_EXISTENT);

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
    void testEquals() {
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);

        MySet<Integer> otherSet = new MySet<>();
        otherSet.add(ELEMENT_1);
        otherSet.add(ELEMENT_2);
        assertTrue(set.equals(otherSet));

        otherSet.add(ELEMENT_3);
        assertFalse(set.equals(otherSet));
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
        set.add(ELEMENT_1);
        set.add(ELEMENT_2);
        set.add(ELEMENT_3);
        
        // Retenho apenas ELEMENT_2 e ELEMENT_3
        assertTrue(set.retainAll(COLLECTION_1));  
        assertEquals(2, set.size());  // Tamanho esperado é 2
        
        // ELEMENT_2 e ELEMENT_3 devem permanecer
        assertTrue(set.contains(ELEMENT_2));
        assertTrue(set.contains(ELEMENT_3));
        
        // ELEMENT_1 deve ser removido
        assertFalse(set.contains(ELEMENT_1));
    }

}
