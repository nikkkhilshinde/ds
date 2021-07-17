package leetcode.dp;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

class Pair implements Comparable {
    public int number;
    public int frequency;

    Pair(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Pair otherPair = (Pair) o;
        Pair thisPair = this;
        if (otherPair.frequency == thisPair.frequency) return 0;
        if (thisPair.frequency > otherPair.frequency) return 1;
        return -1;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {
                "0201","0101","0102","1212","2002"
        };
        System.out.println(solution.openLock(strs, "0202"));
    }
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                String front = queue.remove();
                if(set.contains(front)) continue;
                else set.add(front);
                if(front.equals(target)) return level;

                for(String lock : getNextPositions(front)){
                    if(set.contains(lock)) continue;
                    else{
//                        set.add(lock);
                        queue.add(lock);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    List<String> getNextPositions(String str){
        char[] arr = str.toCharArray();
        List<String> locks = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            arr[i] = ch == '9' ? '0' : (char) (ch  + 1);
            locks.add(String.valueOf(arr));
            arr[i] = ch == '0' ? '9' : (char) (ch - 1);
            locks.add(String.valueOf(arr));
            arr[i] = ch;
        }
        return locks;
    }

    static int scale = 1000000000;
    static int[][] dirs = {{2, 1}, {-2, -1}, {-2, 1}, {2, -1}, {1, 2}, {-1, -2}, {-1, 2}, {1, -2}};

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        List<Pair> list = new ArrayList<>();
        freq.forEach((key, value) -> {
            list.add(new Pair(key, value));
        });
        Collections.sort(list, Collections.reverseOrder());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).number;
        }
        return result;
    }

    static void addTwo(int i) {
        i += 2;
    }

    public static void print(Object... obj) {
        System.out.println(obj[0]);
    }

    protected int code = 111;
    static String[] signs = {};


    void print2dDp(int[][] dp) {
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int maxCoins(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    int solve(int[] nums, int start, int end) {
//        Arrays.copy
        int a = start == 1 ? 1 : 5;
        StringBuilder s = new StringBuilder();
//        s.deleteCharAt()
        if (start > end) return Integer.MAX_VALUE;
        if (start == end) return nums[start];
//        if(start + 1 == end){
//            return nums[start] * nums[end] +  Math.max(nums[start], nums[end]);
//        }
        int max = Integer.MIN_VALUE;

        for (int i = start; i < end; i++) {
            max = Math.max(max, solve(nums, start, i) * nums[i] * solve(nums, i + 1, end));
        }
        return max;
    }

    public static int longestCommonSubstring(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s1.charAt(j - 1)) {
                    if (i == 1 || j == 1) {
                        dp[i][j] = 1;
                    } else {
                        if (s1.charAt(i - 2) == s2.charAt(i - 2)) {
                            dp[i][j] = 1 + dp[i - 1][j - 1];
//                        Math.max(
//                                    1 + dp[i-1][j-1],
//                                    Math.max(
//                                            dp[i-1][j],
//                                            dp[i][j-1]
//                                    )
//                            );
                        } else {
                            dp[i][j] = Math.max(
                                    dp[i - 1][j],
                                    dp[i][j - 1]
                            );
                        }
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[s1.length()][s2.length()];
    }

    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1.0);
        }

        for (int moves = 1; moves <= k; moves++) {
            double[][] temp = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (moves == 1) {
                        double inside = 0.0;
                        for (int[] dir : dirs) {
                            int newI = i + dir[0];
                            int newJ = j + dir[1];
                            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                                inside += dp[i][j];
                            }
                        }
                        temp[i][j] = inside / 8.0;
                    } else {
                        double inside = 0.0;
                        for (int[] dir : dirs) {
                            int newI = i + dir[0];
                            int newJ = j + dir[1];
                            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n) {
                                inside += dp[i][j];
                            }
                        }
                        temp[i][j] = inside / 8.0;
                    }
                }
            }
            dp = temp;
        }
        return dp[row][column];
    }
}
