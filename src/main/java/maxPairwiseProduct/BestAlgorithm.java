package maxPairwiseProduct;

import java.util.Scanner;

public class BestAlgorithm {

    public static long getMaxPairwiseProduct(long[] array) {

        int index = 0;
        int length = array.length;

        for (int i = 1; i < length; i++) {
            if (array[i] > array[index]) {
                index = i;
            }
        }

        long temp = array[index];
        array[index] = array[length - 1];
        array[length - 1] = temp;

        index = 0;

        for (int j = 1; j < length - 1; j++) {
            if (array[j] > array[index]) {
                index = j;
            }
        }

        long temp2 = array[index];
        array[index] = array[length - 2];
        array[length - 2] = temp2;

        return array[length - 2] * array[length - 1];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getMaxPairwiseProduct(numbers));
    }
}
