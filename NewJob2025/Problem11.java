// 11. Container With Most Water - M
// Move two pointers by dropping the smaller one - aka move with potential for a larger area!!!!
    public int maxArea(int[] height) {
        int left = 0; int right = height.length-1;
        int tentLeft = 0; int tentRight = height.length-1;
        int maxArea = (right - left) * Math.min(height[0], height[right]);
        int maxLeft = left; int maxRight = right;


        while (right - left > 0) {
            if ((right - left) * Math.min(height[right], height[left]) > maxArea) {
                maxArea = (right-left) * Math.min(height[right], height[left]);
            }

            if (right - left == 1) break;

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            
        }
        return maxArea;
    }
