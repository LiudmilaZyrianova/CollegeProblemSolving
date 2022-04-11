class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {return false;}
        
        int l = nums[0]; int m = nums[1]; int lowerM = nums[1]; int r = nums[2];
        int i = 0;

        // find first l
        i++;
        while (i < nums.length && nums[i] <= nums[i-1]) {
            i++;
        }
        l = nums[i-1];
        if (i == nums.length) return false;
        
        while (i < nums.length) {
            // find m
            m = nums[i];
            i++;
            while (i < nums.length && nums[i] <= nums[i-1]) {
                if (nums[i] > l) {m = nums[i];}
                i++;
            }
            lowerM = nums[i-1];
            if (i == nums.length) return false;
            
            //find s
            r = nums[i];
            if (r > m) return true;
            
            // new l
            l = lowerM;
        }
      
        return true;
        
    }
}

// Better solution:

   public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
