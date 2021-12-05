/*
* This program generates 250 random numbers in an array
* and allows the user to search the array for a number.
*
* @author  Hussein
* @version 0.5
* @since   2020-12-2
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
* This is the standard "BinarySearch" program.
*/

final class BinarySearch {

    /**
    * The max number for array.
    */
    public static final int MAX = 100;
    /**
    * The number of elements in the array.
    */
    public static final int ARRAY_SIZE = 100;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private BinarySearch() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function finds the index of a number, using Binary Search recursively.
    *
    * @param array The array
    * @param element the element in the array
    * @param low the low index
    * @param high the high index
    * @return binarySearch
    */

    int binarySearch(int[] array, int element, int low, int high) {

        int ret = -1;

        if (high >= low) {
            final int mid = low + (high - low) / 2;

            // check if mid element is searched element
            if (array[mid] == element) {
                ret = mid;
            }

            // Search the left half of mid
            if (array[mid] > element) {
                ret = binarySearch(array, element, low, mid - 1);
            }

            // Search the right half of mid
            ret = binarySearch(array, element, mid + 1, high);
        }
        return ret;
    }
    /**
    * Starting... the main method
    *
    * @param args No args will be used
    */

    public static void main(String[] args) {
        System.out.println("Binary Search Program");
        try {
            // create an object of BinarySearch class
            final BinarySearch obj = new BinarySearch();

            // Initializing the random class
            final Random randNumber = new Random();

            // Initializing array of numbers
            final int[] randomNumberArray = new int[ARRAY_SIZE];

            // Adding numbers to the array
            for (int counter = 0; counter < randomNumberArray.length;
                 counter++) {
                randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
            }

            // Sorting the array
            final int[] numberArray = randomNumberArray;
            Arrays.sort(numberArray);

            // get input from user for element to be searched
            final Scanner userInput = new Scanner(System.in);
            System.out.print("What number are you searching for in the array");
            System.out.print(" (integer between 0 and 100): ");

            // element to be searched
            final int searchNumber = userInput.nextInt();
            userInput.close();
            System.out.println();

            // call the binary search method
            // pass arguments: array, element, index of first and last element
            final int result = obj.binarySearch(numberArray, searchNumber,
                                          0, numberArray.length - 1);
            if (result == -1) {
                System.out.println("Not found");
            } else {
                System.out.println("Element found at index " + result);
            }
        } catch (java.util.InputMismatchException errorCode) {
            System.out.println();
            System.out.println("ERROR: Invalid Input");
        }
        System.out.println("\nDone.");
    }
}
