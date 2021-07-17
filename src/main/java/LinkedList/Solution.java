package LinkedList;


import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Node l1node1 = new Node(1);
        Node l1node2 = new Node(2);
//        Node l1node3 = new Node(3);
//        Node l1node4 = new Node(4);
//        Node l1node5 = new Node(5);
//        Node l1node6 = new Node(6);
//        Node l1node7 = new Node(7);
        l1node1.next = l1node2;
//        l1node2.next = l1node3;
//        l1node3.next = l1node4;
//        l1node4.next = l1node5;
//        l1node5.next = l1node6;
//        l1node6.next = l1node7;

        Node mergedList = oddEvenList(l1node1);

        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }

    public Node mergeInBetween(Node list1, int a, int b, Node list2) {

        int count = 0;
        Node list1Copy = list1;
        for (int i = 0; i <= a; i++) {
            list1 = list1.next;
        }
        Node startAt = list1;
        for (int i = a; i <= b; i++) {
            list1 = list1.next;
        }
        Node endAt = list1;
        startAt.next = list2;
        Node prev = null;
        while(list2 != null){
            prev = list2;
            list2 = list2.next;
        }
        prev.next = endAt;
        return list1Copy;
    }

    public static Node oddEvenList(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) return head;
        Node odd = head;
        Node headCopy = head;
        Node even = head.next;
        Node evenCopy = even;
        head = even.next;
        int count = 3;
        while (head != null) {
            if (count % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            count++;
            head = head.next;
        }
        if (count % 2 == 0) {
            even.next = null;
        }
        odd.next = evenCopy;
        return headCopy;
    }

    public static Node reverseBetween(Node head, int m, int n) {
        Node headCopy = head;

        if (head.next.next == null) {
            if (m == 1 && n == 2) {
                Node first = head;
                head.next = first;
                first.next = null;
                return head;
            }
        }

        for (int i = 0; i < m - 2; i++) {
            head = head.next;
        }
        Node initial = head;
        Node reveredEnd = null;
        Node prev = null;
        head = head.next;
        reveredEnd = head;
        Node next = null;
        for (int i = m; i <= n; i++) {
            if (headCopy == prev && head.next == null) {
                head.next = prev;
                prev.next = null;
                return head;
            }
            next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }

        initial.next = prev;
        reveredEnd.next = next;

        return headCopy;
    }

    public static boolean isPalindrome(Node head) {
        Node headCopy = head;
        Node slow = head;
        Node fast = head;
        while (fast != null || fast.next.next == null) {
            if (fast.next == null) {
                slow = slow.next;
                break;
            }
            if (fast.next.next == null) {
                slow = slow.next;
                System.out.println(slow.next.data);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = headCopy;
        while (slow != null) {
            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node detectCycle(Node head) {
        if (head == null) return null;
        if (head.next == head) return head;
        if (head.next == null) return null;
        Node headCopy = head;
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        } while (slow != fast);

        slow = head;
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    public void deleteNode(Node node) {
        while (node != null) {
            node.data = node.next.data;
            if (node.next.next == null) {
                node.next = null;
            }
            node = node.next;
        }
    }

    public static Node firstNode = null;

    public static Node reverseLists(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Node reversedNode = reverseSubList(head);
        reversedNode.next = null;
        return firstNode;
    }

    public static Node reverseSubList(Node head) {
        if (head.next == null) {
            firstNode = head;
            return head;
        } else {
            Node revered = reverseSubList(head.next);
            revered.next = head;
            return head;
        }
    }

    public static Node removeElements(Node head, int val) {
        Node headCopy = head;
        Node prev = null;
        while (head != null) {
            if (head.data == val) {
                if (head == headCopy) {
                    headCopy = head.next;
                } else {
                    prev.next = head.next;
                }
            } else {
                prev = head;
            }
            head = head.next;
        }
        return headCopy;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        int sizeOfA = 0;
        Node headACopy = headA;
        while (headA != null) {
            sizeOfA++;
            headA = headA.next;
        }
        int sizeOfB = 0;
        while (headB != null) {
            sizeOfB++;
            headB = headB.next;
        }
        return null;
    }

    public static Node deleteDuplicates1(Node head) {
        Node headCopy = head;
        while (head != null) {
            Node headTemp = head;
            while (head != null && head.data == headTemp.data) {
                head = head.next;
            }
            headTemp.next = head;
        }
        return headCopy;
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node l2Copy = l2;
        while (l1 != null) {
            Node next = l1.next;
            if (l1.data < l2.data) {
                l1.next = l2;
                l2 = l1;
                l2Copy = l2;
            } else {
                Node prev = null;
                while (l2.data <= l1.data) {
                    prev = l2;
                    l2 = l2.next;
                    if (l2 == null) {
                        break;
                    }
                }
                prev.next = l1;
                l1.next = l2;
                l2 = l1;
            }
            l1 = next;
        }
        return l2Copy;
    }

    public boolean hasCycle(Node head) {
        HashSet<Node> hashSet = new HashSet<Node>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
        }
        return true;
    }

    public static Node rotateRight(Node head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (k == 0) return head;
        Node headCopy = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        head = headCopy;
        Node breakingNode = head.next;
        if (size == k) return headCopy;
        if (k > size) k = k % size;
        for (int i = 0; i < size - k - 1; i++) {
            head = head.next;
            breakingNode = head.next;
        }
        Node copyBreakingNode = breakingNode;
        head.next = null;
        while (breakingNode.next != null) {
            breakingNode = breakingNode.next;
        }
        breakingNode.next = headCopy;
        return copyBreakingNode;
    }

    public static Node deleteDuplicates(Node head) {
        if (head == null) return null;
        Node headCopy = head;
        Node first = head;
        Node second = head.next;
        if (second == null) {
            return headCopy;
        }
        Node next = second.next;
        Node prev = null;


        while (true) {

            second.next = first;
            if (prev == null) {
                headCopy = second;
            } else {
                prev.next = second;
            }
            prev = first;
            first = next;
            if (first == null) {
                break;
            } else {
                second = first.next;
            }
            next = second.next;
        }
        prev.next = null;
        return headCopy;
    }

    public Node swapNodes(Node head, int k) {

        Node headCopy = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        Node first = null;
        Node last = null;
        head = headCopy;
        for (int i = 1; i <= size; i++) {
            if (i == k) {
                first = head;
            }
            if (i == (size - k - 1)) {
                last = head;
                break;
            }
            head = head.next;
        }

        int temp = last.data;
        last.data = first.data;
        first.data = temp;

        return headCopy;
    }
}