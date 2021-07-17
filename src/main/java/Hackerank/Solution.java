package Hackerank;

import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;
}

public class Solution {
    boolean checkBST(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        checkBSTHelper(root, arrayList);
        return checkIfSorted(arrayList);
    }


    boolean checkIfSorted(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1 || arrayList.size() == 0) return true;

        int prev = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (prev >= arrayList.get(i)) return false;
            prev = arrayList.get(i);
        }
        return true;
    }

    void checkBSTHelper(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.data);
            return;
        }
        checkBSTHelper(root.left, list);
        list.add(root.data);
        checkBSTHelper(root.right, list);
    }
}
