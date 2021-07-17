package leetcode.dp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("babad"));
//        letterCasePermutation("a1b2").forEach(l -> System.out.println(l));
//        climbStairs(4, new HashMap<>());
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];

        min[0] = prices[0];
        max[0] = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max[i - 1]) {
                max[i] = prices[i];
            } else {
                max[i] = max[i - 1];
            }
            if (prices[i] < min[i - 1]) {
                min[i] = prices[i];
                max[i] = 0;
            } else {
                min[i] = min[i - 1];
            }
            if (maxProfit < (max[i] - min[i])) maxProfit = max[i] - min[i];
        }
        if (maxProfit < 0) return 0;
        else return maxProfit;
    }

    public static int count = 0;

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static boolean checkPalindrome(String str) {
        int low = 0;
        int high = str.length() - 1;
        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    //    public static String longPal = "";
//    public static Set<String> stringSet = new HashSet<>();
//
//    public static void longestPalindromeRecursive(String s, String pre, boolean first) {
//        if (checkPalindrome(pre)) {
//            if (longPal.length() < pre.length()) {
//                longPal = pre;
//            }
//            stringSet.add(pre);
//        }
//        if (s.length() == 0) {
//            return;
//        }
//        if (first) {
//            for (int i = 0; i < s.length(); i++) {
//                longestPalindromeRecursive(s.substring(i + 1), pre + s.charAt(i), false);
//            }
//            return;
//        }
//        if (s.length() == 1 && !stringSet.contains(pre + s.charAt(0))) {
//            longestPalindromeRecursive(s.substring(1), pre + s.charAt(0), false);
//        }
//    }
    public static List<String> letterCasePermutation(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        letterCasePermutations(s, "", arrayList);
        return arrayList;
    }

    public static void letterCasePermutations(String s, String pre, ArrayList<String> list) {
        if (s.length() == 0) {
            list.add(pre);
//            System.out.println(pre);
            return;
        }
        if ('a' <= s.charAt(0) && s.charAt(0) <= 'z') {
            letterCasePermutations(s.substring(1), pre + String.valueOf(s.charAt(0)).toUpperCase().charAt(0), list);
            letterCasePermutations(s.substring(1), pre + s.charAt(0), list);
        } else if ('A' <= s.charAt(0) && s.charAt(0) <= 'Z') {
            letterCasePermutations(s.substring(1), pre + String.valueOf(s.charAt(0)).toLowerCase().charAt(0), list);
            letterCasePermutations(s.substring(1), pre + s.charAt(0), list);
        } else {
            letterCasePermutations(s.substring(1), pre + s.charAt(0), list);
        }

    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return null;
        if (s.length() == 1) return String.valueOf(s.charAt(0));
        Map<String, Boolean> booleanMap = new HashMap<>();
        String longestPalindrome = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String pal = s.substring(j, j + i);

            }
        }
        return longestPalindrome;
    }
}

class NumArray{
    int[] nums;
    int[][] dp;

    public NumArray(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        dp = new int[nums.length][nums.length];

    }
    public int sumRange(int i, int j) {
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int sum = 0;
        for (int k = i; k <= j ; k++) {
            sum += this.nums[k];
        }
        dp[i][j] = sum;
        return dp[i][j];
    }
}