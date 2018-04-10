package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {

        return array.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

    }

    public List<Integer> filterMultipleOfThree() {

        return array.stream()
                .filter(x -> x % 3 == 0)
                .collect(Collectors.toList());

    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        throw new NotImplementedException();
    }

    public List<Integer> getDifferentElements() {
        throw new NotImplementedException();
    }
}