package divideAndConquerAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class ClosestPoints {

    record Point(long x, long y) { }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(nextInt(), nextInt()));
        }
        System.out.println(minimalDistance(points));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(Objects.requireNonNull(next()));
    }

    private static double minimalDistance(List<Point> points) {

        points.sort(Comparator.comparingLong(Point::x));

        return getClosestUtil(points);
    }

    private static double getClosestUtil(List<Point> points) {

        if (points.size() <= 3) {
            return bruteForce(points);
        }

        int middleIndex = points.size() / 2;
        Point middlePoint = points.get(middleIndex);

        double smallestDistanceLeft = getClosestUtil(points.subList(0, middleIndex));
        double smallestDistanceRight = getClosestUtil(points.subList(middleIndex, points.size() - 1));
        double distance = Math.min(smallestDistanceLeft, smallestDistanceRight);

        List<Point> stripedPoints = new ArrayList<>();
        for (Point point : points) {
            if (Math.abs(point.x() - middlePoint.x()) < distance) {
                stripedPoints.add(point);
            }
        }

        return Math.min(distance, getClosestInStripped(stripedPoints, distance));
    }

    private static double getClosestInStripped(List<Point> stripedPoints, double distance) {
        double min = distance;
        stripedPoints.sort(Comparator.comparingLong(Point::y));

        for (int i = 0; i < stripedPoints.size(); ++i) {
            for (int j = i + 1; j < stripedPoints.size()
                    && (stripedPoints.get(j).y() - stripedPoints.get(i).y()) < min; ++j) {
                if (getDistance(stripedPoints.get(i), stripedPoints.get(j)) < min) {
                    min = getDistance(stripedPoints.get(i), stripedPoints.get(j));
                }
            }
        }

        return min;
    }

    private static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x() - p2.x()), 2) + Math.pow((p1.y() - p2.y()), 2));
    }

    private static double bruteForce(List<Point> points) {
        double min = Double.MAX_VALUE;
        double currentMin;

        for (int i = 0; i < points.size(); ++i) {
            for (int j = i + 1; j < points.size(); ++j) {
                currentMin = getDistance(points.get(i), points.get(j));
                if (currentMin < min) {
                    min = currentMin;
                }
            }
        }
        return min;
    }
}
