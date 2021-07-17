package leetcode;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.Semaphore;

class Resource{
    static String string1 = "string1";

    static String string2 = "string2";
}
class Thread1 implements Runnable{
    @SneakyThrows
    @Override
    public void run(){
        synchronized (Resource.string1){
            System.out.println("Got lock on string1 from thread1");
            Thread.sleep(10000);
        }

        synchronized (Resource.string2){
            System.out.println("Got lock on string2 from thread1, releasing both resources");
        }
    }
}
class Thread2 implements Runnable{
    @SneakyThrows
    @Override
    public void run(){
        synchronized (Resource.string2){
            System.out.println("Got lock on string2 from thread2");
        }
//        Thread.sleep(10000);
        synchronized (Resource.string1){
            System.out.println("Got lock on string1 from thread2, releasing both resources");
        }
    }
}
public class Main {
    public static int maxLength = 1;

    public static void main(String[] args) {
        Main main = new Main();
//        int a = 11;
//        Thread1 thread1 = new Thread1();
//        Thread2 thread2 = new Thread2();
//        new Thread(thread1).start();
//        new Thread(thread2).start();
//        System.out.println((a & 1) == 0);
//        System.out.println(a >> 2);
//        System.out.println(main.count(new int[]{1,2,3,4,7,8,9,11}, 8, 7));

        int[] array = {1,2,3,4,5};
        int[] newArray = array;
        newArray[0] = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public void lol(int[][] a){
        a[0][0] = 100;
    }
    public static String shortestCommonSupersequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        StringBuilder[][] dp = new StringBuilder[m+1][n+1];
        dp[0][0] = new StringBuilder("");
        for(int i = 1; i <= m; i++){
            dp[i][0] = new StringBuilder(X.substring(0, i));
        }
        for(int i = 1; i <= n; i++){
            dp[0][i] = new StringBuilder(Y.substring(0,i));
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = new StringBuilder();
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1].append(X.charAt(i-1));
                }else{

                    if(dp[i-1][j].length() > dp[i][j-1].length()){
                        dp[i][j].append(dp[i][j-1]).append( Y.charAt(j-1));
                    }else{
                        dp[i][j].append(dp[i-1][j]).append(X.charAt(i-1));
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.reverse()
        return dp[m][n].toString();
    }
    static long countMaximum(int arr[], int n) {
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }
        for (int start = 2; start < n; start++) {
            int row = 0;
            for (int column = start; column < n; row++, column++) {
                dp[row][column] = Math.max(
                        arr[row] + Math.min(dp[row + 2][column], dp[row + 1][column - 1]),
                        arr[column] + Math.min(dp[row][column - 2], dp[row + 1][column - 1])
                );
            }
        }
        return dp[0][n-1];
    }

    public long count(int S[], int m, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            int sum = 0;
            for (int j = 0; j < S.length; j++) {
                if (S[j] <= i) {
                    sum += dp[i - S[j]];
                }
            }
            dp[i] = sum;
        }
        return dp[amount];
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i - 1][i] = nums[i - 1] < nums[i] ? 2 : 1;
        }

        for (int i = 2; i < nums.length; i++) {
            int column = i;
            int row = 0;
            int count = nums.length - column;
            while (count > 0) {
                dp[row][column] = nums[column - 1] < nums[column] ? dp[row][column - 1] + 1 : dp[row][column - 1];
                row++;
                column++;
                count--;
            }
        }

        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int j1 = 0; j1 < nums.length; j1++) {
                System.out.print(dp[i1][j1] + " ");
            }
            System.out.println();
        }
        return 1;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
//        help(candidates, target, 0, result, new ArrayList<>(), 0);
        return result;
    }

    public int myAtoi(String string) {
        string = string.strip();
        StringBuilder stringBuilder = new StringBuilder();
        Integer integer = 0;
        boolean isNegative = false;
        boolean found = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                break;
            }
            if (string.charAt(i) == '-') {
                isNegative = true;
                continue;
            }
            if (string.charAt(i) == '+') {
                continue;
            }
            if ('9' < string.charAt(i) || string.charAt(i) < '0') {
                break;
            } else {
                stringBuilder.append(string.charAt(i));
                integer = integer * 10 + Integer.parseInt(String.valueOf(string.charAt(i)));
            }
        }
        if (stringBuilder.length() == 0) return 0;
//        long result = Long.parseLong(stringBuilder.toString());
        if (isNegative) integer = -integer;
        if (isNegative) {
            if (integer < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int) integer;
        } else {
            if (integer > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int) integer;
        }

    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        fillMatrix(result, 0, 0, 1, true);
        return result;
    }

    public void fillMatrix(int[][] result, int i, int j, int count, boolean direction) {
        if (i < 0 || i >= result.length || j < 0 || j >= result.length || result[i][j] != -1) {
            return;
        }
        result[i][j] = count;
        count++;

        if (direction) {
            fillMatrix(result, i, j + 1, count, true);
            fillMatrix(result, i + 1, j, count, false);
            fillMatrix(result, i, j - 1, count, true);
            fillMatrix(result, i - 1, j, count, false);
        } else {
            fillMatrix(result, i - 1, j, count, false);
            fillMatrix(result, i, j + 1, count, true);
            fillMatrix(result, i + 1, j, count, false);
            fillMatrix(result, i, j - 1, count, true);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> result = new ArrayList<>();

            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] <= i) {
                    if (candidates[j] == i) {
                        result.add(Arrays.asList(candidates[j]));
                    } else {
                        for (List<Integer> prevList : dp[i - candidates[j]]) {
                            if (candidates[j] >= prevList.get(prevList.size() - 1)) {
                                List<Integer> tempList = new ArrayList<>(prevList);
                                prevList.add(candidates[j]);
                                result.add(tempList);
                            }
                        }
                    }
                }
            }
            dp[i] = result;
        }
        return dp[target];
    }

    public void combinationSum(List<List<Integer>> result, List<Integer> list, int[] arr, int target, int start) {
        if (target < 0) return;
        if (target == 0) result.add(new ArrayList<>(list));
        else {
            for (int i = start; i < arr.length; i++) {
                list.add(arr[i]);
                combinationSum(result, list, arr, target - arr[i], i);
                list.remove(list.size() - 1);
            }
        }
    }

    public void combinationSum2(List<List<Integer>> result, List<Integer> list, int[] arr, int target, int start) {
        if (target < 0) return;
        if (target == 0) result.add(new ArrayList<>(list));
        else {
            for (int i = start; i < arr.length; i++) {
                if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                    list.add(arr[i]);
                    combinationSum(result, list, arr, target - arr[i], i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1;
                int end = nums.length - 1;
                int sum = -nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < sum) start++;
                    else end--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int count = 0;
                    if (target - sum == nums[i]) count++;
                    if (target - sum == nums[j]) count++;
                    if (target - sum == nums[k]) count++;

                    if (freq.containsKey(target - sum) && freq.get(target - sum) > count) {
                        List<Integer> l1 = new ArrayList<>();
                        l1.add(nums[i]);
                        l1.add(nums[j]);
                        l1.add(nums[k]);
                        l1.add(target - sum);
                        Collections.sort(l1);
                        StringBuilder stringBuilder = new StringBuilder();
                        l1.forEach(item -> stringBuilder.append(item).append(":"));
                        if (!set.contains(stringBuilder.toString())) {
                            list.add(l1);
                            set.add(stringBuilder.toString());
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void printPermute(String str, String pre, boolean first, Set<Character> chars) {
        System.out.println(pre);
        if (str.length() == 0) return;

        if (first) {
            for (int i = 0; i < str.length(); i++) {
                Set<Character> set = new HashSet<>();
                set.add(str.charAt(i));
                printPermute(str.substring(i + 1), pre + str.charAt(i), false, set);
            }
        } else {
            if (!chars.contains(str.charAt(0))) {
                final int length = (pre + str.charAt(0)).length();
                if (maxLength < length) {
                    maxLength = length;
                }
                chars.add(str.charAt(0));
                printPermute(str.substring(1), pre + str.charAt(0), false, chars);
            }
        }
    }


    public int minDistance(String w1, String w2) {
        char[] word1 = w1.toCharArray();
        char[] word2 = w2.toCharArray();
        int word1Length = w1.length();
        int word2Length = w2.length();
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 1; i <= word1Length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2Length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1[(i - 1)] == word2[(j - 1)]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                    dp[i][j - 1],
                                    dp[i - 1][j - 1]
                            )
                    );
                }
            }
        }
        return dp[word1Length][word2Length];
    }

    public static void printPermuteArray(int[] arr, int xor, int k, int start, int n) {
        if (k == 0) {
            System.out.println();
            return;
        }
        for (int i = start; i <= n - k; i++) {
            System.out.print(arr[i]);
            printPermuteArray(arr, xor + arr[i], k - 1, i + 1, n);
        }
    }


    public static void printPermute(int[] arr, int pre, int k, int start, int n) {
        if (k == 0) {
            System.out.println(pre);
            return;
        }
        for (int i = start; i <= n - k; i++) {
            printPermute(arr, pre + arr[i], k - 1, i + 1, n);
        }
    }

    public static void printPermuteA(String str, String pre, int k, int start) {
        if (k == 0) {
            System.out.println(pre);
            return;
        }
        for (int i = start; i <= str.length() - k; i++) {
            String rem = str.substring(i);
            printPermuteA(rem, pre + str.charAt(i), k - 1, 1);
        }
    }

    public static boolean isAnagram(String s, String t) {
        int[] charSet = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charSet[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            charSet[t.charAt(i)]--;

        }
        for (int i = 0; i < 128; i++) {
            if (charSet[i] != 0) return false;
        }
        return true;
    }

    public static void printSubstrings(String str, String pre) {
        System.out.println(pre);

        if (str.length() == 0) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            printSubstrings(rem, pre + str.charAt(i));
        }
    }

    public boolean isBalanced(TreeNode root) {
        getNodeCount(root);
        return result;
    }

    public static boolean result = true;

    public int getNodeCount(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depthRight = maxDepth(root.right);
        int depthLeft = maxDepth(root.left);
        if (Math.abs(depthLeft - depthLeft) > 1) {
            result = false;
            return 0;
        }
        return depthLeft + depthRight + 2;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depthRight = maxDepth(root.right);
        int depthLeft = maxDepth(root.left);
        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }

    public static ArrayList<Integer> traversed = new ArrayList<>();

    public static void wrapper(TreeNode root) {
        if (root != null) {
            wrapper(root.left);
            traversed.add(root.val);
            wrapper(root.right);
        }
    }

    public static boolean isValidBST(TreeNode root) {
        wrapper(root);
        if (traversed.size() == 0 || traversed.size() == 1) return true;
        for (int i = 0; i < traversed.size() - 1; i++) {
            if (traversed.get(i) >= traversed.get(i + 1)) return false;
        }
        return true;
    }

    public static void printPermutations(String str, String pre) {
        if (str.length() == 0) {
            System.out.println(pre);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(0, i) + str.substring(i + 1);
            printPermutations(remaining, pre + str.charAt(i));
        }
//        printPermutations(str.substring(1), str.substring(0,1));
    }

    public static void printLexicographicOrder(int n, int i) {
        if (i > n) return;
        System.out.println(i);
        for (int j = (i == 0 ? 1 : 0); j < 10; j++) {
            printLexicographicOrder(n, 10 * i + j);
        }
    }

    public static int count = 0;

    public static void printJumps(int rem, String osf) {

        if (rem == 0) {
            System.out.println(osf);
            count++;
//            return;
        }
        if (rem >= 1) {
            printJumps(rem - 1, osf + "1");
        }
        if (rem >= 2) {
            printJumps(rem - 2, osf + "2");
        }
        if (rem >= 3) {
            printJumps(rem - 3, osf + "3");
        }
        if (rem >= 4) {
            printJumps(rem - 4, osf + "4");
        }
        if (rem >= 5) {
            printJumps(rem - 5, osf + "5");
        }
        if (rem >= 6) {
            printJumps(rem - 6, osf + "6");
        }

    }

    public static int printWays(int size, int r, int d, String osf) {
        if (size == 2) {
            if (r > 0 && d > 0) {
                System.out.println(osf + "RD");
                System.out.println(osf + "DR");
                return 2;
            } else if (r > 0) {
                System.out.println(osf + "RR");
                return 1;
            } else {
                System.out.println(osf + "DD");
                return 1;
            }
        } else {
            if (r > 0 && d > 0) {
                int rcount = printWays(size - 1, r - 1, d, osf + "R");
                int dcount = printWays(size - 1, r, d - 1, osf + "D");
                return rcount + dcount;
            } else if (r > 0 && d == 0) {
                return printWays(size - 1, r - 1, d, osf + "R");
            } else {
                return printWays(size - 1, r, d - 1, osf + "D");
            }
        }
    }


}
