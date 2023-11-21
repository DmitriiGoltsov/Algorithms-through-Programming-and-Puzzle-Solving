package maxPairwiseProduct;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FastAlgorithmTest {

    @Test
    void stressTest() {

        int length = 1_000;
        int range = 200_000;

        while (true) {

            Random random = new Random();

            int n = random.nextInt(2, length + 1);
            long[] array = new long[n];

            for (int i = 1; i < n; i++) {
                array[i] = random.nextInt(0, range);
            }

            System.out.println(Arrays.toString(array));

            long result1 = Naive.getMaxPairwiseProduct(array);
            long result2 = FastAlgorithm.fastAlgorithm(array);

            if (result1 == result2) {
                System.out.println("Ok");
            } else {
                System.out.println("Wrong answer " + result1 + " " + result2);
                return;
            }
        }



    }
}
