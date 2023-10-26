package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
	@Test
	@DisplayName("Normal cases")
	void normalCases() {
		var rect = new Rectangle(2, 4);
		assertThat(rect.area()).isEqualTo(8);

		rect = rect.setWidth(4);
		assertThat(rect.area()).isEqualTo(16);

		var square = new Square(3);
		assertThat(square.area()).isEqualTo(9);

		square = square.setHeight(5);
		assertThat(square.area()).isEqualTo(25);
	}

	@Test
	@DisplayName("Edge cases")
	void edgeCases() {
		var rect = new Rectangle(2, 4);
		rect.setHeight(6);
		assertThat(rect.area()).isEqualTo(8);

		rect = new Rectangle(-2, 4);
		assertThat(rect.area()).isEqualTo(0);

		var square = new Square(3);
		square.setHeight(2);
		assertThat(square.area()).isEqualTo(9);

		square = square.setHeight(10);
		square = square.setWidth(11);
		assertThat(square.area()).isEqualTo(121);
	}
}