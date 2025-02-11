// 98. Validate Binary Search Tree - M
    public class Res {
        boolean isValid;
        int smallest;
        int largest;
        Res(boolean isValid) { this.isValid = isValid; }
        Res(boolean isValid, int smallest, int largest) { 
            this.isValid = isValid;
            this.smallest = smallest;
            this.largest = largest;
        }
    }

    public Res isValidBSTRes(TreeNode root) {
        if (root == null) return new Res(true);
        Res left = null;
        Res right = null;
        int largest = root.val;
        int smallest = root.val;

        if (root.left != null) {
            left = isValidBSTRes(root.left);
            if ((!left.isValid) || (left.largest >= root.val)) { return new Res(false); }
            smallest = left.smallest;
        }

        if (root.right != null) {
            right = isValidBSTRes(root.right);
            if ((!right.isValid) || (right.smallest <= root.val)) { return new Res(false); }
            largest = right.largest;
        }

        return new Res(true, smallest, largest);
        
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTRes(root).isValid;
    }

// BETTER SOLUTION _ DFS VIA STACK
   public boolean isValidBST(TreeNode root) {
       Stack<TreeNode> stack = new Stack();
       double inorder = - Double.MAX_VALUE;

       while (!stack.isEmpty() || root != null) {
           while (root != null) {
               stack.push(root);
               root = root.left;
           }
           root = stack.pop();
           // If next element in inorder traversal
           // is smaller than the previous one
           // that's not BST.
           if (root.val <= inorder) return false;
           inorder = root.val;
           root = root.right;
       }
       return true;
   }
