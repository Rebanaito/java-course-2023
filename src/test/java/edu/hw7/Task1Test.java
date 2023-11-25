package edu.hw7;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
	@Test
	@DisplayName("Valid values test")
	void validValuesTest() {
		int value = 0;
		int threadCount = 1;
		int expected = value + threadCount;

		value = AtomicIncrement.threadedIncrement(value, threadCount);
		assertThat(value).isEqualTo(expected);

		value = 0;
		threadCount = 42;
		expected = value + threadCount;

		value = AtomicIncrement.threadedIncrement(value, threadCount);
		assertThat(value).isEqualTo(expected);

		value = -42;
		threadCount = 21;
		expected = value + threadCount;

		value = AtomicIncrement.threadedIncrement(value, threadCount);
		assertThat(value).isEqualTo(expected);
	}

	@Test
	@DisplayName("Valid values test (extremes)")
	void extremeValidValuesTest() {
		int value = 2147483637;
		int threadCount = 10;
		int expected = value + threadCount;

		value = AtomicIncrement.threadedIncrement(value, threadCount);
		assertThat(value).isEqualTo(expected);

		value = 0;
		threadCount = 256;
		expected = value + threadCount;

		value = AtomicIncrement.threadedIncrement(value, threadCount);
		assertThat(value).isEqualTo(expected);
	}

	@Test
	@DisplayName("Invalid values test")
	void invalidValuesTest() {
		int value = 2147483647;
		int expected = value;
		int threadCount = 1;
		boolean exception = false;

		try {
			value = AtomicIncrement.threadedIncrement(value, threadCount);
		} catch (IllegalArgumentException ignored) {
			exception = true;
		} finally {
			assertThat(exception).isTrue();
			assertThat(value).isEqualTo(expected);
		}

		value = 0;
		expected = value;
		threadCount = 257;
		exception = false;

		try {
			value = AtomicIncrement.threadedIncrement(value, threadCount);
		} catch (IllegalArgumentException ignored) {
			exception = true;
		} finally {
			assertThat(exception).isTrue();
			assertThat(value).isEqualTo(expected);
		}

		threadCount = 0;
		exception = false;

		try {
			value = AtomicIncrement.threadedIncrement(value, threadCount);
		} catch (IllegalArgumentException ignored) {
			exception = true;
		} finally {
			assertThat(exception).isTrue();
			assertThat(value).isEqualTo(expected);
		}
	}
}
