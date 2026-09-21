
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int val){
        left = right = null;
        data=val;
    }
}
class deletion{
    public static Node delete(Node root,int key){
        if(root==null)
            return null;
        if (key < root.data) {
            root.left  = delete(root.left, key);
        }else if(key > root.data){
            root.right = delete(root.right, key);
        }else{
            //No Node children
            if(root.left==null && root.right==null){
                return null;
            }//One Child
            else if(root.left==null){
                return root.right;
            }//One Child
            else if(root.right==null){
                return root.left;
            }//Two Children
            Node successor = root.right;
            while(successor.left!=null){
                successor = successor.left;
            }
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        int key = 4;
        root = delete(root, key);
        Queue <Node>q  = new LinkedList<>();
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