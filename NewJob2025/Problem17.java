// 17. Letter Combinations of a Phone Number - M
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) { return res; }
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c')); map.put('3', Arrays.asList('d', 'e', 'f')); 
        map.put('4', Arrays.asList('g', 'h', 'i')); map.put('5', Arrays.asList('j', 'k', 'l')); 
        map.put('6', Arrays.asList('m', 'n', 'o')); map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v')); map.put('9', Arrays.asList('w', 'x', 'y', 'z')); 
        char[] d = digits.toCharArray();
        int num = 0;
        while (num < 10000) {
            StringBuilder s = new StringBuilder();
            int tempNum = 0;
            int overflow = 1;
            for (int i = 0; i < d.length; i++) { 
                int index = (num / (int) Math.pow(10, i)) % 10;
                s.append(map.get(d[i]).get(index));

                // also calculate next number:
                if (overflow + index < map.get(d[i]).size()) {
                    tempNum += (overflow + index) * (int) Math.pow(10, i);
                    overflow = 0;
                } else {
                    overflow = 1;
                }
            }
            res.add(s.toString());

            num = ((overflow == 1) && (tempNum == 0)) ? 10000 : tempNum;
        }
        return res;
    }

// Better solution w backtracking!!

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, String> digitToLetters = new HashMap<>(); digitToLetters.put('2', "abc");// ect
        
        backtrack(digits, 0, new StringBuilder(), res, digitToLetters);
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        String letters = digitToLetters.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }  
