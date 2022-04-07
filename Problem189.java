class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k==0) {return;}
        int moving = nums[0];
        int pos = 0;
        int i = 0;
        while (i < n) {
            int fixPos = pos;
            while (i < n) {
                pos = (pos + k) % n;
                int curr = moving;
                moving = nums[pos];
                nums[pos] = curr;
                i++;
                if (pos == fixPos) {break; }
            }
            pos = (pos + 1) % n;
            moving = nums[pos];
        }
    }
}

// Better solution:
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
