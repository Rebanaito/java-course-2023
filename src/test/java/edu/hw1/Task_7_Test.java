package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task_7_Test {
	@Test
	@DisplayName("Normal cases")
	void normalCases() {
		int answer = Task_7.rotateRight(8, 1);
		assertThat(answer).isEqualTo(4);

		answer = Task_7.rotateLeft(16, 1);
		assertThat(answer).isEqualTo(1);

		answer = Task_7.rotateLeft(17, 2);
		assertThat(answer).isEqualTo(6);

		answer = Task_7.rotateRight(42, 7);
		assertThat(answer).isEqualTo(21);
	}

	@Test
	@DisplayName("Edgier cases")
	void edgierCases() {
		int answer = Task_7.rotateRight(-8, 1);
		assertThat(answer).isEqualTo(-4);

		answer = Task_7.rotateLeft(-16, 1);
		assertThat(answer).isEqualTo(-1);

		answer = Task_7.rotateLeft(-17, 2);
		assertThat(answer).isEqualTo(-6);

		answer = Task_7.rotateRight(-42, 7);
		assertThat(answer).isEqualTo(-21);

		answer = Task_7.rotateRight(1, 42);
		assertThat(answer).isEqualTo(1);

		answer = Task_7.rotateLeft(8, -1);
		assertThat(answer).isEqualTo(4);

		answer = Task_7.rotateRight(16, -1);
		assertThat(answer).isEqualTo(1);

		answer = Task_7.rotateRight(0, 7);
		assertThat(answer).isEqualTo(0);

		answer = Task_7.rotateRight(2147483647, 3);
		assertThat(answer).isEqualTo(2147483647);

		answer = Task_7.rotateLeft(-2147483648, 3);
		assertThat(answer).isEqualTo(-2147483648);
	}
}