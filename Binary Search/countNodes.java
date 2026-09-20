class Node{
        Node left;
        Node right;
    public Node(int data){
         this.left = null;
        this.right = null;
        int val = data;
    }
}
//Count Nodes in Binary Tree
class countNodes{
    public static int count(Node root){

        if(root==null)
            return 0;
        int leftHeight = count(root.left);
        int rightHeight = count(root.right);

        return leftHeight + rightHeight + 1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.left = new Node(6);
        System.out.println("Height of Binary Tree: "+count(root));
    }
}