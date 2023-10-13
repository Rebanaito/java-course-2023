package edu.hw1;

import java.util.logging.Logger;

@SuppressWarnings("TypeName")
public final class Task_8 {
    private Task_8() {
    }

    private final static Logger LOGGER = Logger.getLogger("LOGGER");
    private final static int BOARD_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        if (invalidBoard(board)) {
            return false;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (checkNeighbors(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkNeighbor(int[][] board, int i, int j) {
        if (i < 0 || i >= BOARD_SIZE || j < 0 || j >= BOARD_SIZE) {
            return false;
        }
        return (board[i][j] == 1);
    }

    private static boolean checkNeighbors(int[][] board, int i, int j) {
        boolean neighborsRight = checkNeighbor(board, i - 1, j + 2) | checkNeighbor(board, i + 1, j + 2);
        boolean neighborsDown = checkNeighbor(board, i + 2, j - 1) | checkNeighbor(board, i + 2, j + 1);
        return (neighborsRight | neighborsDown);
    }

    private static boolean invalidBoard(int[][] board) {
        if (board.length != BOARD_SIZE) {
            LOGGER.info("Board must have 8 rows");
            return true;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i].length != BOARD_SIZE) {
                LOGGER.info("Board must have 8 columns");
                return true;
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!(board[i][j] == 0 || board[i][j] == 1)) {
                    LOGGER.info("Only '1' and '0' are allowed");
                    return true;
                }
            }
        }
        return false;
    }
}
