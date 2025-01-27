// 20. Valid Parentheses - E
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if ((c == '(') || (c == '{') || (c == '[')) {
                    stack.push(c);
                } else {
                    return false;
                }
            } else {
                char last = stack.pop();
                if ((c - last >= 1) && (c - last < 3)) {
                    continue;
                } else {
                    stack.push(last);
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();

    }
