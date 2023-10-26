package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
	@Test
	@DisplayName("Who called")
	void whoCalled() {
		var info = Info.callingInfo();
		assertThat(info.className()).isEqualTo("edu.hw2.Task4Test");
		assertThat(info.methodName()).isEqualTo("whoCalled");
	}
}