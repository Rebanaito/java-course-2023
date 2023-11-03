package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTreeGenerator implements Generator {
    public BinaryTreeGenerator() {
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

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                List<Integer> directions = new ArrayList<>();
                if (i > 0) {
                    directions.add(Maze.UP);
                }
                if (j > 0) {
                    directions.add(Maze.LEFT);
                }
                if (directions.isEmpty()) {
                    continue;
                }
                int dir = directions.get(rand.nextInt(directions.size()));
                int nx = j + Maze.nextX(dir);
                int ny = i + Maze.nextY(dir);
                maze[i][j] |= dir;
                maze[ny][nx] |= Maze.opposite(dir);
            }
        }
    }
}
