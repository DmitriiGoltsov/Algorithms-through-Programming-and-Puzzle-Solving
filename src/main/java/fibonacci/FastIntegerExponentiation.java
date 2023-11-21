package fibonacci;

import java.util.Scanner;

public class FastIntegerExponentiation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int number = Integer.parseInt(data[0]);
        int power = Integer.parseInt(data[1]);

        System.out.println(fastIntegerExponentiation(number, power));

    }

    private static int fastIntegerExponentiation(int number, int power) {

        if (power == 0) {
            return 1;
        }

        int z = 0;
        if (isEven(power)) {
            z = fastIntegerExponentiation(number, power / 2);
            return z * z;
        } else {
            z = fastIntegerExponentiation(number, (power - 1) / 2);
            return (z * z) * number;
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
