// 169. Majority Element
    public int majorityElement(int[] nums) {
        // first idea - sort and take n/2th position - time complex
        // second idea - hash map - mem complext
        // third idea - Boyer-Moore Voting Algorithm
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;

    }
