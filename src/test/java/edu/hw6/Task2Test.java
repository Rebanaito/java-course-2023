package edu.hw6;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Task2Test {
	@Test
	@DisplayName("File exists, no copies, with suffix")
	void noCopiesSuffix() throws IOException {
		File file = new File("tinkoff.txt");
		file.createNewFile();
		file.deleteOnExit();

		byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
		Files.write(file.toPath(), bytes);

		Path copy = ClonePath.clonePath(file.toPath());

		assertThat(copy.toString()).isEqualTo("tinkoff - copy.txt");

		byte[] copied = Files.readAllBytes(copy);
		assertThat(Arrays.equals(copied, bytes)).isTrue();

		Files.delete(copy);
	}

	@Test
	@DisplayName("File exists, multiple copies, with suffix")
	void copiesSuffix() throws IOException {
		File file = new File("tinkoff.txt");
		file.createNewFile();
		file.deleteOnExit();

		byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
		Files.write(file.toPath(), bytes);

		Path copy = ClonePath.clonePath(file.toPath());
		Path secondCopy = ClonePath.clonePath(file.toPath());
		Path thirdCopy = ClonePath.clonePath(file.toPath());

		assertThat(secondCopy.toString()).isEqualTo("tinkoff - copy (1).txt");
		assertThat(thirdCopy.toString()).isEqualTo("tinkoff - copy (2).txt");

		byte[] copied = Files.readAllBytes(secondCopy);
		assertThat(Arrays.equals(copied, bytes)).isTrue();
		copied = Files.readAllBytes(thirdCopy);
		assertThat(Arrays.equals(copied, bytes)).isTrue();

		Files.delete(copy);
		Files.delete(secondCopy);
		Files.delete(thirdCopy);
	}

	@Test
	@DisplayName("File exists, no copies, no suffix")
	void noCopiesNoSuffix() throws IOException {
		File file = new File("tinkoff");
		file.createNewFile();
		file.deleteOnExit();

		byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
		Files.write(file.toPath(), bytes);

		Path copy = ClonePath.clonePath(file.toPath());

		assertThat(copy.toString()).isEqualTo("tinkoff - copy");

		byte[] copied = Files.readAllBytes(copy);
		assertThat(Arrays.equals(copied, bytes)).isTrue();

		Files.delete(copy);
	}

	@Test
	@DisplayName("File exists, multiple copies, no suffix")
	void copiesNoSuffix() throws IOException {
		File file = new File("tinkoff");
		file.createNewFile();
		file.deleteOnExit();

		byte[] bytes = {'H', 'e', 'l', 'l', 'o'};
		Files.write(file.toPath(), bytes);

		Path copy = ClonePath.clonePath(file.toPath());
		Path secondCopy = ClonePath.clonePath(file.toPath());
		Path thirdCopy = ClonePath.clonePath(file.toPath());

		assertThat(secondCopy.toString()).isEqualTo("tinkoff - copy (1)");
		assertThat(thirdCopy.toString()).isEqualTo("tinkoff - copy (2)");

		byte[] copied = Files.readAllBytes(secondCopy);
		assertThat(Arrays.equals(copied, bytes)).isTrue();
		copied = Files.readAllBytes(thirdCopy);
		assertThat(Arrays.equals(copied, bytes)).isTrue();

		Files.delete(copy);
		Files.delete(secondCopy);
		Files.delete(thirdCopy);
	}
}
