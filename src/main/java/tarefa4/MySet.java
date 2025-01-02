package tarefa4;

import java.util.Collection;
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
        if (contains(value)) return false;
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

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
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

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
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
        MySet<?> mySet = (MySet<?>) o;
        if (size != mySet.size) return false;
        for (T element : this) {
            if (!mySet.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (T element : this) {
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T element : c) {
            if (add(element)) {
                changed = true;
            }
        }
        return changed;
    }

    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object element : c) {
            if (remove(element)) {
                changed = true;
            }
        }
        return changed;
    }

    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (!c.contains(current.value)) {
                // Remover o elemento que não está na coleção
                if (previous == null) {
                    head = current.next; // Remove o primeiro
                } else {
                    previous.next = current.next; // Remove do meio
                }
                size--;
                changed = true;
            } else {
                previous = current; // Avança para o próximo
            }
            current = current.next;
        }
        return changed;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }
}
