// 290. Word Pattern

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> wordToLetter = new HashMap<>(26);
        Map<Character, String> letterToWord = new HashMap<>(26);

        String[] stringArray = s.split(" ");

        if (stringArray.length != pattern.length()) { return false; }

        for (int i = 0; i < stringArray.length; i++) {
            if (!wordToLetter.containsKey(stringArray[i]) 
            && !letterToWord.containsKey(pattern.charAt(i))) {
                wordToLetter.put(stringArray[i], pattern.charAt(i));
                letterToWord.put(pattern.charAt(i), stringArray[i]);
            } else if ((wordToLetter.getOrDefault(stringArray[i], '1') == pattern.charAt(i)) 
            && (letterToWord.getOrDefault(pattern.charAt(i), null).equals(stringArray[i]))) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

// slightly pretties - first contains check one by one and put if needed. then do get
