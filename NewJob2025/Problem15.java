// 15. 3Sum - M
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int first = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int second = i + 1; int third = nums.length - 1;
            while (second < third) {
                int sum = nums[i] + nums[second] + nums[third];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[second], nums[third]));
                    third--;
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        List<List<Integer>> actualRes = new ArrayList<>();

        for (List<Integer> elem : res) {
            actualRes.add(elem);
        }

        return actualRes;
    }

// avoid dupes as saves time via SET or just checking
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
