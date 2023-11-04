package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class DayMonthYear extends Formatter {
	public DayMonthYear(Formatter next) {
		super(next);
	}

	@Override
	public Optional<LocalDate> parseDate(String input) {
		String[] split = input.split("/");
		int SIZE = 3;
		if (split.length != SIZE) {
			return returnNext(input);
		}
		String days = "dd";
		String months = "MM";
		String years = "yyyy";
		DateTimeFormatter formatter;
		if (split[2].length() == 2) {
			years = "yy";
		}
		if (split[1].length() == 1) {
			months = "M";
		}
		if (split[0].length() == 1) {
			days = "d";
		}
		formatter = DateTimeFormatter.ofPattern(String.join("/", days, months, years));
		LocalDate date;
		try {
			date = LocalDate.parse(input, formatter);
		} catch (DateTimeParseException e) {
			return returnNext(input);
		}
		return Optional.of(date);
	}
}