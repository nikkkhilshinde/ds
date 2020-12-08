package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node();
        Node temp = head;
        //Init linked list
        for (int i = 1; i < 10; i++) {
            head.setData(i);
            Node t = new Node();
            head.setNextNode(t);
            head = t;
        }
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

    public static void traverseLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNextNode();
        }
    }
}
