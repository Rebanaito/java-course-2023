package edu.hw6;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3Test {
	@Test
	@DisplayName("Readable test")
	void readableTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.readable();
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(9);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("Writeable test")
	void writeableTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.writeable();
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(9);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("Regular file test")
	void regularFileTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.regularFile();
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(5);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("Larger than test")
	void largerThanTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.largerThan(100_000);
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(0);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		filter = AbstractFilter.largerThan(10);
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(9);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("Smaller than test")
	void smallerThanTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.smallerThan(100_000);
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(9);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		filter = AbstractFilter.smallerThan(10);
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(0);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("Glob test")
	void globTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.globMatches("*.xml");
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	@DisplayName("Magic number test")
	void magicNumberTest() {
		DirectoryStream.Filter<Path> filter = AbstractFilter.magicNumber("<?xm".getBytes());
		try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("./"), filter)) {
			int size = 0;
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				iterator.next();
				size++;
			}
			assertThat(size).isEqualTo(2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}