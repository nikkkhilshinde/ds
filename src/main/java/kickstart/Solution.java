package kickstart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < t; j++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            long budget = Long.parseLong(input[1]);
            input = scanner.nextLine().split(" ");
            long[] costs = new long[n];
            for (int i = 0; i < n; i++) {
                costs[i] = Long.parseLong(input[i]);
            }
            System.out.println(String.format("Case #%d: %d", j + 1, roundA(costs, budget)));
        }

    }

    static int roundA(long[] costs, long budget) {

        Map<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < costs.length; i++) {
            costMap.put(i + 1, (int) costs[i]);
        }
        int[] prev = new int[(int) (budget + 1)];
        int[] current = new int[(int) (budget + 1)];

        for (int i = 1; i <= costs.length; i++) {
            for (int j = 1; j <= budget; j++) {
                if (costMap.get(i) <= j) {
                    int ifBought = 1 + prev[j - costMap.get(i)];
                    int ifNotBought = prev[j];
                    current[j] = Math.max(ifBought, ifNotBought);
                } else {
                    current[j] = prev[j];
                }
            }
            prev = Arrays.copyOf(current, current.length);
        }
        return prev[(int) budget];
    }
}
