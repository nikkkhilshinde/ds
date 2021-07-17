package Hackerank.QueueStacks;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        front = new Stack<>();
        back = new Stack<>();
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String[] input = scanner.nextLine().split(" ");
            int type = Integer.parseInt(input[0]);
            switch (type) {
                case 1://enqueue
                    int data = Integer.parseInt(input[1]);
                    back.push(data);
                    break;
                case 2:// dequeue
                    if(front.isEmpty()){
                        while (!back.isEmpty()){
                            front.push(back.pop());
                        }
                    }
                    front.pop();
                    break;
                case 3: //print all at front of the queue
                    if(front.isEmpty()){
                        while (!back.isEmpty()){
                            front.push(back.pop());
                        }
                    }
                    System.out.println(front.peek());
                    break;
            }
        }
    }

    static Stack<Integer> front;
    static Stack<Integer> back;
}