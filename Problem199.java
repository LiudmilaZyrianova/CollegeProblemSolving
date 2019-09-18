//199. Binary Tree Right Side View - M
//Given a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static class Pair {
        TreeNode node;
        int level;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root == null) return ls;
        Queue<Pair> q = new LinkedList<>();
        Pair old = new Pair(root, 0);
        Pair l;
        Pair r;
        if (root.left != null){
            l = new Pair(root.left, 1);
            q.add(l);
        }
        if (root.right != null){
            r = new Pair(root.right, 1);
            q.add(r);
        }

        while (!q.isEmpty()){
            Pair newp = q.poll();
            if (newp.level == old.level+1) ls.add(old.node.val);
            if (newp.node.left != null){
                l = new Pair(newp.node.left, newp.level+1);
                q.add(l);
            }
            if (newp.node.right != null){
                l = new Pair(newp.node.right, newp.level+1);
                q.add(l);
            }
            old = newp;
        }
        ls.add(old.node.val);
        return ls;

    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t5;
        System.out.println(rightSideView(t1));


    }

}

