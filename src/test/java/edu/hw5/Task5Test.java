package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
	@Test
	@DisplayName("Valid plates")
	void validPlates() {
		String plate = "А123ВЕ777";
		assertThat(Task5.validPlate(plate)).isTrue();

		plate = "К777МН177";
		assertThat(Task5.validPlate(plate)).isTrue();

		plate = "О123РС08";
		assertThat(Task5.validPlate(plate)).isTrue();

		plate = "Х123ТУ05";
		assertThat(Task5.validPlate(plate)).isTrue();
	}

	@Test
	@DisplayName("Invalid plates")
	void invalidPlates() {
		// Missing digits
		String plate = "А12ВЕ777";
		assertThat(Task5.validPlate(plate)).isFalse();

		// English 'A' instead of the Russian one
		plate = "A123ВЕ777";
		assertThat(Task5.validPlate(plate)).isFalse();

		// String has extra characters outside the pattern
		plate = "А123ВЕ777А";
		assertThat(Task5.validPlate(plate)).isFalse();

		plate = "АА123ВЕ777";
		assertThat(Task5.validPlate(plate)).isFalse();

		// Invalid Russian character
		plate = "А123БЕ777";
		assertThat(Task5.validPlate(plate)).isFalse();
	}
}