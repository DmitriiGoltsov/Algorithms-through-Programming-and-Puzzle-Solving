package fibonacci;

import java.util.Scanner;

public class FibonacciSquare {

    private static final int MOD_SIXTY = 60;
    private static final int MOD_TEN = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        scanner.close();

        System.out.println(getFibonacciSquare(number));
    }

    private static long getFibonacciSquare(long number) {
        long modNumber = number % MOD_SIXTY;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < modNumber; i++) {
            int temp = previous;
            previous = current;
            current = (temp + current) % MOD_TEN;
        }

        return ((long) previous * current) % MOD_TEN;
    }
}
