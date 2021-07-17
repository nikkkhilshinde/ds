package leetcode.Strings;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        if (s.equals("IX") || s.equals("IV") || s.equals("XL") || s.equals("XC") || s.equals("CD") || s.equals("CM")) {
            return hashMap.get(s.charAt(1)) - hashMap.get(s.charAt(0));
        }
        int sum = 0;
        int i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            if (
                    (ch == 'I' && (nextChar == 'V' || nextChar == 'X')) ||
                            (ch == 'X' && (nextChar == 'L' || nextChar == 'C')) ||
                            (ch == 'C' && (nextChar == 'D' || nextChar == 'M'))
            ) {
                sum += hashMap.get(nextChar) - hashMap.get(ch);
                i++;
            } else {
                sum += hashMap.get(s.charAt(i));
            }
        }
        if (i == s.length() - 1) {
            sum += hashMap.get(s.charAt(i));
        }
        return sum;
    }
}
