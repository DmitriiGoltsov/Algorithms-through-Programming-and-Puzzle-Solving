package josephus;

import java.util.Arrays;
import java.util.Scanner;

public class Naive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRebels = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        System.out.println(getJosephus(numberOfRebels, k));
    }

    private static int getJosephus(int numberOfRebels, int k) {
        boolean[] deadAndAlive = new boolean[numberOfRebels];
        Arrays.fill(deadAndAlive, true);

        int numberOfSurvivors = numberOfRebels;
        int currentPosition = 0;
        int index = 0;

        while (true) {
            if (deadAndAlive[currentPosition]) {
                index++;
            }
            if (index == k) {
                numberOfSurvivors--;
                if (numberOfSurvivors == 0) {
                    return currentPosition;
                } else {
                    deadAndAlive[currentPosition] = false;
                    index = 0;
                }
            }

            currentPosition = (currentPosition + 1) % numberOfRebels;
        }
    }
}
