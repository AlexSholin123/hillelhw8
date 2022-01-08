package ua.ithillel.task1;

import java.util.Arrays;
import static ua.ithillel.task1.MyTestMethod.calcNum;
import static ua.ithillel.task1.MyTestMethod.calcSum;

public class Runner {

    private static final int ARRAY_LENGTH = 10;

    public void run() {
        Integer[] arrayInt = new Integer[ARRAY_LENGTH];
        Double[] arrayDouble = new Double[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayInt[i] = ARRAY_LENGTH * 4 + i;
            arrayDouble[i] = (Math.random() + 13) * 3.4;
        }

        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayDouble));
        calcNum(arrayInt, 45);
        calcNum(arrayDouble, 45.0);
        calcSum(arrayInt,45);
        calcSum(arrayDouble,45.5);
    }
}
