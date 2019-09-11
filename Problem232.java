//232. Implement Queue using Stacks - E.
//Implement the following operations of a queue using stacks.

import java.util.Stack;

public class Main {

    static class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;

        /** Initialize your data structure here. */
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            input.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public void pop() {
            peek();
            output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (output.empty())
                while (!input.empty())
                    output.push(input.pop());
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return input.empty() && output.empty();
        }
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.empty();
    }
}

