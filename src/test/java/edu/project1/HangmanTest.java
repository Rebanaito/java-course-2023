package edu.project1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HangmanTest {
	@Test
	@DisplayName("Invalid words")
	void invalidWords() {
		var sesh = new Session(new String[] {""});
		assertThat(sesh.play()).isEqualTo(1);

		sesh = new Session(new String[] {"pneumonoultramicroscopicsilicovolcanoconiosis."});
		assertThat(sesh.play()).isEqualTo(1);
	}

	@Test
	@DisplayName("Losing test")
	void losingTest() {
		var sesh = new Session(new String[] {"auto"});
		assertThat(sesh.gameOver()).isFalse();
		sesh.tryInput("a");
		sesh.tryInput("a");
		sesh.tryInput("a");
		sesh.tryInput("a");
		assertThat(sesh.gameOver()).isFalse();
		sesh.tryInput("a");
		sesh.tryInput("a");
		assertThat(sesh.gameOver()).isTrue();
		assertThat(sesh.haveLost()).isTrue();
		assertThat(sesh.haveWon()).isFalse();
	}

	@Test
	@DisplayName("Winning test")
	void winningTest() {
		var sesh = new Session(new String[] {"auto"});
		assertThat(sesh.gameOver()).isFalse();
		sesh.tryInput("a");
		sesh.tryInput("u");
		sesh.tryInput("t");
		assertThat(sesh.gameOver()).isFalse();
		sesh.tryInput("o");
		assertThat(sesh.gameOver()).isTrue();
		assertThat(sesh.haveLost()).isFalse();
		assertThat(sesh.haveWon()).isTrue();
	}

	@Test
	@DisplayName("Invalid input")
	void invalidInput() {
		var sesh = new Session(new String[] {"a"});
		assertThat(sesh.gameOver()).isFalse();
		sesh.tryInput("auto");
		assertThat(sesh.gameOver()).isFalse();
	}
}