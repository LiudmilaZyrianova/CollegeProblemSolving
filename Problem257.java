//257. Binary Tree Paths - E.
//Given a binary tree, return all root-to-leaf paths.


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public static void traverse(TreeNode node, List<String> ls, StringBuilder sb){
        sb.append(node.val);
        sb.append("->");
        if (node.left != null) traverse(node.left, ls, sb);
        if (node.right != null) traverse(node.right, ls, sb);
        if (node.right == null && node.left == null) {
            sb.delete(sb.length() - 2, sb.length());
            ls.add(sb.toString());
            sb.delete(sb.lastIndexOf("->") + 2, sb.length());
        } else {
            sb.delete(sb.length() - 2, sb.length());
            sb.delete(sb.lastIndexOf("->") + 2, sb.length());
        }

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        if (root == null ) return ls;
        StringBuilder sb = new StringBuilder();
        traverse(root, ls, sb);
        return ls;
    }



    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        System.out.println(binaryTreePaths(t1));


    }

}

