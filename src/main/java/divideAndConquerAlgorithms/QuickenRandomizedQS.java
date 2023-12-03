package divideAndConquerAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickenRandomizedQS {

    private static Partition partition(int[] array, int begin, int end) {
        int left = begin;
        int current = begin;
        int right = end;
        int partitionValue = array[begin];

        while (current <= right) {
            int compareCurrent = Integer.compare(array[current], partitionValue);
            switch (compareCurrent) {
                case -1 -> swap(array, current++, left++);
                case 0 -> current++;
                case 1 -> swap(array, current, right--);
            }
        }

        return new Partition(left, right);
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            int temporary = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temporary;
        }
    }

    private static void randomizedQuickSort(int[] array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) {
            return;
        }

        Partition middlePartition = partition(array, leftIndex, rightIndex);

        randomizedQuickSort(array, leftIndex, middlePartition.getLeft() - 1);
        randomizedQuickSort(array, middlePartition.getRight() + 1, rightIndex);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Partition {
        int left;
        int right;

        public Partition(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
}
