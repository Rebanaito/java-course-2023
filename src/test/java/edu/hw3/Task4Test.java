package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
	@Test
	@DisplayName("Roman numeral tests")
	void romanNumeralTest() {
		String numeral = Roman.convertToRoman(2);
		assertThat(numeral).isEqualTo("II");

		numeral = Roman.convertToRoman(12);
		assertThat(numeral).isEqualTo("XII");

		numeral = Roman.convertToRoman(16);
		assertThat(numeral).isEqualTo("XVI");

		numeral = Roman.convertToRoman(0);
		assertThat(numeral).isEqualTo("");

		numeral = Roman.convertToRoman(1997);
		assertThat(numeral).isEqualTo("MCMXCVII");
	}
}