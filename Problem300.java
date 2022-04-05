class Solution {
    public int len(int[] nums, int index, int currMax, int res) {
        if (index == nums.length) {return res;}
        // try including
        if (nums[index] > currMax) {
            return Math.max(len(nums, index+1, nums[index], res+1), 
                            len(nums, index+1, currMax, res));
        }
        return len(nums, index+1, currMax, res);
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i<n; i++) {dp[i] = 1;}
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
