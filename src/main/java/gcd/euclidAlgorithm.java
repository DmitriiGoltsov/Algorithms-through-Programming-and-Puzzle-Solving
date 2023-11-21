package gcd;

import java.util.Scanner;

public class euclidAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        scanner.close();

        System.out.println(getGCDEuclid(a, b));
    }

    private static long getGCDEuclid(long a, long b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a %= b;
            } else {
                b %= a;
            }
        }

        return Math.max(a, b);
    }
}
