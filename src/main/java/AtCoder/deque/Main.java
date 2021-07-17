package AtCoder.deque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        int start = 0;
        int end = n-1;
        long x = 0;
        long y = 0;
        String lastPlayed = "second";
        while(start <= end){
            if(arr[start] < arr[end]){
                if(lastPlayed.equals("second")){
                    x += arr[end];
                    end--;
                    lastPlayed = "first";
                }else{
                    y += arr[end];
                    end--;
                    lastPlayed = "second";
                }
            }else{
                if(lastPlayed.equals("second")){
                    x += arr[start];
                    start++;
                    lastPlayed = "first";
                }else{
                    y += arr[start];
                    start++;
                    lastPlayed = "second";
                }
            }
        }
        System.out.println(x-y);
    }
}
