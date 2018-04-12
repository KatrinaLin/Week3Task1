package com.thoughtworks.collection;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Reduce{

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {

        return arrayList.stream()
                .reduce((x, y) -> (x > y ? x : y))
                .get();
    }

    public double getMinimum() {

        return arrayList.stream()
                .reduce((x, y) -> (x < y ? x : y))
                .get();
    }

    public double getAverage() {

        return arrayList.stream()
                .mapToDouble(x -> x)
                .average()
                .getAsDouble();
    }

    public double getOrderedMedian() {

        Supplier<IntStream> supplier = () -> arrayList.stream().mapToInt(x -> x);

        long count = supplier.get().count();

        double median = supplier.get().sorted().skip((count - 1)/ 2).limit(2 - count % 2).average().orElse(Double.NaN);

        return median;
    }

    public int getFirstEven() {

        return arrayList.stream()
                .filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(null);
    }

    public int getIndexOfFirstEven() {

        return IntStream.range(0, arrayList.size())
                .filter(x -> arrayList.get(x) % 2 == 0)
                .findFirst()
                .getAsInt();

    }

    public boolean isEqual(List<Integer> arrayList) {

        if (arrayList.size() != this.arrayList.size()) {
            return false;
        }

        return IntStream.range(0, arrayList.size())
                .allMatch(x -> arrayList.get(x) == this.arrayList.get(x));

    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLinkImpl singleLink) {

        arrayList.stream().forEach(i -> singleLink.addTailPointer(i));

        int size = arrayList.size();

        if (size % 2 == 0) {
            return ((Integer)singleLink.getNode(size / 2 + 1) + (Integer)singleLink.getNode(size / 2)) / 2.0;
        } else {
            return (Double)singleLink.getNode(size / 2 + 1);
        }
    }

    public int getLastOdd() {

        return arrayList.stream()
                .filter(x -> x % 2 != 0)
                .reduce((x, y) -> y)
                .orElse(null);
    }

    public int getIndexOfLastOdd() {

        return IntStream.range(0, arrayList.size())
                .filter(x -> arrayList.get(x) % 2 != 0)
                .reduce((x, y) -> y)
                .getAsInt();
    }

}
