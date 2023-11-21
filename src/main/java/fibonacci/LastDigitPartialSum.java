package fibonacci;

import java.util.Scanner;

public class LastDigitPartialSum {

    private static final int MOD_OF_TEN = 10;
    private static final int MOD_OF_SIXTY = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        scanner.close();

        System.out.println(getFibonacciPartialSumFast(m, n));
    }

    private static long getFibonacciPartialSumFast(long m, long n) {
        long sum = 0;

        m = (m % MOD_OF_SIXTY);
        n = (n % MOD_OF_SIXTY);

        if (n < m) {
            n += 60;
        }

        long current = 0;
        long next = 1;

        for (int i = 0; i <= n; ++i) {
            if (i >= m) {
                sum += current;
            }

            long temp = next;
            next = next + current;
            current = temp;
        }

        return sum % MOD_OF_TEN;
    }
}
