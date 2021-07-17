package Algorithm.sorting;

public class QuickSortHoare {
    public static int SIZE = 100;

    public static void main(String[] args) {
        int[] arr = new int[SIZE];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * SIZE);
        }
        quickSort(arr, 0 , SIZE - 1);
        for (int i = 0; i < SIZE; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
