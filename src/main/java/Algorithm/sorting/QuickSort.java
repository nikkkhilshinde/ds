package Algorithm.sorting;

import java.util.Arrays;

public class QuickSort {
    private final static int SIZE = 100;
    private static int[] array = new int[SIZE];

    public static void main(String[] args) {

//        int[] numbers = new int[SIZE];
        for (int i=0;i<SIZE;i++){
            array[i] = (int)(Math.random() * SIZE) + 1;
        }

        quickSort(0, 99);
        Arrays.stream(array).forEach(number -> System.out.print(number + "|"));
    }

    public static void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }


        int pivot = array[end];

        int count = start;

        for (int i = start; i <= end; i++) {

            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;

                count++;
            }
        }


        quickSort(start, count - 2);
        quickSort(count, end);
    }
}
