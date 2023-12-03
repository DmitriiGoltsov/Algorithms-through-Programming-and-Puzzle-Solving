package dynamicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String string1 = scan.next();
        String string2 = scan.next();

        scan.close();
        System.out.println(editDistanceOptimized(string1, string2));
    }

    private static int editDistance(String str1, String str2) {

        int length1 = str1.length();
        int length2 = str2.length();

        if (length1 == 0) {
            return str2.length();
        } else if (length2 == 0) {
            return str1.length();
        }

        int[][] memoTable = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1 + 1; i++) {
            Arrays.fill(memoTable[i], -1);
        }

        if (memoTable[length1][length2] != -1) {
            return memoTable[length1][length2];
        }

        if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
            return memoTable[length1][length2] =
                    editDistance(str1.substring(0, length1 - 1), str2.substring(0, length2 - 1));
        } else {
            int insert = editDistance(str1, str2.substring(0, length2 - 1));
            int deletion = editDistance(str1.substring(0, length1 - 1), str2);
            int replacement = editDistance(str1.substring(0, length1 - 1), str2.substring(0, length2 - 1));

            return memoTable[length1][length2] = 1 + Math.min(insert, Math.min(deletion, replacement));
        }
    }

    private static int editDistanceOptimized(String str1, String str2) {

        int length1 = str1.length();
        int length2 = str2.length();

        int[] previous = new int[length2 + 1];
        int[] current = new int[length2 + 1];

        for (int j = 0; j <= length2; j++) {
            previous[j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            current[0] = i;
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    current[j] = previous[j - 1];
                } else {
                    int minimum = Math.min(1 + previous[j], 1 + current[j - 1]);
                    current[j] = Math.min(minimum, 1 + previous[j - 1]);
                }
            }

            previous = current.clone();
        }

        return previous[length2];
    }
}
