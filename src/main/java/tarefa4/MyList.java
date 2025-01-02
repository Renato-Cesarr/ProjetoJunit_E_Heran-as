package tarefa4;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {

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

    public MyList() {
        this.head = null;
        this.size = 0;
    }

    public boolean add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(Object value) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.value.equals(value)) {
                if (previous == null) {
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

    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void set(int index, T value) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
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

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
        }
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
        MyList<?> myList = (MyList<?>) o;
        if (size != myList.size) return false;
        Iterator<T> iterator1 = iterator();
        Iterator<?> iterator2 = myList.iterator();
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (T element : this) {
            result = 31 * result + (element.hashCode());
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
                if (previous == null) {
                    head = current.next;
                } else {
                }
                size--;
                changed = true;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return changed;
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

    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }
}
