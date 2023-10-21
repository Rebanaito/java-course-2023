package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task8Test {
	@Test
	@DisplayName("Reverse iterator test")
	void reverseIteratorTest() {
		var reverseIterator = new ReverseIterator<>(List.of(1,2,3));
		assertThat(reverseIterator.next()).isEqualTo(3);
		assertThat(reverseIterator.next()).isEqualTo(2);
		assertThat(reverseIterator.next()).isEqualTo(1);
		assertThat(reverseIterator.hasNext()).isFalse();
	}
}