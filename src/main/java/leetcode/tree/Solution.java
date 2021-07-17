package leetcode.tree;

import leetcode.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
    static int count = 0;
    public static void uniquePathsHelper(int m, int n, String osf) {
        if (m == 0 && n == 0) {
            count++;
            return;
        } else {
            if (m == 0) {
                uniquePathsHelper(m, n - 1, osf + "R");
                return;
            }
            if (n == 0) {
                uniquePathsHelper(m - 1, n, osf + "D");
                return;
            }
            uniquePathsHelper(m, n - 1, osf + "R");
            uniquePathsHelper(m - 1, n, osf + "D");

        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, targetSum, 0);
    }

    public boolean hasPathSumHelper(TreeNode root, int targetSum, int calculatedSum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (targetSum == calculatedSum + root.val) return true;
                else return false;
            } else {
                return (hasPathSumHelper(root.left, targetSum, calculatedSum + root.val) ||
                        hasPathSumHelper(root.right, targetSum, calculatedSum + root.val));
            }
        }
        return false;

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeightOfTheTree(root.left) - getHeightOfTheTree(root.right)) <= 1;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode n1, TreeNode n2) {
        if (n1 != null && n2 != null) {
            return (n1.val == n2.val) && isSymmetricHelper(n1.left, n2.right) && isSymmetricHelper(n1.right, n2.left);
        }
        if (n1 == null && n2 == null) return true;
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return (p.val == q.val) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
        if (p != null && q == null) {
            return false;
        }
        if (q != null && p == null) {
            return false;
        }
        return true;
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int countNodes(TreeNode root) {
        count = 0;
        countNodesHelper(root);
        return count;
    }
    public void countNodesHelper(TreeNode root) {
        if (root != null) {
            count++;
            countNodesHelper(root.left);
            countNodesHelper(root.right);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        int height = getHeightOfTheTree(root);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            List<Integer> list = new LinkedList<>();
            if (i % 2 == 0) {
                traverseLevelZigZag(root, i, list, "leftToRight");
            } else {
                traverseLevelZigZag(root, i, list, "rightToLeft");
            }
            lists.add(list);
        }
        return lists;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new LinkedList<>();
        int height = getHeightOfTheTree(root);
        List<Double> averages = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            List<Integer> list = new LinkedList<>();
            traverseLevel(root, i, list);
            double addition = 0;
            for (Integer integer : list) {
                addition += integer;
            }
            averages.add(addition / list.size());
        }
        return averages;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        int height = getHeightOfTheTree(root);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            List<Integer> list = new LinkedList<>();
            traverseLevel(root, i, list);
            lists.add(list);
        }
        return lists;
    }

    public static void traverseLevelZigZag(TreeNode root, int level, List<Integer> list, String direction) {
        if (root != null) {
            if (level == 1) {
                list.add(root.val);
                return;
            }

            if (direction.equals("rightToLeft")) {
                traverseLevelZigZag(root.left, level - 1, list, direction);
                traverseLevelZigZag(root.right, level - 1, list, direction);
            } else {
                traverseLevelZigZag(root.right, level - 1, list, direction);
                traverseLevelZigZag(root.left, level - 1, list, direction);
            }
        }
    }

    public static void traverseLevel(TreeNode root, int level, List<Integer> list) {
        if (root != null) {
            if (level == 1) {
                list.add(root.val);
                return;
            }

            traverseLevel(root.left, level - 1, list);
            traverseLevel(root.right, level - 1, list);
        }
    }

    public static int getHeightOfTheTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeightOfTheTree(root.left);
        int right = getHeightOfTheTree(root.right);
        return 1 + Math.max(left, right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversalHelper(root, list);
        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<String> permutations = getPermutationsOfString(n);
        Set<String> set = new TreeSet<>();
        permutations.forEach(string -> {
            TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(string.charAt(0))));
            for (int i = 1; i < string.length(); i++) {
                insertNodeIntoTree(root, Integer.parseInt(String.valueOf(string.charAt(i))), null);
            }
            StringBuilder stringBuilder = new StringBuilder();
            levelTraversal(root, stringBuilder);
            System.out.println(stringBuilder);
            if (!set.contains(stringBuilder.toString())) {
                treeNodes.add(root);
                set.add(stringBuilder.toString());
            }

        });
        return treeNodes;
    }

    public void levelTraversal(TreeNode root, StringBuilder stringBuilder) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove();
            stringBuilder.append(front.val);
            if (front.left != null) queue.add(front.left);
            if (front.right != null) queue.add(front.right);
        }
    }

    public void insertNodeIntoTree(TreeNode root, int data, TreeNode prev) {
        if (root == null) {
            TreeNode node = new TreeNode(data);
            if (data < prev.val) {
                prev.left = node;
            } else {
                prev.right = node;
            }
            return;
        }

        prev = root;
        if (data < root.val) {
            insertNodeIntoTree(root.left, data, prev);
        } else {
            insertNodeIntoTree(root.right, data, prev);
        }
    }

    public List<String> getPermutationsOfString(int n) {
        List<String> list = new ArrayList<>();
        getPermutationsOfStringHelper(generateNumberString(n), "", list);
        return list;
    }

    public void getPermutationsOfStringHelper(String str, String pre, List<String> list) {
        if (str.length() == 0) {
            list.add(pre);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            getPermutationsOfStringHelper(rem, pre + str.charAt(i), list);
        }
    }

    public String generateNumberString(int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        return stringBuilder.toString();
    }

    public static void inOrderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderTraversalHelper(root.left, list);
            list.add(root.val);
            inOrderTraversalHelper(root.right, list);
        }
    }
}
