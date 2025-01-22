//205. Isomorphic Strings

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> sMap = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i)) && (sMap.get(s.charAt(i)) != t.charAt(i))){
                return false;
            } else if (!sMap.containsKey(s.charAt(i)) && (tSet.contains(t.charAt(i)))) {
                return false;
            } else {
                sMap.put(s.charAt(i), t.charAt(i));
                tSet.add(t.charAt(i));
            }
        }
        return true;
    }

// Could be done w one Map<Character, Character> sMap via
            if (charMap.containsKey(sc)) {
                if (charMap.get(sc) != tc) {
                    return false;
                }
            } else if (charMap.containsValue(tc)) {
                return false;
            }

// or even just use int[] indexS = new int[200]; and do indexS[s.charAt(i)]
