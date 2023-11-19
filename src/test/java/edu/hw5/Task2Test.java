package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Task2Test {
    @Test
    @DisplayName("Fridays in a year")
    void fridays() {
        List<LocalDate> days = Task2.friday13th(1925);
        assertThat(days.size()).isEqualTo(3);
        assertThat(days.get(0).getMonth()).isEqualTo(Month.FEBRUARY);
        assertThat(days.get(1).getMonth()).isEqualTo(Month.MARCH);
        assertThat(days.get(2).getMonth()).isEqualTo(Month.NOVEMBER);

        days = Task2.friday13th(2024);
        assertThat(days.size()).isEqualTo(2);
        assertThat(days.get(0).getMonth()).isEqualTo(Month.SEPTEMBER);
        assertThat(days.get(1).getMonth()).isEqualTo(Month.DECEMBER);
    }

    @Test
    @DisplayName("Next Friday 13th")
    void nextFriday() {
        LocalDate now = LocalDate.of(2023, Month.NOVEMBER, 3);
        LocalDate want = LocalDate.of(2024, Month.SEPTEMBER, 13);
        LocalDate next = Task2.nextFriday13th(now);
        assertThat(next).isEqualTo(want);
    }
}
