//101. Symmetric Tree - E.
//Given a binary tree, check whether it is a mirror of itself
// (ie, symmetric around its center).
public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean checkSymmetry(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return checkSymmetry(left.left, right.right)
                && checkSymmetry(left.right, right.left);

    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetry(root.left, root.right);

    }
    public static void main(String[] args){

    }

}

