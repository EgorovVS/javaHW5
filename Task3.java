package HW5;

//Расставить 8 ферзей на доске 8х8 так, чтоб они не били друг друга.
public class Task3 {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        fillBoard(0, board);
    }
    public static void fillBoard(int raw, int[][] board) {
        if (raw == board.length) {
            print(board);
            System.out.println();
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(raw, i, board)) {
                board[raw][i] = 1;
                fillBoard(raw + 1, board);
                board[raw][i] = 0;
            }
        }
    }

    private static boolean isSafe(int raw, int column, int[][] board) {
        for (int i = 0; i < raw; i++) {
            if (board[i][column] == 1) return false;
        }
        for (int i = raw, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = raw, j = column; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println("\n");
        }
    }
}
