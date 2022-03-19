class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] answer = new int[nums.length];
        for (int i =0; i< nums.length; i++) {
            suffix[i] = nums[i];
            postfix[i] = nums[i];
        }
        for (int i = 1; i< nums.length; i++){
            suffix[i] = suffix[i-1] * nums[i];
        }
        for (int i = nums.length-1; i>0; i--){
            postfix[i-1] = postfix[i] * nums[i-1];
        }
        for (int i = 1; i< nums.length-1; i++){
            answer[i] = suffix[i-1] * postfix[i+1];
        }
        answer[0] = postfix[1];        
        answer[nums.length-1] = suffix[nums.length-2];
        return answer;

    }
}

// Better solution
public class Solution {
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] *= right;
        right *= nums[i];
    }
    return res;
}
