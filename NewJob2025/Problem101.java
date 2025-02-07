// 101. Symmetric Tree - E
    public boolean isSymmetric(TreeNode root) {
        // bfs
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s/2; i++) {
                if ((q.get(i) == null) && (q.get(s-1-i) == null)) continue;
                if ((q.get(i) == null) && (q.get(s-1-i) != null)) return false;
                if ((q.get(i) != null) && (q.get(s-1-i) == null)) return false;
                if (q.get(i).val != q.get(s-1-i).val) return false;
            }
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();
                if (curr!=null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return true;
    }

// better solution:

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
