class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {return 0;}
        if (s.length() == 1) {return 1;}
        Map<Character, Integer> latestPosition = new HashMap<>();
        latestPosition.put(s.charAt(0), 0);
        int res = 1;
        int tempRes = 1;
        int left = 0;
        int right = 1;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (latestPosition.containsKey(c) &&
                latestPosition.get(c) >= left) {
                left = latestPosition.get(c) + 1;
                latestPosition.put(c, right);
                tempRes = right - left + 1;
            } else {
                latestPosition.put(c, right);
                tempRes++;
            }
            right++; 
            res = Math.max(res, tempRes);
        }

        return res;
    }
}
