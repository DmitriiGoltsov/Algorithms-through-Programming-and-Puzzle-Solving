package divideAndConquerAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return -1;
    }

    static int BinarySearchImproved(int[] a, int x) {
        int left = -1;
        int right = a.length - 1;

        while (right > left + 1) {
            int mid = (left + right) / 2;
            if (a[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (a[right] == x) {
            return right;
        } else {
            return -1;
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(BinarySearchImproved(a, b[i]) + " ");
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
}
