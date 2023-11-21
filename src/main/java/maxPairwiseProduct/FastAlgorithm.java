package maxPairwiseProduct;

import java.util.Scanner;

public class FastAlgorithm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(fastAlgorithm(numbers));

    }

    public static long fastAlgorithm(long[] numbers) {

        int index1 = 0;
        int length = numbers.length;

        for (int i = 1; i < length; i++) {
            if (numbers[i] > numbers[index1]) {
                index1 = i;
            }
        }

        int index2 = 0;
        if (index1 == 0) {
            index2 = 1;
        }

        for (int j = 1; j < length; j++) {
            if (j != index1 && numbers[j] > numbers[index2]) {
                index2 = j;
            }
        }

        System.out.println(index1 + " " + index2);
        return numbers[index1] * numbers[index2];

    }
}
