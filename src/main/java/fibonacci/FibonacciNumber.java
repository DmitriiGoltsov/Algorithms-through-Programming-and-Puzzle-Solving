package fibonacci;

import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(findFibOfNumber(n));
    }


    public static long findFibOfNumber(int n) {

        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        int counter = 0;

        while (counter < (n - 1)) {
            long oldPrevious = previous;
            previous = current;
            current += oldPrevious;
            counter++;
        }

        return current;
    }

}
