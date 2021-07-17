package Hackerank.Misc;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Printer<T> {
    void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class Calculator {
    public int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) throw new Exception("n and p should be non-negative");
        Queue<Character> queue = new LinkedList<>();
        char ch = queue.remove();
        return (int) Math.pow(n, p);
    }
}

class Solution {

    public static Node insert(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node headCopy = head;
        while (head.next != null) {
            head = head.next;
        }
        Node newNode = new Node(data);
        head.next = newNode;
        return headCopy;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int returnedDay = Integer.parseInt(input[0]);
        int returnedMonth = Integer.parseInt(input[1]);
        int returnedYear = Integer.parseInt(input[2]);
        input = scanner.nextLine().split(" ");
        int dueDay = Integer.parseInt(input[0]);
        int dueMonth = Integer.parseInt(input[1]);
        int dueYear = Integer.parseInt(input[2]);
        int fine = 0;

        System.out.println(fine);
    }
}