package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class Task1 {
    private Task1() {
    }

    public static Optional<Duration> duration(String[] timestamps) throws DateTimeParseException {
        if (timestamps == null || timestamps.length == 0) {
            return Optional.empty();
        }
        Optional<Duration> dur = Optional.empty();
        Duration d = Duration.ZERO;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        for (String str : timestamps) {
            String[] split = str.split(" - ");
            if (split.length != 2) {
                continue;
            }
            LocalDateTime start = LocalDateTime.parse(split[0], formatter);
            LocalDateTime finish = LocalDateTime.parse(split[1], formatter);
            d = d.plus(Duration.between(start, finish));
        }
        if (!d.equals(Duration.ZERO)) {
            d = d.dividedBy(timestamps.length);
            dur = Optional.ofNullable(d);
        }
        return dur;
    }
}
