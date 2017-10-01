package com.company.javaTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class testStream {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(4);
        myList.add(9);
        myList.add(7);
        test1(myList);
        for (Integer j : myList) {
            System.out.println(j);
        }
    }

    private static void test1(final List<Integer> li) {
        List<Integer> res = li.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
