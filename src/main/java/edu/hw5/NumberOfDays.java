package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class NumberOfDays extends Formatter {
	public NumberOfDays(Formatter next) {
		super(next);
	}

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
		int SIZE = 3;
		if (split.length != SIZE) {
			return true;
		} else return !split[2].equals("ago") || (!split[1].equals("day") && !split[1].equals("days"));
	}
}
