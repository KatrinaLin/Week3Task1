package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {

    public List<Integer> getListByInterval(int left, int right) {

        int[] border = processBorder(left, right);

        try {

            List<Integer> result = IntStream.rangeClosed(border[0], border[1]).boxed().collect(Collectors.toList());

            if (left > right) {
                Collections.reverse(result);
            }

            return result;

        } catch (Exception e) {
            throw e;
        }

    }

    private int[] processBorder(int a, int b) {
        int[] border = new int[2];

        border[0] = a <= b ? a : b;
        border[1] = a <= b ? b : a;

        return border;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {

        int[] border = processBorder(left, right);

        try {

            List<Integer> result = IntStream.rangeClosed(border[0], border[1]).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());

            if (left > right) {
                Collections.reverse(result);
            }

            return result;

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        throw new NotImplementedException();
    }

    public int popLastElment(int[] array) {
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
