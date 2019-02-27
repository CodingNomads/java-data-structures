package com.codingnomads.list;

/**
 * Write a LinkedList from scratch. Make it generic.
 * <p>
 * https://crunchify.com/how-to-implement-a-linkedlist-class-from-scratch-in-java/
 * Double challenge, make it a doubly linked list.
 */

public class MyLinkedList<E>{
    private Node<E> head;
    private int size;

    public MyLinkedList(){
        head = new Node<E>();
    }

    public void displayAll(){
        Node<E> current = head;

        while(current.next != null){
            System.out.print(current.first + " ");
            current = current.next;
        }

        System.out.println(current.first);
    }

    public boolean add(E element){

        if(head.first == null){
            Node<E> firstElement = new Node<>(element);
            head = firstElement;
            ++size;
            return true;
        }

        Node<E> current = new Node();
        current = head;

        while(current.next != null){
            current = current.next;
        }

        current.next = new Node<E>(element);
        ++size;

        return true;
    }

    public boolean addFirst(E element){

        Node<E> current = new Node(element);

        current.next = head;

        head = current;

        ++size;

        return true;
    }

    public boolean add(E element, int index){

        if(index <0 || index > size + 1){
            return false;
        }

        if(index == 0){
            addFirst(element);
            ++size;
            return true;
        }

        if(index == size){
            add(element);
            ++size;
            return true;
        }

        int cursor = 0;

        Node<E> current = head;

        while(cursor < index - 1){
            current = current.next;
            ++cursor;
        }

        Node<E> added = new Node(element);

        added.next = current.next;

        current.next = added;

        ++size;

        return true;
    }

    public boolean remove(){
        head = head.next;

        --size;

        return true;
    }

    public boolean remove(E element){

        if(head.first.equals(element)){
            remove();
            --size;
            return true;
        }

        Node<E> current = head;

        while(!current.next.first.equals(element)){

            current = current.next;
        }

        current.next = current.next.next;

        --size;

        return true;
    }

    public boolean remove(int index){

        if(index == 0){
            remove();
            --size;
            return true;
        }

        int cursor = 0;

        Node<E> current = head;

        while(cursor < index - 1){

            current = current.next;
            ++cursor;
        }

        current.next = current.next.next;

        return true;
    }

    public int getSize() {
        return size;
    }

    class Node<E>{
        private E first;
        private Node next;

        public Node(){ }

        public Node(E first){
            this.first = first;
        }
    }
}
