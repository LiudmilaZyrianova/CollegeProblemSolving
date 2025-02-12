// 34. Find First and Last Position of Element in Sorted Array - M
    public int searchRange(int[] nums, double target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while (low < high) {
            mid = low + (high-low)/2;
            if ((double) nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ((double) nums[low] > target) ? (low - 1) : (low);
    }

    public int[] searchRange(int[] nums, int target) {
        // we could technically find target-0.5, taget+0.5
        int[] empty = {-1, -1};
        if (nums.length == 0) return empty;
        if ((nums[0] > target) || (nums[nums.length-1] < target)) return empty;

        double lower = target - 0.5;
        double higher = target + 0.5;
        int lowerIdx = searchRange(nums, lower);
        int higherIdx = searchRange(nums, higher);
        if (lowerIdx == higherIdx) return empty;
        int[] res = {lowerIdx + 1, higherIdx};
        return res;
    }

// could use is_searching_left (a boolean indicating whether to search for the leftmost or rightmost occurrence of the target).
else if (nums[mid] == target)  {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
