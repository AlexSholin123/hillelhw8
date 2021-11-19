package hw10;

import java.util.Arrays;

public class SimpleSearch {
    static long startTime;
    static long endTime;
    static long totalTime;

    public static void main(String[] args) {
        int[] smallArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            smallArray[i] = (int) (Math.random() * 100);
        }

        int[] bigArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            bigArray[i] = (int) (Math.random() * 100);
        }

        Arrays.sort(smallArray);
        Arrays.sort(bigArray);
        startTime = System.nanoTime();
        linearSearch(smallArray, smallArray[smallArray.length-1]);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds linear search for small array: " + totalTime);

        startTime = System.nanoTime();
        binarySearch(smallArray, smallArray[smallArray.length-1]);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds binarySearch for smallArray: " + totalTime);

        startTime = System.nanoTime();
        linearSearch(bigArray, bigArray[bigArray.length-1]);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds linearSearch for bigArray: " + totalTime);

        startTime = System.nanoTime();
        binarySearch(bigArray, bigArray[bigArray.length-1]);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds binarySearch for bigArray: " + totalTime);

        smallArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            smallArray[i] = (int) (Math.random() * 100);
        }

        startTime = System.nanoTime();
        quickSort(smallArray, 0, smallArray.length - 1);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds quickSort for smallArray: " + totalTime);

        bigArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            bigArray[i] = (int) (Math.random() * 100);
        }

        startTime = System.nanoTime();
        quickSort(bigArray, 0, bigArray.length - 1);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds  quickSort for bigArray: " + totalTime);

        smallArray = new int[10000];
        for (int i = 0; i < 10000; i++) {
            smallArray[i] = (int) (Math.random() * 100);
        }

        startTime = System.nanoTime();
        insertionSort(smallArray);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds insertionSort for smallArray : " + totalTime);

        bigArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            bigArray[i] = (int) (Math.random() * 100);
        }

        startTime = System.nanoTime();
        insertionSort(bigArray);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds insertionSort for bigArray : " + totalTime);

    }

    public static int linearSearch(int[] arr, int elementToSearch) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch){
                return index;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < list[middle]) {
                right = middle - 1;
            } else if (target > list[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while ((j >= 0) && (arr[j] > key)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
