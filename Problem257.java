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

    //Better solution
//public List<String> binaryTreePaths(TreeNode root) {
//     List<String> answer = new ArrayList<String>();
//     if (root != null) searchBT(root, "", answer);
//     return answer;
// }
// private void searchBT(TreeNode root, String path, List<String> answer) {
//     if (root.left == null && root.right == null) answer.add(path + root.val);
//     if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
//     if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
// }
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

