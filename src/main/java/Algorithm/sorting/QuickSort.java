package Algorithm.sorting;

import java.util.Arrays;


public class QuickSort {
    private final static int SIZE = 100;
    private static int[] array = new int[SIZE];

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            array[i] = (int) (Math.random() * SIZE) + 1;
        }

        quickSort(array, 0, 99);
        Arrays.stream(array).forEach(number -> System.out.println(number + "|"));
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);

            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
