// 167. Two Sum II - Input Array Is Sorted - M

    public int getPosition(int[] numbers, int low, int high, int target) {
        int mid = low + (high-low)/2; 
        while (low <= high) {
            mid = low + (high-low)/2; 
            if (numbers[mid] > target) {
                high = mid - 1;
            } else if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int[] twoSum(int[] numbers, int target) {
        int tentativePos;
        for (int i = 0; i < numbers.length; i++) {
            tentativePos = getPosition(numbers, i+1, numbers.length - 1, target - numbers[i]); 
            if (tentativePos > 0) {
                return new int[]{i + 1, tentativePos + 1};
            } 
        }
        throw new IllegalArgumentException("No two sum solution");
    }


// MUCH BETTER SOLUTION - two pointers

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int total = numbers[left] + numbers[right];

            if (total == target) {
                return new int[]{left + 1, right + 1};
            } else if (total > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1}; // If no solution is found        
    }
