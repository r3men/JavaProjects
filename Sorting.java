
/*
Name: Raymond Zhang
Assignment: Arrays Sorting Lab
Date: 3/20/26
Extra: I gave the user the option to enter a name to search for within the array they constructed, rather than explicitly searching for "Oscar".
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Intialize scanner variable.
        // #1
        int[] array1 = {65, 45, 34, 12, 99, 54, 39, 2, 88, 18};
        System.out.println("Here is the original array before bubble sort is applied: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("\nHere is the original array after bubble sort is applied: ");
        bubbleSort(array1); // Call the bubble sort function on array1.
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        // #2
        double[] array2 = {43.2, 13.6, 91.4, 23.6, 72.1};
        System.out.println("\nHere is the original array before exchange sort is applied: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("\nHere is the original array after exchange sort is applied: ");
        exchangeSort(array2);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        // #3
        String[] array3 = {"a", "g", "k", "j", "t", "i", "f", "s", "w", "b"};
        System.out.println("\nHere is the original array before alphabetic sort is applied: ");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println("\nHere is the original array after alphabetic sort is applied: ");
        alphabeticSort(array3);
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        // #4
        String[] array4 = {"camel", "ant", "dog", "cat", "horse", "mule", "java", "goose"};
        System.out.println("\nHere is the original array before alphabetic sort is applied: ");
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");
        }
        System.out.println("\nHere is the original array after alphabetic sort is applied: ");
        alphabeticSort(array4);
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");
        }
        // #5
        String[] names = new String[5];
        for (int i = 0; i < names.length; i++) {
            System.out.print("\nEnter the first name of Friend #" + (i + 1) + ": ");
            names[i] = s.next();
        }
        System.out.println("\nHere is the original array before alphabetic sort is applied: ");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }
        System.out.println("\nHere is the original array after alphabetic sort is applied: ");
        alphabeticSort(names);
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }
        // Extra
        System.out.print("\nWhat name would you like to search for in the array we just created? ");
        String name = s.next();
        int result = sequentialSearch(names, name);
        if (result == -1) {
            System.out.println(name + " was not found in the sorted array.");
        }
        else {
            System.out.println(name + " was found in position " + result + " of the sorted array.");
        }
        // #6
        String[] terms = new String[10];
        for (int i = 0; i < terms.length; i++) {
            System.out.print("Enter the computer term #" + (i + 1) + ": ");
            terms[i] = s.next();
        }
        System.out.println("\nHere is the original array before alphabetic sort is applied: ");
        for (int i = 0; i < terms.length; i++) {
            System.out.print(terms[i] + " ");
        }
        System.out.println("\nHere is the original array after alphabetic sort is applied: ");
        alphabeticSort(terms);
        for (int i = 0; i < terms.length; i++) {
            System.out.print(terms[i] + " ");
        }
        int result2 = binarySearch(terms, "mouse");
        if (result2 == 0) {
            System.out.println("\nmouse was not found in the sorted array.");
        }
        else {
            System.out.println("\nmouse was found in position " + result2 + " of the sorted array.");
        }
    }
    
    public static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true; // Swap occurs, do not end loop yet.
                }
            }
        }
    }
    
    public static void exchangeSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
    public static void alphabeticSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareToIgnoreCase(array[j]) > 0) { // Checks if the current string is greater than the latter string. 
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int sequentialSearch(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) { // Checks if strings are equivalent to each other.
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(String[] array, String target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = array[mid].compareToIgnoreCase(target);
            if (comparison == 0) {
                return mid; // Found
            } 
            else if (comparison < 0) {
                left = mid + 1; // Search right half
            } 
            else {
                right = mid - 1; // Search left half
            }
        }
        return -1;
    }
}


