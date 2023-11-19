package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
	@Test
	@DisplayName("Contains")
	void contains() {
		String string = "Mitochondria is the powerhouse of the cell";
		String substring = "e po";
		assertThat(Task6.contains(string, substring)).isTrue();

		substring = "Mit";
		assertThat(Task6.contains(string, substring)).isTrue();

		substring = "ell";
		assertThat(Task6.contains(string, substring)).isTrue();
	}

	@Test
	@DisplayName("Does not contain")
	void notContain() {
		String string = "Mitochondria is the powerhouse of the cell";
		String substring = "pass";
		assertThat(Task6.contains(string, substring)).isFalse();

		substring = "contain";
		assertThat(Task6.contains(string, substring)).isFalse();

		substring = "ello";
		assertThat(Task6.contains(string, substring)).isFalse();
	}
}
