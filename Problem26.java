class Solution {
    public int removeDup(int[] nums, int position, int largest, int k) {
        if (nums[position] == largest) {
            return k+1;
        }
        // means at least more elements ahead
        if (nums[position] != nums[position + 1]) {
            // first elem is unique
            return removeDup(nums, position + 1, largest, k+1);
        }
        // else move to the left by one and keep k
        for (int i = position; i+1 < nums.length; i++) {
            nums[i] = nums[i+1];
        }
        return removeDup(nums, position, largest, k);
        
    }
    
    public int removeDuplicates(int[] nums) {
        return removeDup(nums, 0, nums[nums.length-1], 0);
    }
}

// Better solution
public int removeDuplicates(int[] nums) {
    int i = nums.length > 0 ? 1 : 0;
    for (int n : nums)
        if (n > nums[i-1])
            nums[i++] = n;
    return i;
}
