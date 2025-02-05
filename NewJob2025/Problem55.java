// 55. Jump Game - M
    public boolean canJump(int[] nums) {
        int lastCan = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastCan) {
                lastCan = i;
            }
        }
        return (lastCan == 0);
    }

// Another solution - think of it as if car gas

    def canJump(self, nums: List[int]) -> bool:
        gas = 0
        for n in nums:
            if gas < 0:
                return False
            elif n > gas:
                gas = n
            gas -= 1
            
        return True
