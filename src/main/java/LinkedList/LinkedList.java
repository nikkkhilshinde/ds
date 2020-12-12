package LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        Node head = new Node();
        Node temp = head;
        //Init linked list
        for (int i = 1; i < 11; i++) {
            head.setData(i);
            Node t = new Node();
            head.setNextNode(t);
            head = t;
        }
        findMiddleElement(temp);
        Node headOfInvertedLinkedList = invert(temp);
        traverseLinkedList(headOfInvertedLinkedList);
    }

    public static Node invert(Node head) {
        Node previous = null;
        Node next = null;
        while(head!=null){
            next = head.getNextNode();
            head.setNextNode(previous);
            previous = head;
            head = next;
        }
        return previous;
    }
    public static void findMiddleElement(Node head){
        Node mid = head;
        int count = 0;
        while (head!=null){
            if(count==2){
                mid = mid.getNextNode();
                count = 0;
            }
            head = head.getNextNode();
            count++;
        }
        System.out.println(mid.getData());
    }
    public static void traverseLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNextNode();
        }
    }
}
