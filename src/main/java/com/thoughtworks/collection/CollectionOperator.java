package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {

    public List<Integer> getListByInterval(int left, int right) {

        int[] border = processBorder(left, right);

        try {

            List<Integer> result = IntStream.rangeClosed(border[0], border[1])
                    .boxed()
                    .collect(Collectors.toList());

            if (left > right) {
                Collections.reverse(result);
            }

            return result;

        } catch (Exception e) {
            throw e;
        }

    }

    protected static int[] processBorder(int a, int b) {
        int[] border = new int[2];

        border[0] = a <= b ? a : b;
        border[1] = a <= b ? b : a;

        return border;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {

        int[] border = processBorder(left, right);

        try {

            List<Integer> result = IntStream.rangeClosed(border[0], border[1])
                    .filter(x -> x % 2 == 0)
                    .boxed()
                    .collect(Collectors.toList());

            if (left > right) {
                Collections.reverse(result);
            }

            return result;

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Integer> popEvenElments(int[] array) {

        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

    }

    public int popLastElment(int[] array) {

        return array[array.length - 1];

    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        List<Integer> list2 = Arrays.stream(secondArray).boxed().collect(Collectors.toList());

        return Arrays.stream(firstArray)
                .boxed()
                .filter(list2::contains)
                .collect(Collectors.toList());

    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {

        return Stream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray))
                .distinct()
                .collect(Collectors.toList());

    }
}
