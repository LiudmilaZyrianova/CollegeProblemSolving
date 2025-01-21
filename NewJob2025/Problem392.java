//392. Is Subsequence  - two pointers
    public boolean isSubsequence(String s, String t) {
        int sPos = 0;
        int tPos = 0;
        while ((sPos < s.length()) && (tPos < t.length())) {
            while (tPos < t.length()) {
                tPos++;
                if (s.charAt(sPos) == t.charAt(tPos-1)) {
                    sPos++;
                    break;
                }
            }
        }
        return (sPos == s.length()) && (s.length() <= t.length());
    }
