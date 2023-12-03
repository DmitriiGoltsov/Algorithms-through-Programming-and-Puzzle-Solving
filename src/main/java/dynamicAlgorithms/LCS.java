package dynamicAlgorithms;

import java.util.Scanner;

public class LCS {

    private static int lcs2(int[] firstArray, int[] secondArray) {

        int length1 = firstArray.length;
        int length2 = secondArray.length;

        int[][] table = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (firstArray[i - 1] == secondArray[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[length1][length2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] array2 = new int[m];
        for (int i = 0; i < m; i++) {
            array2[i] = scanner.nextInt();
        }

        scanner.close();
        System.out.println(lcs2(array1, array2));
    }
}
