//102. Binary Tree Level Order Traversal - M.
//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

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

//instead i can keep track of levels using curr_level = q.size()
    public static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode n, int lev){node = n; level = lev;}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null ) return res;
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(root, 0);
        q.add(p);
        int curr_lev = 0;
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            while (!q.isEmpty() && q.peek().level == curr_lev){
                p = q.poll();
                l.add(p.node.val);
                if (p.node.left != null){
                    Pair lp = new Pair (p.node.left, curr_lev+1);
                    q.add(lp);
                }
                if (p.node.right != null){
                    Pair r = new Pair (p.node.right, curr_lev+1);
                    q.add(r);
                }

            }
            res.add(l);
            curr_lev++;
        }
        return res;

    }

    public static void main(String[] args){

    }

}

