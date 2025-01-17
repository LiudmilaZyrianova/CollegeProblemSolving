// 27. Remove Element
// two pointer for tracking array and non-VAL elements
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int nonValPosition = 0;
        while (i < nums.length) {
            while ((i < nums.length) && (nums[i] == val)) {
                i++;
            }
            while ((i < nums.length) && (nums[i] != val)) {
                nums[nonValPosition] = nums[i];
                nonValPosition++;
                i++;
            }
        }
        return nonValPosition;
    }

// cleaner - no need for double while loops, you can just scan one by one with two pointers
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
