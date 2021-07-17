package AtCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean[] dp = new boolean[k+1];
        for (int i = 1; i <= k ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] <= i){
                    if(!dp[i-arr[j]]) dp[i] = true;
                }
            }
        }
        if(!dp[k]){
            System.out.println("Second");
        }else{
            System.out.println("First");
        }
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        double[] prob = new double[n+1];
//        for (int i = 1; i <= n; i++) {
//            prob[i] = scanner.nextDouble();
//        }
//        double[][] dp = new double[3000][3000];
//        for (int i = 0; i < 3000; i++) {
//            for (int j = 0; j < 3000; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        System.out.println(coins(prob, n, (n+1)/2, dp));
//    }
//
//    public static double coins(double[] prob, int i, int x, double[][] dp) {
//        if (x == 0) return 1;
//        if (i == 0) return 0;
//        if (dp[i][x] > -0.9) return dp[i][x];
//        dp[i][x] = prob[i] * coins(prob, i - 1, x - 1, dp) + (1.0 - prob[i]) * coins(prob, i - 1, x, dp);
//        return dp[i][x];
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int h = scanner.nextInt();
//        int w = scanner.nextInt();
//        String[] grid = new String[h];
//        for (int i = 0; i < h; i++) {
//            grid[i] = scanner.next();
//        }
//        int[][] dp = new int[h][w];
//        boolean isBlocked = false;
//        for (int i = 1; i < w; i++) {
//            if(grid[0].charAt(i) == '#'){
//                isBlocked = true;
//            }
//            if(isBlocked) dp[0][i] = 0;
//            else dp[0][i] = 1;
//        }
//        isBlocked = false;
//        for (int i = 1; i < h; i++) {
//            if(grid[i].charAt(0) == '#'){
//                isBlocked = true;
//            }
//            if(isBlocked) dp[i][0] = 0;
//            else dp[i][0] = 1;
//        }
//        for (int i = 1; i < h; i++) {
//            for (int j = 1; j < w; j++) {
//                if(grid[i].charAt(j) == '#'){
//                    dp[i][j] = 0;
//                }else{
//                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
//                }
//            }
//        }
//        System.out.println(dp[h-1][w-1] % 1000000007);
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        boolean[][] adj = new boolean[n+1][n+1];
//        for (int i = 0; i < m; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            adj[x][y] = true;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            max = Math.max(longestPath(adj, i, n, map), max);
//        }
//        if(max == Integer.MIN_VALUE) System.out.println(0);
//        else System.out.println(max);
//    }
//    static int longestPath(boolean[][] adj, int current, int n, Map<Integer, Integer> dp){
////        if(current > n) return 0;
//        if(dp.containsKey(current)) return dp.get(current);
//        int max = Integer.MIN_VALUE;
//        for(int i = 1; i <= n; i++){
//            if(adj[current][i]){
//                max = Math.max(longestPath(adj, i, n, dp), max);
//            }
//        }
//        if(max == Integer.MIN_VALUE) {
//            dp.put(current, 0);
//        }else{
//            dp.put(current,1 + max);
//        }
//        return dp.get(current);
//    }
//    https://atcoder.jp/contests/dp/tasks/dp_f
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String t = scanner.nextLine();
//        int[][] dp = new int[s.length() +1][t.length() + 1];
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 1; j <= t.length(); j++) {
//
//                if(s.charAt(i-1) == t.charAt(j-1)){
//                    dp[i][j] = 1 + dp[i-1][j-1];
//                }else{
//                    dp[i][j] = Math.max(
//                            dp[i-1][j],
//                            dp[i][j-1]
//                    );
//                }
//            }
//        }
////        System.out.println(dp[s.length()][t.length()]);
//        int i = s.length();
//        int j = t.length();
//        StringBuilder stringBuilder = new StringBuilder();
//        while(i > 0 && j > 0){
//            if(s.charAt(i-1) == t.charAt(j-1)){
//                stringBuilder.append(s.charAt(i-1));
//                i--;
//                j--;
//            }else{
//                if(dp[i-1][j] > dp[i][j-1]){
////                    stringBuilder.append(s.charAt(i-1));
//                    i--;
//                }else{
////                    stringBuilder.append(t.charAt(j-1));
//                    j--;
//                }
//            }
//        }
//
//        System.out.println(stringBuilder.reverse().toString());
//    }

//    https://atcoder.jp/contests/dp/tasks/dp_e
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long w = scanner.nextLong();
//        long[] weights = new long[n];
//        long[] values = new long[n];
//        for (int i = 0; i < n; i++) {
//            weights[i] = scanner.nextLong();
//            values[i] = scanner.nextLong();
//        }
//        long[][] dp = new long[n*1000+1][n+1];
//        for (int i = 0; i < n * 1000 + 1; i++) {
//            for (int j = 0; j < n+1; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        dp[0][0] = 0;
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 1; i <= n; i++) {
//            for(int j = 1; j < n*1000+1; j++){
//                if(values[i-1] > j){
//                    dp[j][i] = dp[j][i-1];
//                }else{
//                    dp[j][i] = Math.min(
//                            dp[j][i-1],
//                            weights[i-1] + dp[(int) (j-values[i-1])][i-1]
//                    );
//                }
//            }
//        }
//        long max = 0;
//        for (int i = 0; i < n * 1000 + 1; i++) {
//            if(dp[i][n] <= w) max = i;
//        }
//
//        System.out.println(max);
//    }

//    https://atcoder.jp/contests/dp/tasks/dp_c
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        int[] c = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//            b[i] = scanner.nextInt();
//            c[i] = scanner.nextInt();
//        }
//        int[][] dp = new int[n][3];
//        dp[0][0] = a[0];
//        dp[0][1] = b[0];
//        dp[0][2] = c[0];
//        int sum = 0;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = a[i] + Math.max(dp[i-1][1],dp[i-1][2]);
//            dp[i][1] = b[i] + Math.max(dp[i-1][0], dp[i-1][2]);
//            dp[i][2] = c[i] + Math.max(dp[i-1][0], dp[i-1][1]);
//        }
//        System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1],dp[n-1][2])));
//    }

//    https://atcoder.jp/contests/dp/tasks/dp_b
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] heights = new int[n];
//        for (int i = 0; i < n; i++) {
//            heights[i] = scanner.nextInt();
//        }
//        int[] dp = new int[n];
//        dp[0] = 0;
//        dp[1] = Math.abs(heights[1]-heights[0]);
//        for (int i = 2; i < heights.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for(int j = 1; j <= k && i-j >= 0; j++){
//                min = Math.min(dp[i-j] + Math.abs(heights[i]-heights[i-j]), min);
//            }
//            dp[i] = min;
//        }
//        System.out.println(dp[n-1]);
//    }
}
