// 226. Invert Binary Tree - E
 
    public TreeNode invertTree(TreeNode root) {
        // invert using rec calls
        if (root == null) return root;
        TreeNode tempNode = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempNode);
        return root;
    }
