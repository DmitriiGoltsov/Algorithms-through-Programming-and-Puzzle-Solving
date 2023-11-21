package quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RandomizedQuickSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(8);
        list.add(9);
        list.add(6);

        List<Integer> sortedList = randomizedQuickSort(list);

        System.out.println(sortedList);
    }

    public static List<Integer> randomizedQuickSort(List<Integer> list) {

        if (list.isEmpty() || list.size() == 1) {
            return list;
        }

        Random random = new Random();
        int randomizedIndex = random.nextInt(0, list.size());

        int m = list.get(randomizedIndex);

        List<Integer> smaller = list.stream()
                .filter(elem -> elem < m)
                .toList();
        List <Integer> bigger = list.stream()
                .filter(elem -> elem > m)
                .toList();

        List<Integer> sortedSmaller = new ArrayList<>(randomizedQuickSort(smaller));
        List<Integer> sortedBigger = new ArrayList<>(randomizedQuickSort(bigger));

        sortedSmaller.add(m);

        return Stream.concat(sortedSmaller.stream(), sortedBigger.stream()).toList();

    }

}
