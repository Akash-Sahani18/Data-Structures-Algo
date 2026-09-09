
class Node {

    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        this.left = null;
        this.right = null;
    }
}

class maxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int lheight = solve(root.left);
        int rheight = solve(root.right);

        int temp = Math.max(Math.max(lheight, rheight) + root.data, root.data);
        int ans = rheight + lheight + root.data;
        maxSum = Math.max(ans, maxSum);
        return temp;
    }

    public static int maxPathSum(Node root) {
        solve(root);
        return maxSum;
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        System.out.println(maxPathSum(root) + " ");

    }
}
