// 108. Convert Sorted Array to Binary Search Tree

    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(nums[low]);
        int mid = low + (high-low)/2;
        return new TreeNode(
            nums[mid], 
            sortedArrayToBST(nums, low, mid-1), 
            sortedArrayToBST(nums, mid+1, high));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = high/2;
        TreeNode root = new TreeNode(
            nums[mid], 
            sortedArrayToBST(nums, 0, mid-1), 
            sortedArrayToBST(nums, mid+1, high));
        return root;
    }
