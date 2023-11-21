package greedyalgorithms;

import java.util.List;

public class ChangeProblem {

    public static void main(String[] args) {

        List<Integer> denominations = List.of(1, 5, 10);
        List<Integer> denominations2 = List.of(1, 4, 6);
        int sumToPay = 28;
        int sumToPay2 = 8;

        System.out.println(getNumberOfCoins(sumToPay, denominations));
        System.out.println(getNumberOfCoins(sumToPay2, denominations2));

        System.out.println(getNumberOfCoinsRecursively(sumToPay, denominations));

    }

    private static int getNumberOfCoins(int sumToPay, List<Integer> denominations) {
        int numCoin = 0;

        while (sumToPay > 0) {
            int finalSumToPay = sumToPay;
            int maxCoin = denominations.stream()
                    .filter(coin -> finalSumToPay - coin >= 0)
                    .max(Integer::compare)
                    .orElse(1);

            sumToPay -= maxCoin;
            numCoin += 1;
        }

        return numCoin;
    }

    private static int getNumberOfCoinsRecursively(int sum, List<Integer> denominations) {
        // Base case
        if (sum == 0) return 0;

        int maxCoin = denominations.stream()
                .filter(coin -> sum - coin >= 0)
                .max(Integer::compare)
                .orElse(1);

        return 1 + getNumberOfCoinsRecursively(sum - maxCoin, denominations);
    }

}
