package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public class NumberOfDays extends Formatter {
    public NumberOfDays(Formatter next) {
        super(next);
    }

    private static final int SIZE = 3;

    @Override
    public Optional<LocalDate> parseDate(String input) {
        String[] split = input.split(" ");
        if (invalidInput(split)) {
            return returnNext(input);
        }
        int days;
        try {
            days = Integer.parseInt(split[0]);
        } catch (NumberFormatException e) {
            return returnNext(input);
        }
        if (days < 0) {
            return returnNext(input);
        }
        return Optional.of(LocalDate.now().minusDays(days));
    }

    private boolean invalidInput(String[] split) {
        if (split.length != SIZE) {
            return true;
        }
        return !split[2].equals("ago") || (!split[1].equals("day") && !split[1].equals("days"));
    }
}
