// 33. Search in Rotated Sorted Array - M
    public int search(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while (low < high-1) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) return mid;
            // check where is rotation:
            boolean rotOnLeft = (nums[low] < nums[mid]) ? false: true;
            if (nums[mid] > target) {
                if ((nums[low] > target) && !rotOnLeft) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }   
            }

            if (nums[mid] < target) {
                if ((nums[high] < target) && rotOnLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1; 
                }
            }
        }
        if (nums[low] == target) return low;
        if (nums[high] == target) return high;

        return -1;
        
    }

// slightly cleaner:
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
