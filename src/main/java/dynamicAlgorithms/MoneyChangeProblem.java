package dynamicAlgorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoneyChangeProblem {

    private static final int[] DENOMINATIONS = {1, 3, 4};

    private static final Map<Integer, Integer> MEMO_TABLE = new HashMap<>();

    private static int getChange(int sum) {

        if (!MEMO_TABLE.containsKey(sum)) {
            if (sum == 0) {
                MEMO_TABLE.put(sum, 0);
            } else {
                int result = Integer.MAX_VALUE;

                for (int denomination : DENOMINATIONS) {
                    if (denomination <= sum) {
                        result = Math.min(result, getChange(sum - denomination) + 1);
                    }
                }

                MEMO_TABLE.put(sum, result);
            }
        }

        return MEMO_TABLE.get(sum);
    }

    private static int getChangeWithoutMemoization(int sum) {
        int[] table = new int[sum + 1];
        for (int i = 1; i < table.length; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        table[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int denomination : DENOMINATIONS) {
                if (denomination <= i) {
                    table[i] = Math.min(table[i], table[i - denomination] + 1);
                }
            }
        }

        return table[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumToPay = scanner.nextInt();

        scanner.close();
        System.out.println(getChange(sumToPay));
        System.out.println(getChangeWithoutMemoization(sumToPay));
    }
}
