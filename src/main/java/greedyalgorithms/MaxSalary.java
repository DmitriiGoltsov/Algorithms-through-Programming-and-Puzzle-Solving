package greedyalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaxSalary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> strings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }
        scanner.close();

        System.out.println(largestNumber(strings));
    }

    private static String largestNumber(List<String> strings) {
        Comparator<String> comparator = (x, y) ->
                Integer.compare(Integer.parseInt(x + y), Integer.parseInt(y + x));

        strings.sort(comparator.reversed());
        StringBuilder stringBuilder = new StringBuilder();
        strings.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
