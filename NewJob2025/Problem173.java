// 173. Binary Search Tree Iterator - M

class BSTIterator {
    public Stack<TreeNode> stack = new Stack<TreeNode>();


    public BSTIterator(TreeNode root) {
        this.getLeftLeaf(root);
    }
    
    public int next() {
        TreeNode res = stack.pop();
        if (res.right != null) {
            this.getLeftLeaf(res.right);
        }
        return res.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void getLeftLeaf(TreeNode root) {
        TreeNode curr = root;
        this.stack.push(curr);
        while (curr.left != null) {
            curr = curr.left;
            this.stack.push(curr);
        }
    }
}
