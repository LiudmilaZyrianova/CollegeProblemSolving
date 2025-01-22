// 383. Ransom Note

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rN = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        Arrays.sort(rN);
        Arrays.sort(m);
        int posInRN = 0;
        int posInM = 0;
        while ((posInRN < rN.length) && (posInM < m.length)) {
            if (rN[posInRN] == m[posInM]) {
                posInRN++;
                posInM++;
            } else {
                posInM++;
            }
        }
        return ((posInRN == rN.length) && (posInM <= m.length));
    }

// speed optimized solution - store ransomNote as hashMap for char per count and subtract all occurences from magazine
// !!! The size should be small since it's alphabet!!!

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magaHash = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            magaHash.put(c, magaHash.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magaHash.containsKey(c) || magaHash.get(c) <= 0) {
                return false;
            }
            magaHash.put(c, magaHash.get(c) - 1);
        }

        return true;
    }

// EVEN MORE OPTIMIZED
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
