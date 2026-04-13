import java.util.Scanner;

public class TicTacToe {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameRunning = true;

        printBoard();

        while (gameRunning) {
            System.out.println("Player " + currentPlayer + ", enter position (1-9): ");
            int pos = sc.nextInt();

            if (pos < 1 || pos > 9 || board[pos - 1] != ' ') {
                System.out.println("Invalid move, try again!");
                continue;
            }

            board[pos - 1] = currentPlayer;
            printBoard();

            if (checkWinner()) {
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameRunning = false;
            } else if (isBoardFull()) {
                System.out.println("🤝 It's a draw!");
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWinner() {
        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, // rows
            {0,3,6}, {1,4,7}, {2,5,8}, // cols
            {0,4,8}, {2,4,6}           // diagonals
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == currentPlayer &&
                board[pos[1]] == currentPlayer &&
                board[pos[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    static boolean isBoardFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }
}