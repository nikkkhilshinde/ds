package Tree.BinarySearchTree;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int findMax(int[] arr, int data, String dir){

        int max = data;
        int index = 0;
        boolean found = false;
        if(dir.equals("left")){
            for(int i=arr.length-1; i>=1;i--){
                System.out.print(arr[i] + " ");
                if(max < arr[i]){
                    found = true;
                    index = i+1;
                    break;
                }
            }
        }else{
            for(int i=0; i<arr.length;i++){
                System.out.print(arr[i] + " ");
                if(max < arr[i]){
                    found = true;
                    index = i+1;
                    break;
                }
            }
        }

        // System.out.println(index);

        if(found){
            return index;
        }else{
            return 0;
        }
    }
    static int solve(int[] arr) {

        int maxProduct = 0;
        for(int i=0;i<arr.length;i++){
            if(i!=0 && i!=arr.length-1){
                int left = findMax(Arrays.copyOfRange(arr, 0, i),arr[i],"left");
                int right = i + 1 + findMax(Arrays.copyOfRange(arr, i + 1 , arr.length),arr[i],"right");
                System.out.print("|"+left + " " + right + "|");
                System.out.println();
                int product =  left*right;

                // System.out.println(product);
                if(maxProduct < product){
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        int result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
