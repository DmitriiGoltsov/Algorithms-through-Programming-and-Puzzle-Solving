package divideAndConquerAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Lottery {

    // To count correctly we need 3 main field: 1) Coordinate - is used for sort only; 2) Type - is used for correct
    // incrementation and defragmentation of numberOfSegments variable;
    // 3) index - needed for correct filling int[] counts
    record Encounter(int coordinate, String type, int index) {}

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] count = new int[points.length];
        List<Encounter> encounters = new ArrayList<>();

        for (int i = 0; i < starts.length; i++) {
            encounters.add(new Encounter(starts[i], "aLeft", i));
        }
        for (int i = 0; i < ends.length; i++) {
            encounters.add(new Encounter(ends[i], "cRight", i));
        }
        for (int i = 0; i < points.length; i++) {
            encounters.add(new Encounter(points[i], "bPoint", i));
        }

        encounters.sort(Comparator.comparing(Encounter::coordinate).thenComparing(Encounter::type));
        int numberOfSegments = 0;

        for (Encounter encounter: encounters) {
            switch (encounter.type()) {
                case "aLeft" -> numberOfSegments++;
                case "bPoint" -> count[encounter.index()] = numberOfSegments;
                case "cRight" -> numberOfSegments--;
                default -> throw new RuntimeException("List of encounters is not valid!");
            }
        }

        return count;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] count = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }

        //use fastCountSegments
        //int[] counts = naiveCountSegments(starts, ends, points);
        int[] counts = fastCountSegments(starts, ends, points);
        for (int x : counts) {
            System.out.print(x + " ");
        }
    }
}
