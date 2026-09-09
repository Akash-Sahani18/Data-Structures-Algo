
class Node {

    int data;
    Node left;
    Node right;

    public Node(int val) {
        this.left = null;
        this.right = null;
        data = val;
    }
}
//Diameter of Binary Tree in Edges

class diameterOfBinaryTree {

    static int res = 0;

    public static int solve(Node root) {

        if (root == null) {
            return 0;
        }

        int lheight = solve(root.left);
        int rheight = solve(root.right);

        if (rheight + lheight > res) {
            res = rheight + lheight;
        }
        return 1 + Math.max(rheight, lheight);
    }

    public static int calculate(Node root) {
        solve(root);
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(60);
        System.out.println(calculate(root) + " ");

    }
}
