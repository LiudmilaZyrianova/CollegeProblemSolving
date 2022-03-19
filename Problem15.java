class Solution {

    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            List<List<Integer>> listOfPairs = twoSums(nums, i+1, 0 - nums[i]);
            if (!listOfPairs.isEmpty()) {
                for (List<Integer> p : listOfPairs) {
                    List<Integer> tripl = localSort(nums[i], nums[p.get(0)], nums[p.get(1)]);
                    result.add(tripl);
                }
            }
        }
        List<List<Integer>> finalRes = new ArrayList<>();
        result.stream().forEach(elem -> finalRes.add(elem));
        return finalRes;
    }
    
    public List<Integer> localSort(int a, int b, int c) {
        List<Integer> preSorted;
        if (a <= Math.min(b,c)) {
            preSorted = List.of(a, Math.min(b,c), Math.max(b,c));
        } else if (b <= Math.min(a,c)) {
            preSorted = List.of(b, Math.min(a,c), Math.max(a,c));
        } else {
            preSorted = List.of(c, Math.min(b,a), Math.max(b,a));
        } 
        return preSorted;
    }
    
    public List<List<Integer>> twoSums(int[] nums, int start, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> superRes = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                superRes.add(List.of(i, map.get(target - nums[i])));
            } else {
                map.put(nums[i], i);
            }
        }
        return superRes;
        
    } 
}


// Better Solution
public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}
