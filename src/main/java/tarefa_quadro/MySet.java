package tarefa_quadro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySet<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public MySet() {
        this.head = null;
        this.size = 0;
    }

    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public boolean remove(Object value) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.value.equals(value)) {
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

    public boolean contains(Object value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void shuffle() {
        if (size <= 1) return;
        ArrayList<T> list = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        Collections.shuffle(list);
        current = head = new Node<>(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Node<T> newNode = new Node<>(list.get(i));
            current.next = newNode;
            current = newNode;
        }
        size = list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
