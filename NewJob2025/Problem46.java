// 46. Permutations - M

    public List<List<Integer>> permute(int[] nums, Set<Integer> toUse) {
        List<List<Integer>> res = new ArrayList<>();

        if (toUse.size() == 0) return res;
        if (toUse.size() == 1) {
            List<Integer> tempRes = Arrays.asList(toUse.iterator().next());
            res.add(tempRes);
            return res;
        }
        // get all possible perm wout q, and then add 1 to every place

        for (int num: nums) {
            if (toUse.contains(num)) {
                toUse.remove(num);
                List<List<Integer>> tempReses = permute(nums, toUse);
                for (List<Integer> tempRes : tempReses) {
                    List<Integer> current = new ArrayList<>(tempRes);
                    current.add(0, num);
                    res.add(current);
                }
                toUse.add(num);
            }
        }
        return res;
    }
    public List<List<Integer>> permute(int[] nums) {

        Set<Integer> toUse = new HashSet<>();
        for (int num: nums) { toUse.add(num); }

        return permute(nums, toUse);
    }

// cleaner solution

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
