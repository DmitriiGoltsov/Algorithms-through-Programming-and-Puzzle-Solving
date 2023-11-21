package josephus;

import java.util.Scanner;

public class FastJosephus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRebels = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        System.out.println(getFastJosephus(numberOfRebels, k));
    }

    private static int getFastJosephus(int aliveRebels, int k) {
        if (aliveRebels == 1) {
            return 1;
        } else {
            return (getFastJosephus(aliveRebels - 1, k) + k - 1) % aliveRebels + 1;
        }
    }
}
