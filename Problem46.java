class Solution {
    public List<List<Integer>> permute(int[] nums, int s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == nums.length-1) {
            res.add(Arrays.asList(nums[s]));
            return res; 
        }
        List<List<Integer>> temp = permute(nums, s+1);
        for (List<Integer> combo : temp) {
            for (int i = 0; i <= combo.size(); i++) {
                List<Integer> temp2 = new ArrayList<>(combo);
                temp2.add(i, nums[s]);
                res.add(temp2);
            }
        }
        return res;
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }
}
