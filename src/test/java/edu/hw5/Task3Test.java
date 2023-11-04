package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Task3Test {
	@Test
	@DisplayName("YearMonthDay Test")
	void yearMonthDayTest() {
		String input = "2020-1-10";
		LocalDate want = LocalDate.of(2020, 1, 10);
		YearMonthDay parser = new YearMonthDay(null);
		Optional<LocalDate> date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "2020-12-2";
		want = LocalDate.of(2020, 12, 2);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "2020-12-32";
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isFalse();
	}

	@Test
	@DisplayName("DayMonthYear Test")
	void dayMonthYearTest() {
		String input = "1/3/1976";
		LocalDate want = LocalDate.of(1976, 3, 1);
		DayMonthYear parser = new DayMonthYear(null);
		Optional<LocalDate> date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "1/3/20";
		want = LocalDate.of(2020, 3, 1);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "1/13/1976";
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isFalse();
	}

	@Test
	@DisplayName("CloseDays Test")
	void closeDaysTest() {
		String input = "tomorrow";
		LocalDate want = LocalDate.now().plusDays(1);
		CloseDays parser = new CloseDays(null);
		Optional<LocalDate> date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "yesterday";
		want = LocalDate.now().minusDays(1);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "today";
		want = LocalDate.now();
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "invalid";
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isFalse();
	}

	@Test
	@DisplayName("NumberOfDays Test")
	void numberOfDaysTest() {
		String input = "3 days ago";
		LocalDate want = LocalDate.now().minusDays(3);
		NumberOfDays parser = new NumberOfDays(null);
		Optional<LocalDate> date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "2234 days ago";
		want = LocalDate.now().minusDays(2234);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "0 days ago";
		want = LocalDate.now();
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "-1 days ago";
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isFalse();
	}

	@Test
	@DisplayName("Chain of Responsibility Test")
	void corTest() {
		Task3 parser = new Task3();
		String input = "tomorrow";
		LocalDate want = LocalDate.now().plusDays(1);
		Optional<LocalDate> date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "16/9/1496";
		want = LocalDate.of(1496, 9, 16);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "2023-7-4";
		want = LocalDate.of(2023, 7, 4);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);

		input = "7 days ago";
		want = LocalDate.now().minusDays(7);
		date = parser.parseDate(input);
		assertThat(date.isPresent()).isTrue();
		assertThat(date.get()).isEqualTo(want);
	}
}