// 155. Min Stack - M
class MinStack {
    Stack<Integer> stack;

    Stack<Pair<Integer, Integer>> minTracker;

    public MinStack() {
        this.stack = new Stack<>();
        this.minTracker = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int pos = stack.size() - 1;
        if ((minTracker.isEmpty()) || (minTracker.peek().getKey() > val)) { 
            minTracker.push(new Pair(val, pos));
        }
    }
    
    public void pop() {
        int pos = stack.size() - 1;
        stack.pop();
        if (minTracker.peek().getValue() == pos) { 
            minTracker.pop();
        } 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTracker.peek().getKey();
    }
}

// Much better - private Stack<int[]> st; , where values are val, min_val - basically keep track of min value
