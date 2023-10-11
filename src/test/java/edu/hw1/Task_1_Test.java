package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_1_Test {
    @Test
    @DisplayName("Valid time inputs")
    void validInputs() {
        int answer = Task_1.minutesToSeconds("23:59");
        assertThat(answer).isEqualTo(1439);

        answer = Task_1.minutesToSeconds("0:0");
        assertThat(answer).isEqualTo(0);

        answer = Task_1.minutesToSeconds("120:0");
        assertThat(answer).isEqualTo(7200);

        answer = Task_1.minutesToSeconds("000:07");
        assertThat(answer).isEqualTo(7);

        answer = Task_1.minutesToSeconds("1234:56");
        assertThat(answer).isEqualTo(74096);
    }

    @Test
    @DisplayName("Invalid inputs")
    void invalidInputs() {
        int answer = Task_1.minutesToSeconds("23:60");
        assertThat(answer).isEqualTo(-1);

        answer = Task_1.minutesToSeconds("0:000");
        assertThat(answer).isEqualTo(-1);

        answer = Task_1.minutesToSeconds("12A:56");
        assertThat(answer).isEqualTo(-1);

        answer = Task_1.minutesToSeconds("23:59:59");
        assertThat(answer).isEqualTo(-1);

        answer = Task_1.minutesToSeconds("Lorem ipsum");
        assertThat(answer).isEqualTo(-1);
    }
}