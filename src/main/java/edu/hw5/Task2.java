package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    private final static int DAY_WANT = 13;
    private final static int MONTHS = 12;

    public static List<LocalDate> friday13th(int year) {
        List<LocalDate> fridays = new ArrayList<>();
        for (int i = MONTHS; i >= 1; i--) {
            LocalDate day = LocalDate.of(year, Month.of(i), DAY_WANT);
            if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.addFirst(day);
            }
        }
        return fridays;
    }

    public static LocalDate nextFriday13th(LocalDate day) {
        if (day.getDayOfWeek() == DayOfWeek.FRIDAY && day.getDayOfMonth() == DAY_WANT) {
            return day;
        }
        LocalDate d = day;
        while (d.isBefore(LocalDate.MAX)) {
            d = d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (d.getDayOfMonth() == DAY_WANT) {
                break;
            }
        }
        return d;
    }
}
