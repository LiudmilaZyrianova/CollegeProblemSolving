class Solution {
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[nums.length-1] = true;
        for (int i= nums.length-2; i >=0; i--) {
            for (int j = 1 ; j<=nums[i]; j++){
                if (i+j < nums.length && can[i+j]) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[0];
    }
}

// better solution

bool canJump(int A[], int n) {
    int last=n-1,i,j;
    for(i=n-2;i>=0;i--){
        if(i+A[i]>=last)last=i;
    }
    return last<=0;
}
