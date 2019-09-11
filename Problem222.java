//222. Count Complete Tree Nodes - M.
//Given a complete binary tree, count the number of nodes.


public class Main {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public int height(TreeNode root) {
        if (root == null) return -1;
        int h = 0;
        while (root!= null) {
            h++;
            root = root.left;
        }
        return h;
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        int nodes = 0;
        int r;
        while (root != null) {
            r = height(root.right);
            if (r == h-1) {
                nodes += 1<<h;
                root = root.right;
            } else {
                nodes += 1<<h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public static void main(String[] args) {
    }
}
