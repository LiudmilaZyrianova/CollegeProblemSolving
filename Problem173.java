//173. Binary Search Tree Iterator - M
//Implement an iterator over a binary search tree (BST).
// Your iterator will be initialized with the root node of a BST.

import javax.print.DocFlavor;
import java.util.*;

public class Main {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class BSTIterator{
        List<Integer> ls;
        ListIterator<Integer> it;

        private void traverse(TreeNode node, List<Integer> list){
            if (node == null) return;
            traverse(node.left, list);
            list.add(node.val);
            traverse(node.right, list);
        }

        public BSTIterator(TreeNode root) {
            ls = new ArrayList<>();
            traverse(root, ls);
            it = ls.listIterator();
        }

        public int next(){
            return it.next();
        }

        public boolean hasNext(){
            return it.hasNext();
        }
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t5;


    }

}

