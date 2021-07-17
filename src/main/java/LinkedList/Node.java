package LinkedList;

public class Node {
    public Node next;
    public int data;
    public Node(int data){
        this.data = data;
    }
    public Node(){}

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node nextNode) {
        this.next = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
