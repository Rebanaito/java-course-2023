package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {
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