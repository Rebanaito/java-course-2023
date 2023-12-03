package edu.hw7;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ThreadedFactorial {
    private ThreadedFactorial() {}

    public static BigInteger getFactorial(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException();
        } else if (value == 0 || value == 1) {
            return BigInteger.ONE;
        }
        return LongStream
                .rangeClosed(1, value)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE,
                        BigInteger::multiply);
    }
}
