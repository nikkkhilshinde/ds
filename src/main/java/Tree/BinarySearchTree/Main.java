package Tree.BinarySearchTree;


import org.apache.log4j.BasicConfigurator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    static void db(){
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            String email = input[1];
            Pattern pattern = Pattern.compile("[a-z]*@gmail.com");
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches()){
                names.add(name);
            }
        }
        names.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }
    static int SIZE = 10;
    static void levelOrder(Node root){
        //Write your code here
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return;
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.remove();
            System.out.println(front.data);
            if(front.left!=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicConfigurator.configure();
        Node rootNode = new Node();
        /*
         * Randomly generate numbers
         * and call the method
         */
        for (int i = SIZE; i >= 0; i--) {
//            int temp = (int) (Math.random() * SIZE) + 1;
            int temp = i;
            insertNode(rootNode, temp);
        }
        int input ;
        do{
            System.out.println("=====================");
            System.out.println("1.InOrder traversal");
            System.out.println("2.PreOrder traversal");
            System.out.println("3.PostOrder traversal");
            System.out.println("4.DFS traversal");
            System.out.println("0.Exit");
            System.out.println("=====================");
            System.out.println(isBST);

            input = scanner.nextInt();
            switch (input){
                case 1:traverseInOrder(rootNode);
                break;
                case 2:traversePreOrder(rootNode);
                break;
                case 3:traversePostOrder(rootNode);
                break;
                case 4:traverseDFS(rootNode);
                break;
                default:System.out.println("Enter appropriate input.");
            }
        }while (input != 0);

    }

    private static void traverseDFS(Node currentNode) {
        Tree tree = new Tree();
        tree.setLeft(currentNode.left);
        tree.setCurrent(currentNode);
        tree.setRight(currentNode.right);

        processTree(tree);
    }

    private static void processTree(Tree tree) {

        if (tree.getLeft() == null && tree.getRight() == null) {
            System.out.println(tree.getCurrent().data);
        } else {
            if (tree.getLeft() != null) {
                traverseDFS(tree.getLeft());
            }
            System.out.println(tree.current.data);
            if (tree.getRight() != null) {
                traverseDFS(tree.getRight());
            }
        }
    }

    static Stack<Integer> traversedNodes = new Stack<>();
    static boolean isBST = true;
    private static void traverseInOrder(Node currentNode) {

        if (currentNode.left != null) {
            traverseInOrder(currentNode.left);
        }
        System.out.println(currentNode.data);
        if(!traversedNodes.empty()){
            if(traversedNodes.peek() == currentNode.data){
                isBST = false;
            }
            if(traversedNodes.peek() < currentNode.data){
                traversedNodes.push(currentNode.data);
            }else{
                isBST = false;
            }
        }
        if (currentNode.right != null) {
            traverseInOrder(currentNode.right);
        }
    }

    private static void traversePreOrder(Node currentNode) {
        System.out.println(currentNode.data);

        if (currentNode.left != null) {
            traverseInOrder(currentNode.left);
        }
        if (currentNode.right != null) {
            traverseInOrder(currentNode.right);
        }
    }

    private static void traversePostOrder(Node currentNode) {
        if (currentNode.left != null) {
            traverseInOrder(currentNode.left);
        }
        if (currentNode.right != null) {
            traverseInOrder(currentNode.right);
        }

        System.out.println(currentNode.data);
    }


    private static void insertNode(Node currentNode, int data) {
        if (currentNode.data == 0) {
            currentNode.data = data;
            System.out.println(String.format("%d added to root", data));
            return;
        }

        /*
         * if current node is of data,
         * then don't need to add new node
         * if data is less than current nodes data, call insertNode for left side
         * else right side.
         * if left of right node is not present, then create new node, set data,
         * and point currentNodes left or right to newly created node
         */
        if (currentNode.data == data) {
            System.out.println(String.format("%d already present", data));
        } else if (data < currentNode.data) {
            if (currentNode.left != null) {
                insertNode(currentNode.left, data);
            } else {
                System.out.println(String.format("%d added to left", data));
                Node leaf = new Node();
                leaf.data = data;
                currentNode.left = leaf;
            }
        } else {
            if (currentNode.right != null) {
                insertNode(currentNode.right, data);
            } else {
                System.out.println(String.format("%d added to right", data));
                Node leaf = new Node();
                leaf.data = data;
                currentNode.right = leaf;
            }
        }
    }
}
