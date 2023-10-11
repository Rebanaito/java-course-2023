package edu.hw1;

import java.util.logging.Logger;

@SuppressWarnings("TypeName")
public final class Task_8 {
    private Task_8() {
    }

    private final static Logger LOGGER = Logger.getLogger("LOGGER");

    @SuppressWarnings("MagicNumber")
    private static boolean checkNeighbor(int[][] board, int i, int j) {
        if (i < 0 || i >= 8 || j < 0 || j >= 8) {
            return false;
        }
        return (board[i][j] == 1);
    }

    private static boolean checkNeighbors(int[][] board, int i, int j) {
        boolean neighborsRight = checkNeighbor(board, i - 1, j + 2) | checkNeighbor(board, i + 1, j + 2);
        boolean neighborsDown = checkNeighbor(board, i + 2, j - 1) | checkNeighbor(board, i + 2, j + 1);
        return (neighborsRight | neighborsDown);
    }

    @SuppressWarnings("MagicNumber")
    private static boolean invalidBoard(int[][] board) {
        if (board.length != 8) {
            LOGGER.info("Board must have 8 rows");
            return true;
        }
        for (int i = 0; i < 8; i++) {
            if (board[i].length != 8) {
                LOGGER.info("Board must have 8 columns");
                return true;
            }
            for (int j = 0; j < 8; j++) {
                if (!(board[i][j] == 0 || board[i][j] == 1)) {
                    LOGGER.info("Only '1' and '0' are allowed");
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] board) {
        if (invalidBoard(board)) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
}
