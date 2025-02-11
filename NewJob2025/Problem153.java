// 153. Find Minimum in Rotated Sorted Array - M
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length - 1;
        int mid = low + (high-low) / 2;

        while (low <= high) {
            if (nums[low] <= nums[high]) return nums[low];
            mid = low + (high-low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                if (nums[mid] < nums[mid-1]) return nums[mid];
                high = mid - 1;
            }
        }

        return -1;

    }
