package edu.project2;

import org.junit.jupiter.api.Test;

public class MazeTest {
	@Test
	@SuppressWarnings("TestOutput")
	void testOutput() {
		DepthGenerator gen = new DepthGenerator();
		var maze = gen.generate(20, 10);
		SimpleRenderer rend = new SimpleRenderer();
		System.out.println(rend.render(maze));
	}
}