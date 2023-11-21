package Rocks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Rocks {

    public static String rocks(int n, int m) throws IOException {

        String[][] gameField = new String[11][11];

        if (n > 10 || m > 10) {
            throw new IOException("n and m have to be 10 or less!");
        }

        gameField[0][0] = "Loser";

        for (int i = 1; i <= n; i++) {

            if (gameField[i - 1][0].equals("Winner")) {
                gameField[i][0] = "Loser";
            } else {
                gameField[i][0] = "Winner";
            }
        }

        for (int j = 1; j <= m; j++) {

            if (gameField[0][j - 1].equals("Winner")) {
                gameField[0][j] = "Loser";
            } else {
                gameField[0][j] = "Winner";
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (gameField[i - 1][j - 1].equals("Winner") && gameField[i][j - 1].equals("Winner")
                        && gameField[i - 1][j].equals("Winner")) {
                    gameField[i][j] = "Loser";
                } else {
                    gameField[i][j] = "Winner";
                }
            }
        }

        return gameField[n][m];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.close();

        try {
            System.out.println(rocks(n, m));
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }

    }
}
