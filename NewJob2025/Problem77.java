// 77. Combinations - M
    public void combine(int n, int k, List<Integer> prefix, List<List<Integer>> res) {
        int s = prefix.size();
        if (k == s) {
            res.add(new ArrayList<Integer>(prefix));
            return;
        }
        int start = (prefix.isEmpty()) ? 0 : prefix.getLast();

        for (int i = start + 1; i < n+1; i++) {
            prefix.add(i);
            combine(n, k, prefix, res);
            prefix.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(n, k, new ArrayList<>(), res);
        return res;
    }
