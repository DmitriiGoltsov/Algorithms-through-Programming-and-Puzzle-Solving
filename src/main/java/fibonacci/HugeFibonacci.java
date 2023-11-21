package fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HugeFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        int m = scanner.nextInt();
        scanner.close();

        System.out.println(findFibOfNumber(n, m));
    }

    public static Long findFibOfNumber(long n, int m) {

        if (n <= 1) {
            return n;
        }

        List<Long> table = new ArrayList<>();
        table.add(0, 0L);
        table.add(1, 1L);


        for (int i = 2; i < n; i++) {
            table.add(i, (table.get(i - 2) + table.get(i - 1)) % m);
        }

        return table.get((int) n);
    }
}
