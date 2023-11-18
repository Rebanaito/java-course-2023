package edu.hw6;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task4Test {
	@Test
	@DisplayName("Normal case")
	void normalTest() {
		Path file = Path.of("composition.txt");
		String text = "Programming is learned by writing programs. ― Brian Kernighan";
		try {
			boolean success = OutputComposition.writeToFile(file.toString(), text);
			assertThat(success).isTrue();
			assertThat(Files.exists(file)).isTrue();
			String check = Files.readString(file);
			assertThat(check).isEqualTo(text);
			Files.delete(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("File already exists")
	void fileExistsTest() {
		Path file = Path.of("pom.xml");
		String text = "Programming is learned by writing programs. ― Brian Kernighan";
		try {
			boolean success = OutputComposition.writeToFile(file.toString(), text);
			assertThat(success).isFalse();
			assertThat(Files.exists(file)).isTrue();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
