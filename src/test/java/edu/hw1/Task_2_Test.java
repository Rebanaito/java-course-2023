package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_2_Test {
    @Test
    @DisplayName("Count digits")
    void countDigits() {
        int answer = Task_2.countDigits(0);
        assertThat(answer).isEqualTo(1);

        answer = Task_2.countDigits(9);
        assertThat(answer).isEqualTo(1);

        answer = Task_2.countDigits(10);
        assertThat(answer).isEqualTo(2);

        answer = Task_2.countDigits(56);
        assertThat(answer).isEqualTo(2);

        answer = Task_2.countDigits(100);
        assertThat(answer).isEqualTo(3);

        answer = Task_2.countDigits(2147483647);
        assertThat(answer).isEqualTo(10);

        answer = Task_2.countDigits(-2147483648);
        assertThat(answer).isEqualTo(10);

        answer = Task_2.countDigits(-1234);
        assertThat(answer).isEqualTo(4);
    }
}