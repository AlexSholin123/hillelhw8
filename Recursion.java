package hw8;

public class Recursion {

    public static void main(String[] args) {

        int[] array = new int[]{3, 2, 4, 8};
        int number = 1325;
        System.out.println("Sum of array elements: " + arraySum(array, array.length - 1));
        System.out.println("Maximum element in the array: " + findMaxRec(array, array.length));
        System.out.println("Sum of digits in " + number + ": " + sumOfDigits(number));
        System.out.println("Reversed number " + number + ": " + numberReversed(number));
    }

    public static int arraySum(int[] array, int index) {
        if (index == 0) {
            return array[0];
        } else {
            return arraySum(array, index - 1) + array[index];
        }
    }

    public static int findMaxRec(int[] array, int lengthOfArray) {
        if (lengthOfArray == 1) {
            return array[0];
        }
        return Math.max(array[lengthOfArray - 1], findMaxRec(array, lengthOfArray - 1));
    }

    public static int sumOfDigits(int number) {
        if (number == 0) {
            return 0;
        } else {
            int numberWithoutLastDigit = number / 10;
            int lastDigitOfNumber = number % 10;
            return lastDigitOfNumber + sumOfDigits(numberWithoutLastDigit);
        }
    }

    public static int numberReversed(int number) {
        if (number < 10) {
            return number;
        } else {
            int lastDigitOfNumber = number % 10;
            int numberWithoutLastDigit = number / 10;
            return Integer.parseInt(lastDigitOfNumber + "" + numberReversed(numberWithoutLastDigit));
        }
    }
}