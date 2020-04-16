package Tree.BinarySearchTree;

public class Main {
    static int SIZE = 10;
    public static void main(String[] args) {
        Node rootNode = new Node();

        /*
        * Randomly generate numbers
        * and call the method
        */
        for (int i=0;i<SIZE;i++){
            int temp  = (int)(Math.random() * SIZE) + 1;
            insertNode(rootNode,temp);
        }
    }

    private static void insertNode(Node currentNode, int data){
        if(currentNode.data == 0){
            currentNode.data = data;
            System.out.println(String.format("%d added to root",data));
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
        if(currentNode.data == data){
            System.out.println(String.format("%d already present",data));
        }else if(data < currentNode.data){
            if(currentNode.left != null){
                insertNode(currentNode.left,data);
            }else{
                System.out.println(String.format("%d added to left",data));
                Node leaf = new Node();
                leaf.data = data;
                currentNode.left = leaf;
            }
        }else{
            if(currentNode.right != null) {
                insertNode(currentNode.right, data);
            }else{
                System.out.println(String.format("%d added to right",data));
                Node leaf = new Node();
                leaf.data = data;
                currentNode.right = leaf;
            }
        }
    }
}
