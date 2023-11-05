package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {
	@Test
	@DisplayName("At least 3 and 3rd is 0")
	void threePlus() {
		String string = "000";
		assertThat(Task7.threePlus(string)).isTrue();

		string = "110";
		assertThat(Task7.threePlus(string)).isTrue();

		string = "0101";
		assertThat(Task7.threePlus(string)).isTrue();

		string = "00";
		assertThat(Task7.threePlus(string)).isFalse();

		string = "001";
		assertThat(Task7.threePlus(string)).isFalse();

		string = "0a0";
		assertThat(Task7.threePlus(string)).isFalse();
	}

	@Test
	@DisplayName("Begins and ends with the same character")
	void sameFirstLast() {
		String string = "000";
		assertThat(Task7.sameFirstLast(string)).isTrue();

		string = "01101010111110";
		assertThat(Task7.sameFirstLast(string)).isTrue();

		string = "1011";
		assertThat(Task7.sameFirstLast(string)).isTrue();

		string = "1000";
		assertThat(Task7.sameFirstLast(string)).isFalse();

		string = "0011";
		assertThat(Task7.sameFirstLast(string)).isFalse();

		string = "0a0";
		assertThat(Task7.sameFirstLast(string)).isFalse();
	}

	@Test
	@DisplayName("Length between 1 and 3")
	void oneToThree() {
		String string = "101";
		assertThat(Task7.oneToThree(string)).isTrue();

		string = "000000";
		assertThat(Task7.oneToThree(string)).isFalse();

		string = "1111";
		assertThat(Task7.oneToThree(string)).isFalse();

		string = "10";
		assertThat(Task7.oneToThree(string)).isTrue();

		string = "0";
		assertThat(Task7.oneToThree(string)).isTrue();

		string = "1a";
		assertThat(Task7.oneToThree(string)).isFalse();
	}
}
