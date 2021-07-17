package Hackerank.Trie;

import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.AtomicReference;
class GenericStack<T>{
    Stack<T> st = new Stack<>();
    public void push(T Obj){}

}

public class Solution {
    static void a(String a){}
    static void a(Integer a){}
    /*
     * Complete the contacts function below.
     */
    static int counter = 0;

    static class Node {
        Character data;
        Map<Character, Node> children;
        boolean endNode;

        public Node() {
            children = new HashMap<>();
        }

        public Node(Character data) {
            this.data = data;
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread f = new Thread();
        f.start();
        System.out.println("A");
        f.wait(1000);
        System.out.println("B");
//        float ff = 35.0f/(float)0;
//        System.out.println(ff);
//        int a = 10 ;
//        System.out.println(++a*a++);
//        try{
//            throw new Error();
//        }catch (Error r){
//            try{
//                throw new RuntimeException();
//            }catch (Throwable e){
//
//            }
//        }
//        Node root = new Node();
//        insert("hack", root);
//        insert("hackerrank", root);
//        Node f = findNode("hac", root);
//        System.out.println(countLeaves(f));
    }

    static int[] contacts(String[][] queries) {
        ArrayList<Integer> list = new ArrayList<>();
        Node root = new Node();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].equals("add")) {
                insert(queries[i][1], root);
            } else {
                list.add(countLeaves(findNode(queries[i][1], root)));
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void insert(String str, Node root) {
        insertHelper(str, root);
    }

    public static int countLeaves(Node root) {
        counter = 0;
        countLeavesHelper(root);
        return counter;
    }

    public static void countLeavesHelper(Node root) {
        if (root == null) {
            counter = 0;
            return;
        }
        if (root.children.size() == 0 || root.endNode) {
            counter++;
        }
        root.children.forEach((key, value) -> countLeavesHelper(value));

    }

    public static Node findNode(String str, Node root) {
        if (str.length() == 0) return root;
        Node found = null;

        if(root.children.containsKey(str.charAt(0))){
            found = root.children.get(str.charAt(0));
        }

        if (found != null) {
            return findNode(str.substring(1), found);
        }
        return null;
    }

    public static void insertHelper(String str, Node root) {
        if (str.length() == 0) return;

        Node found = null;

        if(root.children.containsKey(str.charAt(0))){
            found = root.children.get(str.charAt(0));
        }
        if (found != null) {
            insertHelper(str.substring(1), found);
        } else {
            Node newNode = new Node(str.charAt(0));
            if (str.length() == 1) {
                newNode.endNode = true;
            }
            root.children.put(str.charAt(0), newNode);
            insertHelper(str.substring(1), newNode);
        }
    }
}

