package fibonacci;

import java.util.Scanner;

public class IterativeAlgorithm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(findFibOfNumber(n));

    }

    private static long findFibOfNumber(int num) {

        long[] array = new long[num + 1];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= num; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[num];

    }
}
