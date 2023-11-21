package fibonacci;

import java.util.Scanner;

public class LastDigit {

    public static final int MODUS_OF_TEN = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(findFibOfNumber(n));
    }

    public static long findFibOfNumber(int n) {

        if (n <= 1) {
            return n;
        }

        long[] table = new long[n + 1];
        int length = table.length;
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < length; i++) {
            table[i] = (table[i - 2] + table[i - 1]) % MODUS_OF_TEN;
        }

        return table[n];
    }
}
