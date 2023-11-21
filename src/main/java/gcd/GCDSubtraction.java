package gcd;

import java.util.Scanner;

public class GCDSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        scanner.close();

        System.out.println("The greatest common divisor of " + a + " " + "and " + b + " is " + gcdSubtraction(a, b));
    }

    private static int gcdSubtraction(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return Math.max(a, b);
    }
}
