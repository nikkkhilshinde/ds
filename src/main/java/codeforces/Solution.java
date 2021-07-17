package codeforces;

import leetcode.LinkedList.ListNode;
import leetcode.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

class Node {
    Node prev;
    int data;
    Node next;
}

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    List<Double> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int index = Collections.binarySearch(list, (double) num);
        if (index < 0) index = -index - 1;
        list.add(index, (double) num);
    }

    public double findMedian() {
        if (list.size() == 2) {
            return (list.get(0) + list.get(1)) / 2.0;
        }
        if (list.size() % 2 == 0) {
            int mid = list.size() / 2;
            return (list.get(mid) + list.get(mid - 1)) / 2.0;
        } else {
            return list.get((list.size()) / 2);
        }
    }
}

class TrieNode {
    char val;
    Map<Character, TrieNode> childs;

    public TrieNode() {
        this.childs = new HashMap<>();
    }

    public TrieNode(char val) {
        this.val = val;
    }
}

class Solution {
    public static void main(String args[]) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < n; i++){
//            map.put(scanner.nextInt(), i);
//        }
//        int[][] paths = new int[n][n];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                paths[i][j] = -1;
//            }
//        }
//        int total = scanner.nextInt();
//        for(int i = 0; i < total ; i++){
//            int from = scanner.nextInt();
//            int to = scanner.nextInt();
//            int time = scanner.nextInt();
//            paths[map.get(from)][map.get(to)] = time;
//            paths[map.get(to)][map.get(from)] = time;
//        }
//        int A = scanner.nextInt();
//        int B = scanner.nextInt();
//        Set<Integer> set = new TreeSet<>();
//        solve(paths, new TreeSet<>(), map.get(A), map.get(B), set, 0);
//        set.forEach(item -> System.out.print(item + " "));
//        System.out.println(set.toArray()[0]);
//        Solution solution = new Solution();
//        solution.countSmaller(new int[]{77,21,85,6,85,81,26,11,12,63});
//        int[] arr = {18, 41, 89, 46, 10, 73, 1, 86, 39, 45, 33, 43, 42, 11, 10, 78, 75, 86, 76, 47, 21, 77, 4, 38, 23, 75, 40, 82, 26, 60, 82, 82, 82, 8, 25, 43, 17, 1, 17, 2, 81, 86, 18, 29, 73, 15, 18, 11, 62, 22, 25, 82, 67, 10, 51, 79, 77, 43, 8, 17, 76, 56, 71, 23, 5, 70, 81, 3, 28, 70, 86, 35, 41, 42, 86, 22, 66, 1, 77, 83, 12, 17, 59, 21, 55, 24, 5, 1, 89, 30, 27, 57, 72, 17, 64, 2, 75, 44, 37, 32};
//        Arrays.sort(arr);
//        for (int i : arr) {
//            System.out.print(i + ", ");

        Solution solution = new Solution();
//        solution.colorBorder(new int[][]{{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}}, 1, 3, 1);
//        solution.findPeakElement(new int[]{1,2,3,1});
//        solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        while (str.length() > 0) {
            list.add(str.substring(0, len ));
            str.delete(0, len);
        }
        List<String> wordsList = new ArrayList<>();
        for (String word : words) wordsList.add(word);
        List<Integer> result = new ArrayList<>();

        int start = 0;
        while (list.size() > 0) {
            boolean foundAll = true;
            for (String word : wordsList) {
                if (list.contains(word) && list.indexOf(word) < words.length) {
                    continue;
                } else {
                    foundAll = false;
                    break;
                }
            }
            if (foundAll) {
                result.add(len * start);
            }
            start++;
            list.remove(0);
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int start = j + 1;
                        int end = nums.length - 1;
                        int sum = target - (nums[i] + nums[j]);
                        while (start < end) {
                            if (nums[start] + nums[end] == sum) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (start < end && nums[end] == nums[end - 1]) end--;
                                start++;
                                end--;
                            } else {
                                if (nums[start] + nums[end] > sum) end--;
                                else start++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public String customSortString(String order, String str) {
        List<Character> orderList = new ArrayList<>();
        for (char ch : order.toCharArray()) orderList.add(ch);
        List<Character> list = new ArrayList<>();
        for (char ch : str.toCharArray()) list.add(ch);
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (orderList.contains(o1) && orderList.contains(o2)) {
                    return orderList.indexOf(o1) - orderList.indexOf(o2);
                } else {
                    if (orderList.contains(o1) && !orderList.contains(o2)) {
                        return -1;
                    }
                    if (!orderList.contains(o1) && orderList.contains(o2)) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public int rob(TreeNode root) {
        return solve(root, false);
    }

    int solve(TreeNode root, boolean prevRobbed) {
        if (root == null) return 0;
        if (!prevRobbed) {
            //rob current
            int left = solve(root.left, true);
            int right = solve(root.right, true);
            int leftWithoutRob = solve(root.left, false);
            int rightWithoutRob = solve(root.right, false);
            int[] arr = {left + right + root.val, leftWithoutRob + rightWithoutRob};
            Arrays.sort(arr);
            return arr[1];
        }
        return solve(root.left, false) + solve(root.right, false);
    }

    public int findPeakElement(int[] nums) {
        this.m = nums.length;
        if (m == 1) return nums[0];
        return findPeak(0, m - 1, nums);
    }

    int m;

    int findPeak(int low, int high, int[] nums) {
        if (low <= high) {
            int mid = (high + low) / 2;
            if (mid < m - 1 && mid > 0) {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            }
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
            }
            if (mid == m - 1) {
                if (nums[mid] > nums[mid - 1]) return mid;
            }
            int left = findPeak(low, mid - 1, nums);
            if (left == -1) {
                return findPeak(mid + 1, high, nums);
            } else return left;
        }
        return -1;
    }

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        int prevColor = grid[r0][c0];
        if (prevColor == color) return grid;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int x = front[0];
            int y = front[1];
            grid[x][y] = -grid[x][y];
            boolean onBorder = false;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length) {
                    if (grid[newX][newY] < 0) continue;
                    if (grid[newX][newY] != color && grid[newX][newY] != prevColor) {
                        onBorder = true;
                    } else {
                        if (grid[newX][newY] > 0)
                            queue.add(new int[]{newX, newY});
                    }
                } else {
                    onBorder = true;
                }
            }
            if (onBorder) grid[x][y] = color;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Math.abs(grid[i][j]);
            }
        }
        return grid;
    }

    int policeCatchesThieves(char[] arr, int k) {
        List<Integer> police = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.add(i);
        }
        return solve(arr, police, 0, k);
    }

    int solve(char[] arr, List<Integer> police, int policeIndex, int k) {
        int max = 0;
        if (policeIndex < police.size()) {
            for (int i = police.get(policeIndex) - k; i <= police.get(policeIndex) + k; i++) {
                if (i >= 0 && i < arr.length && arr[i] != '.' && arr[i] == 'T' && i != police.get(policeIndex)) {
                    arr[i] = '.';
                    max = Math.max(max, 1 + solve(arr, police, policeIndex + 1, k));
                    arr[i] = 'T';
                }
            }
        }
        return max;
    }

//    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            if ((front[0] != entrance[0] && front[1] != entrance[1]) &&
                    (front[0] == 0 || front[0] == maze.length - 1 || front[1] == 0 || front[1] == maze[0].length - 1)) {
                return front[2];
            }

            for (int[] dir : dirs) {
                int x = dir[0] + front[0];
                int y = dir[1] + front[1];
                if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != '+') {
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y, front[2] + 1});
                }
            }
        }
        return -1;
    }

    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }
        return res;
    }

    int count = 0;

    public int numDecodings(String s) {
        count = 0;
//        len == 2; start = 0
        solve(0, s);
        return count;
    }

    void solve(int start, String s) {
        if (start == s.length()) count++;
        String sub = s.substring(start, start + 1);
        int a = Integer.parseInt(sub.equals("") ? "0" : sub);
        if ((start < s.length()) && (a <= 9) && (a > 0)) {
            solve(start + 1, s);
        }
        if (start < s.length() - 1) {
            int i = Integer.parseInt(s.substring(start, start + 2));
            if (s.charAt(start) != '0' && i <= 26 && i >= 1) {
                solve(start + 2, s);
            }
        }
    }

    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int num = 0;
        if (s.length() == 0) return 0;
        while (index < s.length() && s.charAt(index) == ' ') index++;
        if ((s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < num || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            index++;
        }
        return num * sign;
    }

    static double findMod(double a, double b) {
        // Handling negative values
        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;

        // Finding mod by repeated subtraction
        double mod = a;
        while (mod >= b)
            mod = mod - b;

        // Sign of result typically depends
        // on sign of a.
        if (a < 0)
            return -mod;

        return mod;
    }

    public int minDiffInBST(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            priorityQueue.offer(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k; i++) {
            Tuple front = priorityQueue.poll();
            if (front.row < matrix.length - 1) {
                priorityQueue.offer(new Tuple(front.row + 1, front.column, matrix[front.row + 1][front.column]));
            }
        }
        return priorityQueue.poll().val;
    }

    static class Tuple implements Comparable<Tuple> {
        int row;
        int column;
        int val;

        public Tuple(int row, int column, int val) {
            this.row = row;
            this.column = column;
            this.val = val;
        }

        @Override
        public int compareTo(@NotNull Solution.Tuple that) {
            return this.val - that.val;
        }

    }

    int[] dfs(TreeNode root) {
        if (root == null) return new int[]{};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left.length == 0 && right.length == 0) {
            return new int[]{root.val, Integer.MAX_VALUE, root.val};
        } else if (left.length == 0) {
            return new int[]{
                    root.val,
                    Math.min(Math.abs(root.val - right[0]), right[1]),
                    right[2]
            };
        } else if (right.length == 0) {
            return new int[]{
                    left[0],
                    Math.min(Math.abs(root.val - left[2]), left[1]),
                    root.val
            };
        } else {
            return new int[]{
                    left[0],
                    Math.min(Math.min(Math.abs(root.val - left[2]), Math.abs(root.val - right[0])),
                            Math.min(left[1], right[1])),
                    right[2]
            };
        }
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int start = stringBuilder.indexOf(part);
        while (start >= 0) {
            stringBuilder.delete(start, start + part.length());
            start = stringBuilder.indexOf(part);
        }
        return stringBuilder.toString();

    }

    int containsFromIndex(int i, String s, String part) {
        if (s.length() - i < part.length()) return -1;
        int j = 0;
        while (j < part.length() && i < s.length()) {
            if (s.charAt(i) != part.charAt(j)) return -1;
            i++;
            j++;
        }
        if (j == part.length()) return i;
        else return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int n = grid.length;
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            if (front[0] == n - 1 && front[1] == n - 1) return front[2];
            for (int[] d : dir) {
                int x = d[0] + front[0];
                int y = d[1] + front[1];
                if (x < n && x >= 0 && y < n && y >= 0 && grid[x][y] != 1) {
                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y, front[2] + 1});
                }
            }
        }

        return -1;
    }

    int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j > grid[0].length || grid[i][j] == -1 || grid[i][j] == 1)
            return 10001;
        if (i == grid.length - 1 && j == grid.length - 1) return 1;
        int temp = grid[i][j];
        grid[i][j] = -1;
        int top = dfs(i - 1, j, grid);
        int right = dfs(i, j + 1, grid);
        int bottom = dfs(i + 1, j, grid);
        int left = dfs(i, j - 1, grid);
        int topRight = dfs(i - 1, j + 1, grid);
        int bottomRight = dfs(i + 1, j + 1, grid);
        int topLeft = dfs(i - 1, j - 1, grid);
        int bottomLeft = dfs(i + 1, j - 1, grid);
        int[] arr = {top, right, bottom, left, topRight, bottomRight, topLeft, bottomLeft};
        Arrays.sort(arr);
        grid[i][j] = temp;
        return 1 + arr[0];
    }

    public int minSetSize(int[] arr) {
        int[] freq = new int[100005];
        for (int num : arr) freq[num]++;
        Arrays.sort(freq);
        int len = arr.length;
        int res = 0;
        for (int i = freq.length - 1; i >= 0; i--) {

            if (len <= arr.length / 2) return res;
            else res++;
            len -= freq[i];
        }
        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = prepareAdjList(numCourses, prerequisites);
        boolean result = true;
        for (int i = 0; i < numCourses; i++) {
            result &= dfs(new HashSet<>(), adj, i);
        }
        return result;
    }

    boolean dfs(Set<Integer> set, List<Integer>[] adj, int curr) {
        for (Integer integer : adj[curr]) {
            if (!set.contains(integer)) {
                set.add(integer);
                boolean result = dfs(set, adj, integer);
                if (!result) return false;
                set.remove(integer);
            } else {
                return false;
            }
        }
        return true;
    }

    List<Integer>[] prepareAdjList(int numCourses, int[][] pre) {
        ArrayList[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] p : pre) {
            adj[p[1]].add(p[0]);
        }
        return adj;
    }

    static int[] elements(int Q, int[][] query) {
        Map<Integer, Pair> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        for (int i = 0; i < Q; i++) {
            int type = query[i][0];
            int num = query[i][1];
            switch (type) {
                case 1:
                    if (map.containsKey(num)) {
                        Pair temp = map.get(num);
                        temp.freq += 1;
                    } else {
                        Pair temp = new Pair(num, 1);
                        map.put(num, temp);
                        priorityQueue.add(temp);
                    }
                    break;
                case 2:
                    if (!priorityQueue.isEmpty()) {
                        Pair temp = priorityQueue.poll();
                        result.add(temp.num);
                        temp.freq -= 1;
                        if (temp.freq > 0) {
                            priorityQueue.offer(temp);
                            map.put(temp.num, temp);
                        }
                    }
                    break;
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    static class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

    }

//    static final int m = 1000000007;

    public int countGoodNumbers(long n) {
        long rem = n % 2;
        long div = n / 2;
        long ans = ((aux(div)) * (rem > 0 ? 5 : 1));
        System.out.println(ans);
        ans = ans;
        return (int) ans;
    }

    long aux(long div) {
        if (div == 1) return 20;
        if (div % 2 == 0) {
            long result = aux(div / 2);
            return (result * result) % m;
        } else {
            long result = aux((div - 1) / 2);
            return ((result * result) % m * 20) % m;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        set.ceiling(9);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) result.add(arr[i]);
        Collections.sort(result, (o1, o2) -> (Math.abs(o1 - x) - Math.abs(o2 - x)));
        List<Integer> r = result.subList(0, k + 1);
        Collections.sort(r);
        return r;
    }
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> list = new ArrayList<>();
//        int parts = s.length() / words[0].length();
//        // System.out.println(parts);
//        // System.out.println(words[0].length());
//        for(int i = 0; i < parts; i++){
//            int start = words[0].length() * i;
//            int end = start + words[0].length() * words.length;
//            if(end <= s.length()){
//                StringBuilder sub = new StringBuilder(s.substring(start, end)) ;
//                boolean result = true;
//                for(String word: words){
////                    if(!sub.) {
////                        result = false;
////                        break;
////                    }
//                }
//                if(result) list.add(start);
//            }
//
//        }
//        return list;
//    }

//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            int index = Collections.binarySearch(list, nums[i]);
//            if (index < 0) {
//                result.add(0, Math.abs(index) - 1);
//            } else {
//                int curr = list.get(index);
//                int dummyIndex = index;
//                while (dummyIndex >= 0 && list.get(dummyIndex) == curr) dummyIndex--;
//                if (dummyIndex == -1) result.add(0, 0);
//                else result.add(0, dummyIndex + 1);
//            }
//            if (index == 0) list.add(0, nums[i]);
//            else if (index < 0) list.add(Math.abs(index) - 1, nums[i]);
//            else list.add(index, nums[i]);
//        }
//        return result;
//    }

    static void solve(int[][] paths, Set<Integer> visited, int current, int dest,
                      Set<Integer> set, int sum) {

        if (!visited.contains(current)) {
            for (int i = 0; i < paths[current].length; i++) {
                if (paths[current][i] >= 0) {
                    visited.add(current);
                    solve(paths, visited, i, dest, set, sum + paths[current][i]);
                    visited.remove(current);
                }
            }
        }
        if (current == dest) {
            set.add(sum);
            return;
        }
    }

    void temp() {
        Map<Integer, Integer> map = new TreeMap<>();
        Set<Integer> set = new HashSet<>();
        int[] result = new int[set.size()];
        for (Integer integer : set) {

        }
    }

    public String getPermutation(int n, int k) {
        this.k = k;
        result = "";
        getPermutations(n, new ArrayList<Integer>());
        return result;
    }

    int k = 0;
    String result;

    void getPermutations(int n, List<Integer> list) {
        if (list.size() == n) {
            k--;
            if (k == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach(stringBuilder::append);
                result = stringBuilder.toString();
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            getPermutations(n, list);
            list.remove(Integer.valueOf(i));
        }
    }

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) set.add(words[j]);
            }
        }
        return new ArrayList<>(set);
    }


    boolean color(int[][] grid, int i, int j, int color, int prev) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        if (grid[i][j] != prev) return false;
        if (grid[i][j] != color) return true;
        boolean result1 = color(grid, i + 1, j, color, prev);
        boolean result2 = color(grid, i, j + 1, color, prev);
        boolean result3 = color(grid, i - 1, j, color, prev);
        boolean result4 = color(grid, i, j - 1, color, prev);
        if (!(result1 && result2 && result3 && result4)) {
            grid[i][j] = color;
            return true;
        }
        return true;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) {
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int streak = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (max <= right && left <= max) {
                streak++;
            } else {
                count += sum(streak);
                streak = 0;
            }
        }
        count += sum(streak);
        return count;
    }

    int sum(int n) {
        return (n * (n + 1)) / 2;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        if (numRows == 1) return result;
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) return result;
        for (int row = 2; row <= numRows; row++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            int first = 0;
            int second = 1;
            while (second < result.get(row - 1).size()) {
                newList.add(result.get(row - 1).get(first) + result.get(row - 1).get(second));
                first++;
                second++;
            }
            newList.add(1);
            result.add(newList);
        }
        return result;
    }

    public int numberOfRounds(String startTime, String finishTime) {
        int start = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(startTime.split(":")[1]);
        int end = Integer.parseInt(finishTime.split(":")[0]) * 60 + Integer.parseInt(finishTime.split(":")[1]);

        int roundStart = getEdge(start, true);

        int roundEnd = getEdge(end, false);

        if (start < end) {
            return Math.max(0, (roundEnd - roundStart) / 15);
        }
        return (24 * 60 - roundStart + roundEnd) / 15;
    }

    int getEdge(int time, boolean isStart) {
        while (time % 15 != 0) {
            if (isStart) time++;
            else time--;
        }
        return time;
    }

    public int swimInWater(int[][] grid) {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        glob = new TreeSet<>();
        solve1(0, 0, grid, set);
//        glob.forEach(item -> System.out.print(item + " "));
        return (int) glob.toArray()[0];
    }

    static Set<Integer> glob;

    void solve1(int i, int j, int[][] grid, Set<Integer> set) {
        if ((i == grid.length - 1 && j == grid[0].length - 1)) {
            set.add(grid[i][j]);
            glob.add((Integer) set.toArray()[0]);
            set.remove(grid[i][j]);
            return;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return;
        set.add(grid[i][j]);
        int val = grid[i][j];
        grid[i][j] = -1;
        solve1(i + 1, j, grid, set);
        solve1(i, j + 1, grid, set);
        solve1(i - 1, j, grid, set);
        solve1(i, j - 1, grid, set);
        grid[i][j] = val;
        set.remove(val);
    }


    boolean ignore = false;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && check(i, j, grid1, grid2)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean check(int i, int j, int[][] grid1, int[][] grid2) {
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0) return true;
        boolean flag = true;
        if (grid2[i][j] == 1 && grid1[i][j] == 0) flag = false;
        grid2[i][j] = 0;
        boolean r1 = check(i + 1, j, grid1, grid2);
        boolean r2 = check(i, j + 1, grid1, grid2);
        boolean r3 = check(i - 1, j, grid1, grid2);
        boolean r4 = check(i, j - 1, grid1, grid2);
        return flag && r1 && r2 && r3 && r4;
    }


    public static String largestOddNumber(String num) {
        List<Character> odds = List.of('1', '3', '5', '7', '9');
        int last = -1;
        for (int i = 0; i < num.length(); i++) {
            if (odds.contains(num.charAt(i))) last = i;
        }
        if (last == -1)
            return "";
        else return num.substring(last + 1);
    }

    static int[] segmentTree = new int[1_20_005];


    boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(String.valueOf('('));
            } else {
                if (stack.peek().equals(String.valueOf('('))) {
                    stack.pop();
                    stack.push(String.valueOf(1));
                } else {
                    int sum = 0;
                    while (isNumber(stack.peek())) {
                        sum += Integer.parseInt(stack.pop());
                    }

                    stack.pop();
                    stack.push(String.valueOf(sum * 2));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    static int getSumInTheRange(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int segmentIndex) {
        if (queryStart <= segmentStart && segmentEnd <= queryEnd) {
            return segmentTree[segmentIndex];
        }
        if (queryStart > segmentEnd || segmentStart > queryEnd) {
            return 0;
        }
        int mid = (segmentStart + segmentEnd) / 2;
        return getSumInTheRange(segmentStart, mid, queryStart, queryEnd, (2 * segmentIndex) + 1) +
                getSumInTheRange(mid + 1, segmentEnd, queryStart, queryEnd, (2 * segmentIndex) + 2);
    }

    static void buildSegmentTree(int index, int low, int high, int[] nums) {
        if (low == high) {
            segmentTree[index] = nums[low];
            return;
        }
        int mid = (low + high) / 2;
        buildSegmentTree((index * 2) + 1, low, mid, nums);
        buildSegmentTree((index * 2) + 2, mid + 1, high, nums);
        segmentTree[index] = segmentTree[(index * 2) + 1] + segmentTree[(index * 2) + 2];
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return -1;
                if (o1[1] < o2[1]) return 1;
                if (o1[0] < o2[0]) return -1;
                if (o1[0] > o2[0]) return 1;
                return 0;
            }
        });
        for (int[] box : boxTypes) {
            System.out.println(box[0] + ":" + box[1]);
        }
        return 1;
    }


    public static List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (checkPal(words[i], words[j])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    static boolean checkPal(String s, String p) {

        if (p.length() == s.length()) {
            int low = 0;
            int high = p.length() - 1;
            while (low < p.length()) {
                if (s.charAt(low) != p.charAt(high)) return false;
                low++;
                high--;
            }
            return true;
        }
        if (s.length() > p.length()) {
            int low = 0;
            int high = p.length() - 1;
            boolean inSecondString = true;
            while (inSecondString || low < high) {
                if (inSecondString && s.charAt(low) != p.charAt(high)) return false;
                if (!inSecondString && s.charAt(low) != s.charAt(high)) return false;
                low++;
                high--;
                if (high == -1) {
                    high = s.length() - 1;
                    inSecondString = false;
                }
            }
            return true;
        } else {
            int low = 0;
            int high = p.length() - 1;
            boolean inFirstString = true;
            while (inFirstString || low < high) {
                if (inFirstString && s.charAt(low) != p.charAt(high)) return false;
                if (!inFirstString && p.charAt(low) != p.charAt(high)) return false;
                low++;
                high--;
                if (low == s.length()) {
                    inFirstString = false;
                    low = 0;
                }
            }
//            int low = 0;
//            int high = s.length() - 1;
//            boolean inSecondString = true;
//            while (inSecondString || low < high){
//                if(inSecondString && p.charAt(low) != s.charAt(high)) return false;
//                if(!inSecondString && p.charAt(low) != p.charAt(high)) return false;
//                low++;
//                high--;
//                if(high == -1){
//                    high = p.length() - 1;
//                    inSecondString = false;
//                }
//            }
            return true;
        }
    }

    public static int largestMagicSquare(int[][] grid) {
        int maxSize = 1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] ver = new int[m][n];
        for (int i = 0; i < n; i++) {
            ver[0][i] = grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ver[i][j] = grid[i][j] + ver[i - 1][j];
            }
        }
        int[][] hor = new int[m][n];
        for (int i = 0; i < m; i++) {
            hor[i][0] = grid[i][0];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                hor[i][j] = grid[i][j] + hor[i][j - 1];
            }
        }
        for (int size = 2; size <= Math.min(m, n); size++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + (size - 1) >= m || j + (size - 1) >= n) continue;
                    int row = i;
                    int column = j;
                    int k = size;
                    int xdiag = 0;
                    int ydiag = 0;
                    while (k > 0) {
                        xdiag += grid[row][column];
                        row++;
                        column++;
                        k--;
                    }
                    row = i + (size - 1);
                    k = size;
                    column = j;
                    while (k > 0) {
                        ydiag += grid[row][column];
                        row--;
                        column++;
                        k--;
                    }
                    if (ydiag != xdiag) continue;
                    row = i + (size - 1);
                    column = j + (size - 1);
                    boolean flag = true;
                    while (row >= i) {
                        int sum = hor[row][column] - (j - 1 >= 0 ? hor[row][j - 1] : 0);
                        if (sum != xdiag) {
                            flag = false;
                            break;
                        }
                        row--;
                    }
                    if (!flag) continue;
                    row = i + (size - 1);
                    while (column >= j) {
                        int sum = ver[row][column] - (i - 1 >= 0 ? ver[i - 1][column] : 0);
                        if (sum != xdiag) {
                            flag = false;
                            break;
                        }
                        column--;
                    }
                    if (!flag) continue;
                    maxSize = size;
                }
            }
        }
        return maxSize;
    }

    void solve(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd, TreeNode root) {
        int rootVal = preorder[pStart];

    }

    boolean dfs(Map<Integer, List<Integer>> map, int start, Set<Integer> set) {
        if (set.contains(start)) return false;
        set.add(start);
        for (Integer integer : map.keySet()) {
            for (Integer integer1 : map.get(integer)) {
                if (!dfs(map, integer1, set)) {
                    return false;
                }
            }
        }
        set.remove(start);
        return true;
    }

    public static int islandPerimeter(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, solve(i, j, grid));
            }
        }
        return max;
    }

    static int solve(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) return 0;
        grid[i][j] = -1;
        int result = solve(i + 1, j, grid) + solve(i, j + 1, grid) + solve(i - 1, j, grid) + solve(i, j - 1, grid);
        grid[i][j] = 1;
        return result;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int min = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                dp[i] = false;
                continue;
            }
            boolean res = false;
            for (int j = i - maxJump >= 0 ? i - maxJump : 0; j <= i - minJump; j++) {
                res |= dp[j];
                if (res) break;
            }
            dp[i] = res;
        }
        return dp[s.length() - 1];
    }

    public static int maxResult(int[] nums, int k) {
        // System.out.println(":");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[deque.peekFirst()] + nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();

            deque.offerLast(i);

            if (i - deque.peekFirst() >= k) deque.peekFirst();
        }
        return nums[nums.length - 1];
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode[][] dp = new TrieNode[10][10];
        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        Set<String> wordsSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            wordsSet.add(words[i]);
        }
        int m = board.length;
        int n = board[0].length;
        Set<String> result = new HashSet<>();
        for (int l = 0; l < words.length; l++) {
            boolean found = false;
            for (int i = 0; i < m; i++) {
                if (!found) {
                    for (int j = 0; j < n; j++) {
                        if (helper(board, i, j, 0, words[l])) {
                            result.add(words[l]);
                            found = true;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }

        }

        return new ArrayList<>(result);
    }

    public boolean helper(char[][] board, int i, int j, int index, String expected) {
        if (index == expected.length()) return true;
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        char temp = board[i][j];
        if (temp == '0') return false;
        if (temp != expected.charAt(index)) return false;

        board[i][j] = '0';

        if (helper(board, i + 1, j, index + 1, expected)) return true;
        if (helper(board, i - 1, j, index + 1, expected)) return true;
        if (helper(board, i, j + 1, index + 1, expected)) return true;
        if (helper(board, i, j - 1, index + 1, expected)) return true;

        board[i][j] = temp;
        return false;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Map<String, String> map = new HashMap<>();
        String str = "";
        Set<String> strings = new HashSet<>();

        int m = 10, n = 10;
        Set<Integer>[][] dp = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[m][n] = new HashSet<>();
            }
        }

        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode list1Current = lists[0];

        int start = 0;
        while (list1Current == null && start < lists.length) {
            list1Current = lists[start];
            start++;
        }
        ListNode list1HeadCopy = list1Current;
        ListNode list1Prev = null;
        for (int i = start == 0 ? 1 : start; i < lists.length; i++) {

            ListNode list2Current = lists[i];

            if (list2Current == null) continue;

            ListNode list2Next = list2Current.next;

            while (list2Current != null) {
                if (list1Prev == null) {
                    if (list2Current.val <= list1Current.val) {
                        list2Current.next = list1Current;
                        list1Prev = list2Current;
                        list1HeadCopy = list1Prev;
                        list2Current = list2Next;
                        if (list2Current != null) {
                            list2Next = list2Next.next;
                        }
                    } else {
                        list1Prev = list1Current;
                        list1Current = list1Current.next;
                    }
                } else if (list1Current != null) {
                    if (list1Prev.val <= list2Current.val && list2Current.val <= list1Current.val) {
                        list1Prev.next = list2Current;
                        list2Current.next = list1Current;
                        list1Prev = list1Prev.next;
                        list2Current = list2Next;
                        if (list2Current != null) {
                            list2Next = list2Next.next;
                        }
                    } else {
                        list1Prev = list1Prev.next;
                        list1Current = list1Current.next;
                    }

                } else {
                    if (list1Prev.val <= list2Current.val) {
                        list1Prev.next = list2Current;
                        list1Prev = list1Prev.next;
                        list2Current.next = null;
                        list2Current = list2Next;
                        if (list2Current != null) {
                            list2Next = list2Next.next;
                        }
                    }
                }
            }
            list1Current = list1HeadCopy;
            list1Prev = null;
        }
        return list1Current;
    }
}