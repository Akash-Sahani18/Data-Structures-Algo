
class Node {

    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        this.left = null;
        this.right = null;
    }
}

class maxPathSumleaf {

    static int maxSum = Integer.MIN_VALUE;

    public static int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int lheight = solve(root.left);
        int rheight = solve(root.right);
        int temp = Math.max(lheight, rheight) + root.data;

        if (root.left == null && root.right == null) {
            temp = Math.max(temp, root.data);
        }
        if (root.left != null && root.right != null) {
            int ans = Math.max(temp, lheight + rheight + root.data);
            maxSum = Math.max(ans, maxSum);
        }

        return temp;

    }

    public static int maxSum(Node root) {
        solve(root);
        return maxSum;

    }

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(-10);
        root.left.left.left = new Node(4);
        System.out.println(maxSum(root) + " ");
    }
}
