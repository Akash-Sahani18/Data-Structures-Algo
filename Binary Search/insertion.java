import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.left = null;
        this.right = null;
        data = val;
    }
}
class insertion{
    public static Node insert(Node root,int key){
        //If the root is null then we just insert in there
        if(root==null)
            return new Node(key);
        //If the key is already present won't insert it again
        if(key==root.data)
            return root;
        //If the Key is less than root, move to left child
        if(key < root.data){
            root.left = insert(root.left, key);
        }
        //If the key is greater than root, move to right child 
        else{
            root.right = insert(root.right, key);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        int key = 4;
        root = insert(root, key);
         // Print level order
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                q.offer(curr.left);
            }if(curr.right!=null){
                q.offer(curr.right);
            }
        }
    }
}

 