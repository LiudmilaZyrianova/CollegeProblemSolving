// 3. Longest Substring Without Repeating Characters - M

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < s.length(); right++) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
                max = Math.max(max, map.size());
            } else {
                int dupePos = map.get(s.charAt(right));
                while (left <= dupePos) {
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(s.charAt(right), right);
            }
        }

        return max;
    }

// Improve - set - only for latest poistion, substring is tracked only based on L&R
        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
