package edu.hw3;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
	@Test
	@DisplayName("FreqDict tests")
	void freqDictTests() {
		var table = FrequencyDict.freqDict(new String[] {"a", "bb", "a", "bb"});
		assertThat(table).containsKeys("a", "bb").containsValues(2, 2);

		table = FrequencyDict.freqDict(new String[] {"this", "and", "that", "and"});
		assertThat(table).containsKeys("this", "and", "that").containsValues(1, 2, 1);

		table = FrequencyDict.freqDict(new String[] {"код", "код", "код", "bug"});
		assertThat(table).containsKeys("код", "bug").containsValues(3, 1);

		var intTable = FrequencyDict.freqDict(new Integer[] {1, 1, 2, 2});
		assertThat(intTable).containsKeys(1, 2).containsValues(2, 2);

		var doubleTable = FrequencyDict.freqDict(new Double[] {2.1, 4.2, 21., 42., 2.1});
		assertThat(doubleTable).containsKeys(2.1, 4.2, 21., 42.).containsValues(2, 1, 1, 1);
	}
}