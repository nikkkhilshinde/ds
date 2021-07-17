package codechef;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.regex.Matcher;

public class Solution {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[][] maze = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                maze[i][j] = scanner.nextInt();
//            }
//        }
//        findWays(maze, 0, 0, new TreeSet<>(), n);
//        System.out.println(count);
//        solveNQueens(5);
//        combinationSumHelper(new int[]{10,1,2,7,6,1,5}, 8, new ArrayList<>(), 0);
        lists.forEach(list ->{
            list.forEach(item -> System.out.print(item + ","));
            System.out.println();
        });
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists.clear();
        set.clear();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if(frequencyMap.containsKey(candidates[i])){
                frequencyMap.put(candidates[i], frequencyMap.get(candidates[i] + 1));
            }else{
                frequencyMap.put(candidates[i], 1);
            }
        }
        combinationSumHelper(candidates, target, new ArrayList<>(), new HashMap<>(), frequencyMap);
        return lists;
    }

    public static List<List<Integer>> lists = new ArrayList<>();
    public static Set<String> set = new TreeSet<>();
    public static void combinationSumHelper(int[] candidates, int target, List<Integer> combination,
                                            Map<Integer, Integer> map, Map<Integer, Integer> frequencyMap) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> result = new ArrayList<>(combination);
            Collections.sort(result);
            StringBuilder stringBuilder = new StringBuilder();
            result.forEach(stringBuilder::append);
            if(!set.contains(stringBuilder.toString())){
                lists.add(result);
                set.add(stringBuilder.toString());
            }
            return;
        }

        for (int i = 0; i < candidates.length; i++) {

                int index = combination.size();
                combination.add(candidates[i]);
//                combinationSumHelper(candidates, target - candidates[i], combination, map);
                combination.remove(index);

        }
    }

    public static int solveNQueens(int n) {
        List<List<String>> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(".");
            }
            grid.add(list);
        }
        List<List<String>> output = new ArrayList<>();
        NQueenHelper(grid, 0, n, output);
//        System.out.println(queenCount);
        return queenCount;
    }

    static int queenCount = 0;

    public static void NQueenHelper(List<List<String>> grid, int row, int n, List<List<String>> output) {
        if (row == n) {
            queenCount++;
            List<String> result = new ArrayList<>();
            grid.forEach(eachRow -> {
                StringBuilder stringBuilder = new StringBuilder();
                eachRow.forEach(stringBuilder::append);
                result.add(stringBuilder.toString());
            });
            output.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafeToPlaceQueen(grid, row, i, n)) {
                grid.get(row).set(i, "Q");
                NQueenHelper(grid, row + 1, n, output);
                grid.get(row).set(i, ".");
            }
        }
    }

    private static boolean isSafeToPlaceQueen(List<List<String>> grid, int row, int column, int n) {

        for (int i = row; i >= 0; i--) {
            if (grid.get(i).get(column).equals("Q")) return false;
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (grid.get(i).get(j).equals("Q")) return false;
        }

        for (int i = row, j = column; i >= 0 && j < n; i--, j++) {
            if (grid.get(i).get(j).equals("Q")) return false;
        }

        return true;
    }

    public static void findSubsets(List<Integer> arr, List<Integer> result, int start) {
        System.out.print("[");
        result.forEach(System.out::print);
        System.out.print("]");
        System.out.println();
        if (start >= arr.size()) return;
        result.add(arr.get(start));
        findSubsets(arr, result, start + 1);
        result.remove(arr.get(start));
        findSubsets(arr, result, start + 1);
    }

    public static int count = 0;

    //https://www.codechef.com/problems/BPHC03
    public static void findWays(int[][] maze, int x, int y, Set<String> visited, int n) {
        if (x == n - 1 && y == n - 1) {
            count++;
            return;
        }

        //marked visited current
        visited.add(String.format("%d:%d", x, y));
        //Go up
        if (x - 1 >= 0 && maze[x - 1][y] != 1 && !visited.contains(String.format("%d:%d", x - 1, y))) {
            findWays(maze, x - 1, y, visited, n);
        }
        //go left
        if (y - 1 >= 0 && maze[x][y - 1] != 1 && !visited.contains(String.format("%d:%d", x, y - 1))) {
            findWays(maze, x, y - 1, visited, n);
        }

        //go down
        if (x + 1 >= 0 && x + 1 < n && maze[x + 1][y] != 1 && !visited.contains(String.format("%d:%d", x + 1, y))) {
            findWays(maze, x + 1, y, visited, n);
        }

        //go right
        if (y + 1 >= 0 && y + 1 < n && maze[x][y + 1] != 1 && !visited.contains(String.format("%d:%d", x, y + 1))) {
            findWays(maze, x, y + 1, visited, n);
        }

        visited.remove(String.format("%d:%d", x, y));
    }
}
