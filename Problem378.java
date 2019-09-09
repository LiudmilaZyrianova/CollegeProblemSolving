//378. Kth Smallest Element in a Sorted Matrix - M.
//Given a n x n matrix where each of the rows and columns are sorted in ascending order,
// find the kth smallest element in the matrix.

import java.util.PriorityQueue;

public class Main {


    public class Triple implements Comparable<Triple> {
        int x, y, val;

        public Triple(int a, int b, int v){
            x = a; y = b; val = v;
        }

        @Override
        public int compareTo(Triple o) {
            return this.val - o.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int s = matrix.length;
        PriorityQueue<Triple> queue = new PriorityQueue<>();
        for (int i = 0; i < s; i++) queue.offer(new Triple(0, i, matrix[0][i]));
        Triple temp;
        for (int i = 0; i < k-1; i++) {
            temp = queue.poll();
            if(temp.x == s-1) continue;
            queue.offer(new Triple(temp.x + 1,temp.y, matrix[temp.x + 1][temp.y]));
        }
        return queue.poll().val;

    }

    public static void main(String[] args) {
    }
}
