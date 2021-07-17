package leetcode.LinkedList;

class MyLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

        if (index >= size) return -1;
        if (index == 0) return head.val;
        if (index == size) return tail.val;
        ListNode headCopy = head;
        int i = 0;
        do{
            headCopy = headCopy.next;
            i++;
        }while(i <index);

        return headCopy.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode item = new ListNode(val);
        if (head == null) {
            head = item;
            tail = item;
        } else {
            item.next = head;
            head = item;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode item = new ListNode(val);
        if (tail == null) {
            head = item;
            tail = item;
        } else {
            tail.next = item;
            tail = tail.next;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        ListNode item = new ListNode(val);
        if (index == size) {
            tail.next = item;
            tail = tail.next;
            size++;
        } else if (index == 0) {
            item.next = head;
            head = item;
            size++;
        } else {
            ListNode headCopy = head;
            ListNode prev = null;
            for (int i = 0; i < index; i++) {

                prev = headCopy;
                headCopy = headCopy.next;
            }
            prev.next = item;
            item.next = headCopy;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            size--;
        } else if (index < size) {
            ListNode prev = null;
            ListNode headCopy = head;
            for (int i = 0; i < index; i++) {
                prev = headCopy;
                headCopy = headCopy.next;
            }
            prev.next = headCopy.next;
            size--;
            if (index == size - 1) {
                tail = tail.next;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */