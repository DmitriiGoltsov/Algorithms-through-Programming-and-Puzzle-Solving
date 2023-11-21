package fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int first = 0;
        int second = 1;

        for (int i = 0; i < n - 1; i ++) {
            int third = (first + second) % 10;
            first = second;
            second = third;
        }

        System.out.println(second);

    }
}
