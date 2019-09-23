//110. Balanced Binary Tree - E.
//Given a binary tree, determine if it is height-balanced.
//For this problem, a height-balanced binary tree is defined as:
//a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //Optimized solution!
//    public boolean isBalanced(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        return height(root)!=-1;
//
//    }
//    public int height(TreeNode node){
//        if(node==null){
//            return 0;
//        }
//        int lH=height(node.left);
//        if(lH==-1){
//            return -1;
//        }
//        int rH=height(node.right);
//        if(rH==-1){
//            return -1;
//        }
//        if(lH-rH<-1 || lH-rH>1){
//            return -1;
//        }
//        return Math.max(lH,rH)+1;
//    }
    
    public int depth(TreeNode node){
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right))+1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return ((Math.abs(depth(root.left) - depth(root.right))) <=1 && isBalanced(root.left)&& isBalanced(root.right));

    }

    public static void main(String[] args){

    }

}

