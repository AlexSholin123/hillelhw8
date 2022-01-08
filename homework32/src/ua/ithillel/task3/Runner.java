package ua.ithillel.task3;

import java.util.Arrays;

public class Runner {
    public void run() {
        MyMixer<Integer> myMixer = new MyMixer<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        MyMixer<String> myMixer2 = new MyMixer<>(new String[]{"Cat", "Dog", "Frog", "Penguin"});

        System.out.println(Arrays.toString(myMixer.getArray()));
        myMixer.shuffle();
        System.out.println(Arrays.toString(myMixer.getArray()));
        System.out.println();
        System.out.println(Arrays.toString(myMixer2.getArray()));
        myMixer2.shuffle();
        System.out.println(Arrays.toString(myMixer2.getArray()));
    }

}
