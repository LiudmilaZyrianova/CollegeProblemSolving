// 530. Minimum Absolute Difference in BST

    // we need to compare rightmost of left subtree and leftmost of right subtree
    public TreeNode getRightMostNode(TreeNode root) {
        return (root.right == null) ? root : getRightMostNode(root.right);
    }

    public TreeNode getLeftMostNode(TreeNode root) {
        return (root.left == null) ? root : getLeftMostNode(root.left);
    }
    
    public int getMinimumDifference(TreeNode root) {
        int left = Integer.MAX_VALUE;
        if (root.left != null) {
            left = (int) Math.min(
                Math.abs(root.val - getRightMostNode(root.left).val), 
                getMinimumDifference(root.left));
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = (int) Math.min(
                Math.abs(root.val - getLeftMostNode(root.right).val),  
                getMinimumDifference(root.right));
        }
        return (int) Math.min(left, right);
    }

// BETTER SOLUTION - in-order traverse!!!

public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
    
}
