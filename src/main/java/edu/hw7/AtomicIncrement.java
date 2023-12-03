package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class AtomicIncrement {
    private AtomicIncrement() {
    }

    private final static int THREAD_LIMIT = 256;

    private final static Logger LOGGER = Logger.getLogger("AtomicIncrementLogger");

    public static int threadedIncrement(int value, int threadCount) throws IllegalArgumentException {
        if (threadCount < 1 || threadCount > THREAD_LIMIT || Integer.MAX_VALUE - threadCount < value) {
            throw new IllegalArgumentException();
        }
        AtomicInteger atomic = new AtomicInteger(value);

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(atomic::incrementAndGet);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.info(e.getMessage());
            }
        }

        return atomic.get();
    }
}
