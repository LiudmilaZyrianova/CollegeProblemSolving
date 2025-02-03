// 199. Binary Tree Right Side View - M
// bfs but right to left
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        if (root == null) return res;
        bfs.add(root);
        while (!bfs.isEmpty()) {
            int n = bfs.size();
            res.add(bfs.peek().val);
            for (int i = 0; i < n; i++) {
                TreeNode curr = bfs.poll();
                if (curr.right != null) {
                    bfs.add(curr.right);
                }
                if (curr.left != null) {
                    bfs.add(curr.left);
                }
            }
        }
        return res;
    }

// Alternatively, use DFS to traverse the tree, prioritizing the right subtree.
