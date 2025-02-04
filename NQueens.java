public class NQueens {

    // Function to print the solution
    public static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;  // Same column
            }
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 1) {
                return false;  // Left diagonal
            }
            if (col + (row - i) < board.length && board[i][col + (row - i)] == 1) {
                return false;  // Right diagonal
            }
        }
        return true;
    }

    // Function to solve the N Queens problem using backtracking
    public static boolean solveNQueens(int[][] board, int row) {
        if (row == board.length) {
            printSolution(board);  // All queens are placed
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;  // Place the queen
                if (solveNQueens(board, row + 1)) {
                    return true;  // Recur to place the next queen
                }
                board[row][i] = 0;  // Backtrack if no solution is found
            }
        }
        return false;  // No safe place found
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];
        if (!solveNQueens(board, 0)) {
            System.out.println("No solution exists");
        }
    }
}
