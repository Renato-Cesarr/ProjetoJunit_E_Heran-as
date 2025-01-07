package tarefa_4_testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tarefa_quadro.MySet;

class MySet_Test {
    @Test
     void testAddElement() {
        MySet<Integer> mySet = new MySet<>();
        assertTrue(mySet.add(1));
        assertTrue(mySet.add(2));
        assertEquals(2, mySet.size());
    }

    @Test
     void testAddDuplicateElement() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        assertFalse(mySet.add(1));
        assertEquals(1, mySet.size());
    }

    @Test
     void testRemoveElement() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        assertTrue(mySet.remove(1));
        assertEquals(0, mySet.size());
    }

    @Test
     void testRemoveNonExistentElement() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        assertFalse(mySet.remove(2));
        assertEquals(1, mySet.size());
    }

    @Test
     void testContainsElement() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        assertTrue(mySet.contains(1));
    }

    @Test
     void testContainsNonExistentElement() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        assertFalse(mySet.contains(2));
    }

    @Test
     void testIsEmpty() {
        MySet<Integer> mySet = new MySet<>();
        assertTrue(mySet.isEmpty());
        mySet.add(1);
        assertFalse(mySet.isEmpty());
    }

    @Test
     void testClear() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.clear();
        assertTrue(mySet.isEmpty());
    }

    @Test
     void testShuffle() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        Integer firstElementBeforeShuffle = null;
        for (Integer value : mySet) {
            firstElementBeforeShuffle = value;
            break;
        }
        mySet.shuffle();
        Integer firstElementAfterShuffle = null;
        for (Integer value : mySet) {
            firstElementAfterShuffle = value;
            break;
        }
    }
}
