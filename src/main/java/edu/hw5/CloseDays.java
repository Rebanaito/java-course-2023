package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public class CloseDays extends Formatter {
    public CloseDays(Formatter next) {
        super(next);
    }

    @Override
    public Optional<LocalDate> parseDate(String input) {
        return switch (input) {
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            default -> returnNext(input);
        };
    }
}
