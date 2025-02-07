// 139. Word Break - M

    public int wordBreak(String s, List<String> wordDict, int[] wordBreak) {
        if (s.length() == 0) return 1;
        if (wordBreak[s.length()] == 1) return 1;
        if (wordBreak[s.length()] == 2) return 2;
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                int res = wordBreak(s.substring(word.length()), wordDict, wordBreak);
                if (res == 1) {
                    wordBreak[s.length()] = 1;
                    return 1;
                }
                if (res == 2) {
                    wordBreak[s.length()] = 2;
                }
            }
        }
        wordBreak[s.length()] = 2;
        return 2;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] wordBreak = new int[s.length()+1];
        return (wordBreak(s, wordDict, wordBreak) == 1);
    }

// could've gotten away with boolean[] wordBreak
