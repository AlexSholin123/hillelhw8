package ua.ithillel.task1;

import java.util.Arrays;

public class MyTestMethod {
    public static <E extends Comparable<E>> void calcNum(E[] array, E value) {
        int count = 0;

        for (E elem : array) {
            if (elem.compareTo(value) > 0) {
                count++;
            }
        }
        System.out.println("Number of values greater than " + value + ": " + count);
    }

    public static <E extends Number> void calcSum(E[] array, E value) {
        double sum = Arrays.stream(array)
                .filter(x -> x.doubleValue() > value.doubleValue())
                .mapToDouble(Number::doubleValue)
                .reduce(0, Double::sum);
        System.out.println("Sum of values greater than " + value + ": " + sum);
    }

}
