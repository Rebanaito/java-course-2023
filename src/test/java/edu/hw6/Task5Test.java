package edu.hw6;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
	@Test
	@DisplayName("Top news test")
	void topNewsTest() {
		var response = HackerNews.hackerNewsTopStories();
		assertThat(response.length).isNotEqualTo(0);
	}

	@Test
	@DisplayName("Article by ID test")
	void newsTest() {
		var title = HackerNews.news(37570037);
		assertThat(title).isEqualTo("JDK 21 Release Notes");

		title = HackerNews.news(375700372);
		assertThat(title).isNull();
	}
}