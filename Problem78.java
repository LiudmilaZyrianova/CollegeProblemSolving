class Solution {
    
    public List<List<Integer>> subsets(int[] nums, List<List<Integer>> res, int pos) {
        if (pos == nums.length) {return res;}
        subsets(nums, res, pos+1);
        int currSize = res.size();
        for (int i = 0; i < currSize; i++) {
            List<Integer> newList = new ArrayList<>(res.get(i));
            newList.add(nums[pos]);
            res.add(newList);
        }
        return res;
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        return subsets(nums, res, 0);
    }
}
