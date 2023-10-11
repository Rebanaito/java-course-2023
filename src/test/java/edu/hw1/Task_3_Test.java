package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_3_Test {
    @Test
    @DisplayName("True statements")
    void trueStatements() {
        boolean answer = Task_3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6});
        assertThat(answer).isTrue();

        answer = Task_3.isNestable(new int[] {3, 1}, new int[] {4, 0});
        assertThat(answer).isTrue();

        answer = Task_3.isNestable(new int[] {0}, new int[] {-1, 1});
        assertThat(answer).isTrue();
    }

    @Test
    @DisplayName("False statements")
    void falseStatements() {
        boolean answer = Task_3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(new int[] {0}, new int[] {0, 1});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(new int[] {0}, new int[] {0});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(new int[] {-3}, new int[] {2});
        assertThat(answer).isFalse();
    }

    @Test
    @DisplayName("Invalid inputs")
    void invalidInputs() {
        boolean answer = Task_3.isNestable(new int[] {}, new int[] {8, 9});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(new int[] {1, 2, 3, 4}, new int[] {});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(null, new int[] {0, 1});
        assertThat(answer).isFalse();

        answer = Task_3.isNestable(new int[] {0}, null);
        assertThat(answer).isFalse();
    }
}