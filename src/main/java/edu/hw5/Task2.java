package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<LocalDate> friday13th(int year) {
        List<LocalDate> fridays = new ArrayList<>();
        for (int i = 12; i >= 1; i--) {
            LocalDate day = LocalDate.of(year, Month.of(i), 13);
            if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.addFirst(day);
            }
        }
        return fridays;
    }

    public static LocalDate nextFriday13th(LocalDate day) {
        if (day.getDayOfWeek() == DayOfWeek.FRIDAY && day.getDayOfMonth() == 13) {
            return day;
        }
        LocalDate d = day;
        while (d.isBefore(LocalDate.MAX)) {
            d = d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (d.getDayOfMonth() == 13) {
                break;
            }
        }
        return d;
    }
}