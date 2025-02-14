// 102. Binary Tree Level Order Traversal - M
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) { q.add(curr.left); }
                if (curr.right != null) { q.add(curr.right); }
            }
            res.add(level);
        }
        return res;
    }

// OTHER SOLUTION via PREORDER!!
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>>al=new ArrayList<>();
        pre(root,0,al);
        return al;
    }
    public static void pre(TreeNode root,int l,List<List<Integer>>al)
    {
        if(root==null)
            return;
        if(al.size()==l)
        {
            List<Integer>li=new ArrayList<>();
            li.add(root.val);
            al.add(li);
        }
        else
            al.get(l).add(root.val);
        pre(root.left,l+1,al);
        pre(root.right,l+1,al);
    } 
