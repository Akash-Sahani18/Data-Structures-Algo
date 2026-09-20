class Node{
        Node left;
        Node right;
    public Node(int data){
         this.left = null;
        this.right = null;
        int val = data;
    }
}
//Height of the Binary Tree
class heightOfBinaryTree{
    public static int height(Node root){

        if(root==null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight , rightHeight);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        System.out.println("Height of Binary Tree: "+height(root));
    }
}