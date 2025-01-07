package tarefa_4_testes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tarefa_quadro.MyList;

class MyListTest {

    private MyList<Integer> list;
    

    @BeforeEach
    void setUp() {
        list = new MyList<>();
    }

    @Test
    void testAdd() {
            assertTrue(list.add(1));
            assertEquals(1, list.size());
    }

    @Test
    void testRemove() {
            list.add(1);
            list.add(2);
            list.add(3);
            assertTrue(list.remove(2));
            assertEquals(2, list.size());
            assertFalse(list.remove(4));

    }

    @Test
    void testGet() {
            list.add(10);
            list.add(20);
            list.add(30);
            assertEquals(20, list.get(1));
    }

    @Test
    void testSet() {
            list.add(10);
            list.add(20);
            list.set(1, 30);
            assertEquals(30, list.get(1));
    }

    @Test
    void testAddAll() {
            Collection<Integer> collection = Arrays.asList(4, 5, 6);
            assertTrue(list.addAll(collection));
            assertEquals(3, list.size());
    }

    @Test
    void testRemoveAll() {
            list.add(1);
            list.add(2);
            list.add(3);
            Collection<Integer> collection = Arrays.asList(2, 3);
            assertTrue(list.removeAll(collection));
            assertEquals(1, list.size());
    }

    @Test
    void testRetainAll() {
            list.add(1);
            list.add(2);
            list.add(3);
            Collection<Integer> collection = Arrays.asList(2, 3);
            assertTrue(list.retainAll(collection));
            assertEquals(2, list.size());
            assertTrue(list.contains(2));
            assertTrue(list.contains(3));
            assertFalse(list.contains(1));
    }

    @Test
    void testContains() {
            list.add(1);
            list.add(2);
            assertTrue(list.contains(1));
            assertFalse(list.contains(3));
    }

    @Test
    void testContainsAll() {
            list.add(1);
            list.add(2);
            list.add(3);
            Collection<Integer> collection = Arrays.asList(1, 2);
            assertTrue(list.containsAll(collection));
            collection = Arrays.asList(1, 4);
            assertFalse(list.containsAll(collection));
    }

    @Test
    void testClear() {
            list.add(1);
            list.add(2);
            list.clear();
            assertTrue(list.isEmpty());
            assertEquals(0, list.size());
    }

    @Test
    void testIsEmpty() {
            assertTrue(list.isEmpty());
            list.add(1);
            assertFalse(list.isEmpty());
    }

    @Test
    void testSize() {
            assertEquals(0, list.size());
            list.add(1);
            assertEquals(1, list.size());
            list.add(2);
            assertEquals(2, list.size());
    }

    @Test
    void testToArray() {
            list.add(1);
            list.add(2);
            Object[] array = list.toArray();
            assertEquals(2, array.length);
            assertEquals(1, array[0]);
            assertEquals(2, array[1]);
    }

    @Test
    void testEquals() {
            list.add(1);
            list.add(2);
            MyList<Integer> otherList = new MyList<>();
            otherList.add(1);
            otherList.add(2);
            assertTrue(list.equals(otherList));

            otherList.add(3);
            assertFalse(list.equals(otherList));

    }

    @Test
    void testHashCode() {
            list.add(1);
            list.add(2);
            MyList<Integer> otherList = new MyList<>();
            otherList.add(1);
            otherList.add(2);
            assertEquals(list.hashCode(), otherList.hashCode());

    }

    @Test
    void testIterator() {
            list.add(1);
            list.add(2);
            int count = 0;
            for (Integer item : list) {
                count++;
            }
            assertEquals(2, count);
    }
}
