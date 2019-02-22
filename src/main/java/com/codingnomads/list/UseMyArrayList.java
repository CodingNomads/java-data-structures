package com.codingnomads.list;

public class UseMyArrayList {

    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();

//        System.out.println("The array is currently empty: " + myList.isEmpty());
        //add
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("e");
        myList.add("f");
        System.out.println(myList);

//        myList.remove(1);
//        System.out.println(myList);
//        System.out.println("The array is currently empty: " + myList.isEmpty());
//
//        System.out.println("The size of this list is " + myList.size() + ".");
//
//        System.out.println(myList.get(1));
//
//        System.out.println(myList.contains("c"));
//
//        if (myList.indexOf("a") == -1) {
//            System.out.println("This list does not include a.");
//        } else {
//            System.out.println("Yes, a is included.");
//        }



        while(myList.hasNext()){
            myList.next();
        };

    }
}
