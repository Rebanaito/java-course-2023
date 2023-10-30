package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
	@Test
	@DisplayName("Clusterize tests")
	void clusterizeTests() {
		String[] clusters = Cluster.clusterize("()()()");
		assertThat(clusters.length).isEqualTo(3);
		assertThat(clusters[0]).isEqualTo("()");
		assertThat(clusters[1]).isEqualTo("()");
		assertThat(clusters[2]).isEqualTo("()");

		clusters = Cluster.clusterize("((()))");
		assertThat(clusters.length).isEqualTo(1);
		assertThat(clusters[0]).isEqualTo("((()))");

		clusters = Cluster.clusterize("((()))(())()()(()())");
		assertThat(clusters.length).isEqualTo(5);
		assertThat(clusters[0]).isEqualTo("((()))");
		assertThat(clusters[1]).isEqualTo("(())");
		assertThat(clusters[2]).isEqualTo("()");
		assertThat(clusters[3]).isEqualTo("()");
		assertThat(clusters[4]).isEqualTo("(()())");

		clusters = Cluster.clusterize("((())())(()(()()))");
		assertThat(clusters.length).isEqualTo(2);
		assertThat(clusters[0]).isEqualTo("((())())");
		assertThat(clusters[1]).isEqualTo("(()(()()))");

		clusters = Cluster.clusterize(null);
		assertThat(clusters).isNull();

		clusters = Cluster.clusterize("((");
		assertThat(clusters).isNull();
	}
}