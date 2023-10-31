package edu.project2;

public final class Maze {
	public Maze(int height, int width, Cell[][] grid) {
		this.height = height;
		this.width = width;
		this.grid = grid;
	}
	private final int height;
	private final int width;
	private final Cell[][] grid;

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Cell.Type getType(int x, int y) {
		return grid[y][x].type();
	}
}

