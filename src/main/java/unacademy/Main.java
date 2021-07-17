package unacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        System.out.println(fibBottomUp(7));
//        System.out.println(fibTopBottom(7, new HashMap<>()));
//        int a[] = {2,7,9,3,1};
//        Map<Integer, Integer> dp = new HashMap<>();
//        System.out.println(maxRob(a, 4, dp));
//        dp.forEach((k,v )-> System.out.println("k:" + k + " ,v:" + v));
        int[] cost = {6, 10, 12};
//        int[] weights = {1, 1, 3};
        HashMap<Integer, Integer> costs = new HashMap<Integer, Integer>() {{
            put(1, 6);
            put(2, 10);
            put(3, 12);
        }};
        HashMap<Integer, Integer> weights = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};
//        System.out.println(knapsack(weights, costs, 5));
        int[] houses = {1,2,3,4};
        System.out.println(roundA(houses, 7));
    }

    static int roundA(int[] costs, int budget) {

        Map<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < costs.length; i++) {
            costMap.put(i + 1, costs[i]);
        }
        int[][] dp = new int[costs.length + 1][budget + 1];

        for (int i = 1; i <= costs.length; i++) {
            for (int j = 1; j <= budget; j++) {
                if (costMap.get(i) <= j) {
                    int ifBought = 1 + dp[i - 1][j - costMap.get(i)];
                    int ifNotBought = dp[i - 1][j];
                    dp[i][j] = Math.max(ifBought, ifNotBought);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[costs.length][budget];
    }

    static int knapsack(HashMap<Integer, Integer> weights, HashMap<Integer, Integer> costs, int size) {
        int[][] dp = new int[weights.size() + 1][size + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i <= weights.size(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= weights.size(); i++) {
            for (int j = 1; j <= size; j++) {
                if (weights.get(i) <= j) {
                    int ifIncluded = dp[i - 1][j - weights.get(i)] + costs.get(i);
                    int ifNotInclude = dp[i - 1][j];
                    dp[i][j] = Math.max(ifIncluded, ifNotInclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= weights.size(); i++) {
            for (int j = 0; j <= size; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[weights.size()][size];
    }

    static int knapsack(int[] weights, int[] costs, int size, int i) {

        if (i == 0 && weights[i] <= size) return costs[i];
        if (i == 0) return 0;
        if (weights[i] <= size) {
            int ifIncluded = costs[i] + knapsack(weights, costs, size - weights[i], i - 1);
            int ifNotIncluded = knapsack(weights, costs, size, i - 1);

            return Math.max(ifIncluded, ifNotIncluded);
        }
        return knapsack(weights, costs, size, i - 1);

    }

    static int maxRob(int[] golds, int currentHouse, Map<Integer, Integer> dp) {
        if (currentHouse == 0) {
            dp.put(currentHouse, golds[0]);
            return dp.get(currentHouse);
        }
        ;
        if (currentHouse == 1) {
            dp.put(currentHouse, Math.max(golds[0], golds[1]));
            return dp.get(currentHouse);
        }
        ;

        int robCurrent = maxRob(golds, currentHouse - 2, dp) + golds[currentHouse];
        int noRobCurrent = maxRob(golds, currentHouse - 1, dp);
        dp.put(currentHouse, Math.max(robCurrent, noRobCurrent));
        return dp.get(currentHouse);
    }

    static int fibTopBottom(int n, Map<Integer, Integer> storage) {
        if (n == 0 || n == 1) return n;
        if (storage.containsKey(n)) return storage.get(n);
        else {
            int a = fibTopBottom(n - 1, storage) + fibTopBottom(n - 2, storage);
            storage.put(n, a);
            return a;
        }
    }

    static int fibBottomUp(int n) {
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
