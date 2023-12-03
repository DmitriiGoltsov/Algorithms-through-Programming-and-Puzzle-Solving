package greedyalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CookingDinner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Dish> dishes = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            dishes.add(new Dish(scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();
        System.out.println(isPossibleToCookAllDishes(dishes));
    }

    private static String isPossibleToCookAllDishes(List<Dish> dishes) {

        Comparator<Dish> comparator = Comparator.comparingInt(dish -> (dish.expirationTime + dish.cookingTime));
        dishes.sort(comparator.reversed());

        int timeSpent = dishes.get(0).cookingTime;
        int idealExpirationTime = dishes.get(0).expirationTime + timeSpent;
        for (int i = 1; i < dishes.size(); i++) {
            dishes.get(i).setBeggingOfExpiration(timeSpent + dishes.get(i).cookingTime);
            if (dishes.get(i).beggingOfExpiration + dishes.get(i).expirationTime < idealExpirationTime) {
                idealExpirationTime = dishes.get(i).beggingOfExpiration + dishes.get(i).expirationTime;
            }
            if (dishes.get(i).beggingOfExpiration > idealExpirationTime) {
                return "No";
            }
            timeSpent += dishes.get(i).cookingTime;
        }

        return "Yes";
    }

    private static class Dish {

        int cookingTime;
        int expirationTime;
        int beggingOfExpiration;

        public Dish(int cookingTime, int expirationTime) {
            this.cookingTime = cookingTime;
            this.expirationTime = expirationTime;
        }

        public void setBeggingOfExpiration(int beggingOfExpiration) {
            this.beggingOfExpiration = beggingOfExpiration;
        }
    }
}
