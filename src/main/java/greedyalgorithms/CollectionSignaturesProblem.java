package greedyalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CollectionSignaturesProblem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Segment> segments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }

    private static List<Integer> optimalPoints(List<Segment> segments) {
        List<Integer> result = new ArrayList<>();

        while (!segments.isEmpty()) {
            Segment championSegment = segments.stream()
                    .min(Comparator.comparingInt(segment -> segment.end))
                    .get();

            int right = championSegment.end;
            result.add(right);
            segments.remove(championSegment);

            segments.removeIf(segment -> segment.start <= right);
        }

        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
