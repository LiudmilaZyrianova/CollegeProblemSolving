// 22. Generate Parentheses - M
    public List<String> generateParenthesis(int n) {
        List<String> curr = new ArrayList<>();
        curr.add("");
        List<String> prev = new ArrayList<>();

        for (int i = 1; i<=n; i++) {
            prev = curr;
            curr = new ArrayList<>();
            for (String s: prev) {
                int o = s.length() - s.replace("(", "").length();
                int c = s.length() - o;
                if (o <= n-1) {
                    curr.add(s + "()");
                }
                if (o <= n-2) {
                    curr.add(s + "((");
                }
                if (o-c >= 2) {
                    curr.add(s + "))");
                }
                if ((o-c >= 1) && (o <= n-1)) {
                    curr.add(s + ")(");
                }
            }
        }


        return curr;
    }

// MUCH BETTER W/ BACKTRACKING IN FORWARD!!!
    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static  List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        backtrack(res, "", 0, 0, n);
        return res;
    }
