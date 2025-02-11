// 63. Unique Paths II - M
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if ((obstacleGrid[0][0] == 1) || (obstacleGrid[n-1][m-1] == 1)) return 0;
        int j = 1;
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < n; i++) {
            while (j < m) {
                if (obstacleGrid[i][j] == 1) {
                    // obstacle 
                    obstacleGrid[i][j] = -1;
                } else {
                    int num = 0;
                    if ((i > 0) && (obstacleGrid[i-1][j] != -1)) {num += obstacleGrid[i-1][j];}
                    if ((j > 0) && (obstacleGrid[i][j-1] != -1)) {num += obstacleGrid[i][j-1];}
                    obstacleGrid[i][j] = num;
                }


                j++;
            }
            j = 0;
        }

        return obstacleGrid[n-1][m-1];
        
    }
