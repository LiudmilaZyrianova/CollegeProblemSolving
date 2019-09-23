//96. Unique Binary Search Trees - M.
//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    //Optimized
//    public int numTrees(int n) {
//        int [] dp = new int[n+1];
//        dp[0]= 1;
//        dp[1] = 1;
//        for(int level = 2; level <=n; level++)
//            for(int root = 1; root<=level; root++)
//                dp[level] += dp[level-root]*dp[root-1];
//        return dp[n];
//    }
    public static int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[][] arr = new int[n+1][n+1];    //index of column - number of rightmost nodes. Cell stores number of config
        arr[2][0] = 1; arr[2][1] = 1;
        int temp_sum = 2;
        int t_t_sum = 0;
        for (int i = 3; i<=n; i++){
            arr[i][0] = temp_sum;
            arr[i][1] = temp_sum;
            t_t_sum = temp_sum+temp_sum;
            for (int j = 2; j< i; j++){
                temp_sum = temp_sum - arr[i-1][j-2];
                arr[i][j] = temp_sum;
                t_t_sum = t_t_sum+temp_sum;
            }
            temp_sum = t_t_sum;
        }
        return temp_sum;

    }

    public static void main(String[] args){

        System.out.println(numTrees(4));
        System.out.println(numTrees(3));
    }

}

