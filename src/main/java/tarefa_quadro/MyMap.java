package tarefa_quadro;

public class MyMap<K, V> {

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

    public boolean remove(K key) {
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

    public V get(K key) {
        Node<Entry<K, V>> current = head;
        while (current != null) {
            if (current.value.getKey().equals(key)) {
                return current.value.getValue();
            }
            current = current.next;
        }
        return null; 
    }

    public boolean containsKey(K key) {
        Node<Entry<K, V>> current = head;
        while (current != null) {
            if (current.value.getKey().equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
