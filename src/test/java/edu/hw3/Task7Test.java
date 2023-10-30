package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

public class Task7Test {
	@Test
	@DisplayName("Custom comparator test")
	void customComparatorTest() {
		TreeMap<String, String> tree = new TreeMap<>(new CustomComparator());
		tree.put(null, "test");
		assertThat(tree.containsKey(null)).isTrue();
	}
}