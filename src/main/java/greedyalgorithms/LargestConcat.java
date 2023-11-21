package greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

public class LargestConcat {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(9);
        list.add(1);
        list.add(2);

        System.out.println("The largest concat number is " + getLargestConcatenation(list)); // expect 93221

    }

    private static String getLargestConcatenation(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return "";
        } else if (numbers.size() == 1) {
            return String.valueOf(numbers.get(0));
        }

        StringBuilder sb = new StringBuilder();

        while (!numbers.isEmpty()) {
            Integer max = numbers.stream()
                    .max(Integer::compareTo)
                    .orElseThrow(() -> new ArrayStoreException("Array does not contain any numbers"));
            sb.append(max);
            numbers.remove(max);
        }

        return sb.toString();
    }
}
