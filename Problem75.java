class Solution {
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) {c0++;}
            if (nums[i] == 1) {c1++;}
            if (nums[i] == 2) {c2++;}
        }

        int k = 0;
        while (c0 > 0) {
            nums[k] = 0;
            k++;
            c0--;
        }
        while (c1 > 0) {
            nums[k] = 1;
            k++;
            c1--;
        }
        while (c2 > 0) {
            nums[k] = 2;
            k++;
            c2--;
        }
        
    }
}

// BUt it's 2 pass!!!!!
// 1 pass

        void sortColors(int A[], int n) {
            int second=n-1, zero=0;
            for (int i=0; i<=second; i++) {
                while (A[i]==2 && i<second) swap(A[i], A[second--]);
                while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
            }
        }
