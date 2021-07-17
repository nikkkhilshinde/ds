package codechef.dp;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        System.out.println(getSteps(12, 0, 1));

        System.out.println(getMinStepsTopDown(10000, 0, new HashMap<Integer, Integer>()));
//        System.out.println(count);
        System.out.println(getMinStepsBottomUp(1000000));
    }

    public static int getMinStepsBottomUp(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 0);
        dp.put(2, 1);
        dp.put(3, 1);

        for (int i = 4; i <= n; i++) {
            int n1 = dp.get(i - 1);
            int n2 = Integer.MAX_VALUE;
            int n3 = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                n2 = dp.get(i / 2);
            }
            if (i % 3 == 0) {
                n3 = dp.get(i / 3);
            }
            final int i1 = 1 + Math.min(n1, Math.min(n2, n3));
//            System.out.println(String.format("n:%d, step: %d", i, i1));
            dp.put(i, i1);
        }
        return dp.get(n);
    }

    public static int getMinStepsTopDown(int n, int steps, Map<Integer, Integer> dp) {

        if (n == 1 || n == 2 || n == 3) return steps + 1;

        int n3 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        int n1;
        if (n % 3 == 0) {
            if (dp.containsKey(n / 3)) n3 = dp.get(n / 3);
            else n3 =getMinStepsTopDown(n / 3, steps, dp);
        }
        if (n % 2 == 0) {
            if (dp.containsKey(n / 2)) n2 = dp.get(n / 2);
            else n2 = getMinStepsTopDown(n / 2, steps, dp);

        }
        if (dp.containsKey(n - 1)) n1 = dp.get(n - 1);
        else n1 = getMinStepsTopDown(n - 1, steps, dp);

        int temp = 1 + Math.min(n3, Math.min(n2, n1));
        dp.put(n, temp);
//        System.out.println(String.format("n:%d, step: %d", n, temp));

        return dp.get(n);
    }
}
