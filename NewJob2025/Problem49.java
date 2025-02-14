// 49. Group Anagrams - M

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(sortedStr, l);
            }
        }

        List<List<String>> res =  new ArrayList<>(map.values());
      
        return res;
    }
