package codinginterview.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Result {
    Node node;
    boolean result;

    public Result(Node head, boolean b) {
        this.node = head;
        this.result = b;
    }
}

class GetNodeResult{
    int data;
    int distanceFromTail;
    boolean isFound;

    public GetNodeResult(int data, int distanceFromTail, boolean isFound){
        this.data = data;
        this.distanceFromTail = distanceFromTail;
        this.isFound = isFound;
    }

    @Override
    public String toString() {
        return "GetNodeResult{" +
                "data=" + data +
                ", distanceFromTail=" + distanceFromTail +
                ", isFound=" + isFound +
                '}';
    }
}
public class LLMain {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node headCopy = head;
        Node mid = null;
        int[] linkedListData = {2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < linkedListData.length; i++) {
            Node node = new Node(linkedListData[i]);
            if (i == 1) {
                mid = node;
            }
            head.next = node;
            head = node;
        }

        //        printLinkedList(headCopy);
        //        removeDuplicatesUsingBuffer(headCopy);
        //        System.out.println();
        //        removeDuplicatesWithoutUsingBuffer(headCopy);
        //        printLinkedList(headCopy);
        //        int node = kthToLast(headCopy, 1);
        //        System.out.println(node);
        //        Node number1 = convertIntegerStringToLinkedList("987654329");
        //        Node number2 = convertIntegerStringToLinkedList("987654321");
        //        Node sum = sumLists(number1, number2);
        //        printLinkedList(sum);
        //        checkIfPalindrome(sum);
        //        checkIfPalindromeUsingExtraSpace(convertIntegerStringToLinkedList("123321"));
        //        boolean isPalindrome = checkIfPalindromeWithoutExtraSpace(convertIntegerStringToLinkedList("1221"));
        //        System.out.println(isPalindrome);
        //        isPalindromeUsingStack(convertIntegerStringToLinkedList("123321"));
//            isPalindromeRecursive(convertIntegerStringToLinkedList("124321"));
//        Node random = convertIntegerStringToLinkedList("1234");
//        Node randomCopy = random;
//        Node prev = null;
//        while (random.next != null) {
//            random = random.next;
//        }
//            random.next = mid;
//        System.out.println(checkIntersection(headCopy, randomCopy));
//        printLinkedList(
//                mergeLists(convertIntegerStringToLinkedList("34557"),convertIntegerStringToLinkedList("1"))
//        );
//        printLinkedList(removeDuplicates(convertIntegerStringToLinkedList("11123344")));
//        System.out.println(getNodeValue(convertIntegerStringToLinkedList("12345"), 1));
        head.next = mid;
        loopDetection(headCopy);
    }

    private static void loopDetection(Node head) {
//        printLinkedList(head);
        Node slow = head;
        Node fast = head;
        Node headCopy = head;
        while (true){
            slow = slow.next;
            fast = skipNodeByCount(fast, 2);

            if(fast == null){
                break;
            }
            if(fast == slow){
                break;
            }
        }
        if(slow == fast && slow == headCopy){
            System.out.println("Loop starts at :" + slow.data);
        }

        fast = headCopy;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(slow.data);

    }


    private static int getNodeValue(Node head, int positionFromTail) {
        int size = 0;
        Node headCopy = head;
        while(head != null){
            size++;
            head = head.next;
        }
        head = headCopy;
        for (int i = 0; i < size - positionFromTail - 1; i++) {
            head = head.next;
        }
        return head.data;
    }

    static Node removeDuplicates(Node head) {
        Node prev = null;
        Node headCopy = head;
        while (head != null){
            if(prev != null && prev.data == head.data){
                prev.next = head.next;
                head = prev;
            }

            prev = head;
            head = head.next;
        }
        return headCopy;
    }
    static Node mergeLists(Node head1, Node head2) {
        Node head2copy = head2;
        Node head1Copy = head1;
        if(head2.next == null){
            Node temp = head1;
            head1 = head2;
            head2 = temp;

            head2copy = head1Copy;
        }
        do {
            head2 = head2copy;
            Node prev = null;
            Node newNode = new Node(head1.data);
            while (head2 != null) {
                if(prev == null){
                    if(head1.data <= head2.data){
                        newNode.next = head2;
                        head2copy = newNode;
                        break;
                    }
                }else{
                    if(prev.data <= head1.data && head1.data <= head2.data || prev.data == head1.data){
                        prev.next = newNode;
                        newNode.next = head2;
                        break;
                    }else{
                        if(head2.next == null && head2.data < head1.data){
                            head2.next = newNode;
                            break;
                        }
                    }
                }
                prev = head2;
                head2 = head2.next;
            }

            head1 = head1.next;
        }while (head1 != null);
        return head2copy;
    }

    private static int checkIntersection(Node l1, Node l2) {
        printLinkedList(l1);
        printLinkedList(l2);
        while (l1 != null) {
            Node next = l1.next;
            l1.next = l1;
            l1 = next;
        }
        while (l2 != null) {

            if (l2.next == l2) {
                return l2.data;
            } else {
                l2 = l2.next;
            }
        }
        return -1;
    }

    private static boolean isPalindromeRecursive(Node head) {
        int size = 0;
        Node headCopy = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        boolean isPal = isPalindrome(headCopy, size).result;
        System.out.println(isPal);
        return false;
    }

    private static Result isPalindrome(Node head, int length) {
        if (length == 0) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        } else {
            Result resultNode = isPalindrome(head.next, length - 2);
            if (head.data != resultNode.node.data) {
                return new Result(resultNode.node.next, false);
            } else {
                return new Result(resultNode.node.next, resultNode.result);
            }
        }
    }


    private static boolean isPalindromeUsingStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        printLinkedList(head);
        Node slow = head;
        Node fast = head;
        while (true) {
            fast = skipNodeByCount(fast, 2);
            if (fast != null) {
                stack.push(slow.data);
                slow = slow.next;
            } else {
                break;
            }
        }
        if (skippedNodesCount % 2 == 0) {
            stack.push(slow.data);
        }

        slow = slow.next;
        System.out.println(slow.data);

        boolean isPalindrome = true;
        do {
            System.out.println(stack.peek() + ":" + slow.data);
            if (stack.pop() != slow.data) {
                isPalindrome = false;
                break;
            }
            slow = slow.next;
        } while (slow != null);

        System.out.println(isPalindrome);
        return false;
    }

    private static int skippedNodesCount = 0;

    private static Node skipNodeByCount(Node node, int count) {
        for (int i = 0; i < count; i++) {
            if (node == null) {
                break;
            }
            skippedNodesCount++;
            node = node.next;

        }
        return node;
    }

    private static boolean checkIfPalindromeWithoutExtraSpace(Node head) {
        int size = 0;
        Node p1 = head;
        while (head != null) {
            size++;
            head = head.next;
        }

        boolean isPalindrome = true;
        for (int i = 0; i < size; i++) {
            Node p2 = p1;
            for (int j = 0; j < size - i - 1; j++) {
                p2 = p2.next;
            }
            if (p1.data != p2.data) {
                isPalindrome = false;
                break;
            }
            size--;
            p1 = p1.next;
        }
        return isPalindrome;
    }

    private static Node cloneList(Node head) {
        Node clone = new Node();
        Node cloneCopy = clone;

        do {
            Node node = new Node(head.data);
            clone.next = node;
            clone = node;
            head = head.next;
        } while (head != null);

        return cloneCopy.next;
    }

    private static void checkIfPalindromeUsingExtraSpace(Node head) {
        Node reversedList = reverseLinkedList(head);
        Node reversedCopy = reversedList;
        Node headCopy = head;
        boolean isPalindrome = true;
        while (head.next != null) {
            if (head.data != reversedList.data) {
                isPalindrome = false;
                break;
            }
            reversedList = reversedList.next;
            head = head.next;
        }
        printLinkedList(reversedCopy);
        System.out.println();
        printLinkedList(headCopy);
        System.out.println(isPalindrome);
    }

    private static Node reverseLinkedList(Node head) {
        Node clone = cloneList(head);
        Node prev = null;
        Node next;
        do {
            next = clone.next;
            clone.next = prev;
            prev = clone;
            clone = next;
        } while (clone != null);

        return prev;
    }

    private static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    private static Node sumLists(Node l1, Node l2) {
        int carry = 0;
        Node head = new Node();
        Node headCopy = head;
        do {
            Node newNode;
            int l1Data;
            int l2Data;

            l1Data = l1 == null ? 0 : l1.data;
            l2Data = l2 == null ? 0 : l2.data;
            int sum = l1Data + l2Data + carry;
            if (carry == 1) {
                carry = 0;
            }
            if (sum > 9) {
                newNode = new Node(sum - 10);
                carry = 1;
            } else {
                newNode = new Node(sum);
            }
            head.next = newNode;
            head = newNode;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        } while (l1 != null || l2 != null);

        head.next = carry == 1 ? new Node(1) : null;

        return headCopy.next;
    }

    private static Node convertIntegerStringToLinkedList(String s) {

        Node head = new Node(Integer.parseInt(String.valueOf(s.charAt(0))));
        Node headCopy = head;
        for (int i = 1; i < s.length(); i++) {
            Node newNode = new Node(Integer.parseInt(String.valueOf(s.charAt(i))));
            head.next = newNode;
            head = newNode;
        }
        return headCopy;
    }

    static boolean found = false;

    private static int kthToLast(Node head, int kth) {
        if (head.next == null) {
            return 1;
        } else {
            int count = kthToLast(head.next, kth);
            if (!found) {
                count++;
            }
            if (kth == count) {
                found = true;
                return head.data;
            }
            return count;
        }
    }

    private static void removeDuplicatesWithoutUsingBuffer(Node head) {
        Node headCopy = head;
        Node p1 = head;
        Node p2;
        while (p1 != null) {
            p2 = p1;
            Node prev = null;
            while (p2 != null) {
                if (p1.data == p2.data && p1 != p2) {
                    prev.next = p2.next;
                }
                prev = p2;
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        printLinkedList(headCopy);
    }

    private static void removeDuplicatesUsingBuffer(Node head) {
        Node prev = null;
        Node headCopy = head;
        HashSet<Integer> data = new HashSet<>();
        while (head != null) {
            if (data.contains(head.data)) {
                prev.next = head.next;
            } else {
                data.add(head.data);
                prev = head;
            }
            head = head.next;
        }
        printLinkedList(headCopy);
    }


    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
