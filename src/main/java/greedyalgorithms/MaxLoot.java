package greedyalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxLoot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Integer> values = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            values.add(scanner.nextInt());
            weights.add(scanner.nextInt());
        }

        scanner.close();
        System.out.println(getOptimalValue(capacity, values, weights)); // 180.0000
    }

    private static double getOptimalValue(int capacity, List<Integer> values, List<Integer> weights) {
        // Base case
        if (capacity == 0 || weights.isEmpty()) {
            return 0;
        }

        int indexOfPriciestGood = 0;
        for (int i = 1; i < values.size(); i++) {
            if ((values.get(i) * weights.get(indexOfPriciestGood)) >
                    (values.get(indexOfPriciestGood) * weights.get(i))) {
                indexOfPriciestGood = i;
            }
        }

        int amount = Math.min(weights.get(indexOfPriciestGood), capacity);
        double value = (double) values.get(indexOfPriciestGood) * ((double) amount / weights.get(indexOfPriciestGood));

        weights.remove(indexOfPriciestGood);
        values.remove(indexOfPriciestGood);
        capacity -= amount;

        return (value + getOptimalValue(capacity, values, weights));
    }
}
