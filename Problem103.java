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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root == null) {return res;}
        
        s1.add(root);
        
        while (!s1.isEmpty() || !s1.isEmpty()) {

            
            List<Integer> newListQ = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode n = s1.pop();
                newListQ.add(n.val);
                if (n.left !=null) {s2.push(n.left);}
                if (n.right !=null) {s2.push(n.right);}
            }
            if (!newListQ.isEmpty()) {
                res.add(newListQ);
            }
            
            
            List<Integer> newListS = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode n = s2.pop();
                newListS.add(n.val);
                if (n.right !=null) {s1.add(n.right);}
                if (n.left !=null) {s1.add(n.left);}

            }
            if (!newListS.isEmpty()) {
                res.add(newListS);
            }
        }
        return res;
    }
