package divideAndConquerAlgorithms;

import java.util.Arrays;

public class Merge {

    public static void mergeSortedLists(int[] array, int[] firstHalf, int[] secondHalf) {

        int length1 = firstHalf.length;
        int length2 = secondHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < firstHalf.length && j < secondHalf.length) {

            if (firstHalf[i] <= secondHalf[j]) {
                array[k++] = firstHalf[i++];
            } else {
                array[k++] = secondHalf[j++];
            }
        }

        while (i < length1) {
            array[k++] = firstHalf[i++];
        }

        while (j < length2) {
            array[k++] = secondHalf[j++];
        }
    }

    public static void mergeSort(int[] array) {

        int n = array.length;

        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            firstHalf[i] = array[i];
        }

        for (int i = mid; i < n; i++) {
            secondHalf[i - mid] = array[i];
        }
        mergeSort(firstHalf);
        mergeSort(secondHalf);

        mergeSortedLists(array, firstHalf, secondHalf);

    }

    public static void main(String[] args) {

        int[] unsortedArray = {8, 3, 27, 9};

        mergeSort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

    }
}
