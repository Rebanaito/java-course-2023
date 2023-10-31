package edu.project2;

import java.util.List;

public class SimpleRenderer implements Renderer {
	public SimpleRenderer() {
	}
	public String render(Maze maze) {
		int height = maze.getHeight();
		int width = maze.getWidth();
		StringBuilder builder = new StringBuilder(height * width);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Cell.Type type = maze.getType(j, i);
				if (type == Cell.Type.WALL) {
					builder.append('*');
				} else {
					builder.append(' ');
				}
				if (j != width - 1) {
					builder.append(' ');
				}
			}
			if (i != height - 1) {
				builder.append('\n');
			}
		}
		return builder.toString();
	}

	public String render(Maze maze, List<Coordinate> path) {
		return null;
	}
}
