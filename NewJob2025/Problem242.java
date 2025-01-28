// 242. Valid Anagram - E

    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c: count) {
            if (c != 0) return false;
        }
        return true;
    }

// slightly longer solution - sort both and do ==
