package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class Task_8_Test {
	@Test
	@DisplayName("Valid boards")
	void validBoards() {
		boolean answer = Task_8.knightBoardCapture(new int[][]{
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{0, 0, 0, 0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0, 1, 0, 1},
				{1, 0, 0, 0, 1, 0, 1, 0},
				{0, 0, 0, 0, 0, 1, 0, 1},
				{1, 0, 0, 0, 1, 0, 1, 0},
				{0, 0, 0, 1, 0, 1, 0, 1}
		});
		assertThat(answer).isFalse();
		answer = Task_8.knightBoardCapture(new int[][]{
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 1, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 0}
		});
		assertThat(answer).isTrue();
		answer = Task_8.knightBoardCapture(new int[][]{
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0}
		});
		assertThat(answer).isFalse();
	}

	@Test
	@DisplayName("Invalid boards")
	void invalidBoards() {
		boolean answer = Task_8.knightBoardCapture(new int[][]{
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 0}
		});
		assertThat(answer).isFalse();
		answer = Task_8.knightBoardCapture(new int[][]{
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 1},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 0}
		});
		assertThat(answer).isFalse();
		answer = Task_8.knightBoardCapture(new int[][]{
				{0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 2, 0},
				{0, 1, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 0}
		});
		assertThat(answer).isFalse();
	}
}