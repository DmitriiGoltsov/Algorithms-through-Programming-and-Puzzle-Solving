package divideAndConquerAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {

    private static int getMajorityElement(int[] a, int left, int right) {

        if (a.length == 0) {
            return -1;
        } else if (left + 1 == right) {
            return a[left];
        }

        int middle = (left + right) / 2;
        final int firstElementToCheck = getMajorityElement(a, left, middle);
        final int firstElementOccurrences = (int) Arrays.stream(a)
                .filter(x -> x == firstElementToCheck)
                .count();

        if (firstElementOccurrences * 2 > right - left) {
            return firstElementToCheck;
        }

        final int secondElementToCheck = getMajorityElement(a, middle, right);
        final int secondElementOccurrences = (int) Arrays.stream(a)
                .filter(x -> x == secondElementToCheck)
                .count();

        if (secondElementOccurrences * 2 > right - left) {
            return secondElementToCheck;
        }

        return -1;
    }

    private static int getMajorityElementWithMemorising(int[] a, int left, int right) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        int half = (left + right) / 2;

        for (int element : a) {
            if (!occurrences.containsKey(element)) {
                occurrences.put(element, 0);
            } else {
                occurrences.replace(element, occurrences.get(element) + 1);
            }

            if (occurrences.get(element) >= half) {
                return 1;
            }
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
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
