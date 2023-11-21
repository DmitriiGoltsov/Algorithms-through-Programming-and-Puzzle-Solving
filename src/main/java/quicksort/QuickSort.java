package quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

    public static List<Integer> quickSort(List<Integer> list) {

        if (list.isEmpty() || list.size() == 1) {
            return list;
        }

        int m = list.get(0);

        List<Integer> smaller = list.stream()
                .filter(elem -> elem < m)
                .toList();
        List <Integer> bigger = list.stream()
                .filter(elem -> elem > m)
                .toList();

        List<Integer> sortedSmaller = new ArrayList<>(quickSort(smaller));
        List<Integer> sortedBigger = new ArrayList<>(quickSort(bigger));

        sortedSmaller.add(m);

        return Stream.concat(sortedSmaller.stream(), sortedBigger.stream()).toList();
    }

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

        List<Integer> sortedList = quickSort(list);

        System.out.println(sortedList);
    }
}
