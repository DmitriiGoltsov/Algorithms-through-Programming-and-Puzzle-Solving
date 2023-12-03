package divideAndConquerAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InversionsNumberProblem {

    private static long mergeAndCount(int[] array, int left, int middle, int right) {

        int[] leftHalf = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightHalf = Arrays.copyOfRange(array, middle + 1, right + 1);

        int index = left;
        int i = 0;
        int j = 0;
        long swaps = 0L;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[index++] = leftHalf[i++];
            } else {
                array[index++] = rightHalf[j++];
                swaps += (middle + 1) - (left + i);
            }
        }

        while (i < leftHalf.length) {
            array[index++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {
            array[index++] = rightHalf[j++];
        }

        return swaps;
    }

    // Merge sort function
    private static long sortAndCountInversions(int[] arr, int left, int right) {

        long count = 0L;

        if (left < right) {
            int middle = (left + right) / 2;

            count += sortAndCountInversions(arr, left, middle);
            count += sortAndCountInversions(arr, middle + 1, right);
            count += mergeAndCount(arr, left, middle, right);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        scanner.close();
        System.out.println(sortAndCountInversions(a, 0, a.length - 1));
    }
}
