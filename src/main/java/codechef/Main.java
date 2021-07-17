package codechef;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> strings = letterCombinations("1");
        strings.forEach(System.out::println);
    }
    public static HashMap<Integer, String> numberLetter = new HashMap(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};
    public static List<String> letterCombinations(String digits) {
        if(digits.equals("1") || digits.equals("")) return new ArrayList<>();

        if(digits.length() == 1){
            String str = numberLetter.get(Integer.parseInt(digits));
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                strings.add(String.valueOf(str.charAt(i)));
            }
            return strings;
        }else{
            String str = numberLetter.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
            List<String> currentLetters = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                currentLetters.add(String.valueOf(str.charAt(i)));
            }
            List<String> nextLetters = letterCombinations(digits.substring(1));
            List<String> finalStrings = new ArrayList<>();
            for (int i = 0; i < currentLetters.size(); i++) {

                for (int j = 0; j < nextLetters.size(); j++) {
                    String temp = currentLetters.get(i) + nextLetters.get(j);
                    finalStrings.add(temp);
                }
            }
            return finalStrings;
        }
    }



    static void printBinaryString(int n, String pre) {
        if (pre.equals("")) {
            printBinaryString(n - 1, "0");
            printBinaryString(n - 1, "1");
            return;
        }

        if (n == 0) {
            System.out.println(pre);
        } else {
            if (pre.charAt(pre.length() - 1) == '0') {
                printBinaryString(n - 1, pre + "1");
                printBinaryString(n - 1, pre + "0");
            } else {
                printBinaryString(n - 1, pre + "0");
            }

        }
    }
}