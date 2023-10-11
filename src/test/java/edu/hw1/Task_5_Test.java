package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_5_Test {
    @Test
    @DisplayName("Palindromes")
    void palindromes() {
        boolean answer = Task_5.isPalindromeDescendant(11);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(101);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(123454321);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(1000000001);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-11);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-101);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-123454321);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-1000000001);
        assertThat(answer).isTrue();
    }

    @Test
    @DisplayName("Palindrome descendants")
    void palindromeDescendants() {
        boolean answer = Task_5.isPalindromeDescendant(11211230);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(13001120);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(23336014);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(123);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-11211230);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-13001120);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-23336014);
        assertThat(answer).isTrue();

        answer = Task_5.isPalindromeDescendant(-123);
        assertThat(answer).isTrue();
    }

    @Test
    @DisplayName("No palindromes")
    void noPalindromes() {
        boolean answer = Task_5.isPalindromeDescendant(124);
        assertThat(answer).isFalse();

        answer = Task_5.isPalindromeDescendant(1003);
        assertThat(answer).isFalse();

        answer = Task_5.isPalindromeDescendant(23336015);
        assertThat(answer).isFalse();

        answer = Task_5.isPalindromeDescendant(2147483647);
        assertThat(answer).isFalse();

        answer = Task_5.isPalindromeDescendant(-2147483648);
        assertThat(answer).isFalse();
    }
}