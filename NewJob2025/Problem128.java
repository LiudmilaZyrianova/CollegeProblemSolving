// 128. Longest Consecutive Sequence - M
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int max = 0;

        for (int elem : nums) {
            set.add(elem);
        }

        for (int elem : nums) {
            if (!set.contains(elem-1)) {
                int count = 1;
                int larger = elem+1;
                while (set.contains(larger)) {
                    count++;
                    set.remove(larger);
                    larger++;
                }
                set.remove(elem);
                max = Math.max(max, count);
            }
        }

        return max;
    }
