package com.company.javaTest;

public class testStringFormat {
    public static void main(String[] args) {
        String st = "roleArn";
        String ts = String.format("victimAccount.%1$s", st);
        System.out.println(ts);
    }
}
