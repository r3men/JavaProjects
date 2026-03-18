// Name: Raymond Zhang
// Assignment: Case of the Torn Raffle Tickets Lab
// Date: 3/12/26
// Extra: I gave the user a choice to sort in descending or ascending order, which has no effect on the method to search for the raffle ticket, since I sort in ascending order after printing regardless.

import java.util.*;
import java.io.*;

public class Case {
    public static void main(String[] args) throws FileNotFoundException {
       String firstName[] = new String[25];
       int firstNum[] = new int[25];
       String lastName[] = new String[25];
       int lastNum[] = new int[25];
       // Initialize scanners for corresponding files
       Scanner firstNameFile = new Scanner(new File("firstname.txt"));
       Scanner firstNumFile = new Scanner(new File("firstnum.txt"));
       Scanner lastNameFile = new Scanner(new File("lastname.txt"));
       Scanner lastNumFile = new Scanner(new File("lastnum.txt"));
       Scanner s = new Scanner(System.in);
       int i = 0;
       while (firstNameFile.hasNextLine() && firstNumFile.hasNextInt()) {
            firstName[i] = firstNameFile.nextLine();
            firstNum[i] = firstNumFile.nextInt();
            i++;
       }
       int j = 0;
       while (lastNameFile.hasNextLine() && lastNumFile.hasNextInt()) {
            lastName[j] = lastNameFile.nextLine();
            lastNum[j] = lastNumFile.nextInt();
            j++;
       }

       // Extra
       System.out.println("Would you like to sort in ascending or descending order?");
       System.out.println("1. Ascending");
       System.out.println("2. Descending");
       int choice = s.nextInt();

       if (choice == 1) {
            ascendingSort(firstName, firstNum);
            ascendingSort(lastName, lastNum);
            System.out.println("In ascending order: ");
            for (int k = 0; k < firstName.length; k++) {
                System.out.println(firstName[k] + " " + lastName[k] + " " + firstNum[k]);
            }
       }
       else if (choice == 2) {
            descendingSort(firstName, firstNum);
            descendingSort(lastName, lastNum);
            System.out.println("In descending order: ");
            for (int k = 0; k < firstName.length; k++) {
                System.out.println(firstName[k] + " " + lastName[k] + " " + firstNum[k]);
            }
            // Resort so binary search works as expected.
            ascendingSort(firstName, firstNum);
            ascendingSort(lastName, lastNum);
       }
       else {
            System.out.println("You did not enter a valid choice. Exiting program...");
       }

       System.out.println("PLease enter the winning raffle ticket number: ");
       int winner = s.nextInt();
       int result = winnerSearch(winner, firstNum);
       if (result == -1) {
            System.out.println("No winner was found.");
       }
       else {
            System.out.println("The winner of the raffle is " + firstName[result] + " " + lastName[result] + "!");
       }

    }

    // Sort arrays in ascending order
    public static void ascendingSort(String[] nameArray, int[] numberArray) {
        int length = numberArray.length;
        for (int i = 1; i < length; i++) {
            int key = numberArray[i];            
            String keyName = nameArray[i];
            int j = i - 1;
            while (j >= 0 && numberArray[j] > key) {
                numberArray[j + 1] = numberArray[j];    
                nameArray[j + 1] = nameArray[j];  
                j--;
            }
            numberArray[j + 1] = key;
            nameArray[j + 1] = keyName;
        }
    }

    // Sort arrays in descending order
    public static void descendingSort(String[] nameArray, int[] numberArray) {
        int length = numberArray.length;
        for (int i = 1; i < length; i++) {
            int key = numberArray[i];            
            String keyName = nameArray[i];
            int j = i - 1;
            while (j >= 0 && numberArray[j] < key) {
                numberArray[j + 1] = numberArray[j];    
                nameArray[j + 1] = nameArray[j];  
                j--;
            }
            numberArray[j + 1] = key;
            nameArray[j + 1] = keyName;
        }
    }

    public static int winnerSearch(int ticket, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right)  / 2;
            if (array[middle] == ticket) {
                return middle;
            }
            else if (array[middle] > ticket) {
                right = middle - 1;
            }
            else if (array[middle] < ticket) {
                left = middle + 1;
            }
        }
        return -1;
    }
}







