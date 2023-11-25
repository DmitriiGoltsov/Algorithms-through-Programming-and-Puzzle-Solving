package greedyalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxNumPrizes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int participantNumber = scanner.nextInt();
        scanner.close();

        List<Integer> summands = optimalSummands(participantNumber);

        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }

    private static List<Integer> optimalSummands(int numberOfPrizes) {
        List<Integer> summands = new ArrayList<>();

        int maxMedalPlaces = 1;
        while (((maxMedalPlaces * (maxMedalPlaces + 1)) / 2) <= numberOfPrizes) {
            maxMedalPlaces += 1;
        }

        maxMedalPlaces -= 1;

        int restOfPrize = numberOfPrizes - maxMedalPlaces * (maxMedalPlaces + 1) / 2;

        for (int i = 1; i < maxMedalPlaces; i++) {
            summands.add(i);
        }

        summands.add(maxMedalPlaces + restOfPrize);
        return summands;
    }
}
