package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    public Task3() {
    }

    private final NumberOfDays numberOfDays = new NumberOfDays(null);
    private final CloseDays closeDays = new CloseDays(numberOfDays);
    private final DayMonthYear dayMonthYear = new DayMonthYear(closeDays);
    private final YearMonthDay yearMonthDay = new YearMonthDay(dayMonthYear);

    public Optional<LocalDate> parseDate(String string) {
        return yearMonthDay.parseDate(string);
    }
}
