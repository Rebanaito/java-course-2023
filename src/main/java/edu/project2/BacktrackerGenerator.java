package edu.project2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BacktrackerGenerator implements Generator {
    public BacktrackerGenerator() {
    }

    public Maze generate(int height, int width) {
        if (width <= 0 || height <= 0) {
            return null;
        }
        int[][] maze = new int[height][];
        for (int i = 0; i < height; i++) {
            maze[i] = new int[width];
            for (int j = 0; j < width; j++) {
                maze[i][j] = 0;
            }
        }
        carvePassage(0, 0, maze);
        return Maze.buildMaze(maze);
    }

    private void carvePassage(int cx, int cy, int[][] grid) {
        Integer[] directions = {Maze.UP, Maze.DOWN, Maze.LEFT, Maze.RIGHT};
        List<Integer> list = Arrays.asList(directions);
        Collections.shuffle(list);
        list.toArray(directions);

        for (int dir : directions) {
            int nx = cx + Maze.nextX(dir);
            int ny = cy + Maze.nextY(dir);

            if (!(ny >= 0 && ny <= grid.length - 1) || !(nx >= 0 && nx <= grid[0].length - 1)) {
                continue;
            }
            if (grid[ny][nx] != 0) {
                continue;
            }
            grid[cy][cx] |= dir;
            grid[ny][nx] |= Maze.opposite(dir);
            carvePassage(nx, ny, grid);
        }
    }
}
