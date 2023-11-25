package greedyalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarFuelProblem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        List<Integer> stops = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            stops.add(i, scanner.nextInt());
        }

        scanner.close();
        System.out.println(computeMinRefills(dist, tank, stops));
    }

    private static int computeMinRefills(int dist, int tank, List<Integer> stops) {
        return computeMinRefills(0, dist, tank, stops);
    }

    private static int computeMinRefills(int currentLocation, int dist, int tank, List<Integer> stops) {
        if ((currentLocation + tank) >= dist) {
            return 0;
        } else if (stops.isEmpty() || (stops.get(0) - currentLocation) > tank) {
            return -1;
        }

        int lastStop = currentLocation;
        while (!stops.isEmpty() && (stops.get(0) - currentLocation) <= tank) {
            lastStop = stops.get(0);
            stops.remove(0);
        }

        int result = computeMinRefills(lastStop, dist, tank, stops);

        if (result == -1) {
            return -1;
        } else {
            return 1 + result;
        }
    }

    /*private static int computeMinRefillsLoop(int dist, int tank, List<Integer> stops) {

    }*/
}
