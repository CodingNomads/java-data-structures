package com.codingnomads.stack;

import java.util.Arrays;

/**
 * Write your own implementation
 */

public class MyStack<E> {

    private Object[] stack;
    private int top = 0;

    public MyStack() {
        this.stack = new Object[5];
    }

    public void push(E element) {
        if (top == stack.length) {
            increaseSizeOfArray();
        }
        stack[top] = element;
        top++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new NullPointerException("No Element to pop");
        }
        stack[top] = null;
        top--;
    }

    public void show() {
        if (isEmpty()) {
            throw new NullPointerException("No Element to show");
        }
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NullPointerException("No Element to peek");
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void increaseSizeOfArray() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

}