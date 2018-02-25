package com.github.davidholiday.interview_prep;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FibonacciTest {

    @Test
    public void testFibonacciForCount() {
        int fibonacciCount = 10;
        List<Integer> actualFibonacciNumberList = Fibonacci.fibonacciForCount(fibonacciCount);

        List<Integer> expectedFibonacciNumberList =
                Stream.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
                      .collect(Collectors.toList());

        assertEquals(
                "method should return the correct fibonacci numbers!",
                expectedFibonacciNumberList,
                actualFibonacciNumberList
        );

    }




}
