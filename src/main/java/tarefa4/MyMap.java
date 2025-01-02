package tarefa4;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyMap<K, V> implements Iterable<MyMap.Entry<K, V>> {

    private Node<Entry<K, V>> head;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }



        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

    }

    public MyMap() {
        this.head = null;
        this.size = 0;
    }

    public boolean put(K key, V value) {
        if (containsKey(key)) {
            return false;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        Node<Entry<K, V>> newNode = new Node<>(newEntry);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public boolean remove(Object key) {
        Node<Entry<K, V>> current = head;
        Node<Entry<K, V>> previous = null;
        while (current != null) {
            if (current.value.getKey().equals(key)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public boolean containsKey(Object key) {
        Node<Entry<K, V>> current = head;
        while (current != null) {
            if (current.value.getKey().equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public V get(Object key) {
        Node<Entry<K, V>> current = head;
        while (current != null) {
            if (current.value.getKey().equals(key)) {
                return current.value.getValue();
            }
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private Node<Entry<K, V>> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Entry<K, V> value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<Entry<K, V>> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyMap<?, ?> myMap = (MyMap<?, ?>) o;
        if (size != myMap.size) return false;
        for (Entry<K, V> entry : this) {
            if (!myMap.containsKey(entry.getKey()) || !Objects.equals(myMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (Entry<K, V> entry : this) {
            result = 31 * result + (entry == null ? 0 : entry.hashCode());
        }
        return result;
    }

}
