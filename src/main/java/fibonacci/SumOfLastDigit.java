package fibonacci;

import java.util.Scanner;

public class SumOfLastDigit {

    public static final int MODUS_OF_TEN = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println((findSum((n + 2) % 60) + 9) % MODUS_OF_TEN);
    }

    private static long findSum(int n) {

        int current = 0;
        int next = 1;

        for (int i = 0; i < n; i++) {
            int temp = current;
            current = next;
            next = (temp + next) % MODUS_OF_TEN;
        }

        return current;
    }


}
