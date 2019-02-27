package com.codingnomads.list;

public class Execute {
    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        myLinkedList.displayAll();

        myLinkedList.add(999,3);

        myLinkedList.displayAll();

        myLinkedList.remove((Integer)999);

        myLinkedList.remove(2);

        myLinkedList.displayAll();















    }
}
