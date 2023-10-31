package edu.project2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BacktrackerGenerator implements Generator {
	public BacktrackerGenerator() {
	}

	private final int UP = 1;
	private final int DOWN = 2;
	private final int RIGHT = 4;
	private final int LEFT = 8;

	public Maze generate(int width, int height) {
		int[][] maze = new int[height][];
		for (int i = 0; i < height; i++) {
			maze[i] = new int[width];
			for (int j = 0; j < width; j++) {
				maze[i][j] = 0;
			}
		}
		carve_passage(0, 0, maze);
		return printMaze(maze);
	}

	private Maze printMaze(int[][] maze) {
		Cell[][] cells = new Cell[maze.length * 2 + 1][];
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new Cell[maze[0].length * 2 + 1];
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = new Cell(i, j, Cell.Type.WALL);
			}
		}

		System.out.print(' ');
		for (int a = 0; a < maze[0].length * 2 - 1; a++) {
			System.out.print('_');
		}
		System.out.println();
		for (int i = 0; i < maze.length; i++) {
			System.out.print('|');
			for (int j = 0; j < maze[i].length; j++) {
				cells[2*i+1][2*j+1] = new Cell(2*i+1, 2*j+1, Cell.Type.PASSAGE);
				if ((maze[i][j] & DOWN) != 0) {
					cells[2*i+2][2*j+1] = new Cell(2*i+2, 2*j+1, Cell.Type.PASSAGE);
					System.out.print(' ');
				} else {
					System.out.print('_');
				}
				if ((maze[i][j] & RIGHT) != 0) {
					cells[2*i+1][2*j+2] = new Cell(2*i+1, 2*j+2, Cell.Type.PASSAGE);
					if (((maze[i][j] | maze[i][j+1]) & DOWN) != 0) {
						cells[2*i+2][2*j+2] = new Cell(2*i+2, 2*j+2, Cell.Type.PASSAGE);
						System.out.print(' ');
					} else {
						System.out.print('_');
					}
				} else {
					System.out.print('|');
				}
			}
			System.out.println();
		}
		return new Maze(cells.length, cells[0].length, cells);
	}

	private void carve_passage(int cx, int cy, int[][] grid) {
		Integer[] directions = {UP, DOWN, LEFT, RIGHT};
		List<Integer> list = Arrays.asList(directions);
		Collections.shuffle(list);
		list.toArray(directions);

		for (int dir : directions) {
			int nx = cx + nextX(dir);
			int ny = cy + nextY(dir);

			if (!(ny >= 0 && ny <= grid.length-1) || !(nx >= 0 && nx <= grid[0].length-1)) {
				continue;
			}
			if (grid[ny][nx] != 0) {
				continue;
			}
			grid[cy][cx] |= dir;
			grid[ny][nx] |= opposite(dir);
			carve_passage(nx, ny, grid);
		}
	}

	private int nextX(int dir) {
		return switch (dir) {
			case RIGHT -> 1;
			case LEFT -> -1;
			default -> 0;
		};
	}

	private int nextY(int dir) {
		return switch (dir) {
			case UP -> -1;
			case DOWN -> 1;
			default -> 0;
		};
	}

	public int opposite(int direction) {
		return switch (direction) {
			case UP -> DOWN;
			case DOWN -> UP;
			case LEFT -> RIGHT;
			case RIGHT -> LEFT;
			default -> 0;
		};
	}
}
