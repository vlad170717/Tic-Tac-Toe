package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String game = sc.nextLine();
        

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

        System.out.println("Enter the coordinates: ");
        String coords = sc.nextLine();

        int emptyFields = 9;
        int xCount = 0;
        int oCount = 0;
        boolean threeXInRow;
        boolean threeOInRow;

        for (int i = 0; i <= 8; i++) {
            switch (game.charAt(i)) {
                case 'X': xCount++;
                    emptyFields--;
                    break;
                case 'O': oCount++;
                    emptyFields--;
                    break;
            }
        }
        threeXInRow = (game.charAt(0) == 'X' && game.charAt(1) == 'X' && game.charAt(2) == 'X')
                   || (game.charAt(3) == 'X' && game.charAt(4) == 'X' && game.charAt(5) == 'X')
                   || (game.charAt(6) == 'X' && game.charAt(7) == 'X' && game.charAt(8) == 'X')
                   || (game.charAt(0) == 'X' && game.charAt(3) == 'X' && game.charAt(6) == 'X')
                   || (game.charAt(1) == 'X' && game.charAt(4) == 'X' && game.charAt(7) == 'X')
                   || (game.charAt(2) == 'X' && game.charAt(5) == 'X' && game.charAt(8) == 'X')
                   || (game.charAt(0) == 'X' && game.charAt(4) == 'X' && game.charAt(8) == 'X')
                   || (game.charAt(2) == 'X' && game.charAt(4) == 'X' && game.charAt(6) == 'X');

        threeOInRow = (game.charAt(0) == 'O' && game.charAt(1) == 'O' && game.charAt(2) == 'O')
                   || (game.charAt(3) == 'O' && game.charAt(4) == 'O' && game.charAt(5) == 'O')
                   || (game.charAt(6) == 'O' && game.charAt(7) == 'O' && game.charAt(8) == 'O')
                   || (game.charAt(0) == 'O' && game.charAt(3) == 'O' && game.charAt(6) == 'O')
                   || (game.charAt(1) == 'O' && game.charAt(4) == 'O' && game.charAt(7) == 'O')
                   || (game.charAt(2) == 'O' && game.charAt(5) == 'O' && game.charAt(8) == 'O')
                   || (game.charAt(0) == 'O' && game.charAt(4) == 'O' && game.charAt(8) == 'O')
                   || (game.charAt(2) == 'O' && game.charAt(4) == 'O' && game.charAt(6) == 'O');

//        System.out.println(emptyFields);
//        System.out.println(xCount);
//        System.out.println(oCount);
//        System.out.println(threeXInRow);
//        System.out.println(threeOInRow);

        if (((xCount - oCount) > 1 || (xCount - oCount) < -1 ) ||
                (threeXInRow && threeOInRow)) {
            System.out.println("Impossible");
        } else if (emptyFields > 0 && !threeXInRow && !threeOInRow) {
            System.out.println("Game not finished");
        } else if (emptyFields == 0 && !threeXInRow && !threeOInRow) {
            System.out.println("Draw");
        } else if (threeXInRow) {
            System.out.println("X wins");
        } else {
            System.out.println("O wins");
        }
    }

    private static void printGameField(char[][] gameField) {
        System.out.println("---------");
        System.out.println("| " + gameField[1][3] + " " + gameField[2][3] + " " + gameField[3][3] + " |");
        System.out.println("| " + gameField[1][2] + " " + gameField[2][2] + " " + gameField[3][2] + " |");
        System.out.println("| " + gameField[1][1] + " " + gameField[2][1] + " " + gameField[3][1] + " |");
        System.out.println("---------");
    }
}
