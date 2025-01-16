
// 26. Remove Duplicates from Sorted Array
public int removeDuplicates(int[] nums) {
        int k = 0;
        if ((nums == null) || (nums.length == 0)){
            return k;
        }
        int currentNum = nums[k];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currentNum) {
                currentNum = nums[i];
                k++;
                nums[k] = currentNum;
            }
        }
        return k+1;
    }


// better solution without storing currentNum:
    int removeDuplicates(vector<int>& nums) {
        int j = 1;
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
