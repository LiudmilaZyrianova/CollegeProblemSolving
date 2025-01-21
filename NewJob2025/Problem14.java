// 14. Longest Common Prefix
class Solution {

    public String getPrefix(String s0, String s1) {
        int i = 0;
        while ((i < s0.length()) && (i < s1.length())) {
            if (s0.charAt(i) == s1.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        if (i == 0) {
            return "";
        } else {
            return s0.substring(0, i);
        }

    }

    public String longestCommonPrefix(String[] strs) {
        // direct approach: find prefix, then compare that prefix with the next word
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }
}

// horizontal scanning. you can also do vertical scanning, or recursion - div array in halves and find common prefix there
