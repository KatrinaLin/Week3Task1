package com.thoughtworks.collection;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {

        return Stream.iterate(number - random.nextInt(3), x -> x - random.nextInt(3))
                .limit(number)
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }
}
