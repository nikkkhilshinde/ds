package leetcode;


class FrontMiddleBackQueue {
    private static class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node front;
    private Node back;
    private Node middle;
    private int frontCount;
    private int backCount;

    public FrontMiddleBackQueue() {
        front = null;
        back = null;
        middle = null;
        frontCount = 0;
        backCount = 0;

    }

    public String toString() {
        Node frontCopy = front;
        StringBuilder stringBuilder = new StringBuilder();
        while (frontCopy != null) {
            stringBuilder.append(frontCopy.val).append(", ");
            frontCopy = frontCopy.next;
        }
        return stringBuilder.toString();
    }

    public void pushFront(int val) {
        Node newNode = new Node(val);
        if (front != null) {
            newNode.next = front;
            front.prev = newNode;
            frontCount++;
        }
        if (back == null) {
            back = newNode;
        }
        if (middle == null) {
            middle = newNode;
        }
        front = newNode;
        adjustMiddle();
    }

    public void pushMiddle(int val) {
        Node newNode = new Node(val);

        int diff = frontCount - backCount;
        if (diff == 0) {
            middle.prev.next = newNode;
            newNode.prev = middle.prev;
            newNode.next = middle;
//            middle.next.prev = newNode;
            middle = newNode;
            backCount++;
        } else if (diff == -1) {
            newNode.next = middle.next;
            middle.next.prev = newNode;
            newNode.prev = middle;
            middle.next = newNode;
            middle = newNode;
            frontCount++;
        }
    }

    public void pushBack(int val) {
        Node newNode = new Node(val);
        if (back != null) {
            back.next = newNode;
            newNode.prev = back;
            back = back.next;
            backCount++;
        } else {
            back = newNode;
        }
        if (front == null) {
            front = newNode;
        }
        if (middle == null) {
            middle = newNode;
        }

    }

    private void adjustMiddle() {
        int diff = frontCount - backCount;
        if (diff == 2) {
            middle = middle.prev;
            backCount++;
            frontCount--;
        } else if (diff == -2) {
            middle = middle.next;
            backCount--;
            frontCount++;
        }
    }

    public int popFront() {
        if (front == null) return -1;
        int val = front.val;
        front = front.next;
        if (front == null) return val;
        front.prev = null;
        frontCount--;
        adjustMiddle();
        return val;
    }

    public int popMiddle() {
        int val = middle.val;

        if (middle.next == null && middle.prev == null) {
            middle = null;
            front = null;
            back = null;
            return val;
        } else if (middle.next != null && middle.prev == null) {
            middle = middle.next;
            middle.prev = null;
            return val;
        } else if (middle.prev != null && middle.next == null) {
            middle = middle.prev;
            middle.next = null;
            return val;
        } else {
            System.out.println(middle.prev.val + ":" + middle.next.val);
            Node middlePrev = middle.prev;
            Node middleNext = middle.next;
            middlePrev.next = middleNext;
            middleNext.prev = middlePrev;
            middle = middle.next;
            backCount--;
            
            return val;
        }
    }

    public int popBack() {
        if (back == null) return -1;
        int val = back.val;
        back = back.prev;
        if (back == null) return val;
        back.next = null;
        backCount--;
        adjustMiddle();
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */