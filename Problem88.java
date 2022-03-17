class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Do a check for constrains
        int[] nums3 = new int[m + n];
        int i = 0;
        int j = 0;
        while (i < m) {
            if (j < n) {
                if (nums1[i] <= nums2[j]) {
                    nums3[i+j] = nums1[i];
                    i++;
                } else {
                    nums3[i+j] = nums2[j];
                    j++;
                }
            } else {
                nums3[i+j] = nums1[i];
                i++;
            }
        }
        while (j < n) {
                nums3[i+j] = nums2[j];
                j++;
        }
        for (int k=0; k<n+m; k++){
            nums1[k] = nums3[k];
        }
    }
}
