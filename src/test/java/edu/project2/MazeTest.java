package edu.project2;

import org.junit.jupiter.api.Test;

public class MazeTest {
	@Test
	@SuppressWarnings("TestOutput")
	void testOutput() {
		BacktrackerGenerator gen = new BacktrackerGenerator();
		var maze = gen.generate(20, 10);
		SimpleRenderer rend = new SimpleRenderer();
		BacktrackerSolver solver = new BacktrackerSolver();
		var solution = solver.solve(maze, new Coordinate(1, 1), new Coordinate(19, 39));
		System.out.println(rend.render(maze, solution));
	}
}