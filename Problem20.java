//20. Valid Parentheses - E. Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.

import java.util.Stack;

public class Main {

    public static char opposite(char c){
        if (c == '(') return ')';
        else if (c == ')') return '(';
        else if (c == '{') return '}';
        else if (c == '}') return '{';
        else if (c == ']') return '[';
        else return ']';
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char e : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(e);
            } else {
                if ( stack.peek() == opposite(e) ) {
                    stack.pop();
                } else {
                    stack.push(e);
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(true);
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }
}
