import java.util.ArrayList;
import java.util.HashMap;

public class Misc {
    public static void main(String[] args) {
        int[] costs = {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};

        System.out.println(candies(10, costs));
//        System.out.println(fibonacci(10));
    }

    static long candies(int n, int[] arr) {
        long totalCandies = 0;
        int[] f = new int[n];
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                totalCandies += f[i - 1] + 1;
                f[i] = f[i - 1] + 1;
            } else if (arr[i] <= arr[i - 1]) {
                totalCandies += 1;
                f[i] = 1;
            }

        }
        return 1;
    }

    static int fibonacci(int n) {
        ArrayList<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(1);
        for (int i = 2; i < n; i++) {
            f.add(i, f.get(i - 1) + f.get(i - 2));
        }
        return f.get(n - 1);
    }


    static void whatFlavors(int[] cost, int money) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(cost[0], 0);
        int a = 0;
        int b = 0;
        for (int i = 1; i < cost.length; i++) {
            if (hashMap.containsKey(money - cost[i])) {
                a = hashMap.get(money - cost[i]);
                b = i;
                break;
            } else {
                hashMap.put(cost[i], i);
            }
        }
        a++;
        b++;
        System.out.println(String.format("%d %d", a, b));
    }
}
