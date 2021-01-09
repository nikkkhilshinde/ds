package codinginterview.arraysAndStrings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
//        permuteStrings("abcd", "");
//        System.out.println(isPermutation("abcd","abcdabcd"));
//        System.out.println(URLify("Mr John Smith    ".toCharArray(), 13));
//        System.out.println(pallindromePermutation("attbtt"));
//        System.out.println(oneAway("pale","bale"));
//        System.out.println(compressString("abcd"));
//        zeroMatrix(initMatrix());
//        stringRotation("waterbottle","aterbottlew");
//        rotateMatrixBy90degree(initMatrixWithSequenceWithSize(8, 8));
    }

    private static void rotateMatrixBy90degree(int[][] matrix) {
        print2DMatrix(matrix);
        int N = matrix.length - 1;
        for (int i = 0; i < (N / 2) + 1; i++) {
            int endIndex = N - i;
            int subMatrixIndex = 0;
            for (int j = i; j < N - i; j++) {
                int temp = matrix[j][endIndex];
                matrix[j][endIndex] = matrix[i][j];
                int temp1 = matrix[endIndex][endIndex - subMatrixIndex];
                matrix[endIndex][endIndex - subMatrixIndex] = temp;
                temp = matrix[endIndex - subMatrixIndex][i];
                matrix[endIndex - subMatrixIndex ][i] = temp1;
                matrix[i][j] = temp;
                subMatrixIndex++;
            }
        }

        print2DMatrix(matrix);
    }

    private static void stringRotation(String str1, String str2) {
        System.out.println(isSubstring(str2 + str2, str1));
    }

    private static boolean isSubstring(String str1, String str2) {
        return getSubstrings(str1).contains(str2);
    }

    private static ArrayList<String> getSubstrings(String str) {
        ArrayList<String> subStrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                subStrings.add(str.substring(j, j + i));
            }
        }
        return subStrings;
    }

    private static int[][] initMatrixWithSequenceWithSize(int M, int N) {
        int[][] matrix = new int[M][N];
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count++;
                matrix[i][j] = count;
            }
        }
        return matrix;
    }

    private static int[][] initMatrixWithSomeZeros() {
        int[][] matrix = new int[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                matrix[i][j] = count;
            }
        }
        matrix[1][1] = 0;
        matrix[2][2] = 0;
        return matrix;
    }

    private static void zeroMatrix(int[][] matrix) {
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroColumns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroColumns.add(j);
                }
            }
        }

        print2DMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRows.contains(i) || zeroColumns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        print2DMatrix(matrix);
    }

    private static void print2DMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.format("%-5s", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("___________");

    }

    private static String compressString(String str) {
        char previousChar = str.charAt(0);
        char currentChar;
        int count = 0;
        boolean uncompressable = true;
        StringBuilder compressedString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (currentChar == previousChar) {
                count++;
            } else {
                if (count > 1) {
                    uncompressable = false;
                }
                compressedString.append(previousChar).append(count);
                count = 1;
            }
            previousChar = currentChar;
        }
        compressedString.append(previousChar).append(count);
        return uncompressable ? str : compressedString.toString();
    }

    private static boolean oneAway(String str1, String str2) {
        String big = str2;
        String small = str1;
        if(str1.length() > str2.length()){
            big = str1;
            small = str2;
        }
        if(Math.abs(small.length()-big.length())>1){
            return false;
        }
        boolean isMatched = false;
        for (int i = 0; i < big.length(); i++) {
            String rem = big.substring(0, i) + big.substring(i + 1);
            System.out.println(rem);
            if(rem.equals(small)){
                isMatched = true;
                break;
            }
        }
        return isMatched;
    }

    private static boolean pallindromePermutation(String str) {
        int[] charCount = new int[128];
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 32) {
                charCount[str.charAt(i)]++;
            } else {
                spaceCount++;
            }
        }
        int oddCount = 0;
        for (int i = 0; i < 128; i++) {
            if (charCount[i] % 2 != 0) {
                oddCount++;
            }
        }
        if ((str.length() - spaceCount) % 2 == 0 && oddCount == 0) return true;
        if ((str.length() - spaceCount) % 2 != 0 && oddCount == 1) return true;

        return false;
    }

    public static char[] URLify(char[] str, int length) {
        int spaceCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == 32) spaceCount++;
        }
        int endSpaceCount = 2 * spaceCount;
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == 32) {
                endSpaceCount = endSpaceCount - 2;
                str[i + endSpaceCount] = '%';
                str[i + endSpaceCount + 1] = '2';
                str[i + endSpaceCount + 2] = '0';
            } else {
                str[i + endSpaceCount] = str[i];
            }
        }
        return str;
    }

    public static boolean isPermutation(String s1, String s2) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!charCount.containsKey(s1.charAt(i))) {
                charCount.put(s1.charAt(i), 1);
            } else {
                int oldCount = charCount.get(s1.charAt(i));
                charCount.put(s1.charAt(1), oldCount++);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            Integer count = charCount.get(s2.charAt(i));
            if (count == null) return false;
            if (count == 1) {
                charCount.remove(s2.charAt(i));
            } else {
                int oldCount = charCount.get(s2.charAt(i));
                charCount.put(s2.charAt(i), oldCount--);
            }
        }

        return charCount.isEmpty();
    }

    public static int count = 0;

    public static void permuteStrings(String str, String prefix) {
        if (str.length() == 0) {
            count++;
            System.out.println(count + ":" + prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permuteStrings(rem, prefix + str.charAt(i));
            }
        }
    }
}