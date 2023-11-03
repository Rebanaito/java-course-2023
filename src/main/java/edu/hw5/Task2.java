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
    public static List<LocalDateTime> friday13th(int year) {
        List<LocalDateTime> fridays = new ArrayList<>();
        for (int i = 12; i >= 1; i--) {
            LocalDateTime day = LocalDateTime.of(year, Month.of(i), 13, 12, 0);
            if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.addFirst(day);
            }
        }
        return fridays;
    }

    public static LocalDateTime nextFriday13th(LocalDateTime day) {
        if (day.getDayOfWeek() == DayOfWeek.FRIDAY && day.getDayOfMonth() == 13) {
            return day;
        }
        LocalDateTime d = day;
        while (d.isBefore(LocalDateTime.MAX)) {
            d = d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (d.getDayOfMonth() == 13) {
                break;
            }
        }
        return d;
    }
}