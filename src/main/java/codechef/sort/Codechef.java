package codechef.sort;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int customerCount = Integer.parseInt(scanner.nextLine());
        long[] budgets = new long[customerCount];
        for (int i = 0; i < customerCount; i++) {
            budgets[i] = scanner.nextLong();
        }
        quickSort(budgets, 0, customerCount - 1);
        long max = 0;
        for (int i = 0; i < customerCount; i++) {
            if ((budgets[i] * (customerCount - i)) > max) {
                max = budgets[i] * (customerCount - i);
            }
        }
        System.out.println(max);
    }

    static void quickSort(long arr[], int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);

            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    static int partition(long arr[], int low, int high) {
        long pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                long temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

}
