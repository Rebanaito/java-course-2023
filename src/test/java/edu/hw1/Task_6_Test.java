package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_6_Test {
    @Test
    @DisplayName("Normal values")
    void normalValues() {
        int answer = Task_6.countK(3524);
        assertThat(answer).isEqualTo(3);

        answer = Task_6.countK(6621);
        assertThat(answer).isEqualTo(5);

        answer = Task_6.countK(6554);
        assertThat(answer).isEqualTo(4);

        answer = Task_6.countK(1234);
        assertThat(answer).isEqualTo(3);
    }

    @Test
    @DisplayName("Edge cases and invalid input")
    void abnormalValues() {
        int answer = Task_6.countK(1222);
        assertThat(answer).isEqualTo(5);

        answer = Task_6.countK(1000);
        assertThat(answer).isEqualTo(-1);

        answer = Task_6.countK(10000);
        assertThat(answer).isEqualTo(-1);

        answer = Task_6.countK(-6174);
        assertThat(answer).isEqualTo(-1);
    }
}