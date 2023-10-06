public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 6, 0, 0, 5, 0, 0, 0},
            {0, 0, 8, 0, 0, 0, 0, 4, 5},
            {7, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 6, 0, 3},
            {0, 0, 0, 0, 0, 0, 0, 5, 0},
            {0, 3, 0, 6, 0, 0, 9, 0, 0},
            {9, 6, 0, 0, 0, 1, 3, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, 4, 0, 8, 2, 0, 0, 0}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Solves the Sudoku puzzle using backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // All cells filled
    }

    // Checks if a number can be placed in a particular cell
    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    // Print the Sudoku board
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
