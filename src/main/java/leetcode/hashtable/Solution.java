package leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2}));
    }
    public static int maxProduct(int[] arr) {
        if(arr.length == 1) return arr[0];

        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= arr.length; i++) {

            dp[i] = Math.max(dp[i - 1] * arr[i - 1], arr[i - 1]);
//            System.out.println(dp[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static int maxSubArraySum(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= arr.length; i++) {

            dp[i] = Math.max(dp[i - 1] + arr[i - 1], arr[i - 1]);
//            System.out.println(dp[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static List<List<String>> groupAnagrams(List<String> strings) {
        List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            boolean belongsToAnyOfTheGroup = false;
            for (int j = 0; j < groups.size(); j++) {
                String groupsFirstString = groups.get(j).get(0);
                if (isAnagram(groupsFirstString, str)) {
                    groups.get(j).add(str);
                    belongsToAnyOfTheGroup = true;
                }
            }
            if (!belongsToAnyOfTheGroup) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groups.add(newGroup);
            }
        }
        return groups;
    }

    public static boolean isAnagram(String str1, String str2) {
        int[] charSet = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            charSet[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            charSet[str2.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (charSet[i] != 0) return false;
        }
        return true;
    }

}
