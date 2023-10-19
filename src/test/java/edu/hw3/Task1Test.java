package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
	@Test
	@DisplayName("Atbash tests")
	void atbashTests() {
		String str = Atbash.atbash("Hello world!");
		assertThat(str).isEqualTo("Svool dliow!");

		str = Atbash.atbash("Any fool can write code that a computer can understand." +
				"Good programmers write code that humans can understand. ― Martin Fowler");
		assertThat(str).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw." +
				"Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");

		str = Atbash.atbash(null);
		assertThat(str).isNull();
	}
}