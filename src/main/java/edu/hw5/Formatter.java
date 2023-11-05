package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Formatter {
    public Formatter next;

    public Formatter(Formatter next) {
        this.next = next;
    }

    public abstract Optional<LocalDate> parseDate(String input);

    public Optional<LocalDate> returnNext(String input) {
        if (next == null) {
            return Optional.empty();
        }
        return next.parseDate(input);
    }
}
