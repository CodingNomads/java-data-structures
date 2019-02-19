package com.codingnomads.list;

class Node <E> {

    private E data;
    private Node next;

    E getData() {
        return data;
    }

    void setData(E data) {
        this.data = data;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
