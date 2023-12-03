package edu.hw7;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    @DisplayName("Comparing performance between mono and multi threaded versions")
    void compare() {
        assertThat(multiIsFaster(10000000)).isTrue();
        assertThat(multiIsFaster(100000000)).isTrue();
        assertThat(multiIsFaster(1000000000)).isTrue();
    }

    boolean multiIsFaster(int n) {
        long start = System.nanoTime();
        try {
            MultiThreadedPi.getPi(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finish = System.nanoTime();

        long multi = finish - start;

        start = System.nanoTime();
        MonoThreadedPi.getPi(n);
        finish = System.nanoTime();

        long mono = finish - start;

        return multi < mono;
    }
}