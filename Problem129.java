//129. Sum Root to Leaf Numbers - M
//Given a binary tree containing digits from 0-9 only,
//each root-to-leaf path could represent a number.

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public static void traverse(TreeNode node, String st, TreeNode res){
        if (node.left != null) traverse(node.left, st+node.val, res);
        if (node.right != null) traverse(node.right, st+node.val, res);
        if (node.left == null && node.right == null) res.val = res.val + Integer.valueOf(st + node.val);
    }

    public static int sumNumbers(TreeNode root) {
        String st = "";
        TreeNode res = new TreeNode(0);
        if (root == null) return 0;
        traverse(root, st, res);
        return res.val;
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        //TreeNode t5 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        //System.out.println(sumNumbers(t1));


    }

}

