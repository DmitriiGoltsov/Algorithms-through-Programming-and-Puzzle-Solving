package dynamicAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalc {

    private static List<Integer> optimalSequence(int n) {

        List<Integer> list = new ArrayList<>(n);

        for (int i = 1; i <= n + 1; i++) {
            list.add(Integer.MAX_VALUE);
        }
        list.set(1, 0);

        for (int j = 2; j < n + 1; j++) {

            list.set(j, 1 + list.get(j - 1));

            if (j % 2 == 0) {
                list.set(j, Math.min(list.get(j), 1 + list.get(j / 2)));
            }

            if (j % 3 == 0) {
                list.set(j, Math.min(list.get(j), 1 + list.get(j / 3)));
            }
        }

        List<Integer> operations = new LinkedList<>();
        operations.add(1);

        while (n > 1) {

            operations.add(n);

            if (n % 3 == 0 && list.get(n) == 1 + list.get(n / 3)) {
                n /= 3;
            } else if (n % 2 == 0 && list.get(n) == 1 + list.get(n / 2)) {
                n /= 2;
            } else if (list.get(n) == 1 + list.get(n - 1)) {
                n -= 1;
            }
        }

        return operations.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
