package com.github.davidholiday.interview_prep;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.github.davidholiday.interview_prep.algorithms.Fibonacci;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FibonacciTest {


    // neato-burrito way to pre-populate a List
    private List<Long> firstTenFibonacciNumberList =
                Stream.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L)
                      .collect(Collectors.toList());


    @Test
    public void testFibonacciForCountIteration() {
        int fibonacciCount = 10;

        List<Long> actualFibonacciNumberList =
                Fibonacci.fibonacciForCountIteration(fibonacciCount);

        List<Long> expectedFibonacciNumberList = firstTenFibonacciNumberList;

        assertEquals(
                "method should return the correct fibonacci numbers!",
                expectedFibonacciNumberList,
                actualFibonacciNumberList
        );

    }


    @Test
    public void testGetNthFibonacciNumberRecursive() {
        int n = 9; // indexing starts at zero - we're checking the 10th number in the series
        long expectedNthFibonacciNumber = 34;
        long actualNthFibonacciNumber = Fibonacci.getNthFibonacciNumberRecursive(n);

        assertEquals(
                "the method isn't returning what's expected!",
                expectedNthFibonacciNumber,
                actualNthFibonacciNumber
        );
    }


    @Test
    public void testGetFibonacciGenerator() {
        LongStream fibonacciGenerator = Fibonacci.getFibonacciGenerator();

        // you need to box the primitive longs -> Longs before collection
        List<Long> actualFibonacciNumberList =
                fibonacciGenerator.limit(10)
                                  .boxed()
                                  .collect(Collectors.toList());

        List<Long> expectedFibonacciNumberList = firstTenFibonacciNumberList;

        assertEquals(
                "method should return the correct fibonacci numbers!",
                expectedFibonacciNumberList,
                actualFibonacciNumberList
        );

    }

}
