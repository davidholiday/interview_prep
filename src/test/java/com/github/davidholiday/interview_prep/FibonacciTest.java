package com.github.davidholiday.interview_prep;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FibonacciTest {

    @Test
    public void testFibonacciForCountIteration() {
        int fibonacciCount = 10;

        List<Long> actualFibonacciNumberList =
                Fibonacci.fibonacciForCountIteration(fibonacciCount);

        // neato-burrito way to pre-populate a List
        List<Long> expectedFibonacciNumberList =
                Stream.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L)
                      .collect(Collectors.toList());

        assertEquals(
                "method should return the correct fibonacci numbers!",
                expectedFibonacciNumberList,
                actualFibonacciNumberList
        );

    }


    @Test
    public void testGetNthFibonacciNumberRecursive() {
        int n = 9; // indexing starts at zero
        long expectedNthFibonacciNumber = 34;
        long actualNthFibonacciNumber = Fibonacci.getNthFibonacciNumberRecursive(n);

        assertEquals(
                "the method isn't returning what's expected!",
                expectedNthFibonacciNumber,
                actualNthFibonacciNumber
        );
    }


}
