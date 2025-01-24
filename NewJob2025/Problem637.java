// 637. Average of Levels in Binary Tree
// Need to be carefull about root = null, about fitting INT_MAX_VAL, BSF

    public void fillOutArrays(TreeNode root, double[] res, int[] count, int level) {
        if (root == null) return;
        res[level] += root.val;
        count[level] ++;
        if (root.left != null) fillOutArrays(root.left, res, count, level+1);
        if (root.right != null) fillOutArrays(root.right, res, count, level+1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        double[] res = new double[10000];
        int[] count = new int[10000];
        List<Double> finRes = new ArrayList<>();
        int level = 0;
        fillOutArrays(root, res, count, level);
        int i = 0;
        while ((i < 10000) && (count[i] != 0)) {
            finRes.add(res[i]/count[i]);
            i++;
        }
        return finRes;
    }

// CORRECT - BSF USING QUEUE
public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    
    if(root == null) return result;
    q.add(root);
    while(!q.isEmpty()) {
        int n = q.size();
        double sum = 0.0;
        for(int i = 0; i < n; i++) {
            TreeNode node = q.poll();
            sum += node.val;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        result.add(sum / n);
    }
    return result;
}
