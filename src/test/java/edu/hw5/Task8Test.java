package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task8Test {
	@Test
	@DisplayName("Odd Length Test")
	void oddLengthTest() {
		String string = "010";
		assertThat(Task8.oddLength(string)).isTrue();

		string = "1010";
		assertThat(Task8.oddLength(string)).isFalse();

		string = "";
		assertThat(Task8.oddLength(string)).isFalse();

		string = "1";
		assertThat(Task8.oddLength(string)).isTrue();

		string = "0l0";
		assertThat(Task8.oddLength(string)).isFalse();
	}

	@Test
	@DisplayName("Odd Or Even Test")
	void oddOrEvenTest() {
		String string = "010";
		assertThat(Task8.oddOrEven(string)).isTrue();

		string = "1010";
		assertThat(Task8.oddOrEven(string)).isTrue();

		string = "";
		assertThat(Task8.oddOrEven(string)).isFalse();

		string = "1";
		assertThat(Task8.oddOrEven(string)).isFalse();

		string = "01";
		assertThat(Task8.oddLength(string)).isFalse();

		string = "0l0";
		assertThat(Task8.oddLength(string)).isFalse();
	}

	@Test
	@DisplayName("Number of 0s divisible by 3")
	void zeroesThreeTest() {
		String string = "010";
		assertThat(Task8.zeroesThree(string)).isFalse();

		string = "01010";
		assertThat(Task8.zeroesThree(string)).isTrue();

		string = "101";
		assertThat(Task8.zeroesThree(string)).isFalse();

		string = "1";
		assertThat(Task8.zeroesThree(string)).isFalse();

		string = "000";
		assertThat(Task8.zeroesThree(string)).isTrue();

		string = "000a";
		assertThat(Task8.zeroesThree(string)).isFalse();
	}

	@Test
	@DisplayName("String is not '11' or '111' Test")
	void notTwoOrThreeOnesTest() {
		String string = "11";
		assertThat(Task8.notTwoOrThreeOnes(string)).isFalse();

		string = "111";
		assertThat(Task8.notTwoOrThreeOnes(string)).isFalse();

		string = "110";
		assertThat(Task8.notTwoOrThreeOnes(string)).isTrue();

		string = "110111";
		assertThat(Task8.notTwoOrThreeOnes(string)).isTrue();

		string = "0111";
		assertThat(Task8.notTwoOrThreeOnes(string)).isTrue();

		string = "";
		assertThat(Task8.notTwoOrThreeOnes(string)).isTrue();

		string = "1a10101";
		assertThat(Task8.notTwoOrThreeOnes(string)).isFalse();
	}

	@Test
	@DisplayName("1s are only odd Test")
	void oddOnes() {
		String string = "";
		assertThat(Task8.oddOnes(string)).isFalse();

		string = "0";
		assertThat(Task8.oddOnes(string)).isFalse();

		string = "1";
		assertThat(Task8.oddOnes(string)).isTrue();

		string = "10";
		assertThat(Task8.oddOnes(string)).isTrue();

		string = "11";
		assertThat(Task8.oddOnes(string)).isTrue();

		string = "101";
		assertThat(Task8.oddOnes(string)).isTrue();

		string = "100";
		assertThat(Task8.oddOnes(string)).isFalse();

		string = "1a1";
		assertThat(Task8.oddOnes(string)).isFalse();
	}

	@Test
	@DisplayName("Mostly Zeroes Test")
	void mostlyZeroesTest() {
		String string = "";
		assertThat(Task8.mostlyZeroes(string)).isFalse();

		string = "0";
		assertThat(Task8.mostlyZeroes(string)).isFalse();

		string = "00";
		assertThat(Task8.mostlyZeroes(string)).isTrue();

		string = "100";
		assertThat(Task8.mostlyZeroes(string)).isTrue();

		string = "1001";
		assertThat(Task8.mostlyZeroes(string)).isFalse();

		string = "00000000000000";
		assertThat(Task8.mostlyZeroes(string)).isTrue();

		string = "00000l000";
		assertThat(Task8.mostlyZeroes(string)).isFalse();
	}

	@Test
	@DisplayName("1s Do Not Repeat Test")
	void onesNoRepeatTest() {
		String string = "";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "1";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "0";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "10";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "01";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "101";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "11";
		assertThat(Task8.onesNoRepeat(string)).isFalse();

		string = "00000000000000";
		assertThat(Task8.onesNoRepeat(string)).isTrue();

		string = "000000001100000000";
		assertThat(Task8.onesNoRepeat(string)).isFalse();
	}
}