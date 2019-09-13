//225. Implement Stack using Queues - E.
//Implement the following operations of a stack using queues.

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {


    //Better using 1 queue 
//    private LinkedList<Integer> q1 = new LinkedList<>();
//
//    // Push element x onto stack.
//    public void push(int x) {
//        q1.add(x);
//        int sz = q1.size();
//        while (sz > 1) {
//            q1.add(q1.remove());
//            sz--;
//        }
//    }
    class MyStack {
        Queue<Integer> f;
        Queue<Integer> s;
        int top;

        /** Initialize your data structure here. */
        public MyStack() {
            f = new LinkedBlockingQueue<>();
            s = new LinkedBlockingQueue<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            top = x;
            f.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int topElem = f.poll();
            while (!f.isEmpty()){
                s.add(topElem);
                topElem = f.poll();
            }
            int res = topElem;
            if (s.isEmpty()) top = 0;
            else {
                topElem = s.poll();
                while (!s.isEmpty()){
                    f.add(topElem);
                    topElem = s.poll();
                }
                top = topElem;
                f.add(topElem);
            }
            return res;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return f.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}

