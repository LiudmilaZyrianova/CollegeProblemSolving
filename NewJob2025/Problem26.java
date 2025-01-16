
// 26. Remove Duplicates from Sorted Array
public int removeDuplicates(int[] nums) {
        int k = 0;
        if ((nums == null) || (nums.length == 0)){
            return k;
        }
        int currentNum = nums[k];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currentNum) {
                currentNum = nums[i];
                k++;
                nums[k] = currentNum;
            }
        }
        return k+1;
    }


// better solution without storing currentNum:
// Better solution
public int removeDuplicates(int[] nums) {
    int i = nums.length > 0 ? 1 : 0;
    for (int n : nums)
        if (n > nums[i-1])
            nums[i++] = n;
    return i;
}
