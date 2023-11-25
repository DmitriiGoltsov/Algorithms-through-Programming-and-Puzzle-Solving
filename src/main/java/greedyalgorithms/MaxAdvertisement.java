package greedyalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaxAdvertisement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> prices = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            prices.add(i, scanner.nextInt());
        }
        List<Integer> clicks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            clicks.add(i, scanner.nextInt());
        }

        scanner.close();
        System.out.println("With recursion: " + maxDotProduct(prices, clicks));
        System.out.println("With loop: " + maxDotProductLoop(prices, clicks));
    }

    private static long maxDotProduct(List<Integer> originalPrices, List<Integer> originalClicks) {
        List<Integer> prices = new ArrayList<>(originalPrices);
        List<Integer> clicks = new ArrayList<>(originalClicks);

        if (prices.isEmpty() || clicks.isEmpty()) {
            return 0L;
        }

        long maxValue = 0;

        int maxPriceIndex = prices.indexOf(prices.stream().max(Integer::compare).orElse(0));
        int maxClickIndex = clicks.indexOf(clicks.stream().max(Integer::compare).orElse(0));
        maxValue += (long) prices.get(maxPriceIndex) * clicks.get(maxClickIndex);

        prices.remove(maxPriceIndex);
        clicks.remove(maxClickIndex);

        return maxValue + maxDotProduct(prices, clicks);
    }

    private static long maxDotProductLoop(List<Integer> prices, List<Integer> clicks) {
        prices.sort(Comparator.reverseOrder());
        clicks.sort(Comparator.reverseOrder());

        long sum = 0L;
        for (int i = 0; i < prices.size(); i++) {
            sum += (long) prices.get(i) * clicks.get(i);
        }

        return sum;
    }
}
