package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {

        int[] border = CollectionOperator.processBorder(leftBorder, rightBorder);

        int result = IntStream.rangeClosed(border[0], border[1])
                .filter(x -> x % 2 == 0)
                .sum();

        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {

        int[] border = CollectionOperator.processBorder(leftBorder, rightBorder);

        int result = IntStream.rangeClosed(border[0], border[1])
                .filter(x -> x % 2 != 0)
                .sum();

        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {

        int result = arrayList.stream()
                .mapToInt(x -> x * 3 + 2)
                .sum();

        return result;

    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        List<Integer> result = new ArrayList<>();

        arrayList.stream().forEach(x -> {
            if (x % 2 != 0) {x = x * 3 + 2;}
            result.add(x); });

        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {

        int result = arrayList.stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(x -> x * 3 + 5)
                .sum();

        return result;

    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {

        Supplier<IntStream> supplier = () -> arrayList.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x);

        long count = supplier.get().count();

        double median = supplier.get()
                .sorted()
                .skip((count - 1)/ 2)
                .limit(2 - count % 2)
                .average()
                .orElse(Double.NaN);

        return median;

    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {

        return arrayList.stream()
                .filter(x -> x % 2 == 0)
                .mapToDouble(x -> x)
                .average()
                .orElse(0);

    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        return arrayList.stream()
                .filter(x -> x % 2 == 0)
                .anyMatch(x -> x == specialElment);

    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {

        return arrayList.stream()
                .filter(x -> x % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {

        List<Integer> result = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> oddList = arrayList.stream()
                .filter(x -> x % 2 != 0)
                .sorted()
                .collect(Collectors.toList());

        Collections.reverse(oddList);

        result.addAll(oddList);

        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {

        return IntStream.range(0, arrayList.size() - 1)
                .boxed()
                .map(x -> (arrayList.get(x) + arrayList.get(x + 1)) * 3)
                .collect(Collectors.toList());

    }
}
