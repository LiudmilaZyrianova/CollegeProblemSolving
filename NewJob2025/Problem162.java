// 162. Find Peak Element - M
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {return 0;}

        int low = 0; int high = nums.length-1;
        int mid;
        while (low <= high) {
            mid = low + (high-low) / 2;
            // edge
            if (mid == nums.length-1) {
                if (nums[mid] > nums[mid-1]) return mid;
                high = mid - 1;
                continue;
            }

            if (mid == 0) {
                if (nums[mid] > nums[mid+1]) return mid;
                low = mid + 1;
                continue;
            }

            if ((nums[mid] > nums[mid+1]) && (nums[mid] > nums[mid-1])) {
                return mid;
            } 

            if ((nums[mid] > nums[mid+1]) && (nums[mid] < nums[mid-1])) {
                high = mid - 1;
                continue;
            } else {
                low = mid+1;
                continue;
            }

        }

        return -1;
        
    }

// could be simplified
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
