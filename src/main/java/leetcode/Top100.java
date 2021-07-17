package leetcode;

//import java.util.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

class NumMatrix {


    public void allPathsHelper(int current, int[][] graph, List<Integer> list, List<List<Integer>> lists) {
        if (current == graph.length) {
            lists.add(new ArrayList<>(list));
        }
    }

    int[][] matrix;

    public int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int mCount = 0;
            int nCount = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') mCount++;
                else nCount++;
            }
            if (mCount <= m && nCount <= n) count++;
        }
        if (count == strs.length) return count - 1;
        return count;
    }

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.map = new HashMap<>();
    }

    Map<String, Integer> map;

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (map.containsKey(row1 + ":" + col1 + ":" + row2 + ":" + col2))
            return map.get(row1 + ":" + col1 + ":" + row2 + ":" + col2);
        int sum = 0;
        for (int i = col1; i <= col2; i++) {
            for (int j = row1; j <= row2; j++) {
                sum += matrix[j][i];
            }
        }
        map.put(row1 + ":" + col1 + ":" + row2 + ":" + col2, sum);
        return sum;
    }
}

public class Top100 {

    //    public static HashMap<Integer, String> numberLetter = new HashMap(){{
//        put(2, "abc");
//        put(3, "def");
//        put(4, "ghi");
//        put(5, "jkl");
//        put(6, "mno");
//        put(7, "pqrs");
//        put(8, "tuv");
//        put(9, "wxyz");
//    }};
    static String[] numberLetter = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits.length() == 0) return list;
        letterCombinationsHelper(0, digits, list, new StringBuilder());
        return list;
    }

    public void letterCombinationsHelper(int current, String digits, List<String> list, StringBuilder result) {
        if (current == digits.length()) {
            list.add(result.toString());
            return;
        }
        String currentChars = numberLetter[(Integer.parseInt(String.valueOf(digits.charAt(current))))];
        for (int i = 0; i < currentChars.length(); i++) {
            int lastIndex = result.length();
            result.append(currentChars.charAt(i));
            letterCombinationsHelper(current + 1, digits, list, result);
            result.deleteCharAt(lastIndex);
        }
    }

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>() {{
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int count1 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i))) count1++;
        }
        int count2 = 0;
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) count2++;
        }
        return count1 == count2;
    }

    public static void main(String[] args) {


    }

    public static void temp(int[] a) {
        a[0] = 0;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder str = new StringBuilder();
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        return wordBreakHelper("", s, set);
    }

    public static boolean wordBreakHelper(String part1, String part2, Set<String> set) {
        if (part1 == part2 && part1.equals("")) return true;
        if (part2.length() == 0) return set.contains(part1);
        if (set.contains(part1)) {
            return wordBreakHelper("", part2, set);
        }
//        if(set.contains(part2)){
//            return wordBreakHelper("",part1, set);
//        }

        return wordBreakHelper(part1.concat(String.valueOf(part2.charAt(0))), part2.substring(1), set);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, list, new HashSet<>());
        return list;
    }

    public static void helper(int[] nums, int index, List<List<Integer>> result, Set<Integer> set) {
        if (set.size() >= nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }
        set.add(index);

        for (int i = 0; i < nums.length; i++) {
            helper(nums, i, result, set);
        }
        set.remove(index);

    }

    public static boolean canReach(int[] arr, int start) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) set.add(i);
        }
        found = false;
        helper(arr, start, set);
        return found;
    }

    static boolean found = false;

    public static void helper(int[] arr, int start, Set<Integer> set) {
        if (start < 0 || start >= arr.length) return;
        if (arr[start] < 0) return;
        if (set.contains(arr[start])) {
            found = true;
            return;
        }
        arr[start] = -arr[start];
        helper(arr, start + arr[start], set);
        helper(arr, start - arr[start], set);
    }

    public static boolean jumpHelper(int[] nums, int current, Map<Integer, Boolean> dp) {
        if (current >= nums.length - 1) return true;
        if (nums[current] == 0) return false;
        if (dp.containsKey(current)) return dp.get(current);
        boolean canReach = false;
        for (int i = 1; i <= nums[current]; i++) {
            canReach = canReach || jumpHelper(nums, current + i, dp);
        }
        dp.put(current, canReach);
        return canReach;
    }


    public static boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }

    public static String decodeString(String s) throws IOException {
        Stack<Character> stack = new Stack<>();
        StringBuilder number = new StringBuilder();
        StringBuilder string = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isNumber(ch) && first) number.append(ch);
            else {
                first = false;
                if (ch == '[') {
                    if (!stack.isEmpty()) string.append(ch);
                    stack.push(ch);
                } else if (ch == ']') {
                    stack.pop();
                    if (!stack.isEmpty()) string.append(ch);
                } else {
                    string.append(ch);
                }
            }
        }
        System.out.println("Number " + number);
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(System.out);
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(number.toString()); i++) {
            decodedString.append(string);
        }
        System.out.println(decodedString);
        return "";
    }

    public static int[] countBits(int num) {
        int[] bitsCount = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bitsCount[i] = convertDecimalToBinary(i, bitsCount);
        }
        return bitsCount;
    }

    public static int convertDecimalToBinary(int number, int[] bitsCount) {
        int count = 0;
        while (number > 0) {
            int rem = number % 2;
            if (rem == 1) count++;
            number /= 2;
            if (bitsCount[number] > 0) return bitsCount[number] + count;
        }
        return count;
    }
}
