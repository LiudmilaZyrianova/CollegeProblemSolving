/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class OurPair {
        int num;
        Integer res;
        OurPair(int num, Integer res) {this.num = num; this.res = res;}
        OurPair() {}
    }
    
    public OurPair countNodes(TreeNode root, int k) {
        
        OurPair l;
        if (root.left != null) l = countNodes(root.left, k);
        else l = new OurPair(0, null);
        
        
        if (l.res != null) {return l;}
        
        if (l.num == k-1) {return new OurPair(k, root.val);}
        
        OurPair r;
        if (root.right != null) r = countNodes(root.right, k-1-l.num);
        else r = new OurPair(0, null);
        
        
        if (r.res != null) {return r;}
        OurPair tempR = new OurPair(l.num + r.num + 1, null);
        return tempR;
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
        OurPair p = countNodes(root, k);
        return p.res;
    }
}

// Better solution!!!
