package edu.hw7;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadedPi {
    private MultiThreadedPi() {}

    public static double getPi(int n) throws InterruptedException {
        if (n < 1) {
            return -1;
        }

        int threadCount = Math.min(Runtime.getRuntime().availableProcessors(), n);

        double[] pies = new double[threadCount];
        Thread[] threads = new Thread[threadCount];

        int num = n;
        for (int i = 0; i < threadCount; i++) {
            int j = i;
            int iterations = num;

            threads[j] = new Thread(() -> {
                pies[j] = singlePi(iterations);
            });
            threads[j].start();

            num -= num / threadCount;
        }

        for (Thread thread : threads) {
            thread.join();
        }

        OptionalDouble pi = Arrays.stream(pies).average();

        if (pi.isEmpty()) {
            return -1;
        }
        return pi.getAsDouble();
    }

    @SuppressWarnings("MagicNumber")
    private static double singlePi(int n) {
        double x;
        double y;
        double distance;
        double pi = 0;

        int circleCount = 0;
        int totalCount = 0;

        for (int i = 0; i < n; i++) {

            x = ThreadLocalRandom.current().nextDouble(1.0) * 2 - 1;
            y = ThreadLocalRandom.current().nextDouble(1.0) * 2 - 1;

            distance = x * x + y * y;

            if (distance <= 1) {
                circleCount++;
            }
            totalCount++;

            pi = ((4.0 * circleCount) / totalCount);
        }
        return pi;
    }
}
