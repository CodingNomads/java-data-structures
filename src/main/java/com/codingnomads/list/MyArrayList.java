package com.codingnomads.list;

import java.util.*;

/**
 * implement a custom ArrayList from scratch.
 * It should be generic, and it should automatically resize itself when nearing it's upper size bounds.
 * It should also resize itself to be smaller if/when needed as well.
 * <p>
 * Part1:
 * Implement the methods:
 * 1) add( Object o): This method adds an object o to the arraylist.
 * 2) add(int index, Object o): It adds the object o to the array list at the given index.
 * 3) remove(Object o): Removes the object o from the ArrayList.
 * 4) remove(int index): Removes element from a given index.
 * 5) set(int index, Object o): Used for updating an element. It replaces the element present at the specified index with the object o.
 * 6) int indexOf(Object o): Gives the index of the object o. If the element is not found in the list then this method returns the value -1.
 * 7) Object get(int index): It returns the object of list which is present at the specified index.
 * 8) int size(): It gives the size of the ArrayList – Number of elements of the list.
 * 9) boolean contains(Object o): It checks whether the given object o is present in the array list if its there then it returns true else it returns false.
 * 10) clear(): It is used for removing all the elements of the array list in one go. The below code will remove all the elements of ArrayList whose object is obj.
 * <p>
 * Part2:
 * Make it Generic
 * <p>
 * Part3:
 * Implement the Iterator
 * https://beginnersbook.com/2014/06/java-iterator-with-examples/
 */

class MyIterator implements Iterator{
    int cursor;

    public int size;

    public Object obj;

    public boolean hasNext(){

        if(cursor == size)
            return false;

        return true;
    }

    public Object next(){
        cursor++;

        return obj;
    }
}

public class MyArrayList<E> {
    private int size;
    private int capacity = 10;
    private Object [] array ;

    private void resizeCapacity(){

        capacity = 10 + size - (size % 10);

        Object[] tempArray = new Object[capacity];

        for(int i = 0; i < size; ++i) {
            tempArray[i] = array[i];
        }

        array = tempArray;
    }

    private boolean indexControl(int index){
        return index < size;
    }

    public MyArrayList(){
        array = new Object[capacity];
    }

    public <E> boolean add (int index, E element){

        if(indexControl(index))
            return false;

        if(size == array.length){
            resizeCapacity();
        }

        Object[] tempArray = new Object[capacity];

        int in = 0;

        for(int i = 0; i < size; ++i){
            if(index == i){
                ++in;
                tempArray[in++] = array[i];
                continue;
            }

            else{
                tempArray[in++] = array[i];
            }
        }

        tempArray[index] = element;

        array = tempArray;

        return true;

    }

    public <E> void add (E element){

        if(size == array.length) {
            resizeCapacity();
        }

        array[size++] = element;
    }

    public <E> boolean remove (E element){

        if(!contains(element)){
            return false;
        }

        int index = indexOf(element);
        int in = 0;

        Object [] tempArray = new Object[capacity];

        for(int i = 0; i < size; ++i){
            if(i == index){
                continue;
            }
            else{
                tempArray[in++] = array[i];
            }
        }

        array = tempArray;

        size -= 1;

        resizeCapacity();

        return true;
    }

    public <E> boolean remove(int index){

        if(!indexControl(index)) {
            return false;
        }

        int in = 0;

        Object [] tempArray = new Object[capacity];

        for(int i = 0; i < size; ++i){
            if(i == index){
                continue;
            }
            else{
                tempArray[in++] = array[i];
            }
        }

        array = tempArray;

        size -= 1;

        resizeCapacity();

        return true;
    }

    public <E> boolean set(int index, E element){

        if(!indexControl(index)){
            System.out.println("Invalid index");
            return false;
        }

        array[index] = element;

        return true;
    }

    public <Object> Object get(int index){

        return (Object)array[index];
    }

    public <E> int indexOf(E element){

        for(int i = 0; i < size; ++i) {
            if (array[i].equals(element))
                return i;
        }

        return -1;
    }

    public <Object> boolean contains(Object element){

        for(int i = 0; i < size; ++i){
            if(array[i].equals(element))
                return true;
        }

        return false;
    }

    public void clear(){

        size = 0;

        resizeCapacity();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getSize(){
        return size;
    }

    public void displayArray(){

        System.out.print('{');

        for(int i = 0; i < size; ++i){
            System.out.print(array[i]+ " ");
        }

        System.out.print('}');

        System.out.println();
    }

    public static void main(String[] args) {

        MyArrayList<Object> list = new MyArrayList();

        list.add(10.5);
        list.add("CodingNomads");
        list.add(true);

        for(int i = 0; i < 30; ++i) {
            list.add(i);
        }

        //ITERATION

        MyIterator itr = new MyIterator();

        itr.size = list.getSize();

        while(itr.hasNext()){
            itr.obj = list.get(itr.cursor);

            System.out.print(itr.obj + " ");

            itr.next();
        }

        System.out.printf("%nSize: %d%nCapacity: %d%n******%n", list.size, list.capacity);

        /* For test

        System.out.printf("Size: %d%nCapacity: %d%n******", list.size, list.capacity);

        System.out.println("Removing # " + list.remove((Object)'#'));

        System.out.println("Getting index no 6 " + (Object)list.get(6));

        System.out.println("Removing index no 6 " + list.remove(6));

        System.out.println("Getting index no 6 " + (Object)list.get(6));

        System.out.println("Removing false " + list.remove(false));

        System.out.println("Getting index of CodingNomads " + list.indexOf("CodingNomads"));

        System.out.println("Setting CodingNomads to CodingNomadsBali" + list.set(list.indexOf("CodingNomads"), "CodingNomadsBali"));

        System.out.println("Checking Contains CodingNomadsBali " + list.contains("CodingNomadsBali"));
        System.out.println("Checking Contains XXXX " + list.contains("XXXX"));

        list.clear();

        System.out.println("After Clear ");


        System.out.printf("Size: %d%nCapacity: %d%n******%n", list.size, list.capacity);

        */
    }
}
