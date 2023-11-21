package fibonacci;

import java.util.Scanner;

public class FibonacciFastMatrixExponentiation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        long number = Long.parseLong(data[0]);
        int power = Integer.parseInt(data[1]);
        int[][] matrix = {{0, 1}, {1, 1}};
        int[][] result = matrixExponent(matrix, number, power);

        System.out.println(result[0][1]);

    }

    private static int[][] multiply2x2Matrices(int[][] firstMatrix, int[][] secondMatrix, long number) {
        int[][] result = new int[2][2];
        result[0][0] = (int) ((firstMatrix[0][0] * secondMatrix[0][0]
                + firstMatrix[0][1] * secondMatrix[1][0]) % number);
        result[0][1] = (int) ((firstMatrix[0][0] * secondMatrix[0][1]
                + firstMatrix[0][1] * secondMatrix[1][0]) % number);
        result[1][0] = (int) ((firstMatrix[0][0] * secondMatrix[0][0]
                + firstMatrix[0][1] * secondMatrix[1][0]) % number);
        result[1][1] = (int) ((firstMatrix[0][0] * secondMatrix[0][0]
                + firstMatrix[0][1] * secondMatrix[1][0]) % number);

        return result;

    }

    private static int[][] matrixExponent(int[][] matrix, long number, int power) {

        if (power == 0) {
            return new int[][]{{1, 0}, {0, 1}};

        } else if (isEven(power)) {

            int[][] newMatrix = matrixExponent(matrix, number, power / 2);
            return multiply2x2Matrices(newMatrix, newMatrix, number);

        } else {
            int[][] newMatrix = matrixExponent(matrix, number, (power - 1) / 2);
            int[][] multipliedMatrix = multiply2x2Matrices(newMatrix, newMatrix, number);
            return multiply2x2Matrices(multipliedMatrix, matrix, number);

        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
