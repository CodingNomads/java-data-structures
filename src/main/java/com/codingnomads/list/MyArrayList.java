package com.codingnomads.list;

/**
 * implement a custom ArrayList from scratch.
 * It should be generic, and it should automatically resize itself when nearing it's upper size bounds.
 * It should also resize itself to be smaller if/when needed as well.
 */

import java.util.Arrays;

public class MyArrayList<T> {

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
}
