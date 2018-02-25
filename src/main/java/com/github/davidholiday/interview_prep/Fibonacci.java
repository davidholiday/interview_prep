package com.github.davidholiday.interview_prep;


import java.util.List;
import java.util.ArrayList;


public class Fibonacci {

    /**
     * easiest most naive implementation of fibonacci number generation
     *
     * @param count: how many fibonacci numbers beyond the first two to generate
     *
     * @return list of computed fibonacci numbers
     */
    public static List<Integer> FibonacciForCount(int count) {

        // set up the first two numbers in the series and prepopulate the return list
        // with them
        int n1 = 0;
        int n2 = 1;

        List<Integer> fibonacciNumberList = new ArrayList<>();
        fibonacciNumberList.add(n1);
        fibonacciNumberList.add(n2);

        for (int i=2; i < count; i ++) {
            int nextFibonacciNumber = n1 + n2;
            fibonacciNumberList.add(nextFibonacciNumber);

            // slide values to the left so we can compute the next number at the next 
            // iteration
            n1 = n2;
            n2 = nextFibonacciNumber;
        }

        return fibonacciNumberList;
    }



}
