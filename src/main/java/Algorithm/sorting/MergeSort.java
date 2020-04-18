package Algorithm.sorting;

import java.util.Arrays;


public class MergeSort {
    private static final int SIZE = 100;
    private static int[] array = new int[SIZE];

    public static void main(String[] args) {

        for (int i=0;i<SIZE;i++){
            array[i] = (int)(Math.random() * SIZE) + 1;
        }

        mergeSort(0,SIZE-1);
        Arrays.stream(array).forEach(number -> System.out.println(number + "|"));
    }


    private static void mergeSort(int start, int end) {

        /*
        * Termination condition
        */
        if(start >= end){return;}

        /*
        * Find mid element, and divide
        */
        int mid = (start + end) / 2;

        /*
        * Call merge sort for left and right
        * both divide arrays
        */
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        /*
        * After sorting, merge arrays
        */
        merge(start, mid, end);
    }

    private static void merge(int start, int mid, int end) {

        int n1 = mid-start+1;
        int n2 = end-mid;
        int[] left = new int[n1];
        int[] right= new int[n2];

        /*
        * Copy arrays into temporary arrays
        */
        for(int i=0;i<n1;i++){
            left[i] = array[start+i];
        }
        for(int i=0;i<n2;i++){
            right[i] = array[mid+1+i];
        }

        int i = 0; /*Starting index of left side array*/
        int j = 0; /*Starting index of right size array*/
        int k = start;/*Starting index for main array*/

        /*
        * Sort both arrays and merge new one
        */
        while (i < n1 && j < n2){

            if(left[i] < right[j]){
                array[k] = left[i];
                i++;
            }else{
                array[k] = right[j];
                j++;
            }
            k++;
        }
        /*
        * Copy remaining element
        */
        while (i < n1){
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < n2){
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
