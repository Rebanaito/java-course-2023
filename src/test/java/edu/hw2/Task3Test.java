package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
	@Test
	@DisplayName("Default manager")
	void defaultManager() {
		boolean stable = false;
		boolean faulty = false;
		var manager = new DefaultConnectionManager();
		for (int i = 0; i < 1000; i++) {
			var conn = manager.getConnection();
			if (conn.getClass().toString().equals("class edu.hw2.StableConnection")) {
				stable = true;
			} else if (conn.getClass().toString().equals("class edu.hw2.FaultyConnection")) {
				faulty = true;
			}
		}
		assertThat(stable).isTrue();
		assertThat(faulty).isTrue();
	}

	@Test
	@DisplayName("Faulty manager")
	void faultyManager() {
		boolean stable = false;
		boolean faulty = false;
		var manager = new FaultyConnectionManager();
		for (int i = 0; i < 1000; i++) {
			var conn = manager.getConnection();
			if (conn.getClass().toString().equals("class edu.hw2.StableConnection")) {
				stable = true;
			} else if (conn.getClass().toString().equals("class edu.hw2.FaultyConnection")) {
				faulty = true;
			}
		}
		assertThat(stable).isFalse();
		assertThat(faulty).isTrue();
	}

	@Test
	@DisplayName("Stable connection")
	void stableConnection() {
		boolean threw = false;
		for (int i = 0; i < 1000; i++) {
			var stable = new StableConnection();
			try (stable) {
				stable.execute("Some command");
			} catch (ConnectionException exc) {
				threw = true;
			}
		}
		assertThat(threw).isFalse();
	}

	@Test
	@DisplayName("Faulty connection")
	void faultyConnection() {
		int thrown = 0;
		for (int i = 0; i < 1000; i++) {
			var faulty = new FaultyConnection();
			try (faulty) {
				faulty.execute("Some command");
			} catch (ConnectionException exc) {
				thrown++;
			}
		}
		assertThat(thrown).isNotEqualTo(1000);
		assertThat(thrown).isNotEqualTo(0);
	}
}