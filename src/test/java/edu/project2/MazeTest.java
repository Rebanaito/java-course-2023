package edu.project2;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

public class MazeTest {
	@Test
	@DisplayName("InvalidInputs")
	void testInvalidInputs() {
		BacktrackerGenerator backtracker = new BacktrackerGenerator();
		var maze = backtracker.generate(0, 10);
		assertThat(maze).isNull();

		maze = backtracker.generate(10, 0);
		assertThat(maze).isNull();

		AldousBroderGenerator slow = new AldousBroderGenerator();
		maze = slow.generate(0, 10);
		assertThat(maze).isNull();

		maze = slow.generate(10, 0);
		assertThat(maze).isNull();

        BinaryTreeGenerator bin = new BinaryTreeGenerator();
        maze = bin.generate(0, 10);
        assertThat(maze).isNull();

        maze = bin.generate(10, 0);
        assertThat(maze).isNull();
	}

	@Test
	@DisplayName("EdgeCases")
	void testEdgeCases() {
		BacktrackerGenerator gen = new BacktrackerGenerator();
		AldousBroderGenerator slow = new AldousBroderGenerator();
        BinaryTreeGenerator bin = new BinaryTreeGenerator();
		var maze = gen.generate(5, 1);
		SimpleRenderer rend = new SimpleRenderer();
		String want = """
				⬛ ⬛ ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛   ⬛
				⬛ ⬛ ⬛""";
		assertThat(rend.render(maze)).isEqualTo(want);
		maze = slow.generate(5, 1);
		assertThat(rend.render(maze)).isEqualTo(want);
        maze = bin.generate(5, 1);
        assertThat(rend.render(maze)).isEqualTo(want);

		maze = gen.generate(1, 5);
		want = """
				⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛
				⬛                   ⬛
				⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛""";
		assertThat(rend.render(maze)).isEqualTo(want);
		maze = slow.generate(1, 5);
		assertThat(rend.render(maze)).isEqualTo(want);
        maze = bin.generate(1, 5);
        assertThat(rend.render(maze)).isEqualTo(want);
	}

	@Test
	@DisplayName("SolverTest")
	void SolverTest() {
		Maze maze = premadeMaze();
		BacktrackerSolver solver = new BacktrackerSolver();
		var solution = solver.solve(maze, new Coordinate(1, 1), new Coordinate(5, 1));
		SimpleRenderer rend = new SimpleRenderer();
		String backtracker = rend.render(maze, solution);
		String want = """
				⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛
				⬛ S ⬛       ⬛
				⬛ x ⬛ x x x ⬛
				⬛ x x x ⬛ x ⬛
				⬛ ⬛ ⬛ ⬛ ⬛ x ⬛
				⬛ E x x x x ⬛
				⬛ ⬛ ⬛ ⬛ ⬛ ⬛ ⬛""";
		assertThat(backtracker).isEqualTo(want);
	}

	private Maze premadeMaze() {
		int width = 7;
		int height = 7;
		Cell[][] cells = new Cell[height][];
		for (int i = 0; i < height; i++) {
			cells[i] = new Cell[width];
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
			}
		}
		for (int i = 0; i < height; i++) {
			cells[i][0] = new Cell(i, 0, Cell.Type.WALL);
			cells[i][width-1] = new Cell(i, width-1, Cell.Type.WALL);
		}
		for (int j = 1; j < width-1; j++) {
			cells[0][j] = new Cell(0, j, Cell.Type.WALL);
			cells[height - 1][j] = new Cell(height - 1, j, Cell.Type.WALL);
		}
		cells[1][2] = new Cell(1, 2, Cell.Type.WALL);
		cells[2][2] = new Cell(2, 2, Cell.Type.WALL);
		cells[3][4] = new Cell(3, 4, Cell.Type.WALL);
		cells[4][4] = new Cell(4, 4, Cell.Type.WALL);
		cells[4][3] = new Cell(4, 3, Cell.Type.WALL);
		cells[4][2] = new Cell(4, 2, Cell.Type.WALL);
		cells[4][1] = new Cell(4, 1, Cell.Type.WALL);
		return new Maze(cells.length, cells[0].length, cells);
	}
}