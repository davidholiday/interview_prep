package com.github.davidholiday.interview_prep.algorithms;


import java.util.List;
import java.util.ArrayList;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;


/**
 * static methods to generate Fibonacci numbers
 */
public class Fibonacci {

    /**
     * easiest most naive implementation of fibonacci number generation. generates the first
     * {$count} fibonacci numbers
     *
     * @param count: how many fibonacci numbers to generate
     *
     * @return list of computed fibonacci numbers
     */
    public static List<Long> fibonacciForCountIteration(int count) {

        // set up the first two numbers in the series and prepopulate the return list
        // with them
        long n1 = 0;
        long n2 = 1;

        List<Long> fibonacciNumberList = new ArrayList<>();
        fibonacciNumberList.add(n1);
        fibonacciNumberList.add(n2);

        for (int i=2; i < count; i ++) {
            long nextFibonacciNumber = n1 + n2;
            fibonacciNumberList.add(nextFibonacciNumber);

            // slide values to the left so we can compute the next number at the next
            // iteration
            n1 = n2;
            n2 = nextFibonacciNumber;
        }

        return fibonacciNumberList;
    }


    /**
     * recursive method to compute the nth fibonacci number
     *
     * @param n which number in the fibonacci series to return. indexing starts at zero.
     * @return the nth number in the fibonacci series
     */
    public static long getNthFibonacciNumberRecursive(int n) {

        // base case
        if ((n == 0) || (n == 1)) { return n; }

        // else recurse
        else {
            return getNthFibonacciNumberRecursive(n - 1) + getNthFibonacciNumberRecursive(n - 2);
        }

    }


    /**
     * supplies Fibonacci numbers to a LongStream
     */
    private static class FibonacciSupplier implements LongSupplier {
        private long previousPreviousFibonacciNumber = 0;
        private long previousFibonacciNumber = 1;
        private long currentFibonacciNumber = -1;

        @Override
        public long getAsLong() {

            // to ensure the first value is '0' and not '1'. breaks the naming convention a bit but only for the
            // first two cycles
            currentFibonacciNumber =
                    (currentFibonacciNumber >= 0) ?
                            (previousPreviousFibonacciNumber + previousFibonacciNumber) :
                            (0);

            previousPreviousFibonacciNumber = previousFibonacciNumber;
            previousFibonacciNumber = currentFibonacciNumber;

            return currentFibonacciNumber;
        }

    }


    /**
     * returns a generator that supplies an infinite stream of Fibonacci numbers
     *
     * @return
     */
    public static LongStream getFibonacciGenerator() {
        FibonacciSupplier fibonacciSupplier = new FibonacciSupplier();
        LongStream fibonacciGenerator = LongStream.generate(fibonacciSupplier);
        return fibonacciGenerator;
    }


}



