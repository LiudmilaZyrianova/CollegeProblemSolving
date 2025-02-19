// 150. Evaluate Reverse Polish Notation - M
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token: tokens) {
            if (!token.equals("*") && !token.equals("/") && !token.equals("+") && !token.equals("-") ) {
                int num = Integer.valueOf(token);
                s.push(num);
            } else {
                int last = s.pop();
                int first = s.pop();
                if (token.equals("*")) { s.push(first * last); }
                else if (token.equals("/")) { s.push(first / last); }
                else if (token.equals("-")) { s.push(first - last); }
                else if (token.equals("+")) { s.push(first + last); }
            }
        }

        return s.pop();
    }

// faster to compare only once:
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
