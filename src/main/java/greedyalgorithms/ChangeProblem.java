package greedyalgorithms;

import java.util.List;

public class ChangeProblem {

    private static final List<Integer> DENOMINATIONS_1 = List.of(1, 5, 10);
    private static final List<Integer> DENOMINATIONS_2 = List.of(1, 4, 6);

    public static void main(String[] args) {

        int sumToPay = 28;
        int sumToPay2 = 8;

        System.out.println(getNumberOfCoins(sumToPay, DENOMINATIONS_1));
        System.out.println(getNumberOfCoins(sumToPay2, DENOMINATIONS_2));
        System.out.println(getNumberOfCoinsRecursively(sumToPay, DENOMINATIONS_1));
        System.out.println(getNumberOfCoinsGreedily(sumToPay));

    }

    private static int getNumberOfCoins(int sum, List<Integer> denominations) {
        int numCoin = 0;

        while (sum > 0) {
            int finalSumToPay = sum;
            int maxCoin = denominations.stream()
                    .filter(coin -> finalSumToPay - coin >= 0)
                    .max(Integer::compare)
                    .orElse(1);

            sum -= maxCoin;
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

    private static int getNumberOfCoinsGreedily(int sum) {
        int numCoin = 0;

        while (sum > 0) {
            if (sum >= DENOMINATIONS_1.get(2)) {
                sum -= DENOMINATIONS_1.get(2);
            } else if (sum >= DENOMINATIONS_1.get(1)) {
                sum -= DENOMINATIONS_1.get(1);
            } else {
                sum -= DENOMINATIONS_1.get(0);
            }

            numCoin++;
        }

        return numCoin;
    }

}
