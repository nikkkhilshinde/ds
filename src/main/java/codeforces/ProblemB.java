package codeforces;

import java.io.*;
import java.util.*;


public class ProblemB {
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }

    public static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String str = scanner.next();
        int sum = a * n;
        if (b > 0) {
            sum += b * n;
            System.out.println(sum);
            return;
        }
        List<Integer> freq = new ArrayList<>();
        int streak = 1;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                freq.add(streak);
                streak = 1;
            } else {
                streak++;
            }
        }
        freq.add(streak);
        sum += ((freq.size() / 2) + 1) * b;
        System.out.println(sum);
    }

    static long upperBound(long[] arr, int start, int end, long k) {
        int N = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (k >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < N && arr[start] <= k) {
            start++;
        }
        return start;
    }

    static long lowerBound(long[] arr, int start, int end, long k) {
        int N = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (k <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (start < N && arr[start] < k) {
            start++;
        }
        return start;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int sumOfNNaturalNumbers(int n) {
        return (n * (n + 1)) / 2;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
