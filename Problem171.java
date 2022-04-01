class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = res +( (int) Math.pow(26, i)) * (columnTitle.charAt(columnTitle.length()-1 - i) - 'A' + 1);
        }
        return res;
        
    }
}

// Better soulution: go left to right with result = result * 26 + (s.charAt(i) - 'A' + 1)
