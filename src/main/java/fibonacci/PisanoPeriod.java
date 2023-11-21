package fibonacci;

import java.util.Scanner;

public class PisanoPeriod {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long number = scanner.nextLong();
        int modulo = scanner.nextInt();
        scanner.close();

        int period = pisanoPeriod(modulo);

        System.out.println(fibonacciMod(number % period, modulo));

    }

    private static int pisanoPeriod(int modulo) {

        int current = 0;
        int next = 1;
        int period = 0;

        while (true) {
            int oldNext = next;
            next = (current + next) % modulo;
            current = oldNext;
            period += 1;

            if (current == 0 && next == 1) {
                return period;
            }
        }
    }

    private static int fibonacciMod(long number, int modulo) {

        int current = 0;
        int next = 1;

        for (int i = 0; i < number; i++) {
            int oldNext = next;
            next = (current + next) % modulo;
            current = oldNext;
        }

        return current;

    }
}
