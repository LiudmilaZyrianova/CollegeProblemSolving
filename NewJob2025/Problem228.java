// 228. Summary Ranges
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> res = new LinkedList<>();
        int st = 0;
        int end = 0;
        while (i < nums.length) {
            StringBuilder sb = new StringBuilder();
            st = nums[i];
            end = st;
            sb.append(st);
            i++;
            while ((i < nums.length) && (nums[i] - 1 == nums[i-1])) {
                end = nums[i];
                i++;
            }
            if (st != end) {
                sb.append("->");
                sb.append(end);
            }
            res.add(sb.toString());
        }
        return res;
    }

