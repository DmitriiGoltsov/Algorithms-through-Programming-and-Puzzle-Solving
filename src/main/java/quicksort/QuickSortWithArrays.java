//package quicksort;
//
//import java.util.Arrays;
//
//public class QuickSortWithArrays {
//
//    public static int[] quickSortArray(int[] array) {
//
//        int length = array.length;
//
//        if (length == 0 || length == 1) {
//            return array;
//        }
//
//        int m = array[0];
//
//        int[] smaller = new int[length];
//        int[] bigger = new int[length];
//
//        int i = 0;
//        int j = 0;
//        for (int element : array) {
//            if (element < m) {
//                smaller[i++] = element;
//            } else if (element > m) {
//                bigger[j++] = element;
//            }
//        }
//
//        quickSortArray(smaller);
//        quickSortArray(bigger);
//
//        int[] sortedArray = new int[length];
//
//        int count = 0;
//
//        for (int element : smaller) {
//            sortedArray[count++] = element;
//        }
//
//        sortedArray[++count] = m;
//
//        for (int element : bigger) {
//            sortedArray[++count] = element;
//        }
//
//        return sortedArray;
//    }
//
//    public static void main(String[] args) {
//
//        int[] array = {4, 7, 2, 5, 3, 1, 8, 9, 6};
//
//        quickSortArray(array);
//
//        System.out.println(Arrays.toString(array));
//
//    }
//}
