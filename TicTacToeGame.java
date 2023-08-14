import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameWon = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameWon) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col, board)) {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard(board);
        System.out.println("Player " + currentPlayer + " wins!");
        scanner.close();
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean isValidMove(int row, int col, char[][] board) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
}
