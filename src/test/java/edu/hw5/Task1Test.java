package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class Task1Test {
    @Test
    @DisplayName("ValidInputs")
    void validInputs() {
        String[] timeframes = {"2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"};
        Optional<Duration> dur = Task1.duration(timeframes);
        Duration want = Duration.ofHours(3).plus(Duration.ofMinutes(40));
        assertThat(dur.isPresent()).isTrue();
        assertThat(dur.get()).isEqualTo(want);
    }

    @Test
    @DisplayName("InvalidInputs")
    void invalidInputs() {
        String[] timeframes = {"202-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"};
        boolean exception = false;
        try {
            Task1.duration(timeframes);
        } catch (DateTimeParseException ignored) {
            exception = true;
        }
        assertThat(exception).isTrue();

        String[] time = {"2022-03-12, 20:20 - 2022-03-12, 25:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"};
        exception = false;
        try {
            Task1.duration(timeframes);
        } catch (DateTimeParseException ignored) {
            exception = true;
        }
        assertThat(exception).isTrue();

        Optional<Duration> dur = Task1.duration(null);
        assertThat(dur.isEmpty()).isTrue();

        dur = Task1.duration(new String[] {"2022-03-12, 20:20", "2022-04-01, 21:30"});
        assertThat(dur.isEmpty()).isTrue();
    }
}