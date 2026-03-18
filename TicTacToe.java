// Name: Raymond Zhang
// Program Name: Tic Tac Toe Lab
// Date: 3/10/25
// Extra: I made an isValidMove() function to check if a user's move is valid in the sense that the spot is not already taken and that it does not not exceed the bounds of the grid.

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] grid = new char[3][3];
        welcome();
        for (int i = 1; i <= 9; i++) {
            int player;
            if (i % 2 != 0) {
                player = 1;
                System.out.println("Player 1's Turn | Enter the row # and column # of the move you would like to make (i.e: 2 1). Remember to use 0-2 for both the row & column number.");
                int row = s.nextInt();
                int col = s.nextInt();
                if (isValidMove(grid, row, col)) {
                    grid[row][col] = 'X';
                }
                else {
                    System.out.println("Invalid move. Try again.");
                    i--; // Re-do player trun in case move is invalid.
                }    
            }
            else {
                player = 2;
                System.out.println("Player 2's Turn | Enter the row # and column # of the move you would like to make (i.e: 2 1). Remember to use 0-2 for both the row & column number.");
                int row = s.nextInt();
                int col = s.nextInt();
                if (isValidMove(grid, row, col)) {
                    grid[row][col] = 'O';
                }
                else {
                    System.out.println("Invalid move. Try again.");
                    i--;
                } 
            }
            showGameBoard(grid); // Display board.
            int result = checkForWinner(grid, player);
            if (result != 0) {
                System.out.println("Congratulations Player " + result + ", you win!");
                break;
            }
        }
    }

    public static void welcome() {
        System.out.println("=================================");
        System.out.println("        TIC TAC TOE GAME         ");
        System.out.println("=================================");
        System.out.println("Two players will take turns.");
        System.out.println("Player 1 = X");
        System.out.println("Player 2 = O");
        System.out.println("Enter the row and column numbers");
        System.out.println("to place your symbol on the board.");
        System.out.println("First player to get 3 in a row wins!");
        System.out.println("=================================");
    }

    public static void showGameBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int checkForWinner(char[][] array, int player) {
        char var;
        if (player == 1) {
            var = 'X';
        }
        else {
            var = 'O';
        }
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == var && array[i][1] == var && array[i][2] == var) {
                return player;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (array[0][j] == var && array[1][j] == var && array[2][j] == var) {
                return player;
            }
        }
        if (array[0][0] == var && array[1][1] == var && array[2][2] == var) {
            return player;
        }
        if (array[0][2] == var && array[1][1] == var && array[2][0] == var) {
            return player;
        }
        return 0;
    }

    public static boolean isValidMove(char[][] grid, int row, int col) { // Extra
        if ((row > -1 && row < 3) && (col > -1 && col < 3) && (grid[row][col] == '\0')) { // Checks if move is within bounds and move does not take up another player's spot {
            return true;
        }
        return false;
    }

}