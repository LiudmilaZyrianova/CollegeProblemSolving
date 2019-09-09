//303. Range Sum Query - Immutable - E.
//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

public class Main {
    class NumArray {

        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }


    public static void main(String[] args) {
    }
}
