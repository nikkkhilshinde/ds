package leetcode.Strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring(""));
        generateParenthesis(4).forEach(item -> {
            System.out.println(item);
        });
    }

    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> strings = new ArrayList<>();
            strings.add("()");
            return strings;
        } else if (n == 2) {
            List<String> strings = new ArrayList<>();
            strings.add("()()");
            strings.add("(())");
            return strings;
        }
        List<String> prevList = generateParenthesis(n - 2);
        List<String> list = generateParenthesis(n - 1);
        Set<String> set = new TreeSet<>();
        list.forEach(item -> {
            set.add(item + "()");
            set.add("()" + item);
            set.add("(" + item + ")");
        });
        prevList.forEach(item -> {
            set.add("(())" + item);
            set.add(item + "(())");
            set.add("((" + item + "))");
        });
        return new ArrayList<>(set);
    }

    public static int myAtoi(String s) {
        Pattern pattern = Pattern.compile("[-+0-9]*[a-zA-Z]*");
        Matcher matcher = pattern.matcher(s.trim());

        while (matcher.find()) {
            String filtered = matcher.group(0);
            if (filtered.length() == 0) return 0;
            int mult = 1;
            if (filtered.charAt(0) == '-') {
                mult = -1;
                filtered = filtered.substring(1);
            }
            if (filtered.contains("-") && filtered.contains("+")) return 0;
            long l = 0l;
            try {
                l = Long.parseLong(filtered);
            } catch (Exception e) {
                return 0;
            }
            int min = -2147483648;
            if (l > Integer.MAX_VALUE) {
                return mult == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                return mult * Integer.parseInt(filtered);
            }
        }
        return 0;
    }

    public static String convert(String s, int numRows) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        if (numRows == 1) return s;
        int i = 0;
        int initialDistance = numRows * 2 - 2;

        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        for (int j = 0; j < numRows; j++) {
            rowMap.put(j + 1, new TreeSet<>());
        }
        while (i < s.length() + 2 * numRows) {
            Set firstRow = rowMap.get(1);
            if (i < s.length()) {
                firstRow.add(i);
            }
            for (int j = 1; j < numRows; j++) {
                Set temp = rowMap.get(1 + j);
                if (i - j > 0 && Math.abs(i - j) < s.length()) {
                    temp.add(i - j);
                }
                if (i + j < s.length()) {
                    temp.add(i + j);
                }
                rowMap.put(1 + j, temp);
            }
            i += initialDistance;
            rowMap.put(1, firstRow);
        }
        StringBuilder stringBuilder = new StringBuilder();
        rowMap.forEach((key, value) -> {
            value.forEach(character -> {
                stringBuilder.append(s.charAt(character));
            });
        });

        return stringBuilder.toString();
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        String max = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                if (max.length() < s.substring(i, i + 2).length()) {
                    max = s.substring(i, i + 2);
                }
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                if (dp[j][j + i]) {
                    final String substring = s.substring(j, j + i + 1);
                    if (max.length() < substring.length()) {
                        max = substring;
                    }
                }
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int length = 0;
        int subStart = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                length++;
            } else {
                while (set.contains(str.charAt(i))) {
                    set.remove(str.charAt(subStart));
                    subStart++;
                    length--;
                }
                set.add(str.charAt(i));
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
