//22. Generate Parentheses - M.
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.*;

public class Main {

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

    public static void main(String[] args) {
        for (String e : generateParenthesis(3)){
            System.out.println(e);
        }

        for (String e : generateParenthesis(4)){
            System.out.println(e);
        }

    }
}
