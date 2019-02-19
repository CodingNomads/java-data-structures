package com.codingnomads.list;

/**
 * implement a custom ArrayList from scratch.
 * It should be generic, and it should automatically resize itself when nearing it's upper size bounds.
 * It should also resize itself to be smaller if/when needed as well.
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {

    private Object[] userArray;
    private int size = 0;

    public MyArrayList() {
        this.userArray = new Object[10];
    }

    public int getLength() {
        return size;
    }

    public void add(T element) {
        if (userArray.length < size) increaseListCapacity();
        userArray[size++] = element;
    }

    public void deleteAt(int index) {
        if (index < size) {
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(userArray, index + 1, userArray, index, numMoved);
            userArray[--size] = null; // clear to let GC do its work
        } else {
            throw new ArrayIndexOutOfBoundsException("[ERROR]THROWN EXPLICITLY");
        }
    }

    public T get(int index) {
        if (index <= size) {
            return elementData(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("[ERROR]THROWN EXPLICITLY");
        }
    }

    private T elementData(int index) {
        return (T) userArray[index];
    }

    private void increaseListCapacity() {
        userArray = Arrays.copyOf(userArray, userArray.length * 2);
    }

    //Iterator implementation starts here

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {

        T current = null;
        int posInArray = 0;

        @Override
        public boolean hasNext() {
            if (current == null && posInArray == 0) {
                return true;
            } else if (current != null && posInArray < size - 1) {
                return userArray[posInArray] != null;
            }
            return false;
        }

        @Override
        public T next() {
            if (current == null && size > 1) {
                current = get(posInArray);
                return current;
            } else if (current != null && size > 1) {
                current = get(posInArray + 1);
                posInArray++;
                return current;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
