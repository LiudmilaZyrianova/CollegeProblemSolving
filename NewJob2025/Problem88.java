//88. Merge Sorted Array
//DONT forget edge cases! and start from the end!
public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ((m == 0) && (n == 0)) return;
        int i = m+n-1;
        m--;
        n--;

        while ((m >= 0) && (n >= 0)) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }

        while (n >= 0) {
            nums1[i] = nums2[n];
            n--;
            i--;
        }
    }

// Cleaner solution - focuses on draining second array first
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

// One more - simply copy second and re-sort lol
