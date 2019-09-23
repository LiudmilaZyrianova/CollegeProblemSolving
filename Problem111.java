//111. Minimum Depth of Binary Tree - E.
//Given a binary tree, find its minimum depth.
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        TreeNode temp;
        while (!q.isEmpty()){
            int curr_level = q.size();
            level++;
            for (int i=0; i< curr_level; i++){
                temp = q.poll();
                if (temp.left == null && temp.right == null) return level;
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return level;

    }

    public static void main(String[] args){

    }

}

