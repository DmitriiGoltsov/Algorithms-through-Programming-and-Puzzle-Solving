package hanoi;

import java.util.Scanner;

public class HanoiTowers {

    public static final int SUM_OF_PEGS_FOR_THREE_TOWERS = 6;

    private static void getMovesOfHanoiTowers(int n, int fromPeg, int toPeg) {


        if (n == 1) {
            System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);
            return;
        }

        int unusedPeg = SUM_OF_PEGS_FOR_THREE_TOWERS - fromPeg - toPeg;

        getMovesOfHanoiTowers(n - 1, fromPeg, unusedPeg);

        System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);

        getMovesOfHanoiTowers(n - 1, unusedPeg, toPeg);
    }

    public static void main(String[] args) {

        System.out.println("Please, choose the number of disk you'd like to move from peg № 1 to peg № 2!");

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.close();

        getMovesOfHanoiTowers(num, 1, 3);
    }
}
