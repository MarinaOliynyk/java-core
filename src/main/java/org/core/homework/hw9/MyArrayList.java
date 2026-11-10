package org.core.homework.hw9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {

    private T[] elements = (T[]) new Object[10];
    private int size = 0;

    public MyArrayList() {
    }

    public MyArrayList(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    public MyArrayList(MyList<? extends T> col) {
        for (int i = 0; i < col.size(); i++) {
            add(col.get(i));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
        elements[size] = value;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T value) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = value;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> value) {
        for (T element : value) {
            add(element);
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T removeElement = elements[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return removeElement;
    }

    @Override
    public T set(int index, T value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T oldElement = elements[index];
        elements[index] = value;
        return oldElement;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                return i;
            }
        }
        return -1;
    }
}
