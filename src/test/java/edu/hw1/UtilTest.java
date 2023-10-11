package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {
	@Test
	@DisplayName("Atoi tests")
	void atoiTests() {
		int result = Utils.atoi("");
		assertThat(result).isEqualTo(0);

		result = Utils.atoi((String)null);
		assertThat(result).isEqualTo(0);

		result = Utils.atoi("aaaaa2");
		assertThat(result).isEqualTo(0);

		result = Utils.atoi("123aaa002");
		assertThat(result).isEqualTo(123);

		result = Utils.atoi("2147483647");
		assertThat(result).isEqualTo(2147483647);

		result = Utils.atoi("-2147483648");
		assertThat(result).isEqualTo(-2147483648);

		result = Utils.atoi("123454321");
		assertThat(result).isEqualTo(123454321);
	}

	@Test
	@DisplayName("Itoa tests")
	void itoaTests() {
		String result = Utils.itoa(0);
		assertThat(result).isEqualTo("0").hasSameSizeAs("0");

		result = Utils.itoa(2147483647);
		assertThat(result).isEqualTo("2147483647").hasSameSizeAs("2147483647");

		result = Utils.itoa(-2147483648);
		assertThat(result).isEqualTo("-2147483648").hasSameSizeAs("-2147483648");

		result = Utils.itoa(123454321);
		assertThat(result).isEqualTo("123454321").hasSameSizeAs("123454321");

		result = Utils.itoa(-42);
		assertThat(result).isEqualTo("-42").hasSameSizeAs("-42");
	}

	@Test
	@DisplayName("IsNum tests")
	void isNumTests() {
		boolean answer = Utils.isNum("123");
		assertThat(answer).isTrue();

		answer = Utils.isNum("-123");
		assertThat(answer).isTrue();

		answer = Utils.isNum("+123");
		assertThat(answer).isTrue();

		answer = Utils.isNum("-123a");
		assertThat(answer).isFalse();

		answer = Utils.isNum("a123");
		assertThat(answer).isFalse();

		answer = Utils.isNum("");
		assertThat(answer).isFalse();

		answer = Utils.isNum(null);
		assertThat(answer).isFalse();
	}
}