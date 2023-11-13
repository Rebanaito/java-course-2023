package edu.project2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AldousBroderGenerator implements Generator {
    public AldousBroderGenerator() {
    }

    @Override
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
        carvePassage(maze);
        return Maze.buildMaze(maze);
    }

    private void carvePassage(int[][] maze) {
        int height = maze.length;
        int width = maze[0].length;

        Random rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(height);
        int remaining = height * width - 1;
        while (remaining > 0) {
            Integer[] directions = {Maze.UP, Maze.DOWN, Maze.LEFT, Maze.RIGHT};
            List<Integer> list = Arrays.asList(directions);
            Collections.shuffle(list);
            list.toArray(directions);
            for (int dir : directions) {
                int nx = x + Maze.nextX(dir);
                int ny = y + Maze.nextY(dir);

                if (!(ny >= 0 && ny < height) || !(nx >= 0 && nx < width)) {
                    continue;
                }
                if (maze[ny][nx] == 0) {
                    maze[y][x] |= dir;
                    maze[ny][nx] |= Maze.opposite(dir);
                    remaining--;
                }
                x = nx;
                y = ny;
                break;
            }
        }
    }
}
