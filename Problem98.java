//98. Validate Binary Search Tree - M.
//Given a binary tree, determine if it is a valid binary search tree (BST).
//Assume a BST is defined as follows:
//  The left subtree of a node contains only nodes with keys less than the node's key.
//  The right subtree of a node contains only nodes with keys greater than the node's key.
//  Both the left and right subtrees must also be binary search trees.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //Slightly better solution
//    public boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack();
//        double inorder = - Double.MAX_VALUE;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            // If next element in inorder traversal
//            // is smaller than the previous one
//            // that's not BST.
//            if (root.val <= inorder) return false;
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    public static void createInorder(TreeNode node, List<Integer> ls){
        if (node.left != null) createInorder(node.left, ls);
        ls.add(node.val);
        if (node.right != null) createInorder(node.right, ls);
    }

    public static  boolean isValidBST(TreeNode root) {
        if (root == null ) return true;
        List<Integer>  ls  = new ArrayList<>();
        createInorder(root, ls);
        for (int i = 1; i< ls.size(); i++){
            if (ls.get(i-1) > ls.get(i)) return false;
        }
        return true;

    }



    public static void main(String[] args){


    }

}

