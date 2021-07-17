package Tree.BinarySearchTree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestClass {
    //            10
    //          /   \
    //         5     15
    //        / \   / \
    //       1   7 14   20

    public static void main(String[] args) {
        Node root = new Node(10);

        Node node5 = new Node(5);
        Node node15 = new Node(15);

        Node node1 = new Node(1);
        Node node8 = new Node(8);
        Node node14 = new Node(14);
        Node node20 = new Node(20);

        Node node6 = new Node(6);
        Node nodeNeg10 = new Node(-10);
        Node node7 = new Node(7);

        root.left = node5;
        root.right = node15;

        node5.left = node1;
        node5.right = node8;
        node15.left = node14;
        node15.right = node20;

        node8.left = node7;
        node7.left = node6;
//        nodeNeg1.left = nodeNeg10;
        rootCopy = root;
        preorderTraversal(root);
        levelMap.forEach((key, value) -> {
            System.out.print(value.get(0) + " ");
        });
//        System.out.println(findHorizontalDistanceFromRoot(root, 6));
//        int treeHeight = heightOfTree(root);
//        for (int i = 0; i < treeHeight; i++) {
//            printTreeLevel(root, i);
//        }
    }
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> seqList = new ArrayList<>(n);
        AtomicInteger lastAnswer = new AtomicInteger(0);
        List<Integer> result = new ArrayList<>();
        queries.forEach(query -> {
            int x = query.get(1);
            int y = query.get(2);
            int index = ((x ^ lastAnswer.get()) % n);
            List<Integer> seq = seqList.get(index);

            if(query.get(0) == 1){
                seq.add(y);
            }else{
                lastAnswer.getAndSet(seq.get(y % seq.size()));
                result.add(lastAnswer.get());
            }
        });

        return result;
    }

    public static Map<Integer, List<Integer>> levelMap = new TreeMap<>();
    public static Node rootCopy = null;
    private static void preorderTraversal(Node root) {
        int horizontalDistance = findHorizontalDistanceFromRoot(rootCopy, root.data);
        List<Integer> list;
        if(levelMap.containsKey(horizontalDistance)){
            list = levelMap.get(horizontalDistance);
        }else{
            list = new ArrayList<>();
        }
        list.add(root.data);
        levelMap.put(horizontalDistance, list);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
    }
    private static int findHorizontalDistanceFromRoot(Node root, int data) {
        if(root == null){
            return 0;
        }
        if(root.data == data){
            return 0;
        }else{
            if(data < root.data){

                return findHorizontalDistanceFromRoot(root.left, data) - 1;
            }else{
                return findHorizontalDistanceFromRoot(root.right, data) + 1;
            }
        }
    }

    private static void printTreeLevel(Node root, int level) {
        if (root != null) {
            if (level == 0) {
                System.out.print(root.data + " ");
            } else {
                printTreeLevel(root.left, level - 1);
                printTreeLevel(root.right, level - 1);
            }
        }

    }

    private static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }

    }

    private static void levelOrderTraversal(Node root) {

        System.out.print(root.data + " ");
        printLevel(root.left, root.right);
    }

    private static void printLevel(Node left, Node right) {
        if (left != null) {
            System.out.print(left.data + " ");
        }
        if (right != null) {
            System.out.print(right.data + " ");
        }
        if (left != null) {
            if (left.left != null && left.right != null) {
                printLevel(left.left, left.right);
            } else {
                if (left.left != null) {
                    printLevel(left.left, null);
                } else {
                    printLevel(null, left.right);
                }
            }
        }
        if (right != null) {
            if (right.left != null && right.right != null) {
                printLevel(right.left, right.right);
            } else {
                if (right.left != null) {
                    printLevel(right.left, null);
                } else {
                    printLevel(null, right.right);
                }
            }
        }
    }


}
