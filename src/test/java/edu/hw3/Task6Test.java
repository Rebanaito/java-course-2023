package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
	@Test
	@DisplayName("Stock exchange tests")
	void stockExchangeTest() {
		var exchange = new NYSE();
		exchange.add(new Stock("AAPL", 175.30));
		exchange.add(new Stock("BRK-B", 335.86));
		exchange.add(new Stock("VZ", 31.57));
		assertThat(exchange.mostValuableStock().tradedAs()).isEqualTo("BRK-B");
		exchange.remove(new Stock("BRK-B"));
		assertThat(exchange.mostValuableStock().tradedAs()).isEqualTo("AAPL");
		exchange.remove(new Stock("AAPL"));
		assertThat(exchange.mostValuableStock().tradedAs()).isEqualTo("VZ");
		exchange.remove(new Stock("VZ"));
		assertThat(exchange.mostValuableStock()).isNull();
	}
}