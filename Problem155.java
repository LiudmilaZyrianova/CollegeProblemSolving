//155. Min Stack - E.
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static class MinStack {
        PriorityQueue<Integer> pq;
        ArrayList<Integer> arr;

        /** initialize your data structure here. */
        public MinStack() {
            this.pq = new PriorityQueue<>();
            this.arr = new ArrayList<>();
        }

        public void push(int x) {
            arr.add(x);
            pq.add(x);
        }

        public void pop() {
            int t = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            pq.remove(t);
        }

        public int top() {
            if (arr.size()!= 0){
            return arr.get(arr.size()-1);
            }
            return 0;
        }

        public int getMin() {
            return pq.peek();
        }
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int param_4 = obj.getMin();
        obj.pop();
        int k = obj.top();
        param_4 = obj.getMin();
        param_4++;

    }

}

