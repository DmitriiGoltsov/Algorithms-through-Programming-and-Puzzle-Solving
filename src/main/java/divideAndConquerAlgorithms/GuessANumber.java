package divideAndConquerAlgorithms;

import java.util.Scanner;

public class GuessANumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 100);
        int tryNumber = scanner.nextInt();

        System.out.println(numberToGuess);

        int counter = tryNumber;
        while (counter != 0) {
            int guess = scanner.nextInt();
            int result = isGuessRight(numberToGuess, guess);
            if (result == 0) {
                System.out.println("You guessed right! You're a winner!");
                break;
            } else if (result < 0){
                System.out.println("You've guessed wrong! The number is less than " + guess + " Try again");
                counter--;
            } else {
                System.out.println("You've guessed wrong! The number is greater than " + guess + " Try again");
                counter--;
            }
        }

        scanner.close();

        if (counter == 0) {
            System.out.println("You could not guess the right number for " + tryNumber + ". " + "You've lost!");
        }
    }

    public static int isGuessRight(int numberToGuess, int guess) {
        return Integer.compare(numberToGuess, guess);
    }
}
