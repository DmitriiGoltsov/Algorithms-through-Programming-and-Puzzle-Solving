package maxPairwiseProduct;

import java.util.Arrays;
import java.util.Scanner;

public class BestAlgorithmWithSorting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getMaxProduct(numbers));
    }

    public static long getMaxProduct(long[] array) {

        int length = array.length;
        Arrays.sort(array);

        return array[length - 1] * array[length - 2];
    }
}
