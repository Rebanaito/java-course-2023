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

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 4;
    public static final int LEFT = 8;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell.Type getType(int x, int y) {
        return grid[y][x].type();
    }

    public static Maze buildMaze(int[][] maze) {
        Cell[][] cells = allocCells(maze.length, maze[0].length);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                cells[2 * i + 1][2 * j + 1] = new Cell(2 * i + 1, 2 * j + 1, Cell.Type.PASSAGE);
                if ((maze[i][j] & Maze.DOWN) != 0) {
                    cells[2 * i + 2][2 * j + 1] = new Cell(2 * i + 2, 2 * j + 1, Cell.Type.PASSAGE);
                }
                if ((maze[i][j] & Maze.RIGHT) != 0) {
                    cells[2 * i + 1][2 * j + 2] = new Cell(2 * i + 1, 2 * j + 2, Cell.Type.PASSAGE);
                    if (((maze[i][j] | maze[i][j + 1]) & Maze.DOWN) != 0) {
                        cells[2 * i + 2][2 * j + 2] = new Cell(2 * i + 2, 2 * j + 2, Cell.Type.PASSAGE);
                    }
                }
            }
        }
        return new Maze(cells.length, cells[0].length, cells);
    }

    private static Cell[][] allocCells(int height, int width) {
        Cell[][] cells = new Cell[height * 2 + 1][];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell[width * 2 + 1];
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
        return cells;
    }

    public static int nextX(int dir) {
        return switch (dir) {
            case RIGHT -> 1;
            case LEFT -> -1;
            default -> 0;
        };
    }

    public static int nextY(int dir) {
        return switch (dir) {
            case UP -> -1;
            case DOWN -> 1;
            default -> 0;
        };
    }

    public static int opposite(int direction) {
        return switch (direction) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            default -> 0;
        };
    }
}

