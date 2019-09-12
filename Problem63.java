//63. Unique Paths II - M.

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach
// the bottom-right corner of the grid (marked 'Finish' in the diagram below) with obstacles.
//How many possible unique paths are there?


public class Main {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] res = new int[x][y];
        res[0][0] = 1;
        int t = 1;
        for(int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                if (i > 0) t+= res[i-1][j];
                if (j > 0) t+= res[i][j-1];
                if (obstacleGrid[i][j] == 1) t=0;
                res[i][j] = t;
                t = 0;
            }
        }
        return res[x-1][y-1];
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        int[][] res = new int[x][y];
        res[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(res));

    }
}

