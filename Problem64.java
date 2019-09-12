//64. Minimum Path Sum - M.
//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
// which minimizes the sum of all numbers along its path.


import static java.lang.Integer.min;

public class Main {

    public static int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] res = new int[x][y];
        res[0][0] = grid[0][0];
        for (int i = 1; i < x; i++)
            res[i][0] = res[i - 1][0] + grid[i][0];
        for (int j = 1; j < y; j++)
            res[0][j] = res[0][j - 1] + grid[0][j];
        for(int i = 1; i<x; i++){
            for (int j = 1; j<y; j++){
                res[i][j] = grid[i][j] + min(res[i-1][j], res[i][j-1]);
            }
        }
        return res[x-1][y-1];
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        int[][] res = new int[x][y];
        res[0][0] = 1; res[0][1] = 3; res[0][2] = 1;
        res[1][0] = 1; res[1][1] = 5; res[1][2] = 1;
        res[2][0] = 4; res[2][1] = 2; res[2][2] = 1;
        System.out.println(minPathSum(res));

    }
}

