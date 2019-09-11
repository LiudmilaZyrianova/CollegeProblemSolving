//62. Unique Paths - M.
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach 
// the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?


public class Main {

    public static int uniquePaths(int m, int n) {
        m--;
        n--;
        long res = 1;
        for (int i = n+1; i <= n+m; i++) {
            res = res * i / (i-n);
        }
        return (int)res;

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10,10));
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths(23,12));

    }
}

