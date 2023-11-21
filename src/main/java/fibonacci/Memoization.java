package fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Memoization {
    private static final int DEFAULT_ARRAY_LENGTH = 1_000;
    private static final long[] table = new long[DEFAULT_ARRAY_LENGTH];

    private static final Map<Integer, Long> mapTable = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        //System.out.println(findFibOfNumber(n));
        System.out.println(findFibOfNumber2(n));
    }

    public static Long findFibOfNumber(int n) {

        if (!mapTable.containsKey(n)) {
            if (n <= 1) {
                mapTable.put(n, (long) n);
            } else {
                mapTable.put(n, findFibOfNumber(n - 2) + findFibOfNumber(n - 1));
            }
        }

        return mapTable.get(n);
    }

    public static long findFibOfNumber2(int n) {

        if (n <= 1) {
            return n;
        }

        if (table[n] != 0) {
            return table[n];
        } else {
            table[n] = findFibOfNumber2(n - 2) + findFibOfNumber2(n - 1);
        }

        return table[n];
    }
}
