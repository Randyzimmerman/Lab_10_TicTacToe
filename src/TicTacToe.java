import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        initializeBoard();

        boolean gameWon = false;
        boolean gameTied = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameWon && !gameTied) {
            displayBoard();
            int row, col;

            
            System.out.print("Enter row (0, 1, 2) for " + currentPlayer + ": ");
            row = scanner.nextInt();
            System.out.print("Enter column (0, 1, 2) for " + currentPlayer + ": ");
            col = scanner.nextInt();


            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                if (isWin(currentPlayer)) {
                    gameWon = true;
                    displayBoard();
                    System.out.println(currentPlayer + " wins!");
                } else if (isTie()) {
                    gameTied = true;
                    displayBoard();
                    System.out.println("It's a tie!");
                } else {
                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }


    public static void initializeBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }


    public static void displayBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < ROW - 1) {
                System.out.println("---------");
            }
        }
    }


    public static boolean isWin(String player) {

        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }


        for (int j = 0; j < COL; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }

        return false;
    }


    public static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" ");
    }
}
