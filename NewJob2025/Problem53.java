// 53. Maximum Subarray - M
    public int maxSubArray(int[] nums) {
        int maxAtPrev = nums[0];
        int maxTotal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxAtPrev >= 0) {
                maxAtPrev += nums[i];
            } else {
                maxAtPrev = nums[i];
            }
            maxTotal = Math.max(maxTotal, maxAtPrev);
        }

        return maxTotal;
    }
