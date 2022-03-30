// O(N lg K) running time + O(K) memory
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // insert first k elements
        for (int i = 0; i< k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i< nums.length; i++) {
            int t = pq.peek();
            if (t < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }
}

// Better solution: quicksort for ON best case
    public int findKthLargest(int[] A, int k) {
        k = A.length - k; // convert to index of k largest
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (A[j] < A[l]) swap(A, j, ++i);
            swap(A, l, i);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return A[i];
        }
        return -1; // k is invalid
    }
