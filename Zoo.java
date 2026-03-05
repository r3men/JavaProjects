/**
* Name: Raymond Zhang
* Program Name: Unit 8 Final Project
* Date: 5/28/24
* Extra: I used ANSI color codes to depict whether the animal shown is critically endangered or not endangered. RED = Critically, GREEN = stable.
*/
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String ANSI_RESET = "\u001B[0m";
    String[] animals = {"Yangtze Finless Porpoise", "Javan Rhino", "African Forest Elephant", "Sunda Island Tiger", "Black Rhino", "Mountain Gorilla", "Sumatran Orangutan", "American Flamingo", "Black-Handed Spider Monkey", "Kori Bustard", "Red Panda", "Desert Kingsnake", "American Alligator"}; // Intializes array of strings
    int[] updpops = {595, 76, 150000, 600, 5550, 1004, 13846, 85000, 250, 3500, 2500, 10000, 5000000};
    int[] updel = {9, 10, 5, 9, 7, 8, 6, 5, 9, 7, 8, 6, 2};
    String[] updnh = {"Yangtze River", "Ujung Kulon National Park", "West/Central Africa", "Sumatra", "Eastern Africa", "West Africa", "Northern Sumatra", "Carribean", "Central/South America", "Eastern/Southern Africa", "Himalayas", "Southern USA", "Southeastern USA"};
    linePrinter(); // Calls the lineprinter function
    System.out.println("Welcome to the Exotic Animal Database! Here you can find some of the most exotic and even endangered animals in the world!");
    linePrinter();
    while (true) { // Runs continously until broken out of
      linePrinter();
      System.out.println("What would you like to do?");
      System.out.println("0. Exit");
      System.out.println("1. Find a Specific Animal");
      System.out.println("2. Sort by Category");
      System.out.println("3. View Our Animals");
      int num = in.nextInt();
      linePrinter();
      if (num == 0) {
        break;
      }
      else if (num == 1) {
        System.out.println("What would you like to search by?");
        System.out.println("1. Animal Name");
        System.out.println("2. Population");
        System.out.println("3. Endangerment Level");
        System.out.println("4. Native Habitat");
        int ans = in.nextInt();
        int idx = 0; 
        if (ans == 1) {
          in.nextLine();
          System.out.println("What is the name of the animal are you looking for?");
          String name = in.nextLine();
          sarraySorterasc(animals, updpops, updel, updnh); // calls string array sorting function
          idx = sgetIndex(animals, name); // Sets the index variable to the index of the animal name in the animals array.
          System.out.println("Here is some information about the " + animals[idx] + ":");
          System.out.println("Population: " + updpops[idx]);
            if (updel[idx] >= 8) {
              // Extra:
              System.out.println("Endangerment Level: " + "\u001B[31m" + updel[idx] + ANSI_RESET);
            }
            else {
              System.out.println("Endangerment Level: " + "\u001B[32m" + updel[idx] + ANSI_RESET);
            }
            System.out.println("Native Habitat: " + updnh[idx]);
          }
        else if (ans == 2) {
          System.out.println("What is the population estimate of the animal you are searching for?");
          int pop = in.nextInt();
          iarraySorterasc(animals, updpops, updel, updnh);
          idx = igetIndex(updpops, pop);
        }
        else if (ans == 3) {
          System.out.println("What endangerment level is of the animal you are searching for considered to be at?");
          int el = in.nextInt();
          iarraySorterasc(animals, updel, updpops, updnh);
          idx = igetIndex(updel, el);
        }
        else if (ans == 4) {
          in.nextLine();
          System.out.println("What is the native habitat of the animal you are searching for?");
          String nh = in.nextLine();
          sarraySorterasc(updnh, updpops, updel, animals);
          idx = sgetIndex(updnh, nh);
          
        }
        else {
          System.out.println("You did not enter one of the available options.");
        }
        if (idx == -1) {
          linePrinter();
          System.out.println("We could not locate that animal in our database.");
          continue;
        }
      }
        else if (num == 2) {
        System.out.println("What category would you like to sort by?");
        System.out.println("1. Animal Names");
        System.out.println("2. Animal Populations (Estimated)");
        System.out.println("3. Endangerment Level [1 (Not in Danger) - 10 (In Extreme Danger)]");
        System.out.println("4. Native Habitats");
        int num2 = in.nextInt();
        linePrinter();
        if (num2 == 1) {
          System.out.println("In Ascending or Descending Order?");
          System.out.println("1. Ascending");
          System.out.println("2. Descending");
          int num3 = in.nextInt();
          if (num3 == 1) {
            sarraySorterasc(animals, updpops, updel, updnh);
            namePrinter(animals, updpops, updel, updnh);
          }
          else if (num3 == 2) {
            sarraySorterdsc(animals, updpops, updel, updnh);
            namePrinter(animals, updpops, updel, updnh);
          }
          else {
            System.out.println("You did not enter one of the available options.");
          }
        }
        else if (num2 == 2) {
          System.out.println("In Ascending or Descending Order?");
          System.out.println("1. Ascending");
          System.out.println("2. Descending");
          int num4 = in.nextInt();
          if (num4 == 1) {
            iarraySorterasc(animals, updpops, updel, updnh);
            namePrinter(animals, updpops, updel, updnh);
          }
          else if (num4 == 2) {
            iarraySorterdsc(animals, updpops, updel, updnh);
            namePrinter(animals, updpops, updel, updnh);
          }
          else {
            System.out.println("You did not enter one of the available options.");
          }
        }
        else if (num2 == 3) {
          System.out.println("In Ascending or Descending Order?");
          System.out.println("1. Ascending");
          System.out.println("2. Descending");
          int num5 = in.nextInt();
          if (num5 == 1) {
            iarraySorterasc(animals, updel, updpops, updnh);
            namePrinter(animals, updpops, updel, updnh);
          }
          else if (num5 == 2) {
            iarraySorterdsc(animals, updel, updpops, updnh);
            namePrinter(animals, updpops, updel, updnh);
          }
          else {
            System.out.println("You did not enter one of the available options.");
          }
        }
        else if (num2 == 4) {
          System.out.println("In Ascending or Descending Order?");
          System.out.println("1. Ascending");
          System.out.println("2. Descending");
          int num6 = in.nextInt();
          if (num6 == 1) {
            sarraySorterasc(updnh, updpops, updel, animals);
            namePrinter(animals, updpops, updel, updnh);
          }
          else if (num6 == 2) {
            sarraySorterdsc(updnh, updpops, updel, animals);
            namePrinter(animals, updpops, updel, updnh);
          }
          else {
            System.out.println("You did not enter one of the available options.");
          }
        }
        else {
          System.out.println("You did not enter one of the available options.");
        }
      }
      else if (num == 3) {
        System.out.println("Here are the animals we currently house: ");
        for (int i = 0; i < animals.length; i++) {
          System.out.println("Animal Name: " + animals[i]);
          System.out.println("Population: " + updpops[i]);
          if (updel[i] >= 8) {
            // Extra:
            System.out.println("Endangerment Level: " + "\u001B[31m" + updel[i] + ANSI_RESET);
          }
          else {
            System.out.println("Endangerment Level: " + "\u001B[32m" + updel[i] + ANSI_RESET);
          }
          System.out.println("Native Habitat: " + updnh[i]);
          System.out.println();
        }
      }
      else {
        System.out.println("You did not enter one of the available options.");
      }
    }
  }
  public static void linePrinter() {
    System.out.println("--------------------------------------------------------------");
  }
  public static void namePrinter(String[] a, int[] b, int[] c, String[] d) {
    String ANSI_RESET = "\u001B[0m";
    for (int i = 0; i < a.length; i++) {
      System.out.println("Animal Name: " + a[i]);
      System.out.println("Population: " + b[i]);
      if (c[i] >= 8) {
        // Extra:
        System.out.println("Endangerment Level: " + "\u001B[31m" + c[i] + ANSI_RESET);
      }
      else {
        System.out.println("Endangerment Level: " + "\u001B[32m" + c[i] + ANSI_RESET);
      }
      System.out.println("Native Habitat: " + d[i]);
      System.out.println();
    }
  }
  public static int sgetIndex(String[] a, String key) {
    int low = 0;
    int high = a.length - 1;
    int mid;
    while (low <= high) {
      mid = (low + high)/2;
      int rslt = key.toUpperCase().compareTo(a[mid].toUpperCase());
      if (rslt == 0) {
        return mid;
      }
      else if (rslt < 0) { 
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return -1;
  }
  public static int igetIndex(int[] a, int key) {
    int low = 0;
    int high = a.length - 1;
    int mid;
    while (low <= high) {
      mid = (low + high)/2;
      if (a[mid] == key) {
        return mid;
      }
      else if (a[mid] < key) { 
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return -1;
  }
  public static String[] sarraySorterasc(String[] arr, int[] arr1, int[] arr2, String[] arr3) {
    String temp, temp3;
    int temp1, temp2;
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i].compareTo(arr[i + 1]) > 0) {
          flag = false; 
          
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          
          temp1 = arr1[i];
          arr1[i] = arr1[i + 1];
          arr1[i + 1] = temp1;

          temp2 = arr2[i];
          arr2[i] = arr2[i + 1];
          arr2[i + 1] = temp2;

          temp3 = arr3[i];
          arr3[i] = arr3[i + 1];
          arr3[i + 1] = temp3;
        }
      }
    }
    return arr;
  }
  public static String[] sarraySorterdsc(String[] arr, int[] arr1, int[] arr2, String[] arr3) {
    String temp, temp3;
    int temp1, temp2;
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i].compareTo(arr[i + 1]) < 0) {
          flag = false; 

          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;

          temp1 = arr1[i];
          arr1[i] = arr1[i + 1];
          arr1[i + 1] = temp1;

          temp2 = arr2[i];
          arr2[i] = arr2[i + 1];
          arr2[i + 1] = temp2;

          temp3 = arr3[i];
          arr3[i] = arr3[i + 1];
          arr3[i + 1] = temp3;
        }
      }
    }
    return arr;
  }
  public static String[] iarraySorterasc(String[] arr, int[] arr1, int[] arr2, String[] arr3) {
    String temp, temp3;
    int temp1, temp2;
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr1[i] > arr1[i + 1]) {
          flag = false; 

          temp1 = arr1[i];
          arr1[i] = arr1[i + 1];
          arr1[i + 1] = temp1;
          
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;

          temp2 = arr2[i];
          arr2[i] = arr2[i + 1];
          arr2[i + 1] = temp2;

          temp3 = arr3[i];
          arr3[i] = arr3[i + 1];
          arr3[i + 1] = temp3;
        }
      }
    }
    return arr;
  }
  public static String[] iarraySorterdsc(String[] arr, int[] arr1, int[] arr2, String[] arr3) {
    String temp, temp3;
    int temp1, temp2;
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr1[i] < arr1[i + 1]) {
          flag = false; 

          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;

          temp1 = arr1[i];
          arr1[i] = arr1[i + 1];
          arr1[i + 1] = temp1;

          temp2 = arr2[i];
          arr2[i] = arr2[i + 1];
          arr2[i + 1] = temp2;

          temp3 = arr3[i];
          arr3[i] = arr3[i + 1];
          arr3[i + 1] = temp3;
        }
      }
    }
    return arr;
  }
}
