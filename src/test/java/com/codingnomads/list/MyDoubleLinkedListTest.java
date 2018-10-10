package com.codingnomads.list;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MyDoubleLinkedListTest {

    public static final String STRING_1 = "String";

    @Test
    public void shouldAddAndGet() {
        List<String> myDoubleLinkedList = new MyDoubleLinkedList<>();
        myDoubleLinkedList.add(STRING_1);
        assertThat(myDoubleLinkedList).contains(STRING_1);
    }
}