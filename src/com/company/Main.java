package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        Main temp = new Main();
        temp.help(test);
        for (int i = 0; i < 3; i++) {
            System.out.println(test.get(i));
        }

    }

    public void help(final List<Integer> mylist) {
        final List<Integer> mytest = new ArrayList<>(mylist);
        Collections.reverse(mytest);
    }
}
