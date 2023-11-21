package GCM;

import java.util.Scanner;

public class GCMMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        scanner.close();

        System.out.println(getGCM(a, b));
    }

    private static long getGCM(long a, long b) {
        long gcm = getGCDEuclid(a, b);

        return a / gcm * b;
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
