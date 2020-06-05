package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String game = "         ";
        

        char[][] gameField = new char[4][4];

        gameField[1][3] = game.charAt(0);
        gameField[2][3] = game.charAt(1);
        gameField[3][3] = game.charAt(2);
        gameField[1][2] = game.charAt(3);
        gameField[2][2] = game.charAt(4);
        gameField[3][2] = game.charAt(5);
        gameField[1][1] = game.charAt(6);
        gameField[2][1] = game.charAt(7);
        gameField[3][1] = game.charAt(8);

        printGameField(gameField);

        boolean goodMove;
        int row;
        int col;
        char currentMove = 'X';
        do {
            goodMove = false;
            do {
                System.out.println("Enter the coordinates:");
                String move = sc.nextLine();

                Scanner scMove = new Scanner(move);
                if (!scMove.hasNextInt()) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                row = scMove.nextInt();
                col = scMove.nextInt();
                if (row < 1 || row > 3 || col < 1 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (gameField[row][col] == 'X' || gameField[row][col] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                gameField[row][col] = currentMove;

                goodMove = true;
            } while (!goodMove);
            printGameField(gameField);
            if (currentMove == 'X') {
                currentMove = 'O';
            } else {
                currentMove = 'X';
            }

        } while (!gameIsOver(gameField));



    }

    private static void printGameField(char[][] gameField) {
        System.out.println("---------");
        System.out.println("| " + gameField[1][3] + " " + gameField[2][3] + " " + gameField[3][3] + " |");
        System.out.println("| " + gameField[1][2] + " " + gameField[2][2] + " " + gameField[3][2] + " |");
        System.out.println("| " + gameField[1][1] + " " + gameField[2][1] + " " + gameField[3][1] + " |");
        System.out.println("---------");
    }

    private static boolean gameIsOver(char[][] gameField) {
        int emptyFields = 9;
        int xCount = 0;
        int oCount = 0;
        boolean threeXInRow;
        boolean threeOInRow;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                switch (gameField[i][j]) {
                    case 'X': xCount++;
                        emptyFields--;
                        break;
                    case 'O': oCount++;
                        emptyFields--;
                        break;
                }
            }
        }
        threeXInRow = checkThreeInRow('X', gameField);

        threeOInRow = checkThreeInRow('O', gameField);

        if (((xCount - oCount) > 1 || (xCount - oCount) < -1 ) ||
                (threeXInRow && threeOInRow)) {
        } else if (emptyFields == 0 && !threeXInRow && !threeOInRow) {
            System.out.println("Draw");
            return true;
        } else if (threeXInRow) {
            System.out.println("X wins");
            return true;
        } else if (threeOInRow) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    private static boolean checkThreeInRow(char Toe, char[][] gameField) {
        return (gameField[1][1] == Toe && gameField[1][2] == Toe && gameField[1][3] == Toe)
            || (gameField[2][1] == Toe && gameField[2][2] == Toe && gameField[2][3] == Toe)
            || (gameField[3][1] == Toe && gameField[3][2] == Toe && gameField[3][3] == Toe)
            || (gameField[1][1] == Toe && gameField[2][1] == Toe && gameField[3][1] == Toe)
            || (gameField[1][2] == Toe && gameField[2][2] == Toe && gameField[3][2] == Toe)
            || (gameField[1][3] == Toe && gameField[2][3] == Toe && gameField[3][3] == Toe)
            || (gameField[1][1] == Toe && gameField[2][2] == Toe && gameField[3][3] == Toe)
            || (gameField[3][1] == Toe && gameField[2][2] == Toe && gameField[1][3] == Toe);
    }
}
