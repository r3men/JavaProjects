// Name: Raymond Zhang
// Assignment: Strictly Speaking Math Lab
// Date: 3/18/26
// Extra: To calculate the median, rather than using a built in sorting method, I implemented my own insertion sort.

import java.util.*;

public class StrictlySpeakingMath {
    public static void main(String[] args) {
        // TASK 1
        int[] integers = new int[25];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = (int) (Math.random() * 100) + 1; // Generates a random integer from 1 to 100 inclusive.
        }
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                System.out.print(integers[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 != 0) {
                System.out.print(integers[i] + " ");
            }
        }
        System.out.println();
        // TASK 2
        int[] integers2 = {101, 444, 222, 505, 154, 278, 909, 881, 118, 221};
        for (int i = 0; i < integers2.length; i++) {
            String stringInteger = Integer.toString(integers2[i]);
            if (reverseString(stringInteger).equals(stringInteger)) { // Check if reverse equals original.
                System.out.println(integers2[i] + " is a palindrome!");
            }
        }
        // TASK 3
        int[] integers3 = new int[25];
        for (int i = 0; i < integers3.length; i++) {
            integers3[i] = (int) (Math.random() * 100) + 1;
        }
        double[] statistics = numberAnalysis(integers3);
        System.out.println("Mean: " + statistics[0]);
        System.out.println("Median: " + statistics[1]);
        System.out.println("Max: " + statistics[2]);
        System.out.println("Min: " + statistics[3]);
        System.out.println("Range: " + statistics[4]);
        System.out.println("Variance: " + statistics[5]);
        System.out.println("Standard Deviation: " + statistics[6]);

    }

    public static String reverseString(String original) {
        String reverseString = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reverseString += original.charAt(i); // Assemble reverse string of original.
        }
        return reverseString;
    }

    public static double[] numberAnalysis(int[] numberArray) {
        int n = numberArray.length;
        double sum = 0;
        for (int num : numberArray) {
            sum += num;
        }
        double mean = sum / n;
        int[] toSort = numberArray.clone();
        insertionSort(toSort);
        double median;
        if (n % 2 == 0) {
            median = (toSort[n / 2 - 1] + toSort[n / 2]) / 2.0;
        } 
        else {
            median = toSort[n / 2];
        }
        int min = toSort[0];
        int max = toSort[n - 1];
        int range = max - min;
        double varianceSum = 0;
        for (int num : numberArray) {
            varianceSum += Math.pow(num - mean, 2);
        }
        double variance = varianceSum / n;
        double stdDev = Math.sqrt(variance);
        return new double[] {
            mean,
            median,
            max,
            min,
            range,
            variance,
            stdDev
        };
    }

    public static void insertionSort(int[] array) { // Extra
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}