//144. Binary Tree Preorder Traversal - M
//Given a binary tree, return the preorder traversal of its nodes' values.

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

     public static  class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     //Iterative solution
//     public List<Integer> preorderIt(TreeNode root) {
//         List<Integer> pre = new LinkedList<Integer>();
//         if(root==null) return pre;
//         Stack<TreeNode> tovisit = new Stack<TreeNode>();
//         tovisit.push(root);
//         while(!tovisit.empty()) {
//             TreeNode visiting = tovisit.pop();
//             pre.add(visiting.val);
//             if(visiting.right!=null) tovisit.push(visiting.right);
//             if(visiting.left!=null) tovisit.push(visiting.left);
//         }
//         return pre;
//     }

     public static List<Integer> traverse(TreeNode root, List<Integer> ls){
         if (root == null) return ls;
         ls.add(root.val);
         traverse(root.left, ls);
         traverse(root.right, ls);
         return ls;
     }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        return traverse(root, ls);

    }
    public static void main(String[] args){
         TreeNode o = new TreeNode(1);
         TreeNode t = new TreeNode(2);
         TreeNode th = new TreeNode(3);
         o.right = t;
         t.left = th;

         System.out.println(preorderTraversal(o));
    }

}

