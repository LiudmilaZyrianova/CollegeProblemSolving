// 80. Remove Duplicates from Sorted Array II - M

    public int removeDuplicates(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;
        int counter = 0;
        int currValue = nums[0];
        while (fastPointer < nums.length){
            counter = 0;
            while ((fastPointer < nums.length) && (nums[fastPointer] == currValue)) {
                counter++;
                fastPointer++;
            }
            nums[slowPointer] = currValue;
            slowPointer++;
            if (counter > 1) {
                nums[slowPointer] = currValue;
                slowPointer++;
            }

            if (fastPointer < nums.length) {
                currValue = nums[fastPointer];
            }
        }
        return slowPointer;
    }

// slightly optimized 
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
