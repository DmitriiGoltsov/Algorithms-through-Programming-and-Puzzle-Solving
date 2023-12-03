package divideAndConquerAlgorithms;

public class SimpleBinarySearch {

    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }

        System.out.println(contains(array, 8));
        System.out.println(contains(array, 105));

    }

    private static boolean contains(int[] array, int number) {

        if (array.length == 0) {
            return false;
        }

        int first = 0;
        int last = array.length - 1;

        int mid = (first + last) / 2;
        while (first <= last) {
            if (number == mid) {
                System.out.println("Element " + number + " Found at index: " + mid);
                return true;
            } else if (number < mid) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

            mid = (first + last) / 2;
        }

        System.out.println("Element " + number + " is not found");
        return false;
    }
}
