package Hackerank;

import java.util.HashMap;
import java.util.Map;

public class dp {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 8, 4};
        System.out.println(maxSubsetSum(arr));
    }

    //https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
    static int maxSubsetSum(int[] arr) {
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        HashMap<Integer, Integer> dp1 = new HashMap<>();
        dp1.put(0, arr[0]);
        dp1.put(1, 0);

        for (int i = 2; i < arr.length; i++) {
            int ifCurrentNotIncluded = dp1.get(i - 1);
            int ifCurrentIncluded = arr[i] + dp1.get(i - 2);
            dp1.put(i, Math.max(ifCurrentIncluded, ifCurrentNotIncluded));
        }
        HashMap<Integer, Integer> dp2 = new HashMap<>();
        dp2.put(0, 0);
        dp2.put(1, arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int ifCurrentNotIncluded = dp2.get(i - 1);
            int ifCurrentIncluded = arr[i] + dp2.get(i - 2);
            dp2.put(i, Math.max(ifCurrentIncluded, ifCurrentNotIncluded));
        }
        if(Math.max(dp1.get(arr.length - 1), dp2.get(arr.length - 1)) < 0) return 0;
        else return Math.max(dp1.get(arr.length - 1), dp2.get(arr.length - 1));
//        if(dp.get(arr.length - 1) < 0) return 0;
//        return dp.get(arr.length - 1);
    }
}
